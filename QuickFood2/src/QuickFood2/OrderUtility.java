package QuickFood2;

import java.util.List;

//REFACTORING: Encapsulate the order-creation logic in its own method.

/// create an order.
/// firstly select a Customer customer from customers
/// print the customers and collect user input

public class OrderUtility {

	public static Order createNewOrder(List<Customer> customers, List<Restaurant> restaurants, Menu menu) {

		MenuUtility.displayList(customers, new CustomerDisplayFunction(), "Select a customer: ");
		int customerChoice = ScannerUtility.getInt("Enter choice: ");
		Customer selectedCustomer = customers.get(customerChoice - 1);

		// same approach for restaurant
		MenuUtility.displayList(restaurants, new RestaurantDisplayFunction(), "Select a restaurant: ");
		int restaurantChoice = ScannerUtility.getInt("Enter choice");
		Restaurant selectedRestaurant = restaurants.get(restaurantChoice - 1);

		/// collect special instructions
		String specialInstructions = ScannerUtility.getString("Enter any special instructions, or type none: ");

		/// CREATE A NEW ORDER...we know the customer, the restaurant and the special
		/// instructions at this point
		Order order = new Order(selectedCustomer, selectedRestaurant, specialInstructions);

		// now we need to choose from the menu of pizzas
		int pizzaChoice;

		// another menu with a do while loop
		// populate the list of pizzas shown with the menu object elements
		do {
			MenuUtility.displayList(menu.getPizzas(), new PizzaDisplayFunction(), "Menu:");
			pizzaChoice = ScannerUtility.getInt("Select a pizza (or enter 99 to finish)");

			List<Pizza> pizzas = menu.getPizzas();
			// add the selected pizza to the order, with some data validation
			// need an int greater than 0 and less than the size of the list of pizzas
			if (pizzaChoice > 0 && pizzaChoice <= pizzas.size()) {
				Pizza selectedPizza = pizzas.get(pizzaChoice - 1);
				order.addPizza(selectedPizza);
			}

		} while (pizzaChoice != 99); // enter 99 to finish
		System.out.println("Order placed by " + selectedCustomer.getCustomerName());
		return order;

	}

	public static void printAllOrders(List<Order> orders) {
		System.out.println("Printing all orders:");
		System.out.println("======================");
		for (Order order : orders) {
			System.out.println("Order placed by:" + order.getCustomer().getCustomerName());
			System.out.println("Pizzas in this order:");
			for (Pizza pizza : order.getPizzas()) {
				System.out.println("- " + pizza.getName() + " (" + pizza.getPrice() + ")");
			}
			System.out.println("=========================");
		}
	}
}
