package ui.user;

import dao.UserDAO;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * User Management UI - Displays all users and allows CRUD operations.
 */
public class UserManagementUI extends JFrame {
    private JTable userTable;
    private DefaultTableModel tableModel;
    private UserDAO userDAO;

    public UserManagementUI() {
        userDAO = new UserDAO();
        
        setTitle("User Management");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new String[]{"User ID", "Name", "Contact", "Payment Method"}, 0);
        userTable = new JTable(tableModel);
        loadUserData();

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add User");
        JButton btnUpdate = new JButton("Update User");
        JButton btnDelete = new JButton("Delete User");

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddUserForm(UserManagementUI.this);
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow >= 0) {
                    int userId = (int) tableModel.getValueAt(selectedRow, 0);
                    new UpdateUserForm(UserManagementUI.this, userId);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a user to update.");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = userTable.getSelectedRow();
                if (selectedRow >= 0) {
                    int userId = (int) tableModel.getValueAt(selectedRow, 0);
                    userDAO.deleteUser(userId);
                    loadUserData();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a user to delete.");
                }
            }
        });

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);

        add(new JScrollPane(userTable), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void loadUserData() {
        tableModel.setRowCount(0);
        List<User> users = userDAO.getAllUsers();
        for (User user : users) {
            tableModel.addRow(new Object[]{user.getUserId(), user.getName(), user.getContactInfo(), user.getPaymentMethod()});
        }
    }
}
