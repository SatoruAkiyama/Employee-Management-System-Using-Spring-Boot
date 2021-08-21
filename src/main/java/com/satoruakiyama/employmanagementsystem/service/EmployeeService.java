package com.satoruakiyama.employmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satoruakiyama.employmanagementsystem.domain.Employee;
import com.satoruakiyama.employmanagementsystem.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

//	get all employees
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

// save an employee
	public void saveEmployee(Employee emp) {
		employeeRepository.save(emp);
	}

//	get employee by id
	public Employee getEmployeeById(Long id) {
		Employee emp = employeeRepository.getById(id);
		if(emp == null ) {
			throw new RuntimeException("Employee not found");
		}
		return emp;
	}

//	delete employee by id
	public String deleteEmployeeById(Long id) {
		Employee emp = employeeRepository.getById(id);
		if(emp == null ) {
			throw new RuntimeException("Employee not found");
		}

		employeeRepository.deleteById(id);
		return "Deleted: " + emp.getFirstName() + " " + emp.getLastName() ;
	}
}
