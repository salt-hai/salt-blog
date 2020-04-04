package com.salthai.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 友链管理
 *
 * @version: v1.0.0
 * @author: SaltHai
 * @date: 2020/4/4 16:09
 */
@Controller
@RequestMapping("/admin")
public class AdminLinksController {
  @RequestMapping("/toAdminLinks")
  public String toAdminLinks() {
    return "/admin/adminLinks";
  }
}
