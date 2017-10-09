package Try;

import java.util.Scanner;
import Try.Employee;
import Try.Manager;
import Try.ReusaxCorp;
import Try.Director;
import Try.Intern;

public class ReusaxCorpMain {
    
	private static final int REGISTER_EMPLOYEE = 1; //done
	private static final int REMOVE_EMPLOYEE = 2; //done
	private static final int PRINT_EMPLOYEE = 3; //done
	private static final int UPDATE_EMPLOYEE = 4; //done
	private static final int TOTAL_GROSS_SALARY = 5;
	private static final int TOTAL_NET_SALARY = 6;
	private static final int TOTAL_EMPLOYEES = 7; //done
	private static final int QUIT = 8;
	
	Scanner input = new Scanner(System.in);
	ReusaxCorp company = new ReusaxCorp();
	
	public static void main(String[] args) {
		ReusaxCorpMain program = new ReusaxCorpMain();
		program.run();
	}
    
	private void printMenuOptions() {
		System.out.println(" =================================================== ");
		System.out.println(" === Reusax Corporate Employee Management System === ");
		System.out.println(" ===                                             === ");
		System.out.println(" ===            Choose an option below:          === ");
		System.out.println(" ===           1. Register an employee.          === ");
		System.out.println(" ===            2. Remove an employee.           === ");
		System.out.println(" ===     3. Print an employee's information.     === ");
		System.out.println(" ===     4. Update an employee's information.    === ");
		System.out.println(" ===   5. Current total gross salary payments.   === ");
		System.out.println(" ===    6. Current total net salary payments.    === ");
		System.out.println(" ===             7. Total Employees.             === ");
		System.out.println(" ===               8.Quit program                === ");
		System.out.println(" =================================================== ");
	}
	
	public void retrieveEmployee() {
		System.out.println(" === Search Employee === ");
		System.out.println();
		System.out.print(" Enter the employee's ID: ");
		String idSearch = input.nextLine();

		if(company.searchId(idSearch) == null) {
			System.out.println("\n" + idSearch + " was not found." + "\n");
			}else {
			System.out.println(company.searchId(idSearch));
		}
	}
	
	public String readEmployeeID() {
		System.out.print(" Type the ID of the employee: ");
		String employeeID = input.nextLine();
		return employeeID;
	}

	public void registrationOptions() {
		System.out.println("\n" + " === Registration === ");
		System.out.println(" Choose an option below: ");
		System.out.println();
		System.out.println(" 1. Register Regular Employee. ");
		System.out.println(" 2. Register Manager. ");
		System.out.println(" 3. Register Director.");
		System.out.println(" 4. Register Intern.");
	}//end of employee registration
	
//1
    public Employee registerEmployee() {
    	    final int REGULAR_EMPLOYEE = 1;
		final int MANAGER = 2;
		final int DIRECTOR = 3;
		final int INTERN = 4;
		
		System.out.print(" Please enter the employee's ID: ");
		String id = input.nextLine();
		Employee foundEmployee = company.searchId(id);
		
		if (foundEmployee == null) {
			
		registrationOptions();
		int employeeType = input.nextInt();
		input.nextLine(); 
		
		switch(employeeType) {
		
		case REGULAR_EMPLOYEE:
		   {
			System.out.print(" Please enter the employee's name: ");
			String name = input.nextLine();
		
			System.out.print(" Please enter the employee's gross salary: ");
			double grossSalary = input.nextDouble();
		
		    Employee newEmployee = new Employee(id, name, grossSalary);
		    company.addEmployee(newEmployee);
		    //System.out.println();
		    //System.out.println(newEmployee.toString());
		    
		    }
		    break;
		    
		case MANAGER:
		   {
			final String BACHELOR = "BSc.";
			final String MASTER = "MSc.";
			final String PHD = "PhD";
			
			System.out.println();
			System.out.println(" Enter name: ");
			String name = input.next();
			
			System.out.println(" Enter gross salary: ");
			double salary = input.nextDouble();
			
			System.out.println(" Enter academic: ");
			System.out.println(" 1. Bachelor (BSc.)"
			+ "\n 2. Master (MSc.)" + "\n 3. PhD.");
			String degree = "";
			double userInp = input.nextInt();
			if(userInp == 1) {
				degree = BACHELOR;
			}else if(userInp == 2) {
				degree = MASTER;
			}else if(userInp == 3) {
				degree = PHD;
			}else {
				System.out.println("You entered an invalid option.");
			}
			Employee newEmployee = new Manager(id, name, salary, degree);
			company.addEmployee(newEmployee);
		    }
		    break;
		    
		case DIRECTOR: 
		    {
		    	 final String BACHELOR = "BSc.";
		     final String MASTER = "MSc.";
		     final String PHD = "PhD";
			 final int BUSINESS = 1;
			 final int TECHNICAL = 2;
			 final int HUMAN_RESOURCES = 3;
				
			 System.out.println();
			 System.out.println(" Enter name: ");
			 String name = input.next();
				
			 System.out.println();
			 System.out.println(" Enter gross salary: ");
			 double salary = input.nextDouble();
			 System.out.println();
				
			 System.out.println();
			 System.out.println(" Enter academic: " + "\n 1. Bachelor (BSc.)"
				+ "\n 2. Master (MSc.)" + "\n 3. PhD.");
			 String degree = "";
			 double userInp = input.nextInt();
			 if(userInp == 1) {
				degree = BACHELOR;
			 }else if(userInp == 2) {
				degree = MASTER;
			 }else if(userInp == 3) {
				degree = PHD;
			 }else {
				 System.out.println();
				 System.out.println(" You entered an invalid option.");
				 System.out.println();
			 }
				
			 System.out.println();
			 System.out.println(" Enter department: " + "\n 1. Business department "
						+ "\n 2. Technical department" + "\n 3. Human Resources department.");
			 userInp = input.nextInt();
			 String department = "";
				
			 if(userInp == 1) {
				department = "Business department";
			 }else if(userInp == 2) {
				department = "Technical department";
			 }else if(userInp == 3) {
				department = "Human Resources department";
			 }else {
				 System.out.println("\n" + "You entered an invalid option." + "\n");
		     }
				
			 Employee newEmployee = new Director(id, name, salary, degree, department);
			 company.addEmployee(newEmployee);
			  }
		      break;
		        
		case INTERN:
		    {
			System.out.println();
			System.out.println(" Enter name: ");
			String name = input.next();
			
			System.out.println(" Enter gross salary: ");
			double salary = input.nextDouble();
			
			System.out.println(" Enter GPA: ");
			double userInp = input.nextDouble();
			System.out.println();
			double gpa = 0;
			
			if(userInp >= 0 && userInp <= 10) {
				gpa = userInp;
			}else {
				do {
					System.out.println("\n" + "You entered an invalid GPA value." + "\n");
					System.out.println(" Enter GPA: ");
					userInp = input.nextDouble();
					gpa = userInp;
				}while(userInp < 0 && userInp > 10);
			}
			Employee newEmployee = new Intern(id, name, salary, gpa);
			company.addEmployee(newEmployee);
		    }
			break;
		}
		
		}
		if (foundEmployee != null) {
			System.out.println("\n" + "Warning! There is already an employee with the ID " + id + "!");
		}
		return null;
    }
    
//2  not done!!!!!	
    public void removeEmployee() {
    	    String employeeID = readEmployeeID();
        Employee foundEmployee = company.searchId(employeeID);
        if (foundEmployee != null) {
        	   company.removeEmployee(foundEmployee);
        	   System.out.println("\n" + "Employee of ID " + employeeID + " removed." + "\n");
        }
        else {
        	System.out.println("\n" + "An employee of ID " + employeeID + " is not registered in the system." + "\n");
        }
    }

//3
    public void printOneEmployee() {
    	    String employeeID = readEmployeeID();
        Employee foundEmployee = company.searchId(employeeID);
        
        if (foundEmployee != null) {
        	   System.out.println("\n" + foundEmployee.toString() + "\n");
        	}
        else { 
        	System.out.println("\n" + "An employee of ID " + employeeID + " is not registered in the system." + "\n");
        }
    }
  
//4
    public void updateEmployee() {
    	    System.out.println("\n" + " === Update === ");
    	    String employeeID = readEmployeeID();
		Employee foundEmployee = company.searchId(employeeID);
		
		if (foundEmployee != null) {
			System.out.println(" Choose an option below: ");
	        System.out.println(" 1. Update Manager. ");
			System.out.println(" 2. Update Director.");
			System.out.println(" 3. Update Intern.");
			int updateType = input.nextInt();
			input.nextLine(); 
			
    	        final int MANAGER = 1;
		    final int DIRECTOR = 2;
		    final int INTERN = 3;
		    
		switch(updateType) {
		    case MANAGER:
		    {
		    final String BACHELOR = "BSc.";
		    final String MASTER = "MSc.";
		    final String PHD = "PhD";
		
		    System.out.println(" Enter the new degree of the manager ");
		    System.out.println(" 1. Bachelor (BSc.)"
		                      + "\n 2. Master (MSc.)" + "\n 3. PhD.");
		    String newDegree = "";
		    double userInp = input.nextInt();
		    if(userInp == 1) {
			    newDegree = BACHELOR;
		    }else if(userInp == 2) {
			    newDegree = MASTER;
		    }else if(userInp == 3) {
			    newDegree = PHD;
		    }else {
			    System.out.println("\n" + "You entered an invalid option." + "\n");
		    }
		    ((Manager) foundEmployee).setAcademicDegree(newDegree);
		    System.out.println("The manager's new academic degree is " + ((Manager) foundEmployee).getAcademicDegree());
	        }
			break;
		case DIRECTOR:
		{
		    final int BUSINESS = 1;
			final int TECHNICAL = 2;
			final int HUMAN_RESOURCES = 3;
			System.out.println(" Enter the new department of the director ");
			System.out.println("1. Business department "
					          + "\n 2. Technical department" + "\n 3. Human Resources department.");
		    double userInp = input.nextInt();
		    String newDepartment = "";
			
		    if(userInp == 1) {
			   newDepartment = "Business department";
		    }else if(userInp == 2) {
			   newDepartment = "Technical department";
		    }else if(userInp == 3) {
			   newDepartment = "Human Resources department";
		    }else {
			    System.out.println("\n" + "You entered an invalid option." + "\n");
	        }
		    ((Director) foundEmployee).setDepartment(newDepartment);
		    System.out.println("The manager's new department is " + ((Director) foundEmployee).getDepartment());
		}
			break;
		case INTERN:
		{
			System.out.println(" Enter the intern's new GPA: ");
			double userInp = input.nextDouble();
			System.out.println();
			double newGpa = 0;
			
			if(userInp >= 0 && userInp <= 10) {
				newGpa = userInp;
			}else {
				do {
					System.out.println("\n" + "You entered an invalid GPA value." + "\n");
					System.out.println(" Enter GPA: ");
					userInp = input.nextDouble();
					newGpa = userInp;
				}while(userInp < 0 && userInp > 10);
			}
			((Intern) foundEmployee).setGpa(newGpa);
		    System.out.println("The intern's new GPA is " + ((Intern) foundEmployee).getGpa());
		}
			break;
		}
		}
    }
    
    public void printEmployeeNum() {
    	       company.totalEmployees();
    }
    
    public void run() {
    	    
        int option = 0;
        do {
        	    printMenuOptions();
        	try {
		System.out.print(" Type the option number: ");
		option = input.nextInt();
		input.nextLine(); 
		
		switch(option) {
		
		case REGISTER_EMPLOYEE:
			
			Employee newEmployee = registerEmployee();
			
			System.out.println();
			if (newEmployee == null) {
				System.out.println("Employee not Registered." + "\n");
			}
			if (newEmployee != null) {
				System.out.println("Employee Registered." + "\n");
			}
			break;
			
		case REMOVE_EMPLOYEE:
			removeEmployee();
		    break;
		   
		case PRINT_EMPLOYEE:
			printOneEmployee();
			break;
			
		case UPDATE_EMPLOYEE:
			updateEmployee();
			break;
		case TOTAL_EMPLOYEES:
			printEmployeeNum();
			break;
		case QUIT:
			System.out.println("\n" + "Thank you for using Company Database!");
			break;
		 }
		 }catch (Exception e) {
				System.out.println(e + " , " + e.getMessage());
				System.out.println("Try again!");
				input.next();
		 }
         }
        while (option != QUIT);
    }
    
  
    
    
}   
