package com.salthai.blog.controller.admin;

import com.salthai.blog.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: 资源管理
 *
 * @version: v1.0.0
 * @author: SaltHai
 * @date: 2020/4/4 16:48
 */
@Controller
@RequestMapping("/admin")
public class AdminResourceController {
  private ResourceService resourceService;

  @Autowired
  public void setResourceService(ResourceService resourceService) {
    this.resourceService = resourceService;
  }
}
