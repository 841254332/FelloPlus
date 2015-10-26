package entity;

public class InvestmentCase {
	private String name;
	private String stage;
	private String into;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	
	public String getInto() {
		return into;
	}
	
	public void setInto(String into) {
		this.into = into;
	}
	public InvestmentCase(String name, String stage, String into) {
		super();
		this.name = name;
		this.stage = stage;
		this.into = into;
	}
	public InvestmentCase() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InvestmentCase [name=" + name + ", stage=" + stage + ", into=" + into + "]";
	}
	
	
	
	
}
