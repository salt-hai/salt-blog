package com.salthai.blog.controller.admin;

import com.salthai.blog.pojo.Admin;
import com.salthai.blog.service.AdminAboutService;
import com.salthai.blog.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 管理员登录相关操作
 *
 * @Author: salthai
 * @Date: 2020/3/20 20:00
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
  @Autowired AdminService adminService;
  AdminAboutService adminAboutService;
  /**
   * 管理员入口
   *
   * @return String
   */
  @RequestMapping({"/login"})
  public String admin() {
    return "/admin/login";
  }

  /**
   * 使用MD5简简单单枯燥登录
   *
   * @param username 管理员用户名
   * @param password 管理员密码
   * @param session
   * @return String
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
      //    session保存管理员昵称，用于拦截
      session.setAttribute("nickName", admin.getNickName());
      System.out.println(admin.getNickName());
      //    session保存管理员Id
      session.setAttribute("adminId", admin.getAdminId());
      // 重定向到请求/admin/adminIndex
      return "redirect:/admin/adminIndex";
    } else {
      session.setAttribute("errorMsg", "用户名或密码错误");
      return "admin/login";
    }
  }

  /**
   * 退出登录，并清除session里admin的信息
   *
   * @param request
   * @param session
   * @return
   */
  @GetMapping("/logout")
  public String logout(HttpServletRequest request, HttpSession session) {
    request.getSession().removeAttribute("adminId");
    request.getSession().removeAttribute("nickName");
    request.getSession().removeAttribute("errorMsg");
    return "admin/login";

  }
}
