package ui.user;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Form for adding a new user.
 */
public class AddUserForm extends JFrame {
    private JTextField txtName, txtContact, txtPayment;
    private UserDAO userDAO;
    private UserManagementUI parentUI;

    public AddUserForm(UserManagementUI parentUI) {
        this.userDAO = new UserDAO();
        this.parentUI = parentUI;

        setTitle("Add New User");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        // Fields
        add(new JLabel("Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Contact:"));
        txtContact = new JTextField();
        add(txtContact);

        add(new JLabel("Payment Method:"));
        txtPayment = new JTextField();
        add(txtPayment);

        // Buttons
        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");

        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String contact = txtContact.getText();
                String paymentMethod = txtPayment.getText();

                if (!name.isEmpty() && !contact.isEmpty() && !paymentMethod.isEmpty()) {
                    User user = new User(name, contact, paymentMethod);
                    userDAO.addUser(user);
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
