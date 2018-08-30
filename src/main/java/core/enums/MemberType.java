package core.enums;

public enum MemberType {

	REGULAR, WALKIN;
	
	public static MemberType fromString(String type) {
		try {
			return MemberType.valueOf(type);
		} catch(Exception e) {
			return REGULAR;
		}
	}

}
