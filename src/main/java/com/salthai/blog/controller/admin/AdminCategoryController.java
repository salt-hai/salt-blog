package com.salthai.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Category;
import com.salthai.blog.service.admin.AdminArticleService;
import com.salthai.blog.service.admin.AdminCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/** 分类控制器 @Author: salthai @Date: 2020/3/27 20:21 @Version 1.0 */
@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
  private AdminCategoryService adminCategoryService;
  private AdminArticleService adminArticleService;

  @Autowired
  public void setAdminCategoryService(AdminCategoryService adminCategoryService) {
    this.adminCategoryService = adminCategoryService;
  }

  @Autowired
  public void setAdminArticleService(AdminArticleService adminArticleService) {
    this.adminArticleService = adminArticleService;
  }
  /**
   * 管理分类入口
   *
   * @param modelMap 对象
   * @param start 第一页开始
   * @param size 每页6条
   * @return String
   * @throws Exception
   */
  @RequestMapping("/toAdminCategory")
  public String toAdminCategory(
      ModelMap modelMap,
      @RequestParam(value = "start", defaultValue = "1") int start,
      @RequestParam(value = "size", defaultValue = "6") int size)
      throws Exception {
    PageHelper.startPage(start, size);
    List<Category> categoryList = adminCategoryService.findAllCategory();
    PageInfo<Category> categoryPageInfo = new PageInfo<>(categoryList);
    modelMap.addAttribute("categoryPageInfo", categoryPageInfo);
    return "admin/adminCategory";
  }

  /**
   * 删除分类，并删除其下文章
   *
   * @param categoryId 分类Id
   * @return
   * @throws Exception
   */
  @RequestMapping("/deleteCategory/{categoryId}")
  public String deleteCategoryByCategoryId(@PathVariable int categoryId) throws Exception {
    int articleBelong = categoryId;
    if (adminCategoryService.deleteByCategoryId(categoryId)
        && adminArticleService.deleteByArticleBelong(articleBelong)) {
      return "redirect:/admin/toAdminCategory";
    } else {
      return "redirect:/admin/toAdminCategory";
    }
  }
}
