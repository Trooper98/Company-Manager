package a3Clutch;
import java.util.*;

public class ReusaxCorp {

private  ArrayList<Employee> reusaxEmployees = new ArrayList<Employee>();

	public void addEmployee(Employee object) {
		this.reusaxEmployees.add(object);
	}//end of method
	
	public int employeeSize() {
		return this.reusaxEmployees.size();
	}
	
	public boolean retreiveEmployeeBoolean(String id) {
		boolean foundEmployee = false;
		for(Employee i: reusaxEmployees) {
			Employee x = i;
			if(x.getId().equals(id)) {
				foundEmployee = true;
				break;
			}
		}
		return foundEmployee;
	}
	
	public Employee retreiveEmployeeType(String id) {
		Employee foundEmployee = null;
		for(Employee employee: reusaxEmployees) {
			if(employee.getId().equals(id)) {
				foundEmployee = employee;
			}
			break;
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
	
	public void printAll() {
		for(Employee employee: reusaxEmployees) {
			System.out.println(employee.toString());
		}
	}
	
	public void sortEmployees() {
		Collections.sort(reusaxEmployees);
	}
	
	
}
 