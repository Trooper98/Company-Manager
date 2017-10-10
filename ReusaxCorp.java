package a3Clutch;
import java.util.ArrayList;

public class ReusaxCorp {

private  ArrayList<Employee> reusaxEmployees = new ArrayList<Employee>();
	
	public void addEmployee(Employee object) {
		this.reusaxEmployees.add(object);
	}//end of method
	
	public int employeeSize() {
		return this.reusaxEmployees.size();
	}
	
	public Employee retreiveEmp(String id) {
		Employee foundEmployee = null;
		for(Employee i: reusaxEmployees) {
			if(i.getId().equals(id)) {
				foundEmployee = i;
				break;
			}
		}
		return foundEmployee;
	}
	
	public void removeEmployee(Employee object) {
		this.reusaxEmployees.remove(object);
	}
	
	public double getTotalExpense() {
		double grossSalaryTotal = 0;
		for(int i = 0; i<reusaxEmployees.size(); i++) {
			grossSalaryTotal += reusaxEmployees.get(i).getGrossSalary();
		}
		return grossSalaryTotal;
	}
	
	public double totalNetSalary() {
		double netSalaryTotal = 0;
		for(Employee i: reusaxEmployees) {
			if(i instanceof Director) {
				netSalaryTotal = netSalaryTotal + ((Director) i).getNetSalary();
			}else if(i instanceof Manager) {
				netSalaryTotal = netSalaryTotal + ((Manager) i).getNetSalary();
			}else if(i instanceof Intern) {
				netSalaryTotal = netSalaryTotal + ((Intern) i).getNetSalary();
			}else if(i instanceof Employee) {
				netSalaryTotal = netSalaryTotal + i.getNetSalary();
			}
		}
		return netSalaryTotal;
	}
	
	public double currentBenefit() {
		double benefit = 0;
		for(Employee i: reusaxEmployees) {
			if(i instanceof Director) {
				benefit = ((Director) i).getDirectorBenefit();
				break;
			}//end of statement
		}//end of loop
		return benefit;
	}
	
	public void updateBenefit(double update) {
		for(Employee i: reusaxEmployees) {
			if(i instanceof Director) {
				((Director) i).setDirectorBenefit(update);
				break;
			}//end of statement
		}//end of loop
	}
}
