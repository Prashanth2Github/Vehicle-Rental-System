package ui.vehicle;

import dao.VehicleDAO;
import model.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * UI for managing vehicles (CRUD operations).
 */
public class VehicleManagementUI extends JFrame {
    private VehicleDAO vehicleDAO;
    private JTable vehicleTable;
    private DefaultTableModel tableModel;

    public VehicleManagementUI() {
        vehicleDAO = new VehicleDAO();
        setTitle("Vehicle Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new Object[]{"ID", "Model", "Rental Rate"}, 0);
        vehicleTable = new JTable(tableModel);
        loadVehicleData();

        JScrollPane scrollPane = new JScrollPane(vehicleTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add Vehicle");
        JButton btnUpdate = new JButton("Update Vehicle");
        JButton btnDelete = new JButton("Delete Vehicle");

        btnAdd.addActionListener(e -> new AddVehicleForm(this));
        btnUpdate.addActionListener(e -> updateVehicle());
        btnDelete.addActionListener(e -> deleteVehicle());

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void loadVehicleData() {
        tableModel.setRowCount(0);
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        for (Vehicle v : vehicles) {
            tableModel.addRow(new Object[]{v.getVehicleId(), v.getModel(), v.getRentalRate()});
        }
    }

    private void updateVehicle() {
        int selectedRow = vehicleTable.getSelectedRow();
        if (selectedRow != -1) {
            int vehicleId = (int) tableModel.getValueAt(selectedRow, 0);
            String model = (String) tableModel.getValueAt(selectedRow, 1);
            double rentalRate = (double) tableModel.getValueAt(selectedRow, 2);
            new UpdateVehicleForm(this, vehicleId, model, rentalRate);
        } else {
            JOptionPane.showMessageDialog(this, "Select a vehicle to update.");
        }
    }

    private void deleteVehicle() {
        int selectedRow = vehicleTable.getSelectedRow();
        if (selectedRow != -1) {
            int vehicleId = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this vehicle?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                vehicleDAO.deleteVehicle(vehicleId);
                loadVehicleData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a vehicle to delete.");
        }
    }
}
