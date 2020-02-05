package com.salthai.blog.pojo;

/**
 * @Author: salthai
 * @Date: 2020/1/26 11:32
 * @Version 1.0
 */
public class Links {
    /**
     * 友情链接表主键
     */
    private int likesId;
    /**
     * 链接标题
     */
    private String likesTitle;
    /**
     * 链接内容
     */
    private String likesHref;
    /**
     * 创建时间
     */
    private String likesTime;

    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
    }

    public String getLikesTitle() {
        return likesTitle;
    }

    public void setLikesTitle(String likesTitle) {
        this.likesTitle = likesTitle;
    }

    public String getLikesHref() {
        return likesHref;
    }

    public void setLikesHref(String likesHref) {
        this.likesHref = likesHref;
    }

    public String getLikesTime() {
        return likesTime;
    }

    public void setLikesTime(String likesTime) {
        this.likesTime = likesTime;
    }

    @Override
    public String toString() {
        return "Links{" +
                "likesId=" + likesId +
                ", likesTitle='" + likesTitle + '\'' +
                ", likesHref='" + likesHref + '\'' +
                ", likesTime='" + likesTime + '\'' +
                '}';
    }
}