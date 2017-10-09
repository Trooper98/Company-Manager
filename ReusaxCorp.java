package Try;

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
	
	public void totalEmployees() {
         for(int i = 0; i < reusaxEmployees.size(); i++) {
			if(reusaxEmployees.get(i) != null) {
				int num = i;
				//System.out.println("\n" + reusaxEmployees.get(i).toString() + "\n");
				}
			System.out.println("The total number of employees is: " + (i + 1));
		}
	}

}

	