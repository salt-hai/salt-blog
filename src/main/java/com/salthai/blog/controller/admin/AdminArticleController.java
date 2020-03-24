package com.salthai.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Article;
import com.salthai.blog.pojo.Category;
import com.salthai.blog.service.ArticleService;
import com.salthai.blog.service.CategoryService;
import com.salthai.blog.service.admin.AdminArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/** @Author: salthai @Date: 2020/3/24 22:04 @Version 1.0 */
@Controller
@RequestMapping("/admin")
public class AdminArticleController {
  private AdminArticleService adminArticleService;
  private CategoryService categoryService;
  private ArticleService articleService;

  @Autowired
  public void setAdminArticleService(AdminArticleService adminArticleService) {
    this.adminArticleService = adminArticleService;
  }

  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @Autowired
  public void setArticleService(ArticleService articleService) {
    this.articleService = articleService;
  }

  /**
   * 写作入口
   *
   * @param modelMap
   * @return String
   * @throws Exception
   */
  @RequestMapping({"/addArticle"})
  public String toArticleEdit(ModelMap modelMap) throws Exception {
    List<Category> categoryList = new ArrayList<>();
    categoryList = categoryService.findAllCategory();
    modelMap.addAttribute("categoryList", categoryList);
    return "admin/articleEdit";
  }

  /**
   * 文章管理页
   *
   * @param modelMap 视图对象
   * @param start 0页开始
   * @param size 每页6条
   * @return String
   * @throws Exception
   */
  @RequestMapping("/articleAdmin")
  public String articleAdmin(
      ModelMap modelMap,
      @RequestParam(value = "start", defaultValue = "0") int start,
      @RequestParam(value = "size", defaultValue = "6") int size)
      throws Exception {
    PageHelper.startPage(start, size);
    List<Article> articleList = new ArrayList<>();
    articleList = articleService.getAllArticle();
    PageInfo<Article> articlePageInfo = new PageInfo<>(articleList);
    modelMap.addAttribute("articlePageInfo", articlePageInfo);
    return "admin/articleAdmin";
  }
}
