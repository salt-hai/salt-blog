package com.salthai.blog.pojo;

/**
 * @Author: salthai
 * @Date: 2020/1/23 0:06
 * @Version 1.0
 */
public class Admin {
    /**
     * 管理员Id
     */
    private int adminId;
    /**
     * 管理员用户名
     */
    private String username;
    /**
     * 管理员登录密码
     */
    private String password;
    /**
     * 管理员地址
     */
    private String adminAddress;
    /**
     * 管理员相关信息
     */
    private String adminAbout;
    /**
     * 管理员昵称
     */
    private String nickName;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminAbout() {
        return adminAbout;
    }

    public void setAdminAbout(String adminAbout) {
        this.adminAbout = adminAbout;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adminAddress='" + adminAddress + '\'' +
                ", adminAbout='" + adminAbout + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
