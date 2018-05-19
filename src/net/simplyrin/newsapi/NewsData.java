package net.simplyrin.newsapi;

/**
 * Created by SimplyRin on 2018/04/15.
 *
 *  Copyright 2018 SimplyRin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
