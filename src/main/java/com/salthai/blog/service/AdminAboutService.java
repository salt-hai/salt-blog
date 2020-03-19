package com.salthai.blog.service;

import com.salthai.blog.mapper.AdminMapper;
import com.salthai.blog.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: salthai
 * @Date: 2020/3/18 22:30
 * @Version 1.0
 */
@Service
public class AdminAboutService {
    @Autowired
    AdminMapper adminMapper;

    /**
     * 查询管理员信息
     *
     * @param
     * @return admin
     */
    public Admin findAdminAbout() {
        Admin admin = adminMapper.findAllAdmin();
        return admin;
    }
}
