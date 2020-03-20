package com.salthai.blog.controller.admin;

import com.salthai.blog.pojo.Admin;
import com.salthai.blog.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/** @Author: salthai @Date: 2020/3/20 21:58 @Version 1.0 */
@Controller
public class AdminController {
  @Autowired AdminService adminService;

  /**
   * 管理员主页管理员信息
   *
   * @param modelMap
   * @return
   */
  @RequestMapping("/admin/adminIndex")
  public String getAdminAbout(ModelMap modelMap) {
    Admin admin = adminService.findAdminAbout();
    modelMap.addAttribute("adminInfo", admin);
    return "admin/adminIndex";
  }
}
