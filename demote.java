package a3Clutch;

public class demote { //delete this line
	public void demote(Employee employee) {
		String id = employee.getId();
		String name = employee.getName();
		double grossSalary = employee.getGrossSalary();
		String academicDegree = ((Manager) employee).getAcademicDegree();
		double gpa = ((Intern) employee).getGpa();
		if (employee instanceof Manager) {
			company.removeEmployee(employee);
			Employee newEmployee = new RegularEmployee(id, name, grossSalary);
			company.addEmployee(newEmployee);
			System.out.println("The manager is demoted to regular employee.");
		}else if (employee instanceof Director) {
			company.removeEmployee(employee);
			Employee newEmployee = new Manager(id, name, grossSalary, academicDegree);
			company.addEmployee(newEmployee);
			System.out.println("The director is demoted to manager.");
		}else if ( employee instanceof RegularEmployee) {
			System.out.println("Enter the GPA of the new intern: ");
			double newGpa = input.nextDouble();
			company.removeEmployee(employee);
			Employee newEmployee = new Intern(id, name, grossSalary, newGpa);
			company.addEmployee(newEmployee);
			System.out.println("The regular employee is demoted to intern.");
			
		}else {
			System.out.println(
					"Employe of Id " + employee.getId() + " cannot be promoted because it's at lowest position.");
		}
		
    }
}//delete slash
