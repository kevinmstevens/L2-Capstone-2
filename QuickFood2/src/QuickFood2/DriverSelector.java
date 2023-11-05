package QuickFood2;

/*PSEUDOCODE
 * I have put the driver selector code in a separate method rather than keep it in FileReader.
 * this method gets the driver with the smallest load in the desired location
 * iterate through the text file and check the location and keep track of the record that has the smallest value
 * the MAX_VALUE technique is a useful one here to start the smallest value with a really large one
 * having to trim the records due to leading spaces but there may be better ways to bring csv in
 *
 *REFACTORING: moved the getSuitableDriver into DriverSelector, better here than in invoice generator.  
 *so by the time we generate an invoice we will have a suitable driver (or none)
 *added error handling around ParseInt - i got errors when refactoring and this helped me work out the errors
 *
 *REFACTORING 2: when getSuitableDriver is called, firstly it calls getDriverInfoFilePath to read the properties file and get the path to 'driver-info.txt'.  So if somebody changes the file path in the future, we can update the properties with actually changing and compiling the java code.
 */
import java.util.List;
import java.io.InputStream;
import java.util.Properties;

public class DriverSelector {
	
	// new method to read properties file and get the file path
	private static String getDriverInfoFilePath() {
		Properties prop = new Properties();
		try (InputStream input = DriverSelector.class.getClassLoader().getResourceAsStream("config.properties")){
			if (input == null) {
				throw new RuntimeException("Sorry, unable to find config.properies file.");
			}
			// load a properties file from the class path
			prop.load(input);
			
			//Get the property value and return it
			return prop.getProperty("driverInfoFilePath");
		} catch (Exception ex) {
			throw new RuntimeException("Error reading the config.properties file.", ex);
		}
	}
	
	public static Driver getDriverWithSmallestLoad(List<List<String>> records, String desiredLocation) {
		List<String> smallestRecord = null;
		int smallestValue = Integer.MAX_VALUE;
		for (List<String> record : records) {
			if (record.size() > 2 && desiredLocation.equals(record.get(1).trim())) {
				String myString = record.get(2).trim();
				try {
					int value = Integer.parseInt(myString);

					if (value < smallestValue) {
						smallestValue = value;
						smallestRecord = record;
					}
				} catch (NumberFormatException e) {
					System.err.println("Failed to parse string: " + myString + " to an integer.");
				}
			}
		}

		if (smallestRecord != null) {
			return new Driver(smallestRecord.get(0).trim(), smallestRecord.get(1).trim(), smallestValue);
		} else {
			return null; // return null but could return exception
		}
	}

	public static Driver getSuitableDriver(String customerLocation) {
		String filePath = getDriverInfoFilePath(); //using the new method
		List<List<String>> records = FileReader.reader(filePath);
		return getDriverWithSmallestLoad(records, customerLocation);
	}

}
