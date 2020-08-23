package com.logicMatter.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ExcelEmployee")
public class Employee {
	
	@Id
	private String Employee_No;
	
	private String Employee_Name;
	
	private String Date_of_Birth;
	
	private String Designation;
	
	private Double Monthly_Salary;
	
	private String Annual_Salary;
	
	
	

}
