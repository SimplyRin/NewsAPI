# NewsAPI
一部コードをドラさんに頂いております。ありがとうございます。感謝します。

日本のヘッドラインニュースを取得する API です。

日本以外のニュースを取得する場合国を指定する必要があります。
```Java
NewsApi#setNewsCountry("国コード(JP,US,CA)")
```

-> GitHub に公開する許可もらいました (2018/5/18)

# Usage
1, NewsAPI キーを [newsapi.org](https://newsapi.org/) から取得

2, [Maven](https://github.com/SimplyRin/NewsAPI#Maven), [Releases](https://github.com/SimplyRin/NewsAPI/releases) から `NewsApi-1.x.jar` またはリポジトリをダウンロードし `net/simplyrin/newsapi/NewsApi.java`, `net/simplyrin/newsapi/NewsData.java` をインポートします。
- 最新バージョンはこちら: [NewsApi-1.1.1.jar](https://github.com/SimplyRin/NewsAPI/releases/download/1.1.1/NewsApi-1.1.1.jar)

一つだけ取得
```Java
NewsApi newsApi = new NewsApi("API_KEY");
NewsData newsData = newsApi.getNewsData();

System.out.println("著者: " + newsData.getAuthor());
System.out.println("タイトル: " + newsData.getTitle());
System.out.println("説明: " + newsData.getDescription());
System.out.println("URL: " + newsData.getUrl());
System.out.println("投稿日: " + newsData.getPublishedAt());
System.out.println("国: " + newsData.getNewsCountry());
```

全て取得 (List)
```Java
NewsApi newsApi = new NewsApi("API_KEY");
List<NewsData> allNewsData = newsApi.getAllNewsData();

for(NewsData newsData : allNewsData)  {
	System.out.println("著者: " + newsData.getAuthor());
	System.out.println("タイトル: " + newsData.getTitle());
	System.out.println("説明: " + newsData.getDescription());
	System.out.println("URL: " + newsData.getUrl());
	System.out.println("投稿日: " + newsData.getPublishedAt());
	System.out.println("国: " + newsData.getNewsCountry());
}
```

# Maven
- Repository
```XML
  <repositories>
    <repository>
      <id>net.simplyrin</id>
      <name>api</name>
      <url>https://api.simplyrin.net/maven/</url>
    </repository>
  </repositories>
```

- Dependency
```XML
  <dependencies>
    <dependency>
      <groupId>net.simplyrin.newsapi</groupId>
      <artifactId>NewsApi</artifactId>
      <version>1.1.1</version>
    </dependency>
  </dependencies>
```

# アップデート
- 1.0: 初期リリース
- 1.1: API から提供されている全てのニュースを List 系で取得できるように
- 1.1.1: 1.1 で追加した国設定コードをセットし忘れ事件の修正

# 使用させて頂いているコード
- [rawWithAgent](https://github.com/Sk1er/Levelhead/blob/master/src/main/java/club/sk1er/mods/levelhead/utils/Sk1erMod.java#L284-L307), Author: [Sk1er](https://github.com/Sk1er)

# 必要なライブラリ
- [Google Gson](https://github.com/google/gson)
