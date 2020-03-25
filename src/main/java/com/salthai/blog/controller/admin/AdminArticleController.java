package com.salthai.blog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Article;
import com.salthai.blog.pojo.Category;
import com.salthai.blog.service.ArticleService;
import com.salthai.blog.service.CategoryService;
import com.salthai.blog.service.admin.AdminArticleService;
import com.salthai.blog.utils.Html2Text;
import com.youbenzi.mdtool.tool.MDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
   * @param modelMap ModelMap对象
   * @return String
   * @throws Exception
   */
  @RequestMapping({"/addArticle"})
  public String toArticleEdit(ModelMap modelMap) throws Exception {
    //得到分类信息，带给前端，写文章要用
    List<Category> categoryList = new ArrayList<>();
    categoryList = categoryService.findAllCategory();
    modelMap.addAttribute("categoryList", categoryList);
    return "admin/articleEdit";
  }

  /**
   * 添加文章请求（代码太憨需要重构）
   *
   * @param articleContent     文章内容
   * @param articleTitle       文章标题
   * @param articleAuthor      文章作者
   * @param articleBelong      文章所属分类
   * @param articleShow        文章是否首页显示
   * @param articleTime        文章创建时间
   * @param redirectAttributes redirectAttributes对象
   * @return
   * @throws Exception
   */
  @PostMapping("/articleEdit")
  public String articleEdit(@RequestParam("articleContent") String articleContent,
                            @RequestParam("articleTitle") String articleTitle,
                            @RequestParam("articleAuthor") String articleAuthor,
                            @RequestParam("articleBelong") int articleBelong,
                            @RequestParam("articleShow") int articleShow,
                            @RequestParam("articleTime") String articleTime,
                            RedirectAttributes redirectAttributes
  )
          throws Exception {
    int categoryId = articleBelong;
    //定义一个文章最少字数
    int articleContentLengthMim = 50;
    //md格式转html
    String articleContentHtml = MDTool.markdown2Html(articleContent);
    //html转text
    String articleContentText = Html2Text.getContent(articleContentHtml);
    Article article = new Article();
    if (articleContentText.length() < articleContentLengthMim) {
      redirectAttributes.addFlashAttribute("errorMsg", "文章字数需要大于50个字符");
      return "redirect:/admin/addArticle";
    } else {
      article.setArticleContent(articleContent);
      article.setArticleTitle(articleTitle);
      article.setArticleAuthor(articleAuthor);
      article.setArticleBelong(articleBelong);
      article.setArticleShow(articleShow);
      article.setCategoryName(categoryService.findByCategoryId(categoryId).getCategoryName());
//      如果用户没有设置时间，系统默认取当前时间
      if (articleTime.length() == 0) {
        Date date = new Date();
        // 设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 强制类型转换
        String articleTime1 = df.format(date);
        articleTime = articleTime1;
        article.setArticleTime(articleTime);
        adminArticleService.addArticle(article);
        //添加成功去文章管理页
        return "redirect:/admin/articleAdmin";
      } else {
        //使用用户设置的时间
        article.setArticleTime(articleTime);
        adminArticleService.addArticle(article);
        //添加成功去文章管理页
        return "redirect:/admin/articleAdmin";
      }
    }
  }

  /**
   * 更新文章入口，并进行数据回显
   *
   * @param modelMap  ModeMap对象
   * @param articleId 文章Id
   * @return
   * @throws Exception
   */
  @RequestMapping("/toArticleUpdate/{articleId}")
  public String toArticleUpdate(ModelMap modelMap, @PathVariable int articleId) throws Exception {
    Article article = new Article();
    article = adminArticleService.findByArticleId(articleId);
    List<Category> categoryList = new ArrayList<>();
    categoryList = categoryService.findAllCategory();
    modelMap.addAttribute("categoryList", categoryList);
    modelMap.addAttribute("article", article);
    return "admin/articleUpdate";
  }

  /**
   * 文章管理页
   *
   * @param modelMap ModelMap 对象
   * @param start    开始页
   * @param size     每页6条
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

  /**
   * 删除文章
   *
   * @param articleId 文章Id
   * @return
   * @throws Exception
   */
  @RequestMapping("/deleteArticle/{articleId}")
  public String deleteArticleByArticleId(@PathVariable int articleId) throws Exception {
    System.out.println(articleId);
    if (adminArticleService.deleteArticleByArticleId(articleId)) {
      return "redirect:/admin/articleAdmin";
    } else {
      return "redirect:/admin/articleAdmin";
    }
  }
}
