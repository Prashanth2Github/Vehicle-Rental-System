package ui.user;

import dao.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Form for deleting a user.
 */
public class DeleteUserForm extends JFrame {
    private UserDAO userDAO;
    private UserManagementUI parentUI;
    private int userId;

    public DeleteUserForm(UserManagementUI parentUI, int userId) {
        this.userDAO = new UserDAO();
        this.parentUI = parentUI;
        this.userId = userId;

        setTitle("Delete User");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblConfirm = new JLabel("Are you sure you want to delete this user?");
        lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblConfirm, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton btnDelete = new JButton("Delete");
        JButton btnCancel = new JButton("Cancel");

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userDAO.deleteUser(userId);
                parentUI.loadUserData();
                dispose();
            }
        });

        btnCancel.addActionListener(e -> dispose());

        buttonPanel.add(btnDelete);
        buttonPanel.add(btnCancel);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
