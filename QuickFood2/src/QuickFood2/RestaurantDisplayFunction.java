package QuickFood2;
//Implements the DisplayFunction interface
public class RestaurantDisplayFunction implements DisplayFunction<Restaurant>{
		@Override
		public String getDisplayString(Restaurant restaurant) {
			return restaurant.getRestaurantName();
		}
	
}
