package ui.rental;

import dao.RentalDAO;
import javax.swing.*;
import java.awt.*;

/**
 * Form for deleting a rental.
 */
public class DeleteRentalForm extends JFrame {
    private JTextField txtRentalId;
    private RentalDAO rentalDAO;
    private RentalManagementUI parentUI;

    public DeleteRentalForm(RentalManagementUI parentUI) {
        this.parentUI = parentUI;
        this.rentalDAO = new RentalDAO();

        setTitle("Delete Rental");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Rental ID:"));
        txtRentalId = new JTextField();
        add(txtRentalId);

        JButton btnDelete = new JButton("Delete");
        JButton btnCancel = new JButton("Cancel");

        btnDelete.addActionListener(e -> deleteRental());
        btnCancel.addActionListener(e -> dispose());

        add(btnDelete);
        add(btnCancel);

        setVisible(true);
    }

    private void deleteRental() {
        try {
            int rentalId = Integer.parseInt(txtRentalId.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this rental?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                rentalDAO.deleteRental(rentalId);
                parentUI.loadRentalData();
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Rental ID.");
        }
    }
}
