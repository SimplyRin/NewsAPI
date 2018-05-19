package net.simplyrin.newsapi;

/**
 * Created by SimplyRin on 2018/04/15.
 */
public class NewsData {

	private String author, title, description, url, publishedAt, newsCountry;

	public NewsData(String author, String title, String description, String url, String publishedAt, String newsCountry) {
		this.author = author;
		this.title = title;
		this.description = description;
		this.url = url;
		this.publishedAt = publishedAt;
	}

	public String getAuthor() {
		return this.author;
	}

	public String getTitle() {
		return this.title;
	}

	public String getDescription() {
		return this.description;
	}

	public String getUrl() {
		return this.url;
	}

	public String getPublishedAt() {
		return this.publishedAt;
	}

	public String getNewsCountry() {
		return this.newsCountry;
	}

}
