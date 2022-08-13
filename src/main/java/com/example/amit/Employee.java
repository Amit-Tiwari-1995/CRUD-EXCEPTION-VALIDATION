package com.example.amit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Data
@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue
	private  int employeeId;
	@Column(name = "employee_name")
	private String employeeName;
	@Column(name = "employee_mobile")
	private String employeeMobile;
	@Column(name = "employee_email")
	private String employeeEmail;
	@Column(name = "employee_gender")
	private String employeeGender;
	@Column(name = "employee_salary")
	private int employeeSalary;

}
