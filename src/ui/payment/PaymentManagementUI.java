package ui.payment;

import dao.PaymentDAO;
import model.Payment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * UI for managing payments.
 */
public class PaymentManagementUI extends JFrame {
    private JTable paymentTable;
    private DefaultTableModel tableModel;
    private PaymentDAO paymentDAO;

    public PaymentManagementUI() {
        paymentDAO = new PaymentDAO();

        setTitle("Payment Management");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        // Table setup
        tableModel = new DefaultTableModel(new String[]{"ID", "Rental ID", "Amount", "Date"}, 0);
        paymentTable = new JTable(tableModel);
        loadPaymentData();
        panel.add(new JScrollPane(paymentTable), BorderLayout.CENTER);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Payment");
        JButton updateButton = new JButton("Update Payment");
        JButton deleteButton = new JButton("Delete Payment");

        addButton.addActionListener(e -> new AddPaymentForm(this));
        updateButton.addActionListener(e -> updatePayment());
        deleteButton.addActionListener(e -> deletePayment());

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    public void loadPaymentData() {
        tableModel.setRowCount(0);
        List<Payment> payments = paymentDAO.getAllPayments();
        for (Payment p : payments) {
            tableModel.addRow(new Object[]{p.getPaymentId(), p.getRentalId(), p.getAmount(), p.getPaymentDate()});
        }
    }

    private void updatePayment() {
        int selectedRow = paymentTable.getSelectedRow();
        if (selectedRow != -1) {
            int paymentId = (int) tableModel.getValueAt(selectedRow, 0);
            new UpdatePaymentForm(this, paymentId);
        } else {
            JOptionPane.showMessageDialog(this, "Select a payment to update.");
        }
    }

    private void deletePayment() {
        int selectedRow = paymentTable.getSelectedRow();
        if (selectedRow != -1) {
            int paymentId = (int) tableModel.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "Delete this payment?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                paymentDAO.deletePayment(paymentId);
                loadPaymentData();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Select a payment to delete.");
        }
    }
}
