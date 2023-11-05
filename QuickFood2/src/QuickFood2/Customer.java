package QuickFood2;

public class Customer {
	// set up the attributes which are common to all Customers
	String customerName;
	String customerTelephone;
	String customerAddress;
	String customerLocation;
	String customerEmail;

	// constructor
	public Customer(String customerName, String customerTelephone, String customerAddress, String customerLocation,
			String customerEmail) {
		this.customerName = customerName;
		this.customerTelephone = customerTelephone;
		this.customerAddress = customerAddress;
		this.customerLocation = customerLocation;
		this.customerEmail = customerEmail;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerTelephone() {
		return customerTelephone;

	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getCustomerLocation() {
		return customerLocation;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

}
