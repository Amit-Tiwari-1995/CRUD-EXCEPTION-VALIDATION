package com.example.amit;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
public class EmployeeDto {

	@NotNull(message = "Employee name can't be null")
	private String employeeName;
	@NotNull(message = "Employee mobile number can't be null")
	@Pattern(regexp = "^\\d{10}$", message = "Mobile number is invalid")
	private String employeeMobile;
	@NotNull(message = "Employee email can't be null")
	private String employeeEmail;
	@NotNull(message = "Employee gender can't be null")
	private String employeeGender;
	@NotNull(message = "Employee salary can't be null")
	@Min(30000)
	@Max(100000)
	private int employeeSalary;

}
