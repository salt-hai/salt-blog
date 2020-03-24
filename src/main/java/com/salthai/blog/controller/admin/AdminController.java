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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @RequestMapping("/adminInfo")
    public String adminInfo(ModelMap modelMap) {
        Admin admin = adminService.findAdminAbout();
        modelMap.addAttribute("admin", admin);
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
            HttpServletRequest request,
            RedirectAttributes redirectAttributes)
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
                    redirectAttributes.addFlashAttribute("errorMsg", "修改失败");
                    return "redirect:/admin/adminInfo";
                }
            }
            redirectAttributes.addFlashAttribute("errorMsg", "两次密码不同");
            return "redirect:/admin/adminInfo";
        }
        redirectAttributes.addFlashAttribute("errorMsg", "您啥也没输入，请输入密码");
        return "redirect:/admin/adminInfo";
    }

    /**
     * 更新管理员信息(可以加一个更新成功的弹窗提示）
     *
     * @return String
     */
    @PostMapping("/updateAdminInfo")
    public String updateAdminInfo(
            @RequestParam("nickName") String nickName,
            @RequestParam("adminAddress") String adminAddress,
            @RequestParam("adminAbout") String adminAbout,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes
    ) throws Exception {
        if (nickName.length() == 0 && adminAddress.length() == 0 && adminAbout.length() == 0) {
            redirectAttributes.addFlashAttribute("errorMsg", "您啥也没输入");
            return "redirect:/admin/adminInfo";
        } else {
            int adminId = (int) request.getSession().getAttribute("adminId");
            Admin admin = new Admin();
            admin.setNickName(nickName);
            admin.setAdminAddress(adminAddress);
            admin.setAdminAbout(adminAbout);
            admin.setAdminId(adminId);
            if (adminService.updateAdminInfo(admin)) {
                return "redirect:/admin/adminIndex";
            } else {
                redirectAttributes.addFlashAttribute("errorMsg", "修改失败");
                return "redirect:/admin/adminInfo";
            }

        }
    }
}
