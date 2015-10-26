package entity;

public class Education {
	private String school;
	private String period;
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Education(String school, String period) {
		this.school = school;
		this.period = period;
	}
	
	
	
}
