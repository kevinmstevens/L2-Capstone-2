package QuickFood2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerUtility {
	private static Scanner scanner = new Scanner(System.in);

	public static String getString(String prompt) {
		System.out.println(prompt);
		return scanner.nextLine();
	}

	public static int getInt(String prompt) {
		int result = -1;
		boolean valid = false;
		while (!valid) {
			System.out.println(prompt);
			try {
				result = scanner.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
			} finally {
				scanner.nextLine(); // Clear scanner
			}
		}
		return result;
	}
}
