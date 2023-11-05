package QuickFood2;

import java.util.List;

public class TestDataUtility {
	public static void populateTestData(List<Customer> customers, List<Restaurant> restaurants) {
		// create some Customers and Restaurants for testing
		Customer jillJack = new Customer("Jill Jack", "123 456 7890", "12 Cherry Road \nPlumstead", "Cape Town",
				"jilljack@yahoo.com");
		customers.add(jillJack);
		Restaurant aesop = new Restaurant("Aesop's Pizza", "098 765 4321", "Cape Town");
		restaurants.add(aesop);

	}

}
