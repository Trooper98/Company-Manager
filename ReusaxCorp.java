package Try;

import java.util.ArrayList;

public class ReusaxCorp {
    private  ArrayList<Employee> reusaxEmployees = new ArrayList<Employee>();
	
	public void addEmployee(Employee object) {
		this.reusaxEmployees.add(object);
	}//end of method
	
	public int employeeSize() {
		int total = reusaxEmployees.size();
		System.out.println("\n" + "The total number of employees is: " + total + "\n");
		return total;
		
	}
	
	public Employee searchId(String id) {
		Employee companyEmployee = null;
		
		for(int i = 0; i < reusaxEmployees.size(); i++) {
			
			if(id.equals(reusaxEmployees.get(i).getId())) {
				companyEmployee = reusaxEmployees.get(i);
			 }//end of statement
		}//end of loop
		return companyEmployee;
	}
	
	public void removeEmployee(Employee object) {
		this.reusaxEmployees.remove(object);
	}
	
	public void promoteToManager(String id, String academicDegree) {
		
		
	}
    
	public void promoteToDirector(String id, String academicDegree, String department) {
		
	}
	
	public void promoteToIntern(String id, String gpa) {
		
	}
	
	public void promoteToEmployee(String id) {
		
	}
}

	