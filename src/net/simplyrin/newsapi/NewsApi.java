package net.simplyrin.newsapi;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Created by SimplyRin on 2018/04/15.
 */
public class NewsApi {

	private String apiKey, newsCountry = "JP";

	public NewsApi(String apiKey) {
		this.apiKey = apiKey;
	}

	public NewsApi(String apiKey, String newsCountry) {
		this.apiKey = apiKey;
		this.newsCountry = newsCountry;
	}

	public void setNewsCountry(String newsCountry) {
		this.newsCountry = newsCountry;
	}

	public NewsData getNewsData() {
		return this.getNewsData(0);
	}

	private NewsData getNewsData(int integer) {
		return this.getNewsData(this.getNewsObject(), integer);
	}

	public List<NewsData> getAllNewsData() {
		JsonObject jsonObject = this.getNewsObject();

		List<NewsData> list = new ArrayList<>();

		for(int integer = 0; jsonObject.get("articles").getAsJsonArray().size() > integer; integer++) {
			list.add(this.getNewsData(jsonObject, integer));
		}

		return list;
	}

	public JsonObject getNewsObject() {
		String result = this.rawWithAgent("https://newsapi.org/v2/top-headlines?country=" + this.newsCountry.toLowerCase() + "&apiKey=" + this.apiKey);
		return new JsonParser().parse(result).getAsJsonObject();
	}

	private NewsData getNewsData(JsonObject jsonObject, int integer) {
		String author = null;
		try {
			author = jsonObject.get("articles").getAsJsonArray().get(integer).getAsJsonObject().get("author").getAsString();
		} catch (Exception e) {
		}

		String title = null;
		try {
			title = jsonObject.get("articles").getAsJsonArray().get(integer).getAsJsonObject().get("title").getAsString();
		} catch (Exception e) {
		}

		String description = null;
		try {
			description = jsonObject.get("articles").getAsJsonArray().get(integer).getAsJsonObject().get("description").getAsString();
		} catch (Exception e) {
		}

		String url = null;
		try {
			url = jsonObject.get("articles").getAsJsonArray().get(integer).getAsJsonObject().get("url").getAsString();
		} catch (Exception e) {
		}

		String publishedAt = null;
		try {
			publishedAt = jsonObject.get("articles").getAsJsonArray().get(integer).getAsJsonObject().get("publishedAt").getAsString();
		} catch (Exception e) {
		}

		return new NewsData(author, title, description, url, publishedAt, this.newsCountry.toLowerCase());
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
