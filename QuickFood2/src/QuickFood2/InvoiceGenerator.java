package QuickFood2;

import java.util.List;
import java.util.ArrayList;

/*PSEUDOCODE
 * Generate the invoices by going through the orders and calling the FileReader method to get the driver
 * I've put this in a separate class to reduce clutter in Main
 * If there is no suitable driver, the invoice does not get created (and the order would not be fulfilled)
 * 
 * Invoices are stored in an arrayList called invoices and the invoice created is added to this
 * 
 * REFACTORING: rename records to driverRecords for clarity
 *think about further modularity for discount, tax, etc
 *moved the getSuitableDriver method into DriverSelector class for modularity and "Single Responsibility principle"
 */
public class InvoiceGenerator {

	public static List<Invoice> generateInvoices(List<Order> orders) {

		List<Invoice> invoices = new ArrayList<>();

		for (Order order : orders) {
			System.out.println("...Processing order...");
			String customerLocation = order.getCustomer().getCustomerLocation();
			// get suitable driver for this order
			Driver suitableDriver = DriverSelector.getSuitableDriver(customerLocation);

			System.out.println("Calling Invoice Generator..."); // for debugging
			Invoice invoice = new Invoice(order, suitableDriver);
			invoices.add(invoice); // adds the invoice to the list of invoices to print to txt file.
			// System.out.println(invoice);
		}

		return invoices;
	}

}
