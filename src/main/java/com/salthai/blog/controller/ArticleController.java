package com.salthai.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.salthai.blog.pojo.Article;
import com.salthai.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
     * @param start
     * @param size
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
        return "index";
    }
}
