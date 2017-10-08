package a3ReusaxCorp;

import java.util.ArrayList;

public class ReusaxCorp {

	private  ArrayList<Employee> reusaxEmployees = new ArrayList<Employee>();
	
	public void addEmployee(Employee object) {
		this.reusaxEmployees.add(object);
	}//end of method
	
	public int employeeSize() {
		return this.reusaxEmployees.size();
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
	
	
}
