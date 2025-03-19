package ui.location;

import dao.LocationDAO;

import javax.swing.*;
import java.awt.*;

/**
 * Form for deleting a location.
 */
public class DeleteLocationForm extends JFrame {
    private JTextField txtLocationId;
    private LocationDAO locationDAO;
    private LocationManagementUI parentUI;

    public DeleteLocationForm(LocationManagementUI parentUI) {
        this.parentUI = parentUI;
        this.locationDAO = new LocationDAO();

        setTitle("Delete Location");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Location ID:"));
        txtLocationId = new JTextField();
        add(txtLocationId);

        JButton btnDelete = new JButton("Delete");
        JButton btnCancel = new JButton("Cancel");

        btnDelete.addActionListener(e -> deleteLocation());
        btnCancel.addActionListener(e -> dispose());

        add(btnDelete);
        add(btnCancel);

        setVisible(true);
    }

    private void deleteLocation() {
        try {
            int locationId = Integer.parseInt(txtLocationId.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "Delete this location?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                locationDAO.deleteLocation(locationId);
                parentUI.loadLocationData();
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Location ID.");
        }
    }
}
