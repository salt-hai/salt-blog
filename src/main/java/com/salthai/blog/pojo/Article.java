package com.salthai.blog.pojo;

/**
 * @Author: salthai
 * @Date: 2020/1/23 0:10
 * @Version 1.0
 */
public class Article {
    /**
     * 文章主键
     */
    private int articleId;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章作者
     */
    private String articleAuthor;
    /**
     * 文章创建时间
     */
    private String articleTime;
    /**
     * 文章内容
     */
    private String articleContent;
    /**
     * 文章隶属分类，默认：0 “其他”分类
     */
    private int articleBelong;
    /**
     * 是否首页显示
     * 1为显示0为不显示，默认显示：1
     */
    private int articleShow;
    /**
     * 文章描述字段，截取内容一部分
     */
    private String articleDepict;

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

    public int getArticleBelong() {
        return articleBelong;
    }

    public void setArticleBelong(int articleBelong) {
        this.articleBelong = articleBelong;
    }

    public int getArticleShow() {
        return articleShow;
    }

    public void setArticleShow(int articleShow) {
        this.articleShow = articleShow;
    }

    public String getArticleDepict() {
        return articleDepict;
    }

    public void setArticleDepict(String articleDepict) {
        this.articleDepict = articleDepict;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleTime='" + articleTime + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleBelong=" + articleBelong +
                ", articleShow=" + articleShow +
                ", articleDepict='" + articleDepict + '\'' +
                '}';
    }
}

