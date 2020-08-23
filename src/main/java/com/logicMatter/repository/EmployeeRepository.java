package com.logicMatter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.logicMatter.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,String>  {

}
