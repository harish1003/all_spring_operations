package com.oracle.databaseOracle.service;

import java.util.List;


import com.oracle.databaseOracle.Error.DataNotFoundException;
import com.oracle.databaseOracle.entity.Emp;
import com.oracle.databaseOracle.entity.Employees;
import com.oracle.databaseOracle.entity.e;

public interface EmployeeService {

	public int getCountOfEmployes();

	public List<Emp> getAllEmployee();
	
	public List<Employees> getAllEmployees();

	public List<e> getTop3EmployeesBasedOnSalary(String department_id);

    public Employees saveEmployee(Employees employees);

	public void deleteEmployeeOld(long employeeId) throws DataNotFoundException;

	public int getCountOfEmployeesBasedOnSalary(long salary);

	public Object updateEmployee(long employeeId, String firstName) throws DataNotFoundException;

	public void saveEmployee(Emp emp);

	public void deleteEmployee(Long id);

	public Emp getEmployeeById(long eMPLOYEE_ID);

	public void updateById(Emp emp);

	
}
