package service;

import dao.PaymentDAO;
import model.Payment;
import java.util.List;

/**
 * Service layer for handling Payment operations.
 */
public class PaymentService {
    private PaymentDAO paymentDAO;

    public PaymentService() {
        this.paymentDAO = new PaymentDAO();
    }

    public void addPayment(Payment payment) {
        paymentDAO.addPayment(payment);
    }

    public Payment getPaymentById(int paymentId) {
        return paymentDAO.getPaymentById(paymentId);
    }

    public List<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

    public void updatePayment(Payment payment) {
        paymentDAO.updatePayment(payment);
    }

    public void deletePayment(int paymentId) {
        paymentDAO.deletePayment(paymentId);
    }
}
