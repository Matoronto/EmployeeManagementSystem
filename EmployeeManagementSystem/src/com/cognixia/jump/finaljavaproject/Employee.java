package com.cognixia.jump.finaljavaproject;


//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;
//import java.util.NoSuchElementException;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;

public class Employee {
	
	private int empID;
	private String fName;
	private String lName;
	private Date dateOfEmployment;
	private double salary;
	private String department;
	
	//Constructor without Stating our employee
	public Employee() {
		super();
		this.empID = 0;
		this.fName = null;
		this.lName = null;
		this.dateOfEmployment = null;
		this.salary = 0.00;
		this.department = null;
	}
	
	//Constructor if we explicitly state our employee and add new Employee.
	public Employee(int empID, String fName, String lName, Date doe, double salary, String department) {
		super();
		this.empID = empID;
		this.fName = fName;
		this.lName = lName;
		this.dateOfEmployment = doe;
		this.salary = salary;
		this.department = department;
	}
	
	//Constructor if we want to update our employee.
	public Employee(int empID, String fName, String lName, double salary, String department) {
		this.empID = empID;
		this.fName = fName;
		this.lName = lName;
		this.salary = salary;
		this.department = department;
	}
	
	public int getEmpID() {
		return empID;
	}
	public String getfName() {
		return fName;
	}
	public String getlName() {
		return lName;
	}
	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}
	public double getSalary() {
		return salary;
	}
	public String getDepartment() {
		return department;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public void setDateOfEmployment(Date doe) {
////		new Date();
		this.dateOfEmployment = doe;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [Employee ID: " + empID + ", First Name: " + fName + ", Last Name: " + lName 
				+ "Date of Employment: "+ dateOfEmployment + ", Salary: " + salary + 
				", Department: " + department + "]";
	}
}
