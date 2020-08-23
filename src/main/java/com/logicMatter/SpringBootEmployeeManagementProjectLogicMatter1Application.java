package com.logicMatter;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootEmployeeManagementProjectLogicMatter1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeManagementProjectLogicMatter1Application.class, args);
	}
	/*
	@Bean
	  public MultipartConfigElement multipartConfigElement() {
		//DataSize ds = new DataSize(1024);
	      MultipartConfigFactory factory = new MultipartConfigFactory();
	    //  factory.setMaxFileSize("100Mb");
	      return factory.createMultipartConfig();
	  }
	  */

}
