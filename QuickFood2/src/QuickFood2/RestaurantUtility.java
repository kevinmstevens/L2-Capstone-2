package QuickFood2;

import java.util.List;

public class RestaurantUtility {

	/// for case 2: input new restaurant
	public static Restaurant getRestaurantInput() {
		String restaurantName = ScannerUtility.getString("Enter restaurant name: ");

		String restaurantTelephone = ScannerUtility.getString("Enter restaurant telephone number: ");

		String restaurantLocation = ScannerUtility.getString("Enter restaurant location: ");

		return new Restaurant(restaurantName, restaurantTelephone, restaurantLocation);

	}

	/// display the details

	public static void displayRestaurantDetails(Restaurant restaurant) {

		System.out.println("Restaurant Details:");
		System.out.println("Name:" + restaurant.getRestaurantName());
		System.out.println("Telephone number:" + restaurant.getRestaurantTelephone());

		System.out.println("Restaurant location:" + restaurant.getRestaurantLocation());
	}

	public static void printAllRestaurants(List<Restaurant> restaurants) {
		System.out.println("Printing all restaurants:");
		System.out.println("=============================");
		for (Restaurant restaurant : restaurants) {
			System.out.println("Name: " + restaurant.getRestaurantName());
			System.out.println("Location: " + restaurant.getRestaurantLocation());
			System.out.println("Telephone Number: " + restaurant.getRestaurantTelephone());
			System.out.println("=============================");
		}

	}
}