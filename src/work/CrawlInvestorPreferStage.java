package work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.IO;

public class CrawlInvestorPreferStage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql = "select * from fp_investor_info";
		Statement statement = IO.connectmsql("fellowplus");
		try {
			ResultSet rs =  statement.executeQuery(sql);
			while(rs.next()){
				String stages[] = rs.getObject(6).toString().replaceAll(" ", "").split("、");
				for(int i =0; i<stages.length; i++){
					sql = "insert into fp_investor_prefer_stage(investor_name, prefer_stage) values('"
							+rs.getObject(2)+"','"+stages[i]+"')";
					IO.savetomysql("fellowplus", sql);
					System.out.println(rs.getObject(2)+"','"+stages[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
