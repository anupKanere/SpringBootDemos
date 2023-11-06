package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Employee;
import com.app.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public List<Employee> getAllEmps() {
		 List<Employee> employees = empRepo.findAll();
		return employees;
	}

	@Override
	public Employee addEmployee(Employee emp) throws Exception {
		if(emp.getName().length() < 3 )
		{
			throw new Exception("Pleas enter valid user name");
		}
		return empRepo.save(emp);
	}

}
