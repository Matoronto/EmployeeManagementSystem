package com.cognixia.jump.finaljavaproject;

public class EmployeeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Employee employee;
	
	public EmployeeException(Employee employee) {
		
		super("Employee with ID " + employee.getEmpID() + " already exists.");
		this.employee = employee;
		
	}
	
	

}
