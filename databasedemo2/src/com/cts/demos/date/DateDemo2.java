package com.cts.demos.date;

import java.text.SimpleDateFormat;
import java.util.Date;
// We want to see the date in a different format and we can take the help of SimpleDateFormat
public class DateDemo2 {

	public static void main(String[] args) {
		Date date=new Date();  // Current System date and time
		System.out.println("Unformatted date");
		System.out.println(date);
        SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
        String strDate=sdf.format(date);
        System.out.println("Formatted date");
	    System.out.println(strDate);
	    sdf.applyPattern("dd, MMM yyyy");
	     strDate=sdf.format(date);
	     System.out.println(strDate);
	     sdf.applyPattern("dd, MMMM yyyy");
	     strDate=sdf.format(date);
	     System.out.println(strDate);
	}     

}
