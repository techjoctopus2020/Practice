package com.Joctopus.Hib_Batch.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertStringToDate(String strdate) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		//String dateInString = "7-Jun-2013";

		Date date = null;
		try {
			
			date = formatter.parse(strdate);

			System.out.println("Date1"+date);
			System.out.println("Date:"+formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
		

	}


	public static void main(String[] args) {

		convertStringToDate("7-Jun-2013");

	}

}
