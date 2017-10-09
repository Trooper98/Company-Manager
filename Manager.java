package Try;

public class Manager extends Employee {

		protected String academicDegree;
		
		private final String BACHELOR = "BSc.";
		private final String MASTER = "MSc.";
		private final String PHD = "PhD";
		private final double BACHELOR_BENEFIT = super.getGrossSalary() * 0.1;
		private final double MASTER_BENEFIT = super.getGrossSalary() * 0.2;
		private final double PHD_BENEFIT = super.getGrossSalary() * 0.35;
		
		
		Manager(String id, String name, double grossSalary, String academicDegree){
			super(id, name, grossSalary);
			this.academicDegree = academicDegree;
		}

		public String getAcademicDegree() {
			String result = academicDegree;
			return result;
		}

		public String setAcademicDegree(String newDegree) {
			academicDegree = newDegree;
			return academicDegree;
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
		
		public String toString() {
			final String END_OF_LINE = System.lineSeparator();
			
			String result ="Manager " + name + " ( ID: " + id + " ) " + END_OF_LINE
					      +"Academic degree: " + academicDegree + END_OF_LINE
			              + "Gross salary is " + getGrossSalary() + " SEK per month."+ END_OF_LINE;
			return result;	
		}
		
	}//end of manager class

