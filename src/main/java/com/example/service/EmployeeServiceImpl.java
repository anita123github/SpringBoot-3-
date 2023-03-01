package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public abstract class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee savEmployee(Employee employee) {
		Employee saveEmployee=employeeRepository.save(employee);
		
		return saveEmployee;
	}
	@Override
	public List<Employee> getAllEmployee() {
		Iterable<Employee> iterable = employeeRepository.findAll();
		return (List<Employee>) iterable;

}

	@Override
	public Employee getEmployeeById(int id) {
		Optional<Employee> response = employeeRepository.findById(id);
		return response.isPresent() ? response.get() : null;
	}

	@Override
	public int updateEmployee(int id, Employee employee) {

		Optional<Employee> response = employeeRepository.findById(id);
		if (response.isPresent()) {
			Employee result = employeeRepository.save(employee);
			return result.getId();
		}

		return 0;
	}

	@Override
	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "Employee deleted";
	}
	
	

	
	}


