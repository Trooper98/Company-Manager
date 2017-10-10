package a3Clutch;

//import java.util.Comparator;
//implements Comparator
public abstract class Employee implements Comparable <Employee> {
	
	public Employee() {
	}// end of constructor
	
	public abstract String getId();
	public abstract String getName();
	public abstract double getGrossSalary();
	public abstract double getNetSalary();
	public abstract void setName(String name);
	public abstract void setGrossSalary(double grossSalary);
	
	/*@Override
	public int compare(Employee employee1, Employee employee2) {
		if(employee1.getName().compareTo(employee2.getName()) != 0) {
			return employee1.getName().compareTo(employee2.getName());
		}else {
			if(employee1.getGrossSalary() < employee2.getGrossSalary()) {
				return -1;
			} else if(employee1.getGrossSalary() > employee2.getGrossSalary()) {
				return 1;
			} else {
				return 0;
			}
				
		}
	}//end of method 1
	*/
	
	@Override
	public int compareTo(Employee otherEmployee) {
		int compareValue = this.getName().compareTo(otherEmployee.getName());
		if (compareValue == 0) {
			if (this.getGrossSalary() <otherEmployee.getGrossSalary()) {
				compareValue = -1;
			} else if (this.getGrossSalary() > otherEmployee.getGrossSalary()) {
				compareValue = 1;
			}
		} else {
			if (compareValue < 0) {
				compareValue = -1;
			} else if (compareValue > 0) {
				compareValue = 1;
			}
		}

		return compareValue;
	}
	
	
}
