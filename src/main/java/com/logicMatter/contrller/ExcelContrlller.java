package com.logicMatter.contrller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.logicMatter.model.Employee;
import com.logicMatter.service.ExcelService;

@RestController
public class ExcelContrlller {
	
	
	 @Autowired
	 private ExcelService excelService;

      @PostMapping("/uploadFile")
	  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
      String message = "";
      
       try {
			 System.out.println();  
			 excelService.saveDataOfFileWithExternalPath(file);
             message = "Uploaded the file successfully";
			 return ResponseEntity.status(HttpStatus.OK).body(message);
			} catch (Exception e) {
			  message = "Could not upload the file ";
			  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
			 }
	   }
      
      
      @PostMapping("/upload")
	  public ResponseEntity<String> uploadFileWithoutFilePath() {
      String message = "";
      
       try {
			 excelService.savedataOfEmbeddedFile();
             message = "Uploaded the file successfully";
			 return ResponseEntity.status(HttpStatus.OK).body(message);
			} catch (Exception e) {
			  message = "Could not upload the file ";
			  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
			 }
	   }

	  
	  @GetMapping("/all")
		public ResponseEntity<?> fetchEmployees(){
			ResponseEntity<?> resp=null;
			try {
				List<Employee> list=excelService.getAllEmployees();
				resp=new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
			} catch (Exception e) {
				resp=new ResponseEntity<String>("Unable to Fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
				e.printStackTrace();
			}

			return resp;
		}
			  
	      
	
	

}
