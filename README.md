# NewsAPI
一部コードをドラさんに頂いております。ありがとうございます。感謝します。

# Usage
1, NewsAPI キーを [newsapi.org](https://newsapi.org/) から取得

2, [Releases](https://github.com/SimplyRin/NewsAPI/releases) から `NewsApi-1.0.jar` またはリポジトリをダウンロードし `NewsApi.java`, `NewsData.java` をインポートします。

```Java
NewsApi newsApi = new NewsApi("API_KEY");
NewsData newsData = newsApi.getNewsData();

System.out.println("著者: " + newsData.getAuthor());
System.out.println("タイトル: " + newsData.getTitle());
System.out.println("説明: " + newsData.getDescription());
System.out.println("URL: " + newsData.getUrl());
System.out.println("投稿日: " + newsData.getPublishedAt());
```

# 必要なライブラリ
- [Google Gson](https://github.com/google/gson)
