package crawler;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entity.InvestmentCase;
import entity.Investor;

public class CrawlInvestor {

	public CrawlInvestor() {
	}

	public Investor getInvestor(String url) {
		String html = null;
		Investor investor = null;
		while(html == null){
			html = Crawl.open(url);
		}
		investor = matchInvestor(html);
		return investor;

	}

	public Investor matchInvestor(String html) {
		// TODO Auto-generated method stub
		String name, position, foudation, interest_area, prefer_stage, resident_city, plan_project_count,
				single_project_amount, begin_invest_date, have_invest_count, project_to_next_count, education,
				work_experience;
		name = position = foudation = interest_area = prefer_stage = resident_city = plan_project_count = single_project_amount = begin_invest_date = have_invest_count = project_to_next_count = education = work_experience = "";
		List<InvestmentCase> list = new ArrayList<InvestmentCase>();
		Pattern pat = Pattern.compile("<div class=\"section-profile\">.*?<ul class=\"social-list\">");
		Matcher mat = pat.matcher(html);
		if (mat.find()) {
			Pattern pat1 = Pattern.compile("<h4>.*?</h4>");
			Matcher mat1 = pat1.matcher(mat.group());
			if (mat1.find()) {
				name = mat1.group().replaceAll("<.*?>", "").replace(" ? ", "-");// 姓名
			}
			pat1 = Pattern.compile("<p class=\"position\">.*?</p>");
			mat1 = pat1.matcher(mat.group());
			if (mat1.find()) {
				position = mat1.group().replaceAll("<.*?>", "").replaceAll("amp;", "").replaceAll(" • ", "");// 职位
			}
			pat1 = Pattern.compile("<p class=\"foudation\">.*?</p>");
			mat1 = pat1.matcher(mat.group());
			if (mat1.find()) {
				foudation = mat1.group().replaceAll("<.*?>", "");// 曾投资
			}
		}

		pat = Pattern.compile("<h6 class=\"block-title\">投资风格</h6>.*?</div><!-- .block 投资风格 -->");
		mat = pat.matcher(html);
		if (mat.find()) {
			Pattern pat1 = Pattern.compile("<p>.*?</p>");
			Matcher mat1 = pat1.matcher(mat.group());
			if (mat1.find()) {
				interest_area = mat1.group().replaceAll("<.*?>", "");
			}
			if (mat1.find()) {
				prefer_stage = mat1.group().replaceAll("<.*?>", "");
			}
			if (mat1.find()) {
				resident_city = mat1.group().replaceAll("<.*?>", "");
			}
			if (mat1.find()) {
				plan_project_count = mat1.group().replaceAll("<.*?>", "").replaceAll("\t", "");
			}
			if (mat1.find()) {
				single_project_amount = mat1.group().replaceAll("<.*?>", "");
			}
		}
		pat = Pattern.compile("<h6 class=\"block-title\">投资数据</h6>.*?</div><!-- .block 投资数据 -->");
		mat = pat.matcher(html);
		if (mat.find()) {
			Pattern pat1 = Pattern.compile("<strong>.*?</strong>");
			Matcher mat1 = pat1.matcher(mat.group());
			if (mat1.find()) {
				begin_invest_date = mat1.group().replaceAll("<.*?>", "").replaceAll("\t", "");
			}
			if (mat1.find()) {
				have_invest_count = mat1.group().replaceAll("<.*?>", "").replaceAll("\t", "");
			}
			if (mat1.find()) {
				project_to_next_count = mat1.group().replaceAll("<.*?>", "").replaceAll("\t", "");
			}
		}

		pat = Pattern.compile("<h6 class=\"block-title\">教育经历</h6>.*?<h6 class=\"block-title\">工作经历</h6>");
		mat = pat.matcher(html);
		if (mat.find()) {
			Pattern pat1 = Pattern.compile("<h6>.*?</h6>");
			Matcher mat1 = pat1.matcher(mat.group());
			while (mat1.find()) {
				education += mat1.group().replaceAll("<h6>", ",").replaceAll("</h6>", "").replaceAll(" &bullet; ", "-");
			}
			education = education.replaceFirst(",", "");
		}

		pat = Pattern.compile("<h6 class=\"block-title\">工作经历</h6>.*?</div><!-- .block 教育经历/工作经历 -->");
		mat = pat.matcher(html);
		if (mat.find()) {
			Pattern pat1 = Pattern.compile("<h6>.*?</h6>");
			Matcher mat1 = pat1.matcher(mat.group());
			while (mat1.find()) {
				work_experience += mat1.group().replaceAll("<h6>", ",").replaceAll("</h6>", "").replaceAll(" &bullet; ",
						"-");
			}
			work_experience = work_experience.replaceFirst(",", "");
		}

		pat = Pattern.compile("<h6 class=\"block-title\">投资案例</h6>.*?</div><!-- .block 投资案例 -->");
		mat = pat.matcher(html);
		if (mat.find()) {
			Pattern pat1 = Pattern.compile("<li>.*?</li>");
			Matcher mat1 = pat1.matcher(mat.group());
			while (mat1.find()) {
				InvestmentCase investment = new InvestmentCase();
				Matcher mat2 = Pattern.compile("<h4>.*?</h4>").matcher(mat1.group());
				if (mat2.find()) {
					investment.setName(mat2.group().replaceAll("<.*?>", ""));
				}
				mat2 = Pattern.compile("<p>.*?</p>").matcher(mat1.group());
				if (mat2.find()) {
					investment.setStage(mat2.group().replaceAll("<.*?>", ""));
				}
				mat2 = Pattern.compile("<div class=\"intro\">.*?</div>").matcher(mat1.group());
				if (mat2.find()) {
					investment.setInto(mat2.group().replaceAll("<.*?>", "").replaceAll("\t", ""));
				}
				list.add(investment);
			}
		}

		return new Investor(name, position, foudation, interest_area, prefer_stage, resident_city, plan_project_count,
				single_project_amount, begin_invest_date, have_invest_count, project_to_next_count, education,
				work_experience, list);
	}
}
