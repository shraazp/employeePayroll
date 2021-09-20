package com.user.employee.payroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
    public static final String PAYROLL_FILE_NAME="C:\\Users\\Shravya P\\eclipse-workspace\\payroll\\src\\main\\java\\com\\user\\employee\\payroll\\payroll-file.txt";
    public void writeData(List<EmployeePayrollData> employeePayrollList) {
        StringBuffer empBuffer=new StringBuffer();
        employeePayrollList.forEach(employee->{
            String emloyeeDataString=employee.toString().concat("\n");
            empBuffer.append(emloyeeDataString);     
        });
        try {
            Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public long countEntries() {
        long entries=0;
        try {
            entries=Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return entries;
    }
    public void printData() {
        try {
            Files.lines(new File(PAYROLL_FILE_NAME).toPath())
            .forEach(System.out::println);   
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

}
