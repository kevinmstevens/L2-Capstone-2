package QuickFood2;

import java.util.ArrayList;
import java.util.List;

/*Create an order object which contains all the necessary information for an order.
 * Each order is then fed into the invoice generator
 * 
 */
public class Order {
	public Customer customer;
	public Restaurant restaurant;
	public List<Pizza> pizzas;
	private String specialInstructions;
	private static int orderCounter = 0; // Static counter variable
	private String orderId; // Unique identifier for each order

	public Order(Customer customer, Restaurant restaurant, String specialInstructions) {
		this.customer = customer;
		this.restaurant = restaurant;
		this.pizzas = new ArrayList<>();
		this.specialInstructions = specialInstructions;
		this.orderCounter++; /// whenever an order is created, increment the counter
		this.orderId = String.format("%04d", orderCounter); // format it as 0000 4 digits
	}

	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);
	}

	/// set up getters
	public Customer getCustomer() {
		return customer;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public String getOrderId() {
		return this.orderId;
	}
}
