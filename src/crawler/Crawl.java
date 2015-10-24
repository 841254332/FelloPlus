package crawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Crawl {

	private static String charset = "UTF-8";

	public static String open(String url) {
		StringBuilder sb = new StringBuilder();
		DefaultHttpClient client = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse response = client.execute(httpGet);
			HttpEntity entity = response.getEntity();
			BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
			String line = null;
			while ((line = br.readLine()) != null)
				sb.append(line);
		} catch (Exception ex) {

//			IO.append(url + "\r\n", "emptysite.txt");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(Crawl.open("http://fellowplus.com/investors/").replaceAll("\t", ""));

	}

}