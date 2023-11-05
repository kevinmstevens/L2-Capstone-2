package QuickFood2;

public class Main {

	public static void main(String[] args) {

		AppData appData = AppData.setupWithTestData();
		int choice = 0;
		/*note: in refactoring, I have been able to remove the try-catch block as it is
		now handled by the scannerUtility method.
		 main do loop*/
		do {
			MenuUtility.displayMainMenu();
			choice = ScannerUtility.getInt("Enter your choice: "); // menu choice needs to be an int

			/// use switch case for the main menu choices
			switch (choice) {

			case 1: {
				Customer newCustomer = CustomerUtility.getCustomerInput();
				appData.customers.add(newCustomer);
				CustomerUtility.displayCustomerDetails(newCustomer);
				break;
			}

			case 2: {
				Restaurant newRestaurant = RestaurantUtility.getRestaurantInput();
				appData.restaurants.add(newRestaurant);
				break;
			}

			case 3: {
				CustomerUtility.printAllCustomers(appData.customers);
				break;
			}

			case 4: {
				RestaurantUtility.printAllRestaurants(appData.restaurants);
				break;
			}

			case 5: {
				Order newOrder = OrderUtility.createNewOrder(appData.customers, appData.restaurants, appData.menu);
				appData.orders.add(newOrder);
				break;
			}

			case 6: {
				OrderUtility.printAllOrders(appData.orders);
				break;
			}

			case 7: {
				InvoiceUtility.printAllInvoices(appData.orders);
				break;
			}

			case 8: {
				InvoiceUtility.saveInvoicesToFile(appData.orders);
			}

			case 99: {
				System.out.println("Exiting program.");
				break;
			}

			default: {
				System.out.println("Invalid choice.  Enter 1,2,3,4, or 99 to exit.");
				break;
			}
			} // close switch-case block

		} while (choice != 99);
	}
}
