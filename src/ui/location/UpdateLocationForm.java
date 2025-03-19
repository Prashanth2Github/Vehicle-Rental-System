package ui.location;

import dao.LocationDAO;
import model.Location;

import javax.swing.*;
import java.awt.*;

/**
 * Form for updating an existing location.
 */
public class UpdateLocationForm extends JFrame {
    private JTextField txtName, txtAddress;
    private LocationDAO locationDAO;
    private LocationManagementUI parentUI;
    private int locationId;

    public UpdateLocationForm(LocationManagementUI parentUI, int locationId) {
        this.parentUI = parentUI;
        this.locationId = locationId;
        this.locationDAO = new LocationDAO();

        Location location = locationDAO.getLocationById(locationId);

        setTitle("Update Location");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Location Name:"));
        txtName = new JTextField(location.getName());
        add(txtName);

        add(new JLabel("Address:"));
        txtAddress = new JTextField(location.getAddress());
        add(txtAddress);

        JButton btnUpdate = new JButton("Update");
        JButton btnCancel = new JButton("Cancel");

        btnUpdate.addActionListener(e -> updateLocation());
        btnCancel.addActionListener(e -> dispose());

        add(btnUpdate);
        add(btnCancel);

        setVisible(true);
    }

    private void updateLocation() {
        try {
            String name = txtName.getText();
            String address = txtAddress.getText();

            if (name.isEmpty() || address.isEmpty()) {
                throw new Exception("Fields cannot be empty!");
            }

            Location location = new Location(locationId, name, address);
            locationDAO.updateLocation(location);
            parentUI.loadLocationData();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input! " + e.getMessage());
        }
    }
}
