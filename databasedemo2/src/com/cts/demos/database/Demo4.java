package com.cts.demos.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/*
 * CREATE TABLE employee_master
(
  empcode VARCHAR(6) PRIMARY KEY,
  firstname VARCHAR(15) NOT NULL,
  middlename VARCHAR(15),
  lastname VARCHAR(15) NOT NULL,
  desig VARCHAR(15) NOT NULL,
  dept VARCHAR(15) NOT NULL,
  basic FLOAT(7,2) NOT NULL,
  date_of_birth DATE NOT NULL
);
 */
public class Demo4 {

	public static void main(String[] args) throws SQLException, ParseException {
		Scanner scanner=new Scanner(System.in);
		String empCode=null;
		String firstName=null;
		String middleName=null;
		String lastName=null;
		String desig=null;
		String dept=null;
		int basic=0;
		String strDate=null;
		Driver driver=new com.mysql.cj.jdbc.Driver();
       
		DriverManager.registerDriver(driver);
		
		String URL="jdbc:mysql://localhost:3306/DB29April";
		String username="root";
		String password="password@123";
		Connection connection=DriverManager.getConnection(URL,username,password);
		
		System.out.println("Enter the employee code");
		 empCode=scanner.next();
		System.out.println("Enter the first name");
		firstName=scanner.next();
		System.out.println("Enter the middle name");
		middleName=scanner.next();
		System.out.println("Enter the last name");
		lastName=scanner.next();
		System.out.println("Enter the designation");
		desig=scanner.next();
		System.out.println("Enter the department");
		dept=scanner.next();
		System.out.println("Enter the basic");
		basic=scanner.nextInt();
		System.out.println("Enter the date of birth");
		strDate=scanner.next();
		SimpleDateFormat fmt=new SimpleDateFormat("dd-MM-yyyy"); 
		Date dob=fmt.parse(strDate);
		java.sql.Date sqlDate=new java.sql.Date(dob.getTime());
		
		
	    String SQL="INSERT INTO employee_master VALUES(?,?,?,?,?,?,?,?)";
	    
        System.out.println(SQL);
        PreparedStatement statement=connection.prepareStatement(SQL);
        statement.setString(1,empCode);
        statement.setString(2,firstName);
        statement.setString(3,middleName);
        statement.setString(4,lastName);
        statement.setString(5,desig);
        statement.setString(6,dept);
        statement.setInt(7, basic);
        statement.setDate(8, sqlDate);
        int inserted=statement.executeUpdate();
        // returns true till it is having the record to read
        if(inserted>0)
        {
        	System.out.println("Record got inserted with a success");
        }
        else
        {
        	System.out.println("Record not inserted!!!!");
        }
        
        statement.close();
      
        connection.close();
	}

}
