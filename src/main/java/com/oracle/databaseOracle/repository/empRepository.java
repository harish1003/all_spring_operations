package com.oracle.databaseOracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.oracle.databaseOracle.entity.e;
import com.oracle.databaseOracle.entity.Emp;

public interface empRepository extends JpaRepository<Emp, Long>{
	@Query(value = "SELECT  e.EMPLOYEE_ID, e.FIRST_NAME, e.SALARY, e.DEPARTMENT_NAME FROM (SELECT * FROM EMPLOYEES e JOIN DEPARTMENTS d on (d.DEPARTMENT_ID = e.DEPARTMENT_ID) WHERE e.DEPARTMENT_ID = ?1) e WHERE rownum <= 3 order by salary desc"
					, nativeQuery = true)
	public List<e> getTop3EmployeesBasedOnSalary(String department_id);

	@Query(value="SELECT * FROM EMP ORDER BY EMPLOYEE_ID ASC",nativeQuery = true)
	public List<Emp> findAllWithSort();

	@Query(value = "UPDATE emp SET EMAIL = ?1 , fIRST_NAME =?2 ,lAST_NAME=?3 where employee_id = ?4", nativeQuery = true)
	public void updateById(String EMAIL, String fIRST_NAME, String lAST_NAME, long EMPLOYEE_ID);
	
}
