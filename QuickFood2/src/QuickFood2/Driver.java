package QuickFood2;

// PSEUDOCODE

/*Creating a driver object allows us to have multiple orders and assign multiple drivers, and enable the invoices to show the driver name for each.
 */
public class Driver {
	private String name;
	private String location;
	private int load;

	public Driver(String name, String location, int load) {
		this.name = name;
		this.location = location;
		this.load = load;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public int getLoad() {
		return load;
	}
}
