package com.salthai.blog.pojo;

/**
 * @Author: salthai
 * @Date: 2020/1/23 0:06
 * @Version 1.0
 */
public class Admin {
    private int adminId;
    private String username;
    private String password;
    private String adminAddress;
    private String adminAbout;

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

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adminAddress='" + adminAddress + '\'' +
                ", adminAbout='" + adminAbout + '\'' +
                '}';
    }
}
