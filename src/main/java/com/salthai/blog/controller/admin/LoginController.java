package com.salthai.blog.controller.admin;

import com.salthai.blog.pojo.Admin;
import com.salthai.blog.service.AdminAboutService;
import com.salthai.blog.service.admin.AdminService;
import com.salthai.blog.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/** @Author: salthai @Date: 2020/3/20 20:00 @Version 1.0 */
@Controller
@RequestMapping("/admin")
public class LoginController {
  @Autowired AdminService adminService;
  AdminAboutService adminAboutService;
  /**
   * 管理员入口
   *
   * @return
   */
  @RequestMapping({"/login"})
  public String admin() {
    return "/admin/login";
  }

  /**
   * 使用MD5简简单单枯燥登录
   *
   * @param username
   * @param password
   * @param session
   * @return
   * @throws Exception
   */
  @PostMapping("/login")
  public String login(
      @RequestParam("username") String username,
      @RequestParam("password") String password,
      ModelMap modelMap,
      HttpSession session)
      throws Exception {
    Admin admin = adminService.login(username, password);
    if (admin != null) {
      // 重定向到请求/admin/adminIndex
      return "redirect:/admin/adminIndex";
    } else {
      session.setAttribute("errorMsg", "用户名或密码错误");
      return "admin/login";
    }
  }
}
