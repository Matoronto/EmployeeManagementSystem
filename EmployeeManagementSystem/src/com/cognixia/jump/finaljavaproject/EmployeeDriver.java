package com.cognixia.jump.finaljavaproject;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

//import java.util.Date;

public class EmployeeDriver {

	public static void main(String[] args) {
		
//		Date date = new Date();
		
//		Employee emp1 = new Employee();
//		Employee emp2 = new Employee(100, "Mathewos", "Mekuria", 25.00, "Information Technology");
//		System.out.println("Here is an employee with " + emp2);
		
		EmployeeSession session = new EmployeeSession();
		
		String empFile = "resources/employees.txt";
		
		try {
			session.loadSession(empFile);
		} catch (FileNotFoundException e) {
			//System.out.println("Sorry can't load employee session.");
			e.printStackTrace();
		}
		
		String menu = new String(
				
				"-----WELCOME TO THE EMPLOYEE MANAGEMENT SYSTEM, PLEASE SELECT THE OPTIONS BELOW-----"
				+"\n1. Add Employee"
				+"\n2. Update Employee"
				+"\n3. Remove Employee"
				+"\n4. Exit"
				);
		System.out.println(menu);
		System.out.println("\nPlease select a number between 1 and 4 to continue: ");
		
		Scanner scan = new Scanner(System.in);
		
		int input = 0;
		
		try {
			input = scan.nextInt();
		} catch(InputMismatchException e1) {
			System.out.println("Invalid Input. Please enter a number between 1 and 4 to continue.");
			scan.next();
		}
		
		int empID;
		String fName;
		String lName;
		double salary;
		String department;
		Employee employee;
		Employee newEmp;
		
//		
//		try {
//			doe = new SimpleDateFormat("dd/MM/yyyy").parse(doe);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		int p = 0;
		
		while(true) {
			switch (input) {
			case 0:
				
				System.out.println("\n" + menu);
				System.out.println("Please Enter an integer between 1 and 4 to continue.");
				try {
					input = scan.nextInt();
				 } catch (InputMismatchException e2) {
					System.out.println("Invalid Input. Please enter a number between 1 and 4 to continue.");
					scan.next();
					input = 0;
					continue;
				}
				break;
		
			
			case 1:
				
				try {
					System.out.println("\nInput Employee ID: ");
					empID = scan.nextInt();
					scan.nextLine();
					
					System.out.println("\nInput Employee First Name: ");
					fName = scan.next();
					
					System.out.println("\nInput Employee Last Name: ");
					lName = scan.next();
					
					System.out.println("\nInput Date of Employment (MM/dd/yyyy): ");
					String dateString = scan.next();
					
					DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					Date doe = formatter.parse(dateString);
//					employee.setDateOfEmployment(doe);
				
					System.out.println("\nInput Employee Department: ");
					department = scan.next();
					
					System.out.println("\nInput Employee Salary: ");
					salary = scan.nextDouble();
					
					System.out.println("Employee Successfully Added!!!");
					
					employee = new Employee(empID, fName, lName, doe, salary, department);
					try {
						session.addEmployee(employee);
						
					} catch (EmployeeException e1) {
						System.out.println(e1.getMessage());
					}
					session.saveSession(empFile);
					
					System.out.println("Employee is added!!");
					
				} catch(InputMismatchException e3) {
					System.out.println("Invalid Input.");
					scan.next();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("\n" + menu);
				System.out.println("Please enter an integer between 1 and 4 to continue:");
				try {
					input = scan.nextInt();
				} catch (InputMismatchException e4) {
					System.out.println("Invalid Input.");
					scan.next();
					input = 0;
					continue;
				}
				break;
				
			case 2:
				
				try {
					System.out.println("\nInput Employee ID you want to update: ");
					empID = scan.nextInt();
					
					System.out.println("Input Employee First Name:");
					scan.nextLine();
					fName = scan.nextLine();
					
					
					System.out.println("Input Employee Last Name:");
					lName = scan.nextLine();
					
//					System.out.println("Input Date of Employment you want to update: ");
//					String dateString = scan.next();
					
					System.out.println("Input Employee Department:");
					department = scan.nextLine();
					
					System.out.println("Input Employee Salary:");
					salary = scan.nextDouble();
					
					
					
					//replace old data in the object with new data
					p = 0;
					for(Employee emp : session.empList) {
						if(emp.getEmpID() == empID) {
							session.deleteEmployee(emp);
							newEmp = new Employee(empID, fName, lName, salary, department);
							
							try {
								session.addEmployee(newEmp);
								
							} catch(EmployeeException e1) {
								System.out.println(e1.getMessage());
							}
							
							session.saveSession(empFile);
							System.out.println("\nEmployee is updated!");
							p = 1;
							break;
						
						}
					}
					if(p==0) {
						System.out.println("\nEmployee Not Found");
					}
					
				} catch(InputMismatchException e5) {
					System.out.println("Invalid Input!!!");
					scan.next();
				}
				System.out.println("\n" + menu);
				System.out.println("Please enter an integer between 1 and 4 to continue");
				try {
					input = scan.nextInt();
						
				} catch(InputMismatchException e5) {
				  System.out.println("Invalid Input!!!!");
				  scan.next();
				  input = 0;
				  continue;
				}
				
				break;
				
			case 3:
				
				try {
					System.out.println("\nInput the employee you want to delete: ");
					empID = scan.nextInt();
					p = 0;
					for(Employee emp : session.empList) {
						if(emp.getEmpID()==empID) {
							session.deleteEmployee(emp);
							session.saveSession(empFile);
							System.out.println("\nEmployee is deleted!!!");
							p = 1;
							break;
							
						}
					}
					if(p==0) {
						System.out.println("\nEmployee Not Found");
					}
				} catch (InputMismatchException e1) {
					System.out.println("Invalid Input!!!!");
					scan.next();
				}
				
				System.out.println("\n" + menu);
				System.out.println("\nPlease enter an integer between 1 and 4 to continue: ");
				try {
					input = scan.nextInt();
				} catch(InputMismatchException e3) {
					System.out.println("Invalid Input");
					scan.next();
					input = 0;
					continue;
				}
				break;
				
			case 4:
				
				System.out.println("You have successfully exited the system!!!");
				session.saveSession(empFile);
				scan.close();
				return;
				
		}
		
		
				
		
		

	}

}
}

