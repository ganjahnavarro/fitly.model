package core.enums;

import java.util.Calendar;
import java.util.Date;

public enum Duration {

	DAYS(Calendar.DAY_OF_YEAR),
	WEEKS(Calendar.WEEK_OF_YEAR),
	MONTHS(Calendar.MONTH),
	ENDLESS;

	private Integer calendarField;
	
	Duration() {}
	
	Duration(Integer calendarField) {
		this.calendarField = calendarField;
	}

	public Date computeEndDate(Date startDate, Integer durationCount) {
		Date endDate = null;
		if (calendarField != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			calendar.add(calendarField, durationCount);
			calendar.add(Calendar.DATE, -1);
			endDate = calendar.getTime();
		}
		return endDate;
	}

}
