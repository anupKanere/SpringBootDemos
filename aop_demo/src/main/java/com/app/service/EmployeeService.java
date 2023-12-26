package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojo.Employee;

public interface EmployeeService {

	List<Employee> getAllEmps();

	Employee addEmployee(Employee emp) throws Exception;

	Optional<Employee> getEmpById(long id);

	void deleteEmp(long id);

	void updateEmp(Employee empo);

	

}
