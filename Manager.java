package a3Clutch;

public class Manager extends Employee{
	
	private String id;
	private String name;
	private double grossSalary;
	private String academicDegree;
	
	private final String BACHELOR = "BSc.";
	private final String MASTER = "MSc.";
	private final String PHD = "PhD";
	private final double BACHELOR_BENEFIT = 0.1;
	private final double MASTER_BENEFIT = 0.2;
	private final double PHD_BENEFIT =  0.35;
	
	public Manager(String id, String name, double grossSalary, String academicDegree) {
		super();
		this.id = id;
		this.name = name;
		this.grossSalary = grossSalary;
		this.academicDegree = academicDegree; 
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
		double totalGrossSalary = 0;
		if(getAcademicDegree().equals(BACHELOR)) {
			//setGrossSalary(this.grossSalary + (BACHELOR_BENEFIT*this.grossSalary));
			//totalGrossSalary = this.grossSalary;
			
			totalGrossSalary = this.grossSalary + (BACHELOR_BENEFIT*this.grossSalary);
		}else if(getAcademicDegree().equals(MASTER)) {
			//setGrossSalary(this.grossSalary + (MASTER_BENEFIT*this.grossSalary));
			//totalGrossSalary = this.grossSalary;
			
			totalGrossSalary = this.grossSalary + (MASTER_BENEFIT*this.grossSalary);
		}else if(getAcademicDegree().equals(PHD)) {
			//setGrossSalary(this.grossSalary + (PHD_BENEFIT*this.grossSalary));
			//totalGrossSalary = this.grossSalary;
			
			
			totalGrossSalary = this.grossSalary + (PHD_BENEFIT*this.grossSalary);
		}
		return totalGrossSalary;
	}

	@Override
	public double getNetSalary() {
		final double TAX10 = 0.1;
		return getGrossSalary() - (getGrossSalary()  * TAX10);
	}
	
	public String getAcademicDegree() {
		return academicDegree;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}
	
	@Override
	public String toString() {
		final String END_OF_LINE = System.lineSeparator();
		
		String result = "Name: " + getName() + " ( ID: " + getId() + " ) " + END_OF_LINE
				      + "Academic degree: " + getAcademicDegree() + END_OF_LINE
		              + "Gross salary: " + getGrossSalary() + " SEK per month."+ END_OF_LINE
		              + "Net Salary: " + getNetSalary() + END_OF_LINE;
		return result;	
	}

}
