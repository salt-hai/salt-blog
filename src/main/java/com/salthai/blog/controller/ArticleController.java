package com.salthai.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Article;
import com.salthai.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/3/14 22:52
 * @Version 1.0
 */
@Controller
public class ArticleController {

  private ArticleService articleService;

  @Autowired
  public void setArticleService(ArticleService articleService) {
    this.articleService = articleService;
  }

  /**
   * index
   *
   * @param modelMap ModelMap对象
   * @param start    0页开始
   * @param size     每页6条
   * @return String
   * @throws Exception
   */
  @RequestMapping("/")
  public String index(
      ModelMap modelMap,
      @RequestParam(value = "start", defaultValue = "0") int start,
      @RequestParam(value = "size", defaultValue = "6") int size)
      throws Exception {
    PageHelper.startPage(start, size);
    List<Article> articleList = articleService.getArticleShowList(1);
    PageInfo<Article> pageInfo = new PageInfo<>(articleList);
    modelMap.addAttribute("pageInfo", pageInfo);
    return "index";
  }

  /**
   * 详情页
   *
   * @param modelMap ModelMap对象
   * @param articleId 文章Id
   * @return article
   * @throws Exception
   */
  @RequestMapping("/article/getArticle/{articleId}")
  public String getArticleByArticleId(@PathVariable int articleId, ModelMap modelMap)
      throws Exception {
    Article article = articleService.getArticleByArticleId(articleId);
    modelMap.addAttribute("article", article);
    System.out.println("------/article/{articleId} success------");
    return "article";
  }

  /**
   * 文章分类页
   *
   * @param modelMap
   * @param start    从0开始
   * @param size     每页6条
   * @return String
   * @throws Exception
   */
  @RequestMapping("/article/getArticleBelong/{categoryId}")
  public String articleCategoryList(
      ModelMap modelMap,
      @PathVariable int categoryId,
      @RequestParam(value = "start", defaultValue = "0") int start,
      @RequestParam(value = "size", defaultValue = "6") int size)
      throws Exception {
    PageHelper.startPage(start, size);
    int articleBelong = categoryId;
    List<Article> articleList = articleService.getArticleBelongList(articleBelong);
    //        该分类是否有文章
    if (articleList != null && !articleList.isEmpty()) {
      PageInfo<Article> articleBelongList = new PageInfo<>(articleList);
      modelMap.addAttribute("articleBelongList", articleBelongList);
      modelMap.addAttribute("categoryId", categoryId);
      System.out.println("------有数据成功执行------");
      return "articleList";
    } else {
      System.out.println("------无数据成功执行------");
      return "error";
    }
  }

  /**
   * 查看全部文章
   *
   * @param modelMap
   * @param start
   * @param size
   * @return String
   * @throws Exception
   */
  @RequestMapping("/article/allArticle")
  public String allArticleList(
          ModelMap modelMap,
          @RequestParam(value = "start", defaultValue = "0") int start,
          @RequestParam(value = "size", defaultValue = "6") int size)
          throws Exception {
    PageHelper.startPage(start, size);
    List<Article> articleList = articleService.getAllArticle();
    PageInfo<Article> allArticleList = new PageInfo<>(articleList);
    modelMap.addAttribute("allArticleList", allArticleList);
    System.out.println("------/article/allArticle success------");
    return "articleListAll";
  }
}
