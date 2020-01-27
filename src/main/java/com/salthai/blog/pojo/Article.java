package com.salthai.blog.pojo;

/**
 * @Author: salthai
 * @Date: 2020/1/23 0:10
 * @Version 1.0
 */
public class Article {
    private int articleId;
    private String articleTitle;
    private String articleAuthor;
    private String articleTime;
    private String articleContent;
    private String articleBelong;
    private String articleShow;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(String articleTime) {
        this.articleTime = articleTime;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleBelong() {
        return articleBelong;
    }

    public void setArticleBelong(String articleBelong) {
        this.articleBelong = articleBelong;
    }

    public String getArticleShow() {
        return articleShow;
    }

    public void setArticleShow(String articleShow) {
        this.articleShow = articleShow;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleTime='" + articleTime + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleBelong='" + articleBelong + '\'' +
                ", articleShow='" + articleShow + '\'' +
                '}';
    }
}
