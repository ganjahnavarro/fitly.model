package core.enums;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import core.model.program.Program;

public enum AvailmentType {

	REGULAR, GUEST, UNLIMITED, REGULAR_WITH_COACH;
	
	public static AvailmentType fromString(String type) {
		try {
			return AvailmentType.valueOf(type);
		} catch(Exception e) {
			return REGULAR;
		}
	}
	
	public BigDecimal getProgramPrice(Program program) {
		if (this == AvailmentType.REGULAR) {
			return program.getMemberPrice();
		} else if (this == AvailmentType.GUEST) {
			return program.getGuestPrice();
		} else if (this == AvailmentType.UNLIMITED) {
			return program.getMonthlyPrice();
		} else if (this == AvailmentType.REGULAR_WITH_COACH) {
			return program.getCoachPrice();
		}
		return null;
	}
	
	public Date getEndDate(Date startDate) {
		if (this == AvailmentType.UNLIMITED) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(startDate);
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DATE, -1);
			return calendar.getTime();
		}
		return startDate;
	}

}
