package QuickFood2;

import java.util.ArrayList;
import java.util.List;

//initialise and setup up the data for the application, this is AppData class; it is the data structure for all the data the application will have
//within this class we encapsulate the setup logic in a separate method AppData(),  creating the arrayLists for customers, restaurants and orders which will be referenced by 
// AppData setup() method populates the test data too.
public class AppData {
	// set up ArrayLists for customers, restaurants and orders
	// use private access modifiers for instance variables
	public List<Customer> customers;
	public List<Restaurant> restaurants;
	public List<Order> orders;
	public Menu menu;

	public AppData() {
		customers = new ArrayList<>();
		restaurants = new ArrayList<>();
		orders = new ArrayList<>();

		// set up menu object for the pizza menu
		menu = new Menu();
	}
	public static AppData setupWithTestData() {
		AppData appData = new AppData();
		TestDataUtility.populateTestData(appData.customers, appData.restaurants);

		return appData;
	
	}
}
