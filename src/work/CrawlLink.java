package work;

import java.util.ArrayList;
import java.util.List;

import crawler.CrawlPageLink;
import entity.Investor;
import util.IO;

public class CrawlLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrawlPageLink cpl = new CrawlPageLink();
		List<Investor> link = new ArrayList<Investor>();
		for (int i = 1; i < 32; i++) {
			link.addAll(cpl.getLink(i));
		}
		String sql = null;
		String database = "fellowplus";
		for(Investor i:link){
			sql = "insert into fp_investor_link(name, link) values ('"+i.getName()+"','"+i.getLink()+"')";
			IO.savetomysql(database, sql);
		}
	}

}
