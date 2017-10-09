package Try;

public class Director extends Manager {
	
	private String department;
	
	private final double DIRECTOR_BENEFIT = 5000;
	private final double TAX_BRACKET1 = 30000;
	private final double TAX_BRACKET2 = 50000;
	
	Director(String id, String name, double grossSalary, String academicDegree, String department){
		super(id, name, grossSalary, academicDegree);
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public double getGrossSalary() {
		return (super.getGrossSalary() + DIRECTOR_BENEFIT);
	}
	
	@Override
	public double getNetSalary() {
		double afterTax = getGrossSalary();
		final double TAX20 = 0.2;
		final double TAX40 = 0.4;
		
		if(getGrossSalary() < TAX_BRACKET1) {
			afterTax = super.getNetSalary();
		}else if(getGrossSalary() >= TAX_BRACKET1 && getGrossSalary() < TAX_BRACKET2) {
			afterTax = getGrossSalary() - (getGrossSalary()*TAX20);
		}else if(getGrossSalary() >= TAX_BRACKET2) {
			afterTax = getGrossSalary() - (TAX_BRACKET1 *TAX20) - ((getGrossSalary() -TAX_BRACKET1) * TAX40);
		}
		
		return afterTax;
	}

	public String toString() {
		final String END_OF_LINE = System.lineSeparator();
		String result ="Director of " + department + END_OF_LINE
				      + getName() + " ( ID: " + getId() + " ) " + END_OF_LINE
			          +"Academic degree: " + getAcademicDegree() + END_OF_LINE
	                  + "Gross salary is " + getGrossSalary() + " SEK per month."+ END_OF_LINE
		              + "Net salary is " + getNetSalary() + " SEK per month." + END_OF_LINE;
		return result;
	}
}//end of director class