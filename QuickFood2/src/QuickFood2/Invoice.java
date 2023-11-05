package QuickFood2;

/*REFACTORING:
 * modularise the toString method, put appendOrderDetails, appendDriverDetails and footer into separate methods 
 * this makes the code easier to read and we can see the structure better.
 */
import java.util.List;

public class Invoice {
	private Customer customer;
	private Restaurant restaurant;
	private List<Pizza> pizzas;
	private double totalAmount;
	private String specialInstructions;
	private Driver driver;
	private String orderId;

	private static int counter = 0; // This counter will be used by the Invoice objects and will be incremented as
									// each one is created
	private int id; // each invoice object will have its unique id.

	public Invoice(Order order, Driver driver) {
		this.customer = order.getCustomer();
		this.pizzas = order.getPizzas();
		this.restaurant = order.getRestaurant();
		this.specialInstructions = order.getSpecialInstructions();
		this.driver = driver;
		this.id = ++counter; /// incrementing
		this.orderId = order.getOrderId();
		calculateTotalAmount();

	}

	/// calculate the total amount and iterate through the pizzas list and add the
	/// price to the total
	private void calculateTotalAmount() {
		totalAmount = 0;
		for (Pizza pizza : pizzas) {
			totalAmount += pizza.getPrice();
		}
	}

	// a getter for invoice id, this is for the filename .txt
	public int getId() {
		return id;
	}

	/// the invoice is returned as a string
	@Override
	public String toString() {

		String output = "";
		output += "===========================================================================================\n";
		if (driver == null) {
			output += "\nSorry! Our drivers are too far away from you to be able to deliver to your location.";
		} else {
			output += appendOrderDetails();
			output += appendDriverDetails();
			output += appendFooter();
		}
		output += "\n===========================================================================================";
		return output + "\n";
	}

	private String appendOrderDetails() {
		String orderDetails = "";

		orderDetails += "\n Order number: " + orderId;
		orderDetails += "\n Customer: " + customer.getCustomerName();
		orderDetails += "\n Email: " + customer.getCustomerEmail();
		orderDetails += "\n Phone number: " + customer.getCustomerTelephone();
		orderDetails += "\n Location: " + customer.getCustomerLocation();
		orderDetails += "\n\n You have ordered the following from " + restaurant.getRestaurantName() + " in "
				+ restaurant.getRestaurantLocation() + ":\n";
		/// loop through the order...pizzas is the list in the order of what has been
		/// ordered
		for (Pizza pizza : pizzas) {
			orderDetails += "- " + pizza.getName() + " (" + pizza.getPrice() + ")\n";

		}
		orderDetails += "\n Special Instructions: " + specialInstructions;
		orderDetails += "\n\n Total: R" + totalAmount + "\n";

		return orderDetails;
	}

	private String appendDriverDetails() {
		String driverDetails = "";

		if (driver != null) { /// if there's no driver then ignore but this is superseded by InvoiceGenerator
								/// anyway now.
			driverDetails += "\n" + driver.getName()
					+ " is nearest to the restaurant and so they will be delivering you order to you at: \n";

		}

		return driverDetails;
	}

	private String appendFooter() {
		String footerDetails = "";
		footerDetails += "\n" + customer.getCustomerAddress();
		footerDetails += "\n\n If you need to contact the restaurant, their number is "
				+ restaurant.getRestaurantTelephone() + ".";
		return footerDetails;

	}
}
