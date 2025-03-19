package ui.main;

import ui.user.UserManagementUI;
import ui.vehicle.VehicleManagementUI;
import ui.rental.RentalManagementUI;
import ui.payment.PaymentManagementUI;
import ui.location.LocationManagementUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainPage - The main dashboard for the Vehicle Rental System.
 */
public class MainPage extends JFrame {

    public MainPage() {
        setTitle("Vehicle Rental System - Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header Label
        JLabel headerLabel = new JLabel("Vehicle Rental System", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(headerLabel, BorderLayout.NORTH);

        // Main Panel with Buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton btnUserManagement = new JButton("User Management");
        JButton btnVehicleManagement = new JButton("Vehicle Management");
        JButton btnRentalManagement = new JButton("Rental Management");
        JButton btnPaymentManagement = new JButton("Payment Management");
        JButton btnLocationManagement = new JButton("Location Management");

        // Button Listeners
        btnUserManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new UserManagementUI();
            }
        });

        btnVehicleManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VehicleManagementUI();
            }
        });

        btnRentalManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RentalManagementUI();
            }
        });

        btnPaymentManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PaymentManagementUI();
            }
        });

        btnLocationManagement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LocationManagementUI();
            }
        });

        // Adding buttons to panel
        panel.add(btnUserManagement);
        panel.add(btnVehicleManagement);
        panel.add(btnRentalManagement);
        panel.add(btnPaymentManagement);
        panel.add(btnLocationManagement);

        // Styling buttons
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JButton) {
                ((JButton) comp).setFont(new Font("Arial", Font.BOLD, 16));
            }
        }

        add(panel, BorderLayout.CENTER);

        // Footer
        JLabel footerLabel = new JLabel("© 2025 Vehicle Rental System", SwingConstants.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        add(footerLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Entry point
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainPage();
            }
        });
    }
}
