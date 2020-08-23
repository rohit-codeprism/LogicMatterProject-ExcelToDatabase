package com.logicMatter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.logicMatter.model.Employee;
import com.logicMatter.repository.EmployeeRepository;
import com.logicMatter.util.ExcelUtility;


@Service	
public class ExcelService {
	

	@Autowired
	 private  EmployeeRepository repository;
	  
	  public void saveDataOfFileWithExternalPath(MultipartFile file) {
		    try {
		      List<Employee> employees = ExcelUtility.excelToEmployeesWithExternalFilePath(file);
		      repository.saveAll(employees);
		    } catch (Exception e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		  }
	  
	  public void savedataOfEmbeddedFile() {
		    try {
		    	System.out.println("Inside the save2() of service class");
		      List<Employee> employees = ExcelUtility.excelToEmployeesWithEmbeddedFile();
		      System.out.println("Inside the save2() of service class----worked fine");
		      repository.saveAll(employees);
		    } catch (Exception e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
		  }
	  
	 
	  public List<Employee> getAllEmployees() {
	    return repository.findAll();
	  }

	
	
	    
	
	

}
