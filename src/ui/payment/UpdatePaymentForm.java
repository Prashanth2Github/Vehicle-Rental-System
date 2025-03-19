package ui.payment;

import dao.PaymentDAO;
import model.Payment;

import javax.swing.*;
import java.awt.*;

/**
 * Form for updating an existing payment.
 */
public class UpdatePaymentForm extends JFrame {
    private JTextField txtAmount, txtDate;
    private PaymentDAO paymentDAO;
    private PaymentManagementUI parentUI;
    private int paymentId;

    public UpdatePaymentForm(PaymentManagementUI parentUI, int paymentId) {
        this.parentUI = parentUI;
        this.paymentId = paymentId;
        this.paymentDAO = new PaymentDAO();

        Payment payment = paymentDAO.getPaymentById(paymentId);

        setTitle("Update Payment");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Amount:"));
        txtAmount = new JTextField(String.valueOf(payment.getAmount()));
        add(txtAmount);

        add(new JLabel("Date (YYYY-MM-DD):"));
        txtDate = new JTextField(payment.getPaymentDate());
        add(txtDate);

        JButton btnUpdate = new JButton("Update");
        JButton btnCancel = new JButton("Cancel");

        btnUpdate.addActionListener(e -> updatePayment());
        btnCancel.addActionListener(e -> dispose());

        add(btnUpdate);
        add(btnCancel);

        setVisible(true);
    }

    private void updatePayment() {
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            String date = txtDate.getText();

            Payment payment = new Payment(paymentId, 0, amount, date);
            paymentDAO.updatePayment(payment);
            parentUI.loadPaymentData();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }
}
