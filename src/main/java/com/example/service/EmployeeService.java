package com.example.service;

import java.util.List;

import com.example.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int id);

	int updateEmployee(int id, Employee employee);

   String deleteEmployeeById(int id);

Employee savEmployee(Employee employee);


}

