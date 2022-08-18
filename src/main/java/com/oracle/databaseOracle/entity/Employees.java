package com.oracle.databaseOracle.entity;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder 
//@Table(name = "Employees")
public class Employees {
	@Id
	public long EMPLOYEE_ID;
//	@Column(name = "FIRST_NAME")
	public String FIRST_NAME; 
	public String LAST_NAME;
	public String EMAIL;
	public String PHONE_NUMBER;
	public Date HIRE_DATE;
	public String JOB_ID;
	public long SALARY;
	public Integer COMMISSION_PCT;
	public Integer MANAGER_ID;
	public Integer DEPARTMENT_ID;
}
