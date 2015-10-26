package work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crawler.CrawlInvestor;
import entity.Investor;
import util.IO;

public class CrawlInvestorInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> urls = new ArrayList<String>();
		Statement statement = IO.connectmsql("fellowplus");
		try {
			ResultSet rs = statement.executeQuery("SELECT * from fp_investor_link");
			while (rs.next()) {
				urls.add((String) rs.getObject(3));
			}
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		CrawlInvestor ci = new CrawlInvestor();
		String sql = null;
		Investor investor;
		for (String url : urls) {
			investor = ci.getInvestor(url);
			sql = "insert into fp_investor_info(name, position, foudation, interest_area, prefer_stage, resident_city, plan_project_count,	single_project_amount, begin_invest_date, have_invest_count, project_to_next_count, education, work_experience)"
					+ "values('" + investor.getName() + "','" + investor.getPosition() + "','" 
					+ investor.getFoudation()+ "','" + investor.getInterest_area() + "','" 
					+ investor.getPrefer_stage() + "','"+ investor.getResident_city() + "','" 
					+ investor.getPlan_project_count() + "','"+ investor.getSingle_project_amount() + "','" 
					+ investor.getBegin_invest_date() + "','"+ investor.getHave_invest_count() + "','"
					+ investor.getProject_to_next_count() + "'," + "'"+ investor.getEducation() + "','" 
					+ investor.getWork_experience() + "')";
//			IO.savetomysql("fellowplus", sql);
			System.out.println(ci.getInvestor(url).getInvestment_case().toString());
		}

	}

}
