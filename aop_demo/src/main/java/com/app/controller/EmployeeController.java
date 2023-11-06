package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Employee;
import com.app.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> fetchAllEmployees() {
	    List<Employee> employees = empService.getAllEmps();
	    return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
	{
		try {
			return new ResponseEntity<Employee>(empService.addEmployee(emp), HttpStatus.OK);
		} catch (Exception e) {
			
			return new ResponseEntity<String>( "Enter valid credentails", HttpStatus.BAD_REQUEST);
		}
	}

}
