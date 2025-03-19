package ui.vehicle;

import dao.VehicleDAO;
import model.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Form for adding a new vehicle.
 */
public class AddVehicleForm extends JFrame {
    private JTextField txtModel;
    private JTextField txtRentalRate;
    private VehicleDAO vehicleDAO;
    private VehicleManagementUI parentUI;

    public AddVehicleForm(VehicleManagementUI parentUI) {
        this.parentUI = parentUI;
        this.vehicleDAO = new VehicleDAO();

        setTitle("Add Vehicle");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Model:"));
        txtModel = new JTextField();
        add(txtModel);

        add(new JLabel("Rental Rate:"));
        txtRentalRate = new JTextField();
        add(txtRentalRate);

        JButton btnSave = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");

        btnSave.addActionListener(e -> saveVehicle());
        btnCancel.addActionListener(e -> dispose());

        add(btnSave);
        add(btnCancel);

        setVisible(true);
    }

    private void saveVehicle() {
        String model = txtModel.getText();
        double rentalRate;
        try {
            rentalRate = Double.parseDouble(txtRentalRate.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid rental rate.");
            return;
        }

        Vehicle vehicle = new Vehicle(0, model, rentalRate);
        vehicleDAO.addVehicle(vehicle);
        parentUI.loadVehicleData();
        dispose();
    }
}
