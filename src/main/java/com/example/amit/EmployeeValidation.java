package com.example.amit;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeValidation {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public Map<String, String> handleInvalidData(MethodArgumentNotValidException error) {
		Map<String, String> errorMap = new HashMap<>();

		error.getBindingResult().getFieldErrors().forEach(e -> {
			errorMap.put(e.getField(), e.getDefaultMessage());
		}

		);

		return errorMap;

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler
	public Map<String, String> employeeNotFoundValidation(EmployeeNotFoundException ex) {
		Map<String, String> errorMap = new HashMap<>();

		errorMap.put("erorMessage", ex.getMessage());
		return errorMap;

	}

}
