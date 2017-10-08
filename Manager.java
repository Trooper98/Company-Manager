package a3ReusaxCorp;

public class Manager extends Employee {

	private String academicDegree;
	
	private final String BACHELOR = "BSc.";
	private final String MASTER = "MSc.";
	private final String PHD = "PhD";
	private final double BACHELOR_BENEFIT = super.getGrossSalary() * 0.1;
	private final double MASTER_BENEFIT = super.getGrossSalary() * 0.2;
	private final double PHD_BENEFIT = super.getGrossSalary() * 0.35;
	
	
	public Manager(String id, String name, double grossSalary, String academicDegree){
		super(id, name, grossSalary);
		this.academicDegree = academicDegree;
	}

	public String getAcademicDegree() {
		return academicDegree;
	}

	public void setAcademicDegree(String academicDegree) {
		this.academicDegree = academicDegree;
	}
	
	@Override
	public double getGrossSalary() {
		double SalaryWithBonus = super.getGrossSalary();
		if(getAcademicDegree().equals(BACHELOR)) {
			setGrossSalary(super.getGrossSalary() + BACHELOR_BENEFIT);
			SalaryWithBonus = super.getGrossSalary();
		}else if (getAcademicDegree().equals(MASTER)) {
			setGrossSalary(super.getGrossSalary() + MASTER_BENEFIT);
			SalaryWithBonus = super.getGrossSalary();
		}else if (getAcademicDegree().equals(PHD)) {
			setGrossSalary(super.getGrossSalary() + PHD_BENEFIT);
			SalaryWithBonus = super.getGrossSalary();
		}
		
		return SalaryWithBonus;
	}
	
	
}//end of manager class
