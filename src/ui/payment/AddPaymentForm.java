package ui.payment;

import dao.PaymentDAO;
import model.Payment;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Form for adding a new payment.
 */
public class AddPaymentForm extends JFrame {
    private JTextField txtRentalId, txtAmount, txtDate;
    private PaymentDAO paymentDAO;
    private PaymentManagementUI parentUI;

    public AddPaymentForm(PaymentManagementUI parentUI) {
        this.parentUI = parentUI;
        this.paymentDAO = new PaymentDAO();

        setTitle("Add Payment");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Rental ID:"));
        txtRentalId = new JTextField();
        add(txtRentalId);

        add(new JLabel("Amount:"));
        txtAmount = new JTextField();
        add(txtAmount);

        add(new JLabel("Date (YYYY-MM-DD):"));
        txtDate = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        add(txtDate);

        JButton btnAdd = new JButton("Add");
        JButton btnCancel = new JButton("Cancel");

        btnAdd.addActionListener(e -> addPayment());
        btnCancel.addActionListener(e -> dispose());

        add(btnAdd);
        add(btnCancel);

        setVisible(true);
    }

    private void addPayment() {
        try {
            int rentalId = Integer.parseInt(txtRentalId.getText());
            double amount = Double.parseDouble(txtAmount.getText());
            String date = txtDate.getText();

            Payment payment = new Payment(0, rentalId, amount, date);
            paymentDAO.addPayment(payment);
            parentUI.loadPaymentData();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input!");
        }
    }
}
