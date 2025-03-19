package ui.rental;

import dao.RentalDAO;
import model.Rental;

import javax.swing.*;
import java.awt.*;

/**
 * Form for adding a new rental.
 */
public class AddRentalForm extends JFrame {
    private JTextField txtUserId, txtVehicleId, txtStartDate, txtEndDate, txtTotalCost;
    private RentalDAO rentalDAO;
    private RentalManagementUI parentUI;

    public AddRentalForm(RentalManagementUI parentUI) {
        this.parentUI = parentUI;
        this.rentalDAO = new RentalDAO();

        setTitle("Add Rental");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("User ID:"));
        txtUserId = new JTextField();
        add(txtUserId);

        add(new JLabel("Vehicle ID:"));
        txtVehicleId = new JTextField();
        add(txtVehicleId);

        add(new JLabel("Start Date (YYYY-MM-DD):"));
        txtStartDate = new JTextField();
        add(txtStartDate);

        add(new JLabel("End Date (YYYY-MM-DD):"));
        txtEndDate = new JTextField();
        add(txtEndDate);

        add(new JLabel("Total Cost:"));
        txtTotalCost = new JTextField();
        add(txtTotalCost);

        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");

        btnSave.addActionListener(e -> saveRental());
        btnCancel.addActionListener(e -> dispose());

        add(btnSave);
        add(btnCancel);

        setVisible(true);
    }

    private void saveRental() {
        try {
            int userId = Integer.parseInt(txtUserId.getText());
            int vehicleId = Integer.parseInt(txtVehicleId.getText());
            String startDate = txtStartDate.getText();
            String endDate = txtEndDate.getText();
            double totalCost = Double.parseDouble(txtTotalCost.getText());

            Rental rental = new Rental(0, userId, vehicleId, startDate, endDate, totalCost);
            rentalDAO.addRental(rental);
            parentUI.loadRentalData();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }
}
