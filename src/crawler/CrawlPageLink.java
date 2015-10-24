package crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.Investor;

public class CrawlPageLink {
	public CrawlPageLink() {
	}

	public List<Investor> getLink(int page) {
		String url = "http://fellowplus.com/investors/?page=" + page + "/";
		String html = Crawl.open(url);
		List<Investor> link = matchLink(html);
		return link;
	}

	public List<Investor> matchLink(String html) {
		// TODO Auto-generated method stub
		String url = null;
		String name = null;
		String htm = null;
		Investor investor = null;
		List<Investor> link = new ArrayList<Investor>();
		Pattern pat = Pattern.compile("<div class=\"tzr-list\">.*?<div class=\"page-navi\">");
		Matcher mat = pat.matcher(html);
		if (mat.find()) {
			html = mat.group();
			pat = Pattern.compile("<div class=\"user-item\">.*?</div>");
			mat = pat.matcher(html);
			while (mat.find()) {
				htm = mat.group();
				Pattern pat1 = Pattern.compile("<a href=\".*?\"");
				Matcher mat1 = pat1.matcher(htm);
				if (mat1.find()) {
					url = mat1.group().replace("<a href=", "").replaceAll("\"", "");
				}
				
				pat1 = Pattern.compile("alt=\".*?\"");
				mat1 = pat1.matcher(htm);
				if(mat1.find()){
					name = mat1.group().replace("alt=\"", "").replace("\"", "");
				}
				
				investor = new Investor(name, url);
				link.add(investor);
			}
		}
		return link;
	}
}
