package QuickFood2;

import java.util.ArrayList;
import java.util.List;

/*A simple Menu of pizzas object.
 * we assume all restaurants have the same menu and prices!
 * nor do we offer the functionality to update the menu, it's hardcoded
 * returns pizzas which is a list of pizzas on offer
 *
 *REFACTORING: the pizzas list was public, now make it private and the class shall provide methods to manipulate the list rather than allow access directly.
 *This will make it easier to write methods to update prices and add/remove prices.  And give each restaurant a different menu.  Also if we add other products we need to support that.
 */
public class Menu {
	private List<Pizza> pizzas;

	public Menu() {
		this.pizzas = new ArrayList<>();
		initialisePizzas();
	}

	// initialise default pizzas
	private void initialisePizzas() {

		pizzas.add(new Pizza("Pepperoni", 78.00));
		pizzas.add(new Pizza("Hawaiian", 82.00));
		pizzas.add(new Pizza("American Hot", 80.00));
	}

	public List<Pizza> getPizzas() {
		return new ArrayList<>(pizzas); // returns a copy so we don't change it....defensive programming
	}

	/// to add a pizza to the list (note in future we should consider remove???)
	public void addPizza(Pizza pizza) {
		this.pizzas.add(pizza);

	}

}
