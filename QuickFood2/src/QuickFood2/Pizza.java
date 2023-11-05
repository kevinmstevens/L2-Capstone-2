package QuickFood2;

/*A Pizza object.  This is passed into the program to allow selections to be made from the menu 
 * as well as pass the prices into the order and the invoice
 * 
 */
public class Pizza {
	public String name;
	public double price;

	public Pizza(String name, double price) {
		this.name = name;
		this.price = price;

	}

	public String getName() {
		return name;

	}

	public double getPrice() {
		return price;
	}

	public String toString() {
		return name + " : R" + price;
	}
}
