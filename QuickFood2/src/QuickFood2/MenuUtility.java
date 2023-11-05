package QuickFood2;

import java.util.List;
/*REFACTORING: the menus are handled here, making the code modular and cleaner
 * i then noticed that the menus are repeating the same for loop code.
 * after a bit of research i learned that we can pass arguments into a for loop so we don't need to repeat the same code 3 times
 *
 *displayList replaces the repeated for loops to display customers, restaurants and pizzas.
 *the method has 3 parameters: 
 *i. List<T>items: a list of items to be displayed. 
 *ii. DisplayFunction<T> function: an instance of the interface that enables us to get a display string for each item in the list.  <T> is a convention, for type.
 *iii. String title: printed at the top when displaying the list
 */

public class MenuUtility {

	public static <T> void displayList(List<T> items, DisplayFunction<T> function, String title) {
		System.out.println(title);
		for (int i = 0; i < items.size(); i++) {
			T item = items.get(i);
			System.out.println((i + 1) + ". " + function.getDisplayString(item));
		}
	}

	public static void displayMainMenu() {

		System.out.println("QUICKFOOD V2 - REFACTORED \nMain menu:");
		System.out.println("1. Enter a new customer");
		System.out.println("2. Enter a new restaurant");
		System.out.println("3. Print customers");
		System.out.println("4. Print restaurants");
		System.out.println("5. Input new order");
		System.out.println("6. Print all orders to screen");
		System.out.println("7. Print all invoices to screen");
		System.out.println("8. Generate invoice files to .txt file");
		System.out.println("99. Exit"); /// generally input 99 to exit something, rather than Q as Q is not an
										/// integer

	}

}
