package work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import crawler.CrawlInvestor;
import entity.Investor;
import util.IO;

public class CrawlInvestment {

	public static void main(String[] args) {
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
			for (int i = 0; i < investor.getInvestment_case().size(); i++) {
				sql = "insert into fp_invetment_event(investor_name, project_name, project_stage, intro) values('"
						+ investor.getName() + "','" + investor.getInvestment_case().get(i).getName() + "','"
						+ investor.getInvestment_case().get(i).getStage() + "','"
						+ investor.getInvestment_case().get(i).getInto() + "')";
				 IO.savetomysql("fellowplus", sql);
			}
			 System.out.println(investor.getInvestment_case());
		}

	}

}
