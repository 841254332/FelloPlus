package work;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.IO;

public class CrawlInvestorArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Statement statement = IO.connectmsql("fellowplus");
		String sql = "select * from fp_investor_info";
		try {
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String[] areas = rs.getObject(5).toString().split("、");
				for(int i = 0 ; i<areas.length ; i++){
					sql = "insert into fp_investor_area(investor_name, area) values ('"+
							rs.getObject(2)+"','"+areas[i]+"')";
								IO.savetomysql("fellowplus", sql);
							System.out.println(rs.getObject(2)+"---"+areas[i]);
				}
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
