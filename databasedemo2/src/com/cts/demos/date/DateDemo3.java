package com.cts.demos.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDemo3 {

	public static void main(String[] args) throws ParseException  {
		String strDate;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the date in dd-MM-yyyy format");
		strDate=scanner.next();   
		SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");  // In which format date is accepted
        Date date=format.parse(strDate);
        System.out.println(date);
        strDate=format.format(date);
        System.out.println(strDate);
	}

}
