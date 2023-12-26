package com.app.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<Employee> getEmpById(long id) {
		
		Optional<Employee> emp = empRepo.findById(id);
		return emp;
	}

	@Override
	public void deleteEmp(long id) {
		empRepo.deleteById(id);
		
	}

	@Override
	public void updateEmp(Employee empo) {
		
		empRepo.save(empo);
	}



}
