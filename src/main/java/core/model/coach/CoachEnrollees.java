package core.model.coach;

public class CoachEnrollees {

	private Coach coach;
	private Long count;

	public CoachEnrollees(Coach coach, Long count) {
		this.coach = coach;
		this.count = count;
	}

	public Coach getCoach() {
		return coach;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
