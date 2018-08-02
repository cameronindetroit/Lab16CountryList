package co.grandcircus.countrylist;

public class Countries {

	// Class variables
	private String name;
	private int population;
	private String continant;

	// constructors
	public Countries(String name, int population, String continant) {
		this.name = name;
		this.population = population;
		this.continant = continant;

	}

	public Countries() {

	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getContinant() {
		return continant;
	}

	public void setContinant(String continant) {
		this.continant = continant;
	}

	@Override
	public String toString() {

		String line = String.format("%-15s %,-15d %-15s", name, population, continant);
		return line;
	}

}
