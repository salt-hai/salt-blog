package com.salthai.blog.controller.admin;

import com.salthai.blog.pojo.Admin;
import com.salthai.blog.service.admin.AdminService;
import com.salthai.blog.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: salthai
 * @Date: 2020/3/20 21:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private
    AdminService adminService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * 管理员主页管理员信息
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/adminIndex")
    public String getAdminAbout(ModelMap modelMap) {
        Admin admin = adminService.findAdminAbout();
        modelMap.addAttribute("adminInfo", admin);
        return "admin/adminIndex";
    }

    /**
     * 修改信息入口
     *
     * @return
     */
    @RequestMapping({"/adminInfo"})
    public String adminInfo() {
        return "admin/adminInfo";
    }

    /**
     * 更新管理员密码
     *
     * @param password1
     * @param password2
     * @param request
     * @return String
     * @throws Exception
     */
    @PostMapping("/updateAdminPassword")
    public String updateAdminPassword(
            @RequestParam("password1") String password1,
            @RequestParam("password2") String password2,
            HttpServletRequest request)
            throws Exception {
        if (password1.length() != 0 && password2.length() != 0) {
            if (password1.equals(password2)) {
                Admin admin = new Admin();
                String passwordMd5 = Md5Util.md5Encode(password1, "UTF-8");
                int adminId = (int) request.getSession().getAttribute("adminId");
                admin.setAdminId(adminId);
                admin.setPassword(passwordMd5);
                if (adminService.updateAdminPassword(admin)) {
                    request.getSession().removeAttribute("adminId");
                    request.getSession().removeAttribute("nickName");
                    request.getSession().removeAttribute("errorMsg");
                    return "redirect:/admin/logout";
                } else {
                    request.getSession().removeAttribute("errorMsg");
                    request.getSession().setAttribute("errorMsg", "修改失败");
                    return "admin/adminInfo";
                }
            }
            request.getSession().removeAttribute("errorMsg");
            request.getSession().setAttribute("errorMsg", "两次密码不同");
            return "admin/adminInfo";
        }
        request.getSession().removeAttribute("errorMsg");
        request.getSession().setAttribute("errorMsg", "请输入密码");
        return "admin/adminInfo";
    }
}
