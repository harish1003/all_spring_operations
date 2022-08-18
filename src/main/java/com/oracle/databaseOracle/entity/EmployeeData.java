package com.oracle.databaseOracle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmployeeData {
	@Id
	private long employee_id;
	private String first_name;
	private String last_name;
	private String department;
	private long salary;
}
