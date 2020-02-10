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
    private int linksId;
    /**
     * 链接标题
     */
    private String linksTitle;
    /**
     * 链接内容
     */
    private String linksHref;
    /**
     * 创建时间
     */
    private String linksTime;

    public int getLinksId() {
        return linksId;
    }

    public void setLinksId(int linksId) {
        this.linksId = linksId;
    }

    public String getLinksTitle() {
        return linksTitle;
    }

    public void setLinksTitle(String linksTitle) {
        this.linksTitle = linksTitle;
    }

    public String getLinksHref() {
        return linksHref;
    }

    public void setLinksHref(String linksHref) {
        this.linksHref = linksHref;
    }

    public String getLinksTime() {
        return linksTime;
    }

    public void setLinksTime(String linksTime) {
        this.linksTime = linksTime;
    }

    @Override
    public String toString() {
        return "Links{" +
                "linksId=" + linksId +
                ", linksTitle='" + linksTitle + '\'' +
                ", linksHref='" + linksHref + '\'' +
                ", linksTime='" + linksTime + '\'' +
                '}';
    }
}
