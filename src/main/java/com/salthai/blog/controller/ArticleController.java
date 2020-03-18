package com.salthai.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Article;
import com.salthai.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/3/14 22:52
 * @Version 1.0
 */
@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;

    /**
     * index
     *
     * @param modelMap
     * @param start    从0开始
     * @param size     每页6条
     * @return
     * @throws Exception
     */
    @RequestMapping("/")
    public String index(ModelMap modelMap,
                        @RequestParam(value = "start", defaultValue = "0") int start,
                        @RequestParam(value = "size", defaultValue = "6") int size)
            throws Exception {
        PageHelper.startPage(start, size);
        List<Article> articleList = articleService.getArticleShowList(1);
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        modelMap.addAttribute("pageInfo", pageInfo);
        System.out.println("------/success------");
        return "index";
    }

    /**
     * 详情页
     *
     * @param modelMap
     * @param articleId
     * @return
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
     * @return
     * @throws Exception
     */
    @RequestMapping("/article/getArticleBelong/{categoryId}")
    public String articleCategoryList(ModelMap modelMap, @PathVariable int categoryId,
                                      @RequestParam(value = "start", defaultValue = "0") int start,
                                      @RequestParam(value = "size", defaultValue = "6") int size)
            throws Exception {
        PageHelper.startPage(start, size);
        int articleBelong = categoryId;
        List<Article> articleList = articleService.getArticleBelongList(articleBelong);
        PageInfo<Article> articleBelongList = new PageInfo<>(articleList);
        modelMap.addAttribute("articleBelongList", articleBelongList);
        modelMap.addAttribute("articleBelong", articleBelong);
        System.out.println("------/category/{articleBelong} success------");
        return "articleList";
    }

    @RequestMapping("/article/allArticle")
    public String allArticleList(ModelMap modelMap,
                                 @RequestParam(value = "start", defaultValue = "0") int start,
                                 @RequestParam(value = "size", defaultValue = "6") int size)
            throws Exception {
        PageHelper.startPage(start, size);
        List<Article> articleList = articleService.getAllArticle();
        PageInfo<Article> allArticleList = new PageInfo<>(articleList);
        modelMap.addAttribute("articleBelongList", allArticleList);
        System.out.println("------/article/allArticle success------");
        return "articleList";
    }
}
