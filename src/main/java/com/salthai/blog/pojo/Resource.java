package com.salthai.blog.pojo;

/**
 * @Author: salthai
 * @Date: 2020/1/26 11:34
 * @Version 1.0
 */
public class Resource {
    /**
     * 资源表主键Id
     */
    private int resourceId;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 资源链接
     */
    private String resourcePath;
    /**
     * 创建时间
     */
    private String resourceTime;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getResourceTime() {
        return resourceTime;
    }

    public void setResourceTime(String resourceTime) {
        this.resourceTime = resourceTime;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourcePath='" + resourcePath + '\'' +
                ", resourceTime='" + resourceTime + '\'' +
                '}';
    }
}
