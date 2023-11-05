package QuickFood2;

/// call the invoice generator, passing the orders to it

/// save the invoices in a folder as txt files individually, with unique
/// filenames
/// see
/// https://www.javatpoint.com/utf-in-java#:~:text=Program%20to%20Convert%20Unicode%20to%20UTF%2D8%20in%20Java&text=This%20conversion%20is%20done%20with,into%20an%20array%20of%20bytes.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InvoiceUtility {
	public static void printAllInvoices(List<Order> orders) {
		System.out.println("Printing invoices:");
		if (orders.isEmpty()) {
			System.out.println("No orders to print invoices for.");
			return; // exit if no orders
		}
		/// create a list of the generated invoices by calling InvoiceGenerator and pass
		/// the orders to that.
		List<Invoice> generatedInvoices = InvoiceGenerator.generateInvoices(orders);

		/// iterate through the list and print each invoice
		for (Invoice invoice : generatedInvoices) {
			System.out.println(invoice);
		}
	}

	public static void saveInvoicesToFile(List<Order> orders) {
		try {
			List<Invoice> generatedInvoices = InvoiceGenerator.generateInvoices(orders);
			for (Invoice invoice : generatedInvoices) {
				Path path = Paths.get("invoices", "invoice_" + invoice.getId() + ".txt");
				// Ensure the directory exists
				Files.createDirectories(path.getParent());

				List<String> content = new ArrayList<>();
				content.add(invoice.toString());
				Files.write(path, content);
				// Printing the path where the invoice is saved
				System.out.println("Invoice_" + invoice.getId() + " has been written to: " + path.toAbsolutePath());

			}
			System.out.println("Invoices have been written to files.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}