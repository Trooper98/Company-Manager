package a3ReusaxCorp;
import java.util.*;

public class ReusaxCorpMain {

	private static final int REGISTER_Employee = 1;
	private static final int RETREIVE_EMPLOYEE  = 2;
	private static final int REMOVE_EMPLOYEE = 3;
	private static final int UPDATE_EMPLOYEE = 4;
	private static final int TOTAL_GROSS_SALARY = 5;
	private static final int TOTAL_NET_SALARY = 6;
	private static final int TOTAL_EMPLOYEES = 7;
	private static final int QUIT = 8;
	private Scanner input = new Scanner(System.in);
	ReusaxCorp company = new ReusaxCorp();
	
	public void printOptions() {
		System.out.println();
		System.out.println(" === Welcome to Reusax Corp. === ");
		System.out.println(" Choose an option below: ");
		System.out.println();
		System.out.println(" 1. Register employee. ");
		System.out.println(" 2. Retreive employee. ");
		System.out.println(" 3. Remove employee.");
		System.out.println(" 4. Update employee.");
		System.out.println(" 5. Current total gross salary payments. ");
		System.out.println(" 6. Current total net salary payments. ");
		System.out.println(" 7. Total Employees. ");
		System.out.println(" 8. Quit this program. ");
		System.out.println();
	}
	
	public void registrationOptions() {
		System.out.println(" === Registration === ");
		System.out.println(" Choose an option below: ");
		System.out.println();
		System.out.println(" 1. Register Employee. ");
		System.out.println(" 2. Register Manager. ");
		System.out.println(" 3. Register Director.");
		System.out.println(" 4. Register Intern.");
	}//end of employee registration
	
	public void register() {
		final int REGULAR_EMPLOYEE = 1;
		final int MANAGER = 2;
		final int DIRECTOR = 3;
		final int INTERN = 4;
		
		registrationOptions();
		int employeeType = input.nextInt();
		
		switch(employeeType) {
		case REGULAR_EMPLOYEE:
		{
			System.out.println();
			System.out.println(" Enter username (id): ");
			String id = input.next();
			
			System.out.println(" Enter name: ");
			String name = input.next();
			
			System.out.println(" Enter gross salary: ");
			double salary = input.nextDouble();
			System.out.println();
			
			Employee newEmployee = new Employee(id, name, salary);
			company.addEmployee(newEmployee);
		}
			break;
		case MANAGER:
		{
			final String BACHELOR = "BSc.";
			final String MASTER = "MSc.";
			final String PHD = "PhD";
			
			System.out.println();
			System.out.println(" Enter username (id): ");
			String id = input.next();
			
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
			System.out.println(" Enter username (id): ");
			String id = input.next();
			
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
				System.out.println();
				System.out.println(" You entered an invalid option.");
				System.out.println();
			}
			
			Employee newEmployee = new Director(id, name, salary, degree, department);
			company.addEmployee(newEmployee);
		}
			break;
		case INTERN:
		{
			System.out.println();
			System.out.println(" Enter username (id): ");
			String id = input.next();
			
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
					System.out.println();
					System.out.println(" You entered an invalid GPA value.");
					System.out.println();
					
					System.out.println(" Enter GPA: ");
					userInp = input.nextDouble();
					gpa = userInp;
				}while(userInp < 0 && userInp > 10);
			}
			
			Employee newEmployee = new Intern(id, name, salary, gpa);
			company.addEmployee(newEmployee);
		}
			break;
		}//end of switch
	}//end of registration method
	
	public void retreive() {
		
		System.out.println(" === Search Resaux Corp. employees === ");
		System.out.println();
		System.out.println(" Enter employee I.D: ");
		String idSearch = input.nextLine();

		if(company.searchId(idSearch) == null) {
			System.out.println();
			System.out.println(idSearch + " was not found.");
			System.out.println();
		}else {
			//TODO: make a toString method
			System.out.println(company.searchId(idSearch));
		}
		
	}//end of retrieve
	
	private void run() {
	
		int option;
		do {
			printOptions();
			option = input.nextInt();
			
			switch (option) {
			case REGISTER_Employee:
				register();
				break;
			case RETREIVE_EMPLOYEE:
				retreive();
				break;
			case REMOVE_EMPLOYEE:
				//TODO
				break;
			case UPDATE_EMPLOYEE:
				//TODO
				break;
			case TOTAL_GROSS_SALARY:
				//TODO
				break;
			case TOTAL_NET_SALARY:
				//TODO
				break;
			case TOTAL_EMPLOYEES:
				//TODO
				break;
			}//end of switch
		}while(option != QUIT);
	}
	
	public static void main(String [] args) {
		ReusaxCorpMain company = new ReusaxCorpMain();
		company.run();
	}//end of main
}//end of class
