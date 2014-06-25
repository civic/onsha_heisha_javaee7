JavaEE7 チュートリアル つまみ食い
================================

公式ドキュメント [The Java EE 7 Tutorial](http://docs.oracle.com/javaee/7/tutorial/doc/home.htm)を参考につまみ食い。

今回のチュートリアルではNetBeansを使用。公式チュートリアルでサンプルコードをピックアップしながら、最終的になにかを作ろう。


準備
-------

### Java SE 
Java開発キット。 7以上で。パッケージマネージャでいれるとか、Oracle Java SEをダウンロード。

<http://www.oracle.com/technetwork/java/javase/downloads/index.html>

### NetBeans

開発用IDE。Application ServlerのGlassFishも同時にインストール。

NetBeans8を使用します。ダウンロードエディションが選べますが、Java EEかすべてで。

<https://netbeans.org/downloads/>

インストール時にアプリケーションサーバーを同時にインストールことを選択できる。
GlassFish Server Open Source Edition 4.0がデフォルトでチェックされているはずなので、
そのままGlassFish Serverをインストール。
基本的にデフォルトのままで同意してインストール。

すでにNetBeansをインストール済みで、GlassFishをインストールしていなかった場合は、インストーラーを再実行することで、
GlassFishを追加することができる。

または、GlassFish4を自分でインストールして、NetBeansの**ツール−サーバー**からインストール済みのGlassFishをNetBeansに登録することで使用できるようになる。



### 依存ライブラリの入手

NetBeans同梱のmavenを使用しますが、依存ライブラリのダウンロードをある程度事前に済ませておきたいので、
仮のプロジェクトをビルドすることで依存ライブラリを入手しておいてください。

(mavenプロジェクトをビルドすると自動的に依存ライブラリをダウンロードして、ローカルリポジトリ（~/.m2/repository)に取得します。
同じライブラリの再ダウンロードが不要になるように準備してます)

1. メニューから、 **ファイル−新規プロジェクト−サンプル/JavaEE/注釈サーブレット(Java EE7)** を選択、次へ
2. 適当なプロジェクトの場所を指定して、終了
3. メニューから、**実行− プロジェクト(annotation-war)をビルド** を選択  
依存ライブラリなどを自動ダウンロードし、最終的に出力ウィンドウに`BUILD SUCCESS`と表示されることを確認。
4. メニューから、**実行−プロジェクト(annotation-war)を実行** を選択しプロジェクトを実行する。  
GlassFishが起動し、Webアプリケーションのデプロイ後にブラウザが起動し、`Hello, my servlet, my filter, my listener`という文字列が表示されることを確認。
GlassFishの起動時に、JavaDBのセキュリティマネージャーが云々というメッセージがでますが、ここでは無効にしなくてもOKです。

やること
--------

- Servlet
- WebSocket
- CDI (Contexts and Dependency Injection)
- JAX-RS(REST)
- EJB(Enterprise Beans)
- JPA(Persistence)

目次
--------

1. [Overview](01.Overview.md)
2. [Web Tier](02.WebTier.md)
3. [CDI](03.CDI.md)
4. [JAX-RS(REST)](04.JAX-RS.md)

メモ
--------

### Example sources
Java EE 7 Tutorialで使われるexamplesソースコードは以下の方法で入手可能。

    $ svn export https://svn.java.net/svn/javaeetutorial~svn/branches/javaee-tutorial-7.0.4/examples javaee7-tutorial-examles


