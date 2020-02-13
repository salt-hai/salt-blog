package com.salthai.blog;

import com.salthai.blog.mapper.AdminMapper;
import com.salthai.blog.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/2/2 13:02
 * @Version 1.0
 */
@SpringBootTest
public class AdminMapperTest {
    @Autowired
    AdminMapper adminMapper;


    public void findAllAdmin() {
        List<Admin> admins = adminMapper.findAllAdmin();
        System.out.println(admins);
    }


    public void saveAdmin() {
        Admin admin = new Admin();
        admin.setAdminAbout("测试插入");
        admin.setAdminAddress("寻乌");
        admin.setUsername("salt");
        admin.setPassword("1234");
        adminMapper.addAdmin(admin);
        System.out.println("success");
    }


    public void deleteByAdminId() {
        adminMapper.deleteByAdminId(3);
        System.out.println("success");
    }


    public void findByAdminId() {
        Admin admin = adminMapper.findByAdminId(1);
        System.out.println(admin);
    }


    public void updateAdminPassword() {
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setPassword("root");
        adminMapper.updateAdminPassword(admin);
        System.out.println("success");
    }

    @Test
    public void updateAdminInfo() {
        Admin admin = new Admin();
        admin.setUsername("tom");
        admin.setAdminAddress("赣州");
        admin.setAdminAbout("不会代码");
        admin.setAdminId(4);
        adminMapper.updateAdminInfo(admin);
        System.out.println("success");
    }
}
