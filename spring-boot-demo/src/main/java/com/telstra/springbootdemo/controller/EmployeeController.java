package com.telstra.springbootdemo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.springbootdemo.model.Employee;

@RestController
public class EmployeeController {
	
	private static ArrayList<Employee> empList;
	
	static {
		empList = new ArrayList<>();
		empList.add(new Employee(1001, "Ram", "Manager", 50000));
		empList.add(new Employee(1002, "Shyam", "Lead", 45000));
		empList.add(new Employee(1003, "Siya", "Architect", 60000));
		empList.add(new Employee(1004, "Radha", "HR Manager", 55000));
	}
	
	
	@GetMapping("/employee")
	public ArrayList<Employee> getAllEmployees(){
		return empList;
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("empId") int empId) {
		
		for(Employee emp:empList) {
			if(emp.getEmpId()==empId) {
				return new ResponseEntity<>(emp, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Employee with id: "+empId+" Not Found !!!",
				HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		empList.add(employee);
		return "Employee "+employee.getName()+" is added Successfully..!!!";
	}
	
	@DeleteMapping("/employee/{empId}")
	public String deleteEmployee(@PathVariable("empId") int empId) {
		
		Employee employee=employeeById(empId);				
		if(employee!=null) {
		empList.remove(employee);
		return "Employee "+employee.getName()+" with empId="+empId+" is Removed Successfully..!!!";
		}
		else {
		return "Error... \nEmployee Id:"+empId+" Not Found..!!";
		}
	}
	
	public Employee employeeById(int empId) {
		for(Employee emp:empList) {
			if(emp.getEmpId()==empId) {
				
				return emp;
			}
		}
		return null;
	}
	@PutMapping("/employee/{empId}")
	public void updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable("empId") int empId) {
		
		empList.remove(employeeById(empId));
		empList.add(updatedEmployee);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
