package ui.user;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Form for updating an existing user.
 */
public class UpdateUserForm extends JFrame {
    private JTextField txtName, txtContact, txtPayment;
    private UserDAO userDAO;
    private UserManagementUI parentUI;
    private int userId;

    public UpdateUserForm(UserManagementUI parentUI, int userId) {
        this.userDAO = new UserDAO();
        this.parentUI = parentUI;
        this.userId = userId;

        User user = userDAO.getUserById(userId);
        if (user == null) {
            JOptionPane.showMessageDialog(null, "User not found!");
            dispose();
            return;
        }

        setTitle("Update User");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Name:"));
        txtName = new JTextField(user.getName());
        add(txtName);

        add(new JLabel("Contact:"));
        txtContact = new JTextField(user.getContactInfo());
        add(txtContact);

        add(new JLabel("Payment Method:"));
        txtPayment = new JTextField(user.getPaymentMethod());
        add(txtPayment);

        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String contact = txtContact.getText();
                String paymentMethod = txtPayment.getText();

                if (!name.isEmpty() && !contact.isEmpty() && !paymentMethod.isEmpty()) {
                    User updatedUser = new User(userId, name, contact, paymentMethod);
                    userDAO.updateUser(updatedUser);
                    parentUI.loadUserData();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "All fields are required!");
                }
            }
        });

        btnCancel.addActionListener(e -> dispose());

        add(btnSave);
        add(btnCancel);

        setVisible(true);
    }
}
