package com.logicMatter.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.logicMatter.model.Employee;

@Component
public class ExcelUtility {

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    //static  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    public static List<Employee> excelToEmployeesWithExternalFilePath(MultipartFile files) throws Exception {

        List<Employee> employeeList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {

                Employee employee = new Employee();

                XSSFRow row = worksheet.getRow(index);
                employee.setEmployee_No(row.getCell(0).getStringCellValue());
                employee.setEmployee_Name(row.getCell(1).getStringCellValue());
                Date dob = row.getCell(2).getDateCellValue();
                String date = sdf.format(dob);
                employee.setDate_of_Birth(date);
                employee.setDesignation(row.getCell(3).getStringCellValue());
                employee.setMonthly_Salary(row.getCell(4).getNumericCellValue());
                employee.setAnnual_Salary(row.getCell(5).getStringCellValue());


                employeeList.add(employee);
            }
        }
        workbook.close();
        return employeeList;


    }

    public static List<Employee> excelToEmployeesWithEmbeddedFile() throws Exception {

        List<Employee> employeeList = new ArrayList<>();
        FileInputStream file = new FileInputStream(new File("C:\\Users\\hp\\Desktop\\LogicMatterEmployeeDetails.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet worksheet = workbook.getSheetAt(0);

        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            if (index > 0) {

                Employee employee = new Employee();

                XSSFRow row = worksheet.getRow(index);

                employee.setEmployee_No(row.getCell(0).getStringCellValue());
                employee.setEmployee_Name(row.getCell(1).getStringCellValue());
                Date dob = row.getCell(2).getDateCellValue();
                String date = sdf.format(dob);
                employee.setDate_of_Birth(date);
                employee.setDesignation(row.getCell(3).getStringCellValue());
                employee.setMonthly_Salary(row.getCell(4).getNumericCellValue());

                employee.setAnnual_Salary(row.getCell(5).getStringCellValue());


                employeeList.add(employee);

            }
        }
        workbook.close();
        return employeeList;


    }


}


