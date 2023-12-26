package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Employee;
import com.app.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	//Get all employees
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> fetchAllEmployees() {
		List<Employee> employees = empService.getAllEmps();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	//get single employee by id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getEmpById(@PathVariable long id) {
		Optional<Employee> emp = empService.getEmpById(id);
		if (emp.isPresent())
			return new ResponseEntity<>(emp, HttpStatus.OK);
		else
			return new ResponseEntity<>("Emp not present or Invalid Emp Id ", HttpStatus.BAD_REQUEST);
	}

	//add new Employee
	@PostMapping("/add")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp) {
		try {
			return new ResponseEntity<Employee>(empService.addEmployee(emp), HttpStatus.OK);
		} catch (Exception e) {

			return new ResponseEntity<String>("Enter valid credentails", HttpStatus.BAD_REQUEST);
		}
	}

	//delete emp by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removeEmployee(@PathVariable long id) {
		empService.deleteEmp(id);
		return new ResponseEntity<>(" Employee with id " + id + "deleted Successfully", HttpStatus.OK);

	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> updateEmp (@PathVariable long id ,@RequestBody Employee employee)
	{
		Optional<Employee> emp = empService.getEmpById(id);
		if(emp.isPresent())
		{
			Employee empo = emp.get();
			empo.setId(employee.getId());
			empo.setName(employee.getName());
			empService.updateEmp(empo);
			return new ResponseEntity<String> ( "Emp Updated ", HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Enter valid credentails", HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
