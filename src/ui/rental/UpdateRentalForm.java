package ui.rental;

import dao.RentalDAO;
import model.Rental;

import javax.swing.*;
import java.awt.*;

/**
 * Form for updating a rental.
 */
public class UpdateRentalForm extends JFrame {
    private JTextField txtUserId, txtVehicleId, txtStartDate, txtEndDate, txtTotalCost;
    private RentalDAO rentalDAO;
    private RentalManagementUI parentUI;
    private int rentalId;

    public UpdateRentalForm(RentalManagementUI parentUI, int rentalId, int userId, int vehicleId, String startDate, String endDate, double totalCost) {
        this.parentUI = parentUI;
        this.rentalDAO = new RentalDAO();
        this.rentalId = rentalId;

        setTitle("Update Rental");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        add(new JLabel("User ID:"));
        txtUserId = new JTextField(String.valueOf(userId));
        add(txtUserId);

        add(new JLabel("Vehicle ID:"));
        txtVehicleId = new JTextField(String.valueOf(vehicleId));
        add(txtVehicleId);

        add(new JLabel("Start Date (YYYY-MM-DD):"));
        txtStartDate = new JTextField(startDate);
        add(txtStartDate);

        add(new JLabel("End Date (YYYY-MM-DD):"));
        txtEndDate = new JTextField(endDate);
        add(txtEndDate);

        add(new JLabel("Total Cost:"));
        txtTotalCost = new JTextField(String.valueOf(totalCost));
        add(txtTotalCost);

        JButton btnSave = new JButton("Update");
        JButton btnCancel = new JButton("Cancel");

        btnSave.addActionListener(e -> updateRental());
        btnCancel.addActionListener(e -> dispose());

        add(btnSave);
        add(btnCancel);

        setVisible(true);
    }

    private void updateRental() {
        try {
            int userId = Integer.parseInt(txtUserId.getText());
            int vehicleId = Integer.parseInt(txtVehicleId.getText());
            String startDate = txtStartDate.getText();
            String endDate = txtEndDate.getText();
            double totalCost = Double.parseDouble(txtTotalCost.getText());

            Rental rental = new Rental(rentalId, userId, vehicleId, startDate, endDate, totalCost);
            rentalDAO.updateRental(rental);
            parentUI.loadRentalData();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }
}
