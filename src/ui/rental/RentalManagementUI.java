package ui.rental;

import dao.RentalDAO;
import model.Rental;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * UI for managing rentals (CRUD operations).
 */
public class RentalManagementUI extends JFrame {
    private RentalDAO rentalDAO;
    private JTable rentalTable;
    private DefaultTableModel tableModel;

    public RentalManagementUI() {
        rentalDAO = new RentalDAO();
        setTitle("Rental Management");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new Object[]{"ID", "User ID", "Vehicle ID", "Start Date", "End Date", "Total Cost"}, 0);
        rentalTable = new JTable(tableModel);
        loadRentalData();

        JScrollPane scrollPane = new JScrollPane(rentalTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        JButton btnAdd = new JButton("Add Rental");
        JButton btnUpdate = new JButton("Update Rental");
        JButton btnDelete = new JButton("Delete Rental");

        btnAdd.addActionListener(e -> new AddRentalForm(this));
        btnUpdate.addActionListener(e -> updateRental());
        btnDelete.addActionListener(e -> deleteRental());

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void loadRentalData() {
        tableModel.setRowCount(0);
        List<Rental> rentals = rentalDAO.getAllRentals();
        for (Rental r : rentals) {
            tableModel.addRow(new Object[]{r.getRentalId(), r.getUserId(), r.getVehicleId(), r.getStartDate(), r.getEndDate(), r.getTotalCost()});
        }
    }

    private void updateRental() {
        int selectedRow = rentalTable.getSelectedRow();
        if (selectedRow != -1) {
            int rentalId = (int) tableModel.getValueAt(selectedRow, 0);
            int userId = (int) tableModel.getValueAt(selectedRow, 1);
            int vehicleId = (int) tableModel.getValueAt(selectedRow, 2);
            String startDate = (String) tableModel.getValueAt(selectedRow, 3);
            String endDate = (String) tableModel.getValueAt(selectedRow, 4);
            double totalCost = (double) tableModel.getValueAt(selectedRow, 5);
            new UpdateRentalForm(this, rentalId, userId, vehicleId, startDate, endDate, totalCost);
        } else {
            JOptionPane.showMessageDialog(this, "Select a rental to update.");
        }
    }

    private void deleteRental() {
        int selectedRow = rentalTable.getSelectedRow();
        if (selectedRow != -1) {
            int rentalId = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this rental?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                rentalDAO.deleteRental(rentalId);
                loadRentalData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a rental to delete.");
        }
    }
}
