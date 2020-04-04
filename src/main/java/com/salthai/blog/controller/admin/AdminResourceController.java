package com.salthai.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Resource;
import com.salthai.blog.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Description: 资源管理
 *
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

  /**
   * 资源列表
   *
   * @param modelMap
   * @param start
   * @param size
   * @return String
   * @throws Exception
   */
  @RequestMapping("/toAdminResource")
  public String toAdminResource(ModelMap modelMap,
                                @RequestParam(value = "start", defaultValue = "1") int start,
                                @RequestParam(value = "size", defaultValue = "6") int size)
          throws Exception {
    PageHelper.startPage(start, size);
    List<Resource> resourceList = resourceService.findAllResource();
    PageInfo<Resource> resourcePageInfo = new PageInfo<>(resourceList);
    modelMap.addAttribute("resourcePageInfo", resourcePageInfo);
    return "admin/adminResource";
  }

  /**
   * 删除资源
   *
   * @param resourceId
   * @return
   * @throws Exception
   */
  @RequestMapping("/deleteResource/{resourceId}")
  public String deleteByResourceId(@PathVariable int resourceId) throws Exception {
    if (resourceService.deleteByResourceId(resourceId)) {
      return "redirect:/admin/toAdminResource";
    }
    return "redirect:/admin/toAdminResource";
  }
}
