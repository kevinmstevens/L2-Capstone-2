package QuickFood2;
//define the DisplayFunction interface
//For each type (Customer, Restaurant, Pizza), we'll create implementations of this interface:
//being CustomerDisplayFunction.java, RestaurantDisplayFunction.java, PizzaFunction.java
public interface DisplayFunction<T> {
	String getDisplayString(T item);
}
