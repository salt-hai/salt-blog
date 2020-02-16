package com.salthai.blog.service;

import com.salthai.blog.mapper.AdminMapper;
import com.salthai.blog.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: salthai
 * @Date: 2020/2/16 15:29
 * @Version 1.0
 */
@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    public Admin loginAdmin(Admin admin) {
        return adminMapper.findAdmin(admin);
    }
}
