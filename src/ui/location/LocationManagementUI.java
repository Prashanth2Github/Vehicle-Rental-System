package ui.location;

import dao.LocationDAO;
import model.Location;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * UI for managing locations.
 */
public class LocationManagementUI extends JFrame {
    private JTable locationTable;
    private DefaultTableModel tableModel;
    private LocationDAO locationDAO;

    public LocationManagementUI() {
        locationDAO = new LocationDAO();

        setTitle("Location Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Address"}, 0);
        locationTable = new JTable(tableModel);
        loadLocationData();
        panel.add(new JScrollPane(locationTable), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Location");
        JButton updateButton = new JButton("Update Location");
        JButton deleteButton = new JButton("Delete Location");

        addButton.addActionListener(e -> new AddLocationForm(this));
        updateButton.addActionListener(e -> updateLocation());
        deleteButton.addActionListener(e -> deleteLocation());

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void loadLocationData() {
        tableModel.setRowCount(0);
        List<Location> locations = locationDAO.getAllLocations();
        for (Location loc : locations) {
            tableModel.addRow(new Object[]{loc.getLocationId(), loc.getName(), loc.getAddress()});
        }
    }

    private void updateLocation() {
        int selectedRow = locationTable.getSelectedRow();
        if (selectedRow != -1) {
            int locationId = (int) tableModel.getValueAt(selectedRow, 0);
            new UpdateLocationForm(this, locationId);
        } else {
            JOptionPane.showMessageDialog(this, "Select a location to update.");
        }
    }

    private void deleteLocation() {
        int selectedRow = locationTable.getSelectedRow();
        if (selectedRow != -1) {
            int locationId = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Delete this location?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                locationDAO.deleteLocation(locationId);
                loadLocationData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a location to delete.");
        }
    }
}
