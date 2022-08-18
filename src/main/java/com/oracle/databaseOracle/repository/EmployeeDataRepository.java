package com.oracle.databaseOracle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oracle.databaseOracle.entity.EmployeeData;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData, Long>{
	@Query(value = "select count(*) from employees", nativeQuery = true)
	public int getCountOfEmployes();

}
