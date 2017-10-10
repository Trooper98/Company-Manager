package a3Clutch;

public abstract class Employee {
	
	public Employee() {
	}// end of constructor
	
	public abstract String getId();
	public abstract String getName();
	public abstract double getGrossSalary();
	public abstract double getNetSalary();
	public abstract void setName(String name);
	public abstract void setGrossSalary(double grossSalary);
}
