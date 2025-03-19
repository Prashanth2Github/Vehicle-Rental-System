package ui.payment;

import dao.PaymentDAO;

import javax.swing.*;
import java.awt.*;

/**
 * Form for deleting a payment.
 */
public class DeletePaymentForm extends JFrame {
    private JTextField txtPaymentId;
    private PaymentDAO paymentDAO;
    private PaymentManagementUI parentUI;

    public DeletePaymentForm(PaymentManagementUI parentUI) {
        this.parentUI = parentUI;
        this.paymentDAO = new PaymentDAO();

        setTitle("Delete Payment");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Payment ID:"));
        txtPaymentId = new JTextField();
        add(txtPaymentId);

        JButton btnDelete = new JButton("Delete");
        JButton btnCancel = new JButton("Cancel");

        btnDelete.addActionListener(e -> deletePayment());
        btnCancel.addActionListener(e -> dispose());

        add(btnDelete);
        add(btnCancel);

        setVisible(true);
    }

    private void deletePayment() {
        try {
            int paymentId = Integer.parseInt(txtPaymentId.getText());
            int confirm = JOptionPane.showConfirmDialog(this, "Delete this payment?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                paymentDAO.deletePayment(paymentId);
                parentUI.loadPaymentData();
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid Payment ID.");
        }
    }
}
