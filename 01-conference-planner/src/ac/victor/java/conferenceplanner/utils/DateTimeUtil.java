package ac.victor.java.conferenceplanner.utils;

import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {

	// Helper function that generates a Time object from hour and minute integers.
	public static Date generateTime(int hour, int minute) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.MINUTE, minute);

		return cal.getTime();
	}
	
}
