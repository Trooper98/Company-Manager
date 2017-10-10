package a3Clutch;

public class Director extends Manager {

	private String department;
	
	private double directorBenefit = 0;
	
	public Director(String id, String name, double grossSalary, String academicDegree, String department){
		super(id, name, grossSalary, academicDegree);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public double getDirectorBenefit() {
		return directorBenefit;
	}

	@Override
	public double getGrossSalary() {
		return (super.getGrossSalary() + this.getDirectorBenefit());
	}
	
	@Override
	public double getNetSalary() {
		double afterTax = this.getGrossSalary();
		final double TAX10 = 0.1;
		final double TAX20 = 0.2;
		final double TAX40 = 0.4;
		final double TAX_BRACKET1 = 30000;
		final double TAX_BRACKET2 = 50000;
		
		if(this.getGrossSalary() < TAX_BRACKET1) {
			afterTax = this.getGrossSalary() - (this.getGrossSalary()*TAX10);
		}else if(this.getGrossSalary() >= TAX_BRACKET1 && this.getGrossSalary() < TAX_BRACKET2) {
			afterTax = this.getGrossSalary() - (this.getGrossSalary()*TAX20);
		}else if(this.getGrossSalary() >= TAX_BRACKET2) {
			afterTax = this.getGrossSalary() - (TAX_BRACKET1 *TAX20) - ((this.getGrossSalary() -TAX_BRACKET1) * TAX40);
		}
		
		return afterTax;
	}
	
	
	public void setDepartment(String department) {
		this.department = department;
	}

	public void setDirectorBenefit(double directorBenefit) {
		this.directorBenefit = directorBenefit;
	}
	
	@Override
	public String toString() {
		final String END_OF_LINE = System.lineSeparator();
		String result ="Director of " + this.getDepartment() + END_OF_LINE
				      + " Name: " + getName() + " ( ID: " + getId() + " ) " + END_OF_LINE
			          +" Academic degree: " + this.getAcademicDegree() + END_OF_LINE
	                  + " Gross salary: " + this.getGrossSalary() + " SEK per month."+ END_OF_LINE
		              + " Net salary: " + this.getNetSalary() + " SEK per month." + END_OF_LINE;
		return result;
	}
	
}
