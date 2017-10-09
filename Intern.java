package Try;

public class Intern extends Employee{

	private double gpa;
	
	public Intern(String id, String name, double grossSalary, double gpa){
		super(id, name, grossSalary);
		this.gpa = gpa;
	}
	
	
	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public double getGrossSalary() {
		final double BONUS = 1000;
		final double NO_SALARY = 0;
		double internSalary = NO_SALARY;
		
		if(getGpa() <= 5 ) {
		}else if(getGpa() > 5 && getGpa() < 8) {
			internSalary = super.getGrossSalary();
		}else if(getGpa() >= 8 && getGpa() <= 10){
			internSalary = (super.getGrossSalary() + BONUS);
		}
		
		return internSalary;
	}

	@Override
	public double getNetSalary() {
		return getGrossSalary();
	}
	
	public String toString() {
		final String END_OF_LINE = System.lineSeparator();
		String result ="Intern " + getName() + " ( ID: " + getId() + " ) " + END_OF_LINE
			          +"GPA: " + getGpa() + END_OF_LINE
	                  + "Gross salary is " + getGrossSalary() + " SEK per month."+ END_OF_LINE
	                  + "Net salary is " + getNetSalary() + " SEK per month." + END_OF_LINE;
		return result;
	}
}//end of intern class
