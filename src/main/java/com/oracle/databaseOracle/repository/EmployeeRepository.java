package com.oracle.databaseOracle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.databaseOracle.entity.Employees;
@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long>{
	@Query(value ="select count(*) from employees where salary > :sal",nativeQuery = true)
	int getCountOfEmployeesBasedOnSalary(@Param("sal")long salary);
	

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "update employees set first_name = ?1 where employee_id = ?2", nativeQuery = true)
	Object updateEmployee(String firstName, long employeeId);
}
