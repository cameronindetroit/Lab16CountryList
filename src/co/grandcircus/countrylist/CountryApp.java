package co.grandcircus.countrylist;

import java.util.List;
import java.util.Scanner;

public class CountryApp {

	public static void main(String[] args) {
		// Scanner
		Scanner scnr = new Scanner(System.in);

		// New Country ArrayList
		List<Countries> oldCountries = CountriesTextFile.readFile();

		// Class variables
		int userInput = 0;
		String userEnteredCountry = null;
		Countries userCountry = null;
		int removeCountry = 0;

		// Welcome message

		// user Input
		System.out.println("Welcome to the Countries Maintenance Application!");
		userInput = Validator.getInt(scnr, "\n1-See the list of countries\n2-Add a country\n3-Exit\n4-Remove", 1, 4);
		scnr.nextLine();

		// Start program based on user input
		while (userInput != 3) {

			// Path based on user input
			if (userInput == 1) {
				// List out all countries in file
				int num = 1;
				for (Countries country : oldCountries) {

					System.out.println(num + ". " + country);
					num++;

				}

				userInput = Validator.getInt(scnr, "\n1-See the list of countries\n2-Add a country\n3-Exit\n4-Remove",
						1, 4);
				scnr.nextLine();

			} else if (userInput == 2) {
				// Add countries to file
				userCountry = CountriesMethods.UserCountryFormatted();
				CountriesTextFile.appendLine(userCountry);

				userInput = Validator.getInt(scnr, "\n1-See the list of countries\n2-Add a country\n3-Exit\n4-Remove",
						1, 4);
				scnr.nextLine();

			} else if (userInput == 4) {

				// prompt user for country country to remove
				removeCountry = Validator.getInt(scnr,
						"Which country would you like to remove?\nRemove country by number");

				oldCountries.remove(removeCountry - 1);
				CountriesTextFile.writeFile(oldCountries);

				userInput = Validator.getInt(scnr, "\n1-See the list of countries\n2-Add a country\n3-Exit\n4-Remove",
						1, 4);
				scnr.nextLine();

			} else if (userInput == 3) {
				break;
			}
		}
		System.out.println("GoodBye!");

	}

}
