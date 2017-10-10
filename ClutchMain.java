package final_edition;

import java.util.*;

public class ClutchMain {

	private Scanner input = new Scanner(System.in);
	private Scanner nameInput = new Scanner(System.in);
	ReusaxCorp company = new ReusaxCorp();

	public void printOptions() {
		System.out.println();
		System.out.println(" =================================================== ");
		System.out.println(" == Reusax Corporate Employee Management System   == ");
		System.out.println(" =================================================== ");
		System.out.println(" ===                                             === ");
		System.out.println(" ===   Choose an option below:                   === ");
		System.out.println(" ===   1. Register an employee.                  === ");
		System.out.println(" ===   2. Remove an employee.                    === ");
		System.out.println(" ===   3. Print an employee's information.       === ");
		System.out.println(" ===   4. Update an employee's information.      === ");
		System.out.println(" ===   5. Current total gross salary payments.   === ");
		System.out.println(" ===   6. Current total net salary payments.     === ");
		System.out.println(" ===   7. Total Employees.                       === ");
		System.out.println(" ===   8. Update director benefits.              === ");
		System.out.println(" ===   9. Change employee position.              === ");
		System.out.println(" ===   10.Quit program                           === ");
		System.out.println(" ===                                             === ");
		System.out.println(" =================================================== ");
		System.out.println();
	}

	public void regirstartionMenu() {
		System.out.println(" ====== Employee type ====== ");
		System.out.println(" = Choose an option below: =");
		System.out.println(" =                         =");
		System.out.println(" = 1. Register as Employee.=");
		System.out.println(" = 2. Register as Manager. =");
		System.out.println(" = 3. Register as Director.=");
		System.out.println(" = 4. Register as Intern.  =");
		System.out.println(" =                         =");
	}// end of employee registration

	// 1) register
	public void register() {
		System.out.println(" ====== New Employee ====== ");
		System.out.println();
		System.out.println(" Enter new Id: ");
		String id = input.next();

		if (company.retreiveEmployeeType(id) == null) {//type
			System.out.println(" Enter name: ");
			String name = nameInput.nextLine();

			System.out.println(" Enter gross salary: ");
			double salary = input.nextDouble();
			System.out.println();

			regirstartionMenu();
			final int REGULAR_EMPLOYEE = 1;
			final int MANAGER = 2;
			final int DIRECTOR = 3;
			final int INTERN = 4;

			int employeeType = input.nextInt();

			switch (employeeType) {
			case REGULAR_EMPLOYEE: {
				Employee newEmployee = new RegularEmployee(id, name, salary);
				company.addEmployee(newEmployee);
				System.out.println("\n== Regular employee has been registered. ==\n" + newEmployee.toString()
						+ "===========================================");
			}
				break;
			case MANAGER: {
				final String BACHELOR = "BSc.";
				final String MASTER = "MSc.";
				final String PHD = "PhD";

				System.out.println(" Enter academic degree: ");
				System.out.println(" 1. Bachelor (BSc.)" + "\n 2. Master (MSc.)" + "\n 3. PhD.");
				String degree = "";
				double userInp = input.nextInt();
				if (userInp == 1) {
					degree = BACHELOR;
				} else if (userInp == 2) {
					degree = MASTER;
				} else if (userInp == 3) {
					degree = PHD;
				} else {
					System.out.println("You entered an invalid option.");
				}
				Employee newEmployee = new Manager(id, name, salary, degree);
				company.addEmployee(newEmployee);
				System.out.println("\n== Manager has been registered. ==\n" + newEmployee.toString()
						+ "==================================");
			}
				break;
			case DIRECTOR: {
				final String BACHELOR = "BSc.";
				final String MASTER = "MSc.";
				final String PHD = "PhD";
				final int BUSINESS = 1;
				final int TECHNICAL = 2;
				final int HUMAN_RESOURCES = 3;

				System.out.println();
				System.out.println(
						" Enter academic degree: " + "\n 1. Bachelor (BSc.)" + "\n 2. Master (MSc.)" + "\n 3. PhD.");
				String degree = "";
				double userInp = input.nextInt();
				if (userInp == 1) {
					degree = BACHELOR;
				} else if (userInp == 2) {
					degree = MASTER;
				} else if (userInp == 3) {
					degree = PHD;
				} else {
					System.out.println();
					System.out.println(" You entered an invalid option.");
					System.out.println();
				}

				System.out.println();
				System.out.println(" Enter department: " + "\n 1. Business department " + "\n 2. Technical department"
						+ "\n 3. Human Resources department.");
				userInp = input.nextInt();
				String department = "";

				if (userInp == BUSINESS) {
					department = "Business department";
				} else if (userInp == TECHNICAL) {
					department = "Technical department";
				} else if (userInp == HUMAN_RESOURCES) {
					department = "Human Resources department";
				} else {
					System.out.println();
					System.out.println(" You entered an invalid option.");
					System.out.println();
				}

				Employee newEmployee = new Director(id, name, salary, degree, department);
				company.addEmployee(newEmployee);
				System.out.println("\n== Director has been registered. ==\n" + newEmployee.toString()
						+ "===================================");
			}
				break;
			case INTERN: {
				System.out.println(" Enter GPA (0 to 10): ");
				double userInp = input.nextDouble();
				System.out.println();
				double gpa = 0;

				if (userInp >= 0 && userInp <= 10) {
					gpa = userInp;
				} else {
					do {
						System.out.println();
						System.out.println(" You entered an invalid GPA value.");
						System.out.println();

						System.out.println(" Enter GPA (0 to 10): ");
						userInp = input.nextDouble();
						gpa = userInp;
					} while (userInp < 0 && userInp > 10);
				}

				Employee newEmployee = new Intern(id, name, salary, gpa);
				company.addEmployee(newEmployee);
				System.out.println("\n== Intern has been registered. ==\n" + newEmployee.toString()
						+ "=================================");
			}
				break;
			}// end of switch
		} else {
			System.out.println("An employe with Id " + id + " already exists.");
		}
	}// end of registration method

	// 2) remove
	public void removeEmploye() {
		System.out.println(" === Remove Resaux Corp. employees === ");
		System.out.println();
		System.out.println(" Enter employee I.D: ");
		String id = input.next();

		if (company.retreiveEmployeeBoolean(id) == true) {//boolean
			company.removeEmployee(company.retreiveEmployeeType(id));//employee type
			System.out.println(id + " was removed from Reusax Corp.");
			
		} else {
			System.out.println();
			System.out.println(id + " was not found.");
			System.out.println();
		}
	}

	// 3) retrieve
	public void retreiveEmployee() {

		System.out.println(" === Search Resaux Corp. employees === ");
		System.out.println();
		System.out.println(" Enter employee I.D: ");
		String identity = input.next();
		
		if(company.retreiveEmployeeType(identity) != null) {
			System.out.println(company.retreiveEmployeeType(identity).toString());
		}else {
			System.out.println("Id \""+identity+"\" is cannot be found.");
		}

	}// end of retrieve

	// 4) update employee
	public void updateName(Employee employee) {
		System.out.println(" Enter new name: ");
		String newName = nameInput.nextLine();
		employee.setName(newName);
		System.out.println("Name has been changed to " + employee.getName());
		System.out.println();
	}

	public void updateSalary(Employee employee) {
		System.out.println("Set new gross salary: ");
		double newSalary = input.nextDouble();
		employee.setGrossSalary(newSalary);
		System.out.println("New salary has been set to " + employee.getGrossSalary());
		System.out.println();
	}

	public void updateDegree(Manager employee) {
		final String BACHELOR = "BSc.";
		final String MASTER = "MSc.";
		final String PHD = "PhD";
		final int BACHELOR_OPTION = 1;
		final int MASTER_OPTION = 2;
		final int PHD_OPTION = 3;

		System.out.println(" Enter the degree of the manager ");
		System.out.println(" 1. Bachelor (BSc.)" + "\n 2. Master (MSc.)" + "\n 3. PhD.");
		int newDegree = input.nextInt();

		if (newDegree == BACHELOR_OPTION) {
			employee.setAcademicDegree(BACHELOR);
		} else if (newDegree == MASTER_OPTION) {
			employee.setAcademicDegree(MASTER);
		} else if (newDegree == PHD_OPTION) {
			employee.setAcademicDegree(PHD);
		} else {
			System.out.println("You entered an invalid option");
		}
		System.out.println("Academic degree has been set to " + employee.getAcademicDegree());
		System.out.println();
	}

	public void updateGpa(Intern employee) {
		System.out.println("Set new GPA: ");
		double newGpa = input.nextDouble();
		employee.setGpa(newGpa);
		System.out.println("New GPA has been set to " + employee.getGpa());
		System.out.println();
	}

	public void updateDepartment(Director employee) {
		final int BUSINESS = 1;
		final int TECHNICAL = 2;
		final int HUMAN_RESOURCES = 3;
		System.out.println(" Enter the new department of the director ");
		System.out.println(
				"1. Business department " + "\n 2. Technical department" + "\n 3. Human Resources department.\n");
		int userInp = input.nextInt();

		if (userInp == BUSINESS) {
			employee.setDepartment("Business department");
		} else if (userInp == TECHNICAL) {
			employee.setDepartment("Technical department");
		} else if (userInp == HUMAN_RESOURCES) {
			employee.setDepartment("Human Resources department");
		} else {
			System.out.println("\n" + "You entered an invalid option." + "\n");
		}
	}

	public void updateEmployee() {
		System.out.println("\n" + " ====== Update Employee ===== ");
		System.out.println(" Enter employee id: ");
		String id = input.next();
		//input.next();
		Employee foundEmployee = company.retreiveEmployeeType(id);//employee type

		if (foundEmployee != null) {
			final int NAME = 1;
			final int GROSS_SALARY = 2;
			final int ACADEMIC_DEGREE = 3;
			final int GPA = 3;
			final int DEPARTMENT = 4;
			if (foundEmployee instanceof Director) {
				System.out.println(" ====== Update Director =====");
				System.out.println(" = Choose an option below:  =");
				System.out.println(" = 1. Name                  =");
				System.out.println(" = 2. Gross Salary          =");
				System.out.println(" = 3. Academic Degree       =");
				System.out.println(" = 4. Department            =");
				System.out.println(" =                          =");
				System.out.println(" ============================");
				int userInp = input.nextInt();
				if (userInp == NAME) {
					updateName(foundEmployee);
				} else if (userInp == GROSS_SALARY) {
					updateSalary(foundEmployee);
				} else if (userInp == ACADEMIC_DEGREE) {
					updateDegree((Manager) foundEmployee);
				} else if (userInp == DEPARTMENT) {
					updateDepartment((Director) foundEmployee);
				} else {
					System.out.println("You entered an invalid option.");
				}

			} else if (foundEmployee instanceof Manager) {
				System.out.println(" ====== Update Manager  =====");
				System.out.println(" = Choose an option below:  =");
				System.out.println(" = 1. Name                  =");
				System.out.println(" = 2. Gross Salary          =");
				System.out.println(" = 3. Academic Degree       =");
				System.out.println(" =                          =");
				System.out.println(" ============================");
				int userInp = input.nextInt();
				if (userInp == NAME) {
					updateName(foundEmployee);
				} else if (userInp == GROSS_SALARY) {
					updateSalary(foundEmployee);
				} else if (userInp == ACADEMIC_DEGREE) {
					updateDegree((Manager) foundEmployee);
				} else {
					System.out.println("You entered an invalid option.");
				}

			} else if (foundEmployee instanceof Intern) {
				System.out.println(" ====== Update Intern   =====");
				System.out.println(" = Choose an option below:  =");
				System.out.println(" = 1. Name                  =");
				System.out.println(" = 2. Gross Salary          =");
				System.out.println(" = 3. GPA                   =");
				System.out.println(" =                          =");
				System.out.println(" ============================");
				int userInp = input.nextInt();
				if (userInp == NAME) {
					updateName(foundEmployee);
				} else if (userInp == GROSS_SALARY) {
					updateSalary(foundEmployee);
				} else if (userInp == GPA) {
					updateGpa((Intern) foundEmployee);
				}

			} else if (foundEmployee instanceof RegularEmployee) {
				System.out.println(" ====== Update Employee =====");
				System.out.println(" = Choose an option below:  =");
				System.out.println(" = 1. Name                  =");
				System.out.println(" = 2. Gross Salary          =");
				System.out.println(" =                          =");
				System.out.println(" ============================");
				int userInp1 = input.nextInt();
				if (userInp1 == NAME) {
					updateName(foundEmployee);
				} else if (userInp1 == GROSS_SALARY) {
					updateSalary(foundEmployee);
				}
			}

		} else {
			System.out.println("An employee of ID" + id + " is not registered in the system.");
		} // end of if statement
	}// end of class

	// 5) total gross salary
	public void totalGrossSalary() {
		System.out.println("Reusax Corp. total expenses:" + company.getTotalExpense() + " USD .");
	}

	// 6) total net salary
	public void totalNetSalary() {
		System.out.println(
				"Reusax Corp. pays a total Net Salary of " + company.totalNetSalary() + " USD to it's employees.");
	}

	// 7) total employees
	public void totalEmployees() {

		System.out.println("Total number of Reusax Corp. employees: " + company.employeeSize());
	}

	// 8) director benefit
	public void updateBenefit() {
		System.out.println("\n Current Director benefit is " + company.currentBenefit() + "\n");
		System.out.println(" Enter new Director Benefit: ");
		double newBenefit = input.nextDouble();
		company.updateBenefit(newBenefit);
		System.out.println("\n New Director benefit is " + company.currentBenefit() + "\n");
	}

	// 9) change position
	public void changePosition() {
		System.out.println("\n ====== Update Employee ===== ");
		System.out.println(" Enter employee id: ");
		String id = input.next();
		Employee foundEmployee = company.retreiveEmployeeType(id);//employee type

		if (foundEmployee != null) {
			final int PROMOTE = 1;
			final int DEMOTE = 2;

			System.out.println("\n====== Change Position =====");
			System.out.println(" = Choose an option below:  =");
			System.out.println(" = 1. Promote               =");
			System.out.println(" = 2. Demote                =");
			System.out.println(" =                          =");
			System.out.println(" ==============================\n");
			int userInp = input.nextInt();
			if (userInp == PROMOTE) {
                promote(foundEmployee);
			} else if (userInp == DEMOTE) {
                demote(foundEmployee);
			} else {
				System.out.println(" You entered an invalid option.");
			}
		} else {
			System.out.println("An employee of ID" + id + " is not registered in the system.");
		} // end of if else statement
	}// end of method

	public void promote(Employee employee) {
		String id = employee.getId();
		String name = employee.getName();
		double grossSalary = employee.getGrossSalary();
		String academicDegree = ((Manager) employee).getAcademicDegree();

		if (employee instanceof Manager) {
			final int BUSINESS = 1;
			final int TECHNICAL = 2;
			final int HUMAN_RESOURCES = 3;
			System.out.println(" Enter the new department of the director ");
			System.out.println(
					"1. Business department " + "\n 2. Technical department" + "\n 3. Human Resources department.\n");
			int userInp = input.nextInt();
			String department = "";
			if (userInp == BUSINESS) {
				department = "Business department";
			} else if (userInp == TECHNICAL) {
				department = "Technical department";
			} else if (userInp == HUMAN_RESOURCES) {
				department = "Human Resources department";
			} else {
				System.out.println("\n" + "You entered an invalid option." + "\n");
			}

			company.removeEmployee(employee);
			Employee newEmployee = new Director(id, name, grossSalary, academicDegree, department);
			company.addEmployee(newEmployee);
			System.out.println("New employee psition :\n " + newEmployee.toString());

		} else if (employee instanceof Intern) {
			company.removeEmployee(employee);
			Employee newEmployee = new RegularEmployee(id, name, grossSalary);
			company.addEmployee(newEmployee);

		} else if (employee instanceof Employee) {
			final String BACHELOR = "BSc.";
			final String MASTER = "MSc.";
			final String PHD = "PhD";
			final int BACHELOR_OPTION = 1;
			final int MASTER_OPTION = 2;
			final int PHD_OPTION = 3;

			System.out.println(" Enter the degree of the manager ");
			System.out.println(" 1. Bachelor (BSc.)" + "\n 2. Master (MSc.)" + "\n 3. PhD.");
			int newDegree = input.nextInt();
			String degree = "";
			if (newDegree == BACHELOR_OPTION) {
				degree = BACHELOR;
			} else if (newDegree == MASTER_OPTION) {
				degree = MASTER;
			} else if (newDegree == PHD_OPTION) {
				degree = PHD;
			} else {
				System.out.println("You entered an invalid option");
			}
			company.removeEmployee(employee);
			Employee newEmployee = new Manager(id, name, grossSalary, degree);
			company.addEmployee(newEmployee);

		} else {
			System.out.println(
					"Employe of Id " + employee.getId() + " cannot be promoted because the are at highest position.");
		}

	}
	
	public void demote(Employee employee) {
		String id = employee.getId();
		String name = employee.getName();
		double grossSalary = employee.getGrossSalary();
		String academicDegree = ((Manager) employee).getAcademicDegree();
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

	private void run() {

		final int REGISTER_Employee = 1;
		final int REMOVE_EMPLOYEE = 2;
		final int RETREIVE_EMPLOYEE = 3;
		final int UPDATE_EMPLOYEE = 4;
		final int TOTAL_GROSS_SALARY = 5;
		final int TOTAL_NET_SALARY = 6;
		final int TOTAL_EMPLOYEES = 7;
		final int UPDATE_DIRECTOR_BENEFIT = 8;
		final int CHANGE_POSITION = 9;
		final int QUIT = 10;

		int option;
		do {
			company.sortEmployees();
			printOptions();
			option = input.nextInt();

			switch (option) {
			case REGISTER_Employee:
				register();
				break;
			case REMOVE_EMPLOYEE:
				removeEmploye();
				break;
			case RETREIVE_EMPLOYEE:
				retreiveEmployee();
				break;
			case UPDATE_EMPLOYEE:
				updateEmployee();
				break;
			case TOTAL_GROSS_SALARY:
				totalGrossSalary();
				break;
			case TOTAL_NET_SALARY:
				totalNetSalary();
				break;
			case TOTAL_EMPLOYEES:
				totalEmployees();
				break;
			case UPDATE_DIRECTOR_BENEFIT:
				updateBenefit();
				break;
			case CHANGE_POSITION:
				changePosition();
				break;
			case 98:
				company.printAll();
			}// end of switch
		} while (option != QUIT);
	}

	public static void main(String[] args) {
		ClutchMain company = new ClutchMain();
		company.run();
		System.out.println();
		System.out.print("Thanks for using Reusax Corporate Employee Management System.");
	}// end of main
}
