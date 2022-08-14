package com.example.amit;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/create")
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeDto dto) {
		return new ResponseEntity<>(employeeService.createEmployee(dto), HttpStatus.CREATED);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) throws EmployeeNotFoundException
	{
       return ResponseEntity.ok(employeeService.getEmoloyeeById(id));		
 	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid EmployeeDto dto, @PathVariable int id)
			throws EmployeeNotFoundException {
		return new ResponseEntity<>(employeeService.updateEmployee(dto, id), HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) throws EmployeeNotFoundException {

		employeeService.deleteEmployee(id);

		return "Employee deleted with id: " + id;

	}

}
