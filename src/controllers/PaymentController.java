package controllers;

import model.Payment;
import service.PaymentService;
import java.time.LocalDate;
import java.util.List;

/**
 * Controller for managing payment-related operations.
 */
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController() {
        this.paymentService = new PaymentService();
    }

    public void addPayment(int rentalId, double amount, LocalDate paymentDate) {
        Payment payment = new Payment(0, rentalId, amount, paymentDate); // ID auto-generated
        paymentService.addPayment(payment);
    }

    public Payment getPaymentById(int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    public void updatePayment(int paymentId, int rentalId, double amount, LocalDate paymentDate) {
        Payment payment = new Payment(paymentId, rentalId, amount, paymentDate);
        paymentService.updatePayment(payment);
    }

    public void deletePayment(int paymentId) {
        paymentService.deletePayment(paymentId);
    }
}
