package ui.vehicle;

import dao.VehicleDAO;
import model.Vehicle;

import javax.swing.*;
import java.awt.*;

/**
 * Form for updating a vehicle.
 */
public class UpdateVehicleForm extends JFrame {
    private JTextField txtModel;
    private JTextField txtRentalRate;
    private VehicleDAO vehicleDAO;
    private VehicleManagementUI parentUI;
    private int vehicleId;

    public UpdateVehicleForm(VehicleManagementUI parentUI, int vehicleId, String model, double rentalRate) {
        this.parentUI = parentUI;
        this.vehicleDAO = new VehicleDAO();
        this.vehicleId = vehicleId;

        setTitle("Update Vehicle");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Model:"));
        txtModel = new JTextField(model);
        add(txtModel);

        add(new JLabel("Rental Rate:"));
        txtRentalRate = new JTextField(String.valueOf(rentalRate));
        add(txtRentalRate);

        JButton btnSave = new JButton("Update");
        JButton btnCancel = new JButton("Cancel");

        btnSave.addActionListener(e -> updateVehicle());
        btnCancel.addActionListener(e -> dispose());

        add(btnSave);
        add(btnCancel);

        setVisible(true);
    }

    private void updateVehicle() {
        String model = txtModel.getText();
        double rentalRate;
        try {
            rentalRate = Double.parseDouble(txtRentalRate.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid rental rate.");
            return;
        }

        Vehicle vehicle = new Vehicle(vehicleId, model, rentalRate);
        vehicleDAO.updateVehicle(vehicle);
        parentUI.loadVehicleData();
        dispose();
    }
}
