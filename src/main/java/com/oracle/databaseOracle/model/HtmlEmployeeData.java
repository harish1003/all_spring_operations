package com.oracle.databaseOracle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HtmlEmployeeData {
	public long emp_id;
	public String emp_fname;
	public String emp_lname;
	public long emp_sal;
}
