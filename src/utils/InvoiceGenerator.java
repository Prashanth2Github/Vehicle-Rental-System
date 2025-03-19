package utils;

import model.Rental;
import model.Vehicle;
import model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Utility class for generating rental invoices.
 */
public class InvoiceGenerator {
    private static final String INVOICE_DIRECTORY = "invoices/";

    /**
     * Generates an invoice for a rental.
     * 
     * @param rental Rental details
     * @param user   User details
     * @param vehicle Vehicle details
     */
    public static void generateInvoice(Rental rental, User user, Vehicle vehicle) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fileName = INVOICE_DIRECTORY + "Invoice_" + rental.getRentalId() + "_" + sdf.format(rental.getRentalDate()) + ".txt";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("====================================\n");
            writer.write("         VEHICLE RENTAL INVOICE     \n");
            writer.write("====================================\n");
            writer.write("Invoice ID: " + rental.getRentalId() + "\n");
            writer.write("Customer Name: " + user.getName() + "\n");
            writer.write("Vehicle: " + vehicle.getMake() + " " + vehicle.getModel() + " (" + vehicle.getYear() + ")\n");
            writer.write("Rental Date: " + rental.getRentalDate() + "\n");
            writer.write("Return Date: " + rental.getReturnDate() + "\n");
            writer.write("Total Cost: $" + rental.getTotalCost() + "\n");
            writer.write("====================================\n");
            writer.write("   Thank you for choosing our service!   \n");
            writer.write("====================================\n");
            
            System.out.println("Invoice generated successfully: " + fileName);
        } catch (IOException e) {
            System.err.println("Error generating invoice: " + e.getMessage());
        }
    }
}
