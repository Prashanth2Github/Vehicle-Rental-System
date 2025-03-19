package ui.vehicle;

import dao.VehicleDAO;

import javax.swing.*;
import java.awt.*;

/**
 * Confirmation form for deleting a vehicle.
 */
public class DeleteVehicleForm extends JFrame {
    private VehicleDAO vehicleDAO;
    private VehicleManagementUI parentUI;
    private int vehicleId;

    public DeleteVehicleForm(VehicleManagementUI parentUI, int vehicleId) {
        this.vehicleDAO = new VehicleDAO();
        this.parentUI = parentUI;
        this.vehicleId = vehicleId;

        setTitle("Delete Vehicle");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblConfirm = new JLabel("Are you sure you want to delete this vehicle?");
        lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblConfirm, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton btnDelete = new JButton("Delete");
        JButton btnCancel = new JButton("Cancel");

        btnDelete.addActionListener(e -> {
            vehicleDAO.deleteVehicle(vehicleId);
            parentUI.loadVehicleData();
            dispose();
        });

        btnCancel.addActionListener(e -> dispose());

        buttonPanel.add(btnDelete);
        buttonPanel.add(btnCancel);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
