package com.oracle.databaseOracle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.oracle.databaseOracle.Error.DataNotFoundException;
import com.oracle.databaseOracle.entity.Emp;
import com.oracle.databaseOracle.entity.Employees;
import com.oracle.databaseOracle.entity.e;
import com.oracle.databaseOracle.repository.EmployeeDataRepository;
import com.oracle.databaseOracle.repository.EmployeeRepository;
import com.oracle.databaseOracle.repository.empRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDataRepository employeeDataRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private empRepository empRepository;
	
	@Override
	public int getCountOfEmployes() {
		return employeeDataRepository.getCountOfEmployes();
	}
	@Override
	public List<Emp> getAllEmployee() {
		return empRepository.findAllWithSort();
	}
	@Override
	public List<Employees> getAllEmployees() {
		return employeeRepository.findAll();
	}
	@Override
	public List<e> getTop3EmployeesBasedOnSalary(String department_id) {
		return empRepository.getTop3EmployeesBasedOnSalary(department_id);
	}
	@Override
	public Employees saveEmployee(Employees employees) {
		return employeeRepository.save(employees);
	}
	@Override
	public void deleteEmployeeOld(long employeeId) throws DataNotFoundException {
		if(employeeRepository.existsById(employeeId))
		   employeeRepository.deleteById((long) employeeId);
		else
			throw new DataNotFoundException("Employee id does not exists in database");
		
	}
	@Override
	public int getCountOfEmployeesBasedOnSalary(long salary) {
		return employeeRepository.getCountOfEmployeesBasedOnSalary(salary);
	}
	@Override
	public Object updateEmployee(long employeeId, String firstName) throws DataNotFoundException {
		if(employeeRepository.existsById(employeeId))
		return employeeRepository.updateEmployee(firstName,employeeId);
		else
		throw new DataNotFoundException("Employee id does not exists in database");
		
	}
	@Override
	public void saveEmployee(Emp emp) {
		empRepository.save(emp);
		
	}
	@Override
	public void deleteEmployee(Long id) {
		empRepository.deleteById(id);
		
	}
	@Override
	public Emp getEmployeeById(long employee_id) {
		Optional<Emp> emp = empRepository.findById(employee_id);
		return emp.get();
	}
	@Override
	public void updateById(Emp emp) {
		System.out.println(emp.EMAIL);
		try {
		empRepository.updateById(emp.EMAIL,emp.FIRST_NAME,emp.LAST_NAME,emp.EMPLOYEE_ID);
		}
		catch(Exception e) {}
		
	}


}
