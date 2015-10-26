package entity;

public class Experience {
	private String position;
	private String period;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Experience(String position, String period) {
		this.position = position;
		this.period = period;
	}
	
	
	
}
