package com.salthai.blog.controller;

import com.salthai.blog.pojo.Admin;
import com.salthai.blog.service.AdminAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: salthai
 * @Date: 2020/3/18 23:01
 * @Version 1.0
 */
@Controller
public class AdminAboutController {
    @Autowired
    AdminAboutService adminAboutService;

    /**
     * 关于页面信息
     *
     * @param modelMap
     * @return String
     */
    @RequestMapping("/admin/getAdminAbout")
    public String getAdminAbout(ModelMap modelMap) {
        Admin admin = adminAboutService.findAdminAbout();
        modelMap.addAttribute("adminAbout", admin);
        return "about";
    }
}
