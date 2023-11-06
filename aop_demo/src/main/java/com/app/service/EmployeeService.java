package com.app.service;

import java.util.List;

import com.app.pojo.Employee;

public interface EmployeeService {

	List<Employee> getAllEmps();

	Employee addEmployee(Employee emp) throws Exception;

	

}
