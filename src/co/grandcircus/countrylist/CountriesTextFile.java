package co.grandcircus.countrylist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesTextFile {

	// The path to the file to use
	public static final String FILE_NAME = "countries.txt";

	// Modify this method as necessary to convert a line of text from the file to a
	// new item instance
	private static Countries convertLineToItem(String line) {
		String[] parts = line.split("---");
		Countries country = new Countries();
		country.setName(parts[0]);
		country.setPopulation(Integer.parseInt(parts[1]));
		country.setContinant(parts[2]);
		return country;
	}

	// Modify this method as necessary to convert an item instance to a line of text
	// in the file
	private static String convertItemToLine(Countries country) {
		return String.format("%s---%d---%s", country.getName(), country.getPopulation(), country.getContinant());
	}

	// Read File Method
	public static List<Countries> readFile() {
		List<Countries> items = new ArrayList<>();

		try (
				// Open/prepare the resources in the try resources block
				FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
				Scanner fileScanner = new Scanner(fileInputStream)) {
			// loop until the end of the file
			while (fileScanner.hasNextLine()) {
				// read each line as a string
				String line = fileScanner.nextLine();
				// then convert it to an object
				items.add(convertLineToItem(line));
			}

		} catch (FileNotFoundException ex) {
			// If the file doesn't exist, there just aren't any items.
			return items;
		} catch (IOException e) {
			// If something else crazy goes wrong, print out the error.
			System.err.println("Something unexpected happended.");
			e.printStackTrace();
		}

		// Finally return the array of items.
		return items;

	}

	// Add item to file
	public static void appendLine(Countries country) {
		// convert player object to a string line of text to be written to the file
		String line = convertItemToLine(country);

		try (
				// The `true` here tells the FileOutputStream to append to the file rather than
				// overwriting it
				FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, true);
				PrintWriter fileWriter = new PrintWriter(fileOutputStream);) {
			// write to the file
			fileWriter.println(line);

		} catch (IOException e) {
			// If something else crazy goes wrong, print out the error.
			System.err.println("Something unexpected happended.");
			e.printStackTrace();
		}
	}

	// Write to file
	public static void writeFile(List<Countries> items) {
		try (
				// The `false` here tells the FileOutputStream to overwrite the file, rather
				// than append to it
				FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME, false);
				PrintWriter fileWriter = new PrintWriter(fileOutputStream);) {
			// write to the file
			for (Countries item : items) {
				// each item must be converted to a string of text to write to the file
				String line = convertItemToLine(item);
				fileWriter.println(line);
			}

		} catch (IOException e) {
			// If something else crazy goes wrong, print out the error.
			System.err.println("Something unexpected happended.");
			e.printStackTrace();
		}
	}

}
