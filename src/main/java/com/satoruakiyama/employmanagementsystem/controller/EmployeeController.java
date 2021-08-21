package com.satoruakiyama.employmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.satoruakiyama.employmanagementsystem.domain.Employee;
import com.satoruakiyama.employmanagementsystem.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService; 

//	display list of employees
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	
//	showNewEmployeeForm
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
//	add an employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		
		return "redirect:/";
	}
	
//	show update form
	@GetMapping("/showFormForUpdate/{id}")
	public String showUpdateForm(@PathVariable Long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	
//	delete the employee by id
	@GetMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable Long id, Model model) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
}
 