PSEUDO CODE
Main() is the entry point.

1.set up scanner
2.set up objects for customers, restaurants, orders, invoices, pizza menu
3.set up test objects for customer, restaurant
4.create the main do-while loop for the Main Menu, use switch-case to manage options

References:
user input: https://www.w3schools.com/java/showjava.asp?filename=demo_api_scanner
printStackTrace() is useful for error tracing https://stackoverflow.com/questions/2560368/what-is-the-use-of-printstacktrace-method-in-java and https://www.javatpoint.com/inputmismatchexception-in-java
switch-case menus https://stackoverflow.com/questions/53117137/repeating-for-loop-in-menu

REFACTORING
NOTE that a fundamental principle of refactoring is that NO FUNCTIONALITY IS CHANGED OR ADDED.  

5. Main: Break down Main into smaller methods.  This improves readability and makes it more modular.  Each case in the switch statement can be a separate method.  Put these new methods into utility classes.

So I have created:
i. CustomerUtility.java - takes us through the steps needed to create customers
ii. RestaurantUtility.java - akes us through the steps needed to create restaurants
iii. OrderUtility.java - this takes us through the steps to create an order 
iv. InvoiceUtility.java - creates the invoices from the orders
v. MenuUtility.java (to display the Main menus and the sub-menus for customers, restaurants and pizzas).  The customer, restaurant and pizza menus were all being displayed using their own for loops.  To avoid repeating this code I have created a method displayList in MenuUtility.java	
vi. TestDataUtility.java (for the test data)
vii.  ScannerUtility.java (encapsulating the Scanner logic)
viii.  I have put the initialisation of the ArrayLists into AppData.java and all the references to customers and restaurants etc are now appData.customers, appData.restaurants etc
 
 6. Menu.java: refactored the pizza menu to make it more modular