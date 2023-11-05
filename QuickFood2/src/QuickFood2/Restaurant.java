//Restaurant class

package QuickFood2;

public class Restaurant {
	// set up the attributes
	String restaurantName;
	String restaurantTelephone;

	String restaurantLocation;

	// constructor
	public Restaurant(String restaurantName, String restaurantTelephone,

			String restaurantLocation) {
		this.restaurantName = restaurantName;
		this.restaurantTelephone = restaurantTelephone;

		this.restaurantLocation = restaurantLocation;

	}

	/// getters
	public String getRestaurantName() {
		return restaurantName;
	}

	public String getRestaurantTelephone() {
		return restaurantTelephone;

	}

	public String getRestaurantLocation() {
		return restaurantLocation;
	}

}
