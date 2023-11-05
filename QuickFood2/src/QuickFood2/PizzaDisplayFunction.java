package QuickFood2;

public class PizzaDisplayFunction implements DisplayFunction<Pizza> {
	@Override
	public String getDisplayString(Pizza pizza) {
		return pizza.getName() + " (" + pizza.getPrice() + ")";
	}
}
