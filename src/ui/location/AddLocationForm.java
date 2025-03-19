package ui.location;

import dao.LocationDAO;
import model.Location;

import javax.swing.*;
import java.awt.*;

/**
 * Form for adding a new location.
 */
public class AddLocationForm extends JFrame {
    private JTextField txtName, txtAddress;
    private LocationDAO locationDAO;
    private LocationManagementUI parentUI;

    public AddLocationForm(LocationManagementUI parentUI) {
        this.parentUI = parentUI;
        this.locationDAO = new LocationDAO();

        setTitle("Add Location");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Location Name:"));
        txtName = new JTextField();
        add(txtName);

        add(new JLabel("Address:"));
        txtAddress = new JTextField();
        add(txtAddress);

        JButton btnAdd = new JButton("Add");
        JButton btnCancel = new JButton("Cancel");

        btnAdd.addActionListener(e -> addLocation());
        btnCancel.addActionListener(e -> dispose());

        add(btnAdd);
        add(btnCancel);

        setVisible(true);
    }

    private void addLocation() {
        try {
            String name = txtName.getText();
            String address = txtAddress.getText();

            if (name.isEmpty() || address.isEmpty()) {
                throw new Exception("Fields cannot be empty!");
            }

            Location location = new Location(0, name, address);
            locationDAO.addLocation(location);
            parentUI.loadLocationData();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input! " + e.getMessage());
        }
    }
}
