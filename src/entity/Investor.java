package entity;

import java.util.List;

public class Investor {
	private String name;
	private String position;
	private String foudation;
	private String interest_area;
	private String prefer_stage;
	private String resident_city;
	private String plan_project_count;
	private String single_project_amount;
	private String begin_invest_date;
	private String have_invest_count;
	private String project_to_next_count;
	private String education;
	private String work_experience;
	private List<InvestmentCase> investment_case;
	private String link;
	
	
	
	public Investor() {
	}


	public Investor(String name, String position, String foudation, String interest_area, String prefer_stage,
			String resident_city, String plan_project_count, String single_project_amount, String begin_invest_date,
			String have_invest_count, String project_to_next_count) {
		super();
		this.name = name;
		this.position = position;
		this.foudation = foudation;
		this.interest_area = interest_area;
		this.prefer_stage = prefer_stage;
		this.resident_city = resident_city;
		this.plan_project_count = plan_project_count;
		this.single_project_amount = single_project_amount;
		this.begin_invest_date = begin_invest_date;
		this.have_invest_count = have_invest_count;
		this.project_to_next_count = project_to_next_count;
	}








	//全部属性
	public Investor(String name, String position, String foudation, String interest_area, String prefer_stage,
			String resident_city, String plan_project_count, String single_project_amount, String begin_invest_date,
			String have_invest_count, String project_to_next_count, String education, String work_experience,
			List<InvestmentCase> investment_case) {
		this.name = name;
		this.position = position;
		this.foudation = foudation;
		this.interest_area = interest_area;
		this.prefer_stage = prefer_stage;
		this.resident_city = resident_city;
		this.plan_project_count = plan_project_count;
		this.single_project_amount = single_project_amount;
		this.begin_invest_date = begin_invest_date;
		this.have_invest_count = have_invest_count;
		this.project_to_next_count = project_to_next_count;
		this.education = education;
		this.work_experience = work_experience;
		this.investment_case = investment_case;
	}
	
	
	
	//姓名和链接
	public Investor(String name, String link) {
		this.name = name;
		this.link = link;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getFoudation() {
		return foudation;
	}
	public void setFoudation(String foudation) {
		this.foudation = foudation;
	}
	public String getInterest_area() {
		return interest_area;
	}
	public void setInterest_area(String interest_area) {
		this.interest_area = interest_area;
	}
	public String getPrefer_stage() {
		return prefer_stage;
	}
	public void setPrefer_stage(String prefer_stage) {
		this.prefer_stage = prefer_stage;
	}
	public String getResident_city() {
		return resident_city;
	}
	public void setResident_city(String resident_city) {
		this.resident_city = resident_city;
	}
	public String getPlan_project_count() {
		return plan_project_count;
	}
	public void setPlan_project_count(String plan_project_count) {
		this.plan_project_count = plan_project_count;
	}
	public String getSingle_project_amount() {
		return single_project_amount;
	}
	public void setSingle_project_amount(String single_project_amount) {
		this.single_project_amount = single_project_amount;
	}
	public String getBegin_invest_date() {
		return begin_invest_date;
	}
	public void setBegin_invest_date(String begin_invest_date) {
		this.begin_invest_date = begin_invest_date;
	}
	public String getHave_invest_count() {
		return have_invest_count;
	}
	public void setHave_invest_count(String have_invest_count) {
		this.have_invest_count = have_invest_count;
	}
	public String getProject_to_next_count() {
		return project_to_next_count;
	}
	public void setProject_to_next_count(String project_to_next_count) {
		this.project_to_next_count = project_to_next_count;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getWork_experience() {
		return work_experience;
	}
	public void setWork_experience(String work_experience) {
		this.work_experience = work_experience;
	}
	public List<InvestmentCase> getInvestment_case() {
		return investment_case;
	}
	public void setInvestment_case(List<InvestmentCase> investment_case) {
		this.investment_case = investment_case;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}



	@Override
	public String toString() {
		return "Investor [name=" + name + ", position=" + position + ", foudation=" + foudation + ", interest_area="
				+ interest_area + ", prefer_stage=" + prefer_stage + ", resident_city=" + resident_city
				+ ", plan_project_count=" + plan_project_count + ", single_project_amount=" + single_project_amount
				+ ", begin_invest_date=" + begin_invest_date + ", have_invest_count=" + have_invest_count
				+ ", project_to_next_count=" + project_to_next_count + ", education=" + education + ", work_experience="
				+ work_experience + ", investment_case=" + investment_case + ", link=" + link + "]";
	}

	
	
	
}
