package a3ReusaxCorp;

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
		return id;
	}

	public String getName() {
		return name;
	}

	public double getGrossSalary() {
		return grossSalary;
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
	
}//end of employee class
