package com.alianza.rs.utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateManagement {

	public static Date getStringToDate(String strDate) {
		if (strDate != null && !strDate.equals("")) {
			try {
				DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				Date date = format.parse(strDate);
				return date;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String getDateToString(Date date) {
		if (date != null) {
			try {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				return dateFormat.format(date);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
