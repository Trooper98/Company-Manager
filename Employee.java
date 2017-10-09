package Try;

public class Employee {
	
	private String id;//change to a "UUID"
	private String name;
	private double grossSalary;
	
	public Employee(String id, String name, double grossSalary){
		this.id = id;
		this.name = name;
		this.grossSalary = grossSalary;
	}//end of constructor

	
	public String getId() {
		String result = id;
		return result;
	}

	public String getName() {
		String result = name;
		return result;
		//return this.id;
	}

	public double getGrossSalary() {
		double result = grossSalary;
		return result;
	}

	public double getNetSalary() {
	return getGrossSalary() - (getGrossSalary() * 0.1);	
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}
	
	public String toString() {
		final String END_OF_LINE = System.lineSeparator();
		
		String result = getName() + " ( ID: " + id + " ) " + END_OF_LINE
		              + "Gross salary is " + getGrossSalary() + " SEK per month." + END_OF_LINE
		              + "Net salary is " + getNetSalary() + " SEK per month." + END_OF_LINE;
		return result;	
	}
}
