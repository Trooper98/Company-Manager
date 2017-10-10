package a3Clutch;

public class Intern extends Employee{

	private String id;
	private String name;
	private double grossSalary;
	private double gpa;
	
	public Intern(String id, String name, double grossSalary, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.grossSalary = grossSalary;
		this.gpa = gpa;
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
		final double BONUS = 1000;
		final double NO_SALARY = 0;
		double internSalary = NO_SALARY;

		if (getGpa() <= 5) {
		} else if (getGpa() > 5 && getGpa() < 8) {
			internSalary = this.grossSalary;
		} else if (getGpa() >= 8 && getGpa() <= 10) {
			internSalary = (this.grossSalary + BONUS);
		}
		return internSalary;
	}

	public double getActualSalary() {
		return this.grossSalary;
	}
	
	@Override
	public double getNetSalary() {
		return getGrossSalary();
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
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
		String result = " Name: " + getName() + " ( ID: " + getId() + " ) " + END_OF_LINE 
				+ "GPA: " + getGpa() + END_OF_LINE 
				+ "Gross salary: " + getGrossSalary() + " SEK per month." + END_OF_LINE
				+ "Net salary: " + getNetSalary() + " SEK per month." + END_OF_LINE;
		return result;
	}
}
