package net.simplyrin.newsapi;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by SimplyRin on 2018/04/15.
 */
public class NewsApi {

	private String apiKey;

	public NewsApi(String apiKey) {
		this.apiKey = apiKey;
	}

	public NewsData getNewsData() {
		String result = this.rawWithAgent("https://newsapi.org/v2/top-headlines?country=jp&apiKey=" + this.apiKey);
		JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();

		String author = null;
		try {
			author = jsonObject.get("articles").getAsJsonArray().get(0).getAsJsonObject().get("author").getAsString();
		} catch (Exception e) {
		}

		String title = null;
		try {
			title = jsonObject.get("articles").getAsJsonArray().get(0).getAsJsonObject().get("title").getAsString();
		} catch (Exception e) {
		}

		String description = null;
		try {
			description = jsonObject.get("articles").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString();
		} catch (Exception e) {
		}

		String url = null;
		try {
			url = jsonObject.get("articles").getAsJsonArray().get(0).getAsJsonObject().get("url").getAsString();
		} catch (Exception e) {
		}

		String publishedAt = null;
		try {
			publishedAt = jsonObject.get("articles").getAsJsonArray().get(0).getAsJsonObject().get("publishedAt").getAsString();
		} catch (Exception e) {
		}

		NewsData newsData = new NewsData(author, title, description, url, publishedAt);

		return newsData;
	}

	/**
	 * @author Sk1er
	 * @github https://github.com/Sk1er/Levelhead/blob/master/src/main/java/club/sk1er/mods/levelhead/utils/Sk1erMod.java#L284-L307
	 */
	private String rawWithAgent(String url) {
		try {
			URL u = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) u.openConnection();
			connection.setRequestMethod("GET");
			connection.setUseCaches(true);
			connection.addRequestProperty("User-Agent", "Mozilla/5.0");
			connection.setReadTimeout(15000);
			connection.setConnectTimeout(15000);
			connection.setDoOutput(true);
			InputStream is = connection.getInputStream();
			Charset encoding = Charset.forName("UTF-8");
			String s = IOUtils.toString(is, encoding);
			if (s != null) {
				return s;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
