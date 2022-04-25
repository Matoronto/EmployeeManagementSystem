package com.cognixia.jump.finaljavaproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class EmployeeSession {
	
	//Used for creating and deleting employees.
	
	ArrayList<Employee> empList = new ArrayList<Employee>();
	
	public void loadSession(String empFilePath) throws FileNotFoundException{
		
		File empFile = new File(empFilePath);
		
		if(!empFile.exists()) {
			try {
				empFile.createNewFile();
			} catch (IOException e) {
				System.out.println("The File Exists.");
				e.printStackTrace();
			}
		}
		
//		readEmployessFromFile(empFilePath);
		
	}
	
	public void saveSession(String empFile) {
		
		writeEmployeesToFile(empList, empFile);
		
	}
	
	
	public void addEmployee(Employee emp) throws EmployeeException{
		
		//add employee to the list for this session
		//check for duplicate employee ids.
		
		Stream<Employee>empStream = empList.stream();
		Optional <Employee> opt = empStream.filter(x->x.getEmpID() == emp.getEmpID()).findAny();
		if(opt.isEmpty() == true) {
			empList.add(emp);
		} else {
			throw new EmployeeException(emp);
		}
	}
	
	public void deleteEmployee(Employee emp){
		
		empList.remove(emp);
		
	}
	
	public void writeEmployeesToFile(ArrayList<Employee> empList, String filepath) {
		
		//A given employee object and path to a file overwrites entire file with employee data from the list
		
		StringBuffer outputString = new StringBuffer();
		
		File file = new File(filepath);
		
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				System.out.println("Could not create the file.");
				e1.printStackTrace();
			}
		}
		
		try (FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter pw = new PrintWriter(bw);
				){
			
			  for(Employee emp: empList) {
				  outputString.setLength(0);
				  outputString.append(generateEmployeeOutputString(emp));
				  pw.println(outputString);
				  
				  
			  }
			
		} catch(IOException e1) {
			System.out.println("Employee Already exists in the file.");
			e1.printStackTrace();
		}
		
	}
	
	public ArrayList<Employee> readEmployessFromFile(String filepath) throws FileNotFoundException{
		empList = new ArrayList<Employee>();
		
		File file = new File(filepath);
		
		try (FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				){
			
			String line;
			while((line = br.readLine()) != null) {
				
				Employee emp = buildEmployeeFromInputString(line.trim());
				empList.add(emp);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return empList;
	}

	
	//Internal Methods
	private Object generateEmployeeOutputString(Employee emp) {
		
		return new String(emp.getEmpID() + "|" + emp.getfName() + "|" + emp.getlName() 
		+ "|" + emp.getSalary() + "|" + emp.getDepartment());
	}
	
	
	//This internal method used by the methods above returns an array containing individual fields to be passed
	//to an appropriate wrapper constructor below
	
	public static ArrayList<String> buildFieldsFromInputString(String s){
		
		ArrayList<String> fields = new ArrayList<String>();
		StringBuffer currentField = new StringBuffer();
		
		//loop appends letters to the current field until it detects a vertical bar character '|';
		//once this bar is detected, the current field is considered complete and is added to the return list.
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '|') {
				fields.add(currentField.toString());
				currentField.setLength(0);
			} else {
				currentField.append(s.charAt(i));
			}
			
		}
		
		//last field isn't followed by the vertical bar and must be added manually.
		
		if(!currentField.toString().equals("")) {
			fields.add(currentField.toString());
		}
		
		return fields;
		
	}
	
	public static Employee buildEmployeeFromInputString(String s) throws NumberFormatException {
		
		ArrayList<String> fields = buildFieldsFromInputString(s);
		return new Employee(Integer.parseInt(fields.get(0)), fields.get(1), fields.get(2), Double.parseDouble(fields.get(3)),
				fields.get(4));
				
	}
	
	
	
	
	

}
