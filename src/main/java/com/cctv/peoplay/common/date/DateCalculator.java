package com.cctv.peoplay.common.date;

import java.util.Calendar;

public class DateCalculator {
	public java.util.Date dateAdd(int subscriptionNumber, int period, java.sql.Date memberSubscribeValidity) {
		Calendar cal = Calendar.getInstance();

		if(memberSubscribeValidity == null || memberSubscribeValidity.compareTo(new java.sql.Date(System.currentTimeMillis())) < 0) {
			cal.setTime(new java.sql.Date(System.currentTimeMillis()));
		} else {
			cal.setTime(memberSubscribeValidity);
		}

        cal.add(Calendar.MONTH, period);
        
        java.util.Date date = cal.getTime();
        
        return date;
	}
}
