package com.oracle.databaseOracle.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class e {
	
	@Id
	private int employee_id;
	private String first_name;
	private int salary;
	private String department_name;
}
