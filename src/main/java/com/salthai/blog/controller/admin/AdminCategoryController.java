package com.salthai.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Category;
import com.salthai.blog.service.admin.AdminArticleService;
import com.salthai.blog.service.admin.AdminCategoryService;
import com.salthai.blog.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    //删除分类也一并删除该分类下的文章
    if (adminCategoryService.deleteByCategoryId(categoryId)
            && adminArticleService.deleteByArticleBelong(articleBelong)) {
      return "redirect:/admin/toAdminCategory";
    } else {
      return "redirect:/admin/toAdminCategory";
    }
  }

  /**
   * 突然意识到爷的前端非常差，添加分类
   *
   * @param categoryName
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
  @ResponseBody
  public String addCategory(@RequestParam("categoryName") String categoryName) throws Exception {
    Category category = new Category();
    if (StringUtils.isEmpty(categoryName)) {
      return "error";
    } else {
      DataUtil dataUtil = new DataUtil();
      category.setCategoryName(categoryName);
      category.setCategoryTime(dataUtil.getDate());
      adminCategoryService.addCategory(category);
      return "success";
    }
  }
}
