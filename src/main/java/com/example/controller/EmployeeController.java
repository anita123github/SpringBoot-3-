package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController 
@RequestMapping ("/emp")
public class EmployeeController {
	@Autowired 
	private EmployeeService employeeService;
	@PostMapping("/save")
	public Employee addEmployee(@RequestBody Employee employee) {
		
	return employeeService.savEmployee(employee);

}

	@GetMapping("/allEmp")
	public List<Employee> getAll() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{id}")
	public Employee getEmpById(@PathVariable int id) {
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}

	@GetMapping("/request")
	public Employee getById(@RequestParam("empcode") int id) {
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}

	/*@PutMapping("/update")
	public String updateEmp(@RequestBody Employee employee) {
		int id = employeeService.updateEmployee(employee.getId(),employee);
		if (id ==0) {
			return "employee not found";
		}
		return String.format("Employee is updated for the id ::%d", id);
	}*/

	@DeleteMapping("/delete/{id}")
	public String deleteEmp( @PathVariable int id) {
		String response = employeeService.deleteEmployeeById(id);
		return response;

	}
}
