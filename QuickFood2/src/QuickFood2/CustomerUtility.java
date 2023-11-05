package QuickFood2;

/**
 * REFACTORING: keep all customer-related operations in one utility class.
 * this makes it easier to manage and maintain the customer-related functionalities in your program
 * note by having ScannerUtility the code here is cleaner
 */
import java.util.List;

public class CustomerUtility {

	// for case 1: input new customer
	public static Customer getCustomerInput() {

		String customerName = ScannerUtility.getString("Enter customer name: ");
		String customerTelephone = ScannerUtility.getString("Enter customer telephone number: ");
		String customerAddress = ScannerUtility.getString("Enter customer address: ");
		String customerLocation = ScannerUtility.getString("Enter customer location: ");
		String customerEmail = ScannerUtility.getString("Enter customer email address: ");

		// create a new customer object with the inputted data above
		return new Customer(customerName, customerTelephone, customerAddress, customerLocation, customerEmail);
	}
	// display the details

	public static void displayCustomerDetails(Customer customer) {
		System.out.println("Customer Details:");
		System.out.println("Name:" + customer.getCustomerName());
		System.out.println("Telephone number:" + customer.getCustomerTelephone());
		System.out.println("Customer address:" + customer.getCustomerAddress());
		System.out.println("Customer location:" + customer.getCustomerLocation());
		System.out.println("Customer email:" + customer.getCustomerEmail());

	}

	// iterate through customers(ArrayList) and print

	public static void printAllCustomers(List<Customer> customers) {
		System.out.println("Printing all customers:");
		System.out.println("=============================");
		for (Customer customer : customers) {
			System.out.println("Name: " + customer.getCustomerName());
			System.out.println("Address: " + customer.getCustomerAddress());
			System.out.println("Location: " + customer.getCustomerLocation());
			System.out.println("Telephone Number: " + customer.getCustomerTelephone());
			System.out.println("=============================");
		}
	}

}
