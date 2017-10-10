package a3Clutch;

public class RegularEmployee extends Employee {
	
	private String id;
	private String name;
	private double grossSalary;
	
	public RegularEmployee(String id, String name, double grossSalary) {
		super();
		this.id = id;
		this.name = name;
		this.grossSalary = grossSalary;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getGrossSalary() {
		return grossSalary;
	}

	@Override
	public double getNetSalary() {
		return getGrossSalary() - (getGrossSalary() * 0.1);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	@Override
	public String toString() {
		final String END_OF_LINE = System.lineSeparator();

		String result = " Name: " + name + " ( ID: " + getId() + " ) " + END_OF_LINE + " Gross salary: " + getGrossSalary()
				+ " SEK per month." + END_OF_LINE + " Net salary: " + getNetSalary() + " SEK per month." + END_OF_LINE;
		return result;
	}
}
