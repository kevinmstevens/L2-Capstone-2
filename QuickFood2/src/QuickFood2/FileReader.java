/*PSEUDOCODE
 * 
 * Method FileReader to read the drivers.txt file, match the desired Location and the driver with the smallest number of deliveries
 * In the event that there is more than one driver with the same smallest value, the first one found will be returned.
 * 
 * Data structure: the input file drivers.txt is a csv file with tabular rows and columns.
 * Therefore the java data structure "List<List<String>> records" represents a list of lists of strings in Java.
 * List<List<String>> is a list where each element is a list of strings.  The outer List represents the rows of a table, and the inner List<String> represents the individual cells in each row.
 * this is put into an ArrayList, so that further operations can be done.
 * 
 * 
 * 
 * references: 
 * 1. reading CSV files using the scanner class: https://www.studytonight.com/java-examples/reading-a-csv-file-in-java#:~:text=Reading%20CSV%20Files%20by%20Using,the%20comma%20as%20a%20delimiter.
 * 2. data structure - https://javahungry.blogspot.com/2020/01/list-of-lists-in-java.html
 * 3. try-with-resources Statement: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
 * 4. printStackTrace() method give us useful error messages: https://www.educative.io/answers/what-is-the-printstacktrace-method-in-java
 * 5. comma delimiter....useDelimiter method...https://www.geeksforgeeks.org/scanner-usedelimiter-method-in-java-with-examples/
 * 6. integer MAX_value technique: https://www.geeksforgeeks.org/integer-max_value-and-integer-min_value-in-java-with-examples/
 */

package QuickFood2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	// sets up a Scanner object, sets up the list of lists ie the table structure
	// and the ArrayList
	// reads each row and builds the table up row by row
	// using try-with-resources, scanner automatically closed
	// reads each line and calls getRecordFromLine method
	// returns: records. This is the table of data.
	public static List<List<String>> reader(String fileName) {
		List<List<String>> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(fileName))) {
			while (scanner.hasNextLine()) { //
				records.add(getRecordFromLine(scanner.nextLine()));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return records; // records fed back to invoice generator
	}

	// sets up the List<String> : for each row of the table
	// returns: values. This is a row of the table.
	private static List<String> getRecordFromLine(String line) {
		List<String> values = new ArrayList<>();
		try (Scanner rowScanner = new Scanner(line)) {
			rowScanner.useDelimiter(",");
			while (rowScanner.hasNext()) {
				values.add(rowScanner.next());
			}
		}
		return values;
	}
}
