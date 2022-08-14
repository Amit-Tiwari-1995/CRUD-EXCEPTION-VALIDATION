package com.example.amit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByEmployeeId(int id);
	
	
	@Modifying // Need to use this for DML operations
	@Query("delete from Employee where employeeId=:id")
	void deleteByEmployeeId(@Param(value = "id") int id);
	

}
