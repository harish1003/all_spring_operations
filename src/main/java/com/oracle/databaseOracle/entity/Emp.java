package com.oracle.databaseOracle.entity;

	import java.sql.Date;
	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	public class Emp {
		@Id
		public long EMPLOYEE_ID;
		public String FIRST_NAME; 
		public String LAST_NAME;
		public String EMAIL;
	}


