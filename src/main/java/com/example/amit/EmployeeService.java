package com.example.amit;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(EmployeeDto dto) {

		Employee employee = Employee.build(0, dto.getEmployeeName(), dto.getEmployeeMobile(), dto.getEmployeeEmail(),
				dto.getEmployeeGender(), dto.getEmployeeSalary());

		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getEmoloyeeById(int id) throws EmployeeNotFoundException {

		Employee employee = employeeRepository.findByEmployeeId(id);
		if (employee != null) {
			return employee;
		}

		else {
			throw new EmployeeNotFoundException("Employee not found with id: " + id);
		}

	}

}
