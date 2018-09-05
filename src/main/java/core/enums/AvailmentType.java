package core.enums;

public enum AvailmentType {

	REGULAR, GUEST, UNLIMITED, REGULAR_WITH_COACH;
	
	public static AvailmentType fromString(String type) {
		try {
			return AvailmentType.valueOf(type);
		} catch(Exception e) {
			return REGULAR;
		}
	}

}
