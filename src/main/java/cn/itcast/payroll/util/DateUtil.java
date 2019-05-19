package cn.itcast.payroll.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static long getDaysBetween(LocalDate d1,LocalDate d2) {
		return d1.getDayOfYear()-d2.getDayOfYear();
	}
	
	public static boolean isAfterFirday(LocalDate localDate) {
		ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
		Date date=Date.from(zonedDateTime.toInstant());
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		return ca.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
				&& ca.get(Calendar.DATE) % 2 == 0;
	}

	public static boolean between(LocalDate d,LocalDate start,LocalDate end) {
		return d.isAfter(start)&&d.isBefore(end);
	}
	
	public static boolean isFriday(LocalDate date) {
		return date.getDayOfWeek().equals(DayOfWeek.FRIDAY);
	}
	
	public static LocalDate add(LocalDate date,int day) {
		return date.plusDays(day);
	}
	
	public static boolean isLastDayOfMonth(LocalDate localDate) {
		ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
		Date date=Date.from(zonedDateTime.toInstant());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
		if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
			return true;
		}
		return false;
	}
	
	public static LocalDate getFirstDay(LocalDate localDate) {
		ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.systemDefault());
		Date date=Date.from(zonedDateTime.toInstant());
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int month = ca.get(Calendar.MONTH);
		while (ca.get(Calendar.MONTH) == month) {
			ca.add(Calendar.DATE, -1);
		}
		return ca.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
}
