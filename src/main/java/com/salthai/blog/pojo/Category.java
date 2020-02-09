package com.salthai.blog.pojo;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/1/26 11:27
 * @Version 1.0
 */
public class Category {
    /**
     * 分类表主键
     */
    private int categoryId;
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 创建时间
     */
    private String categoryTime;

    /**
     * 一对多的映射关系
     */
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryTime() {
        return categoryTime;
    }

    public void setCategoryTime(String categoryTime) {
        this.categoryTime = categoryTime;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryTime='" + categoryTime + '\'' +
                '}';
    }
}
