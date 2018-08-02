package co.grandcircus.countrylist;

import java.util.Scanner;

public class CountriesMethods {

	// Scanner
	static Scanner scnr = new Scanner(System.in);

	// Builds country object
	public static Countries UserCountryFormatted() {
		// Take user input for new car
		System.out.println("What country would you like to add?");
		System.out.print("Enter Country: ");
		String userCountry = Validator.getStringWithValidInformation(scnr, "");
		System.out.print("Enter Population: ");
		int userPopulation = Validator.getInt(scnr, "");
		scnr.nextLine();
		System.out.print("Enter Continant: ");
		String userContinant = Validator.getStringWithValidInformation(scnr, "");
		Countries userEnteredCountry = new Countries(userCountry, userPopulation, userContinant);
		return userEnteredCountry;

	}

}
