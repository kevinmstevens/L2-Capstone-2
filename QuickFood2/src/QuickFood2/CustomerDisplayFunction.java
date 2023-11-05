package QuickFood2;
//Implements the DisplayFunction interface
public class CustomerDisplayFunction implements DisplayFunction<Customer>{
	@Override
	public String getDisplayString(Customer customer) {
		return customer.getCustomerName();
	}
}