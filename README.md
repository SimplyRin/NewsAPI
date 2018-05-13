# NewsAPI
一部コードをドラさんに頂いております。ありがとうございます。感謝します。

日本のヘッドラインニュースを一つ取得する API です。

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

# 使用させて頂いているコード
- [rawWithAgent](https://github.com/Sk1er/Levelhead/blob/master/src/main/java/club/sk1er/mods/levelhead/utils/Sk1erMod.java#L284-L307), Author: [Sk1er](https://github.com/Sk1er)

# 必要なライブラリ
- [Google Gson](https://github.com/google/gson)
