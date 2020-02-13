package com.salthai.blog;

import com.salthai.blog.mapper.ArticleMapper;
import com.salthai.blog.pojo.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/2/12 19:25
 * @Version 1.0
 */
@SpringBootTest
public class ArticleMapperTest {
    @Autowired
    ArticleMapper articleMapper;


    public void saveArticle() {
        //获取当前时间
        Date date = new Date();
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //强制类型转换
        String articleTime = df.format(date);

        Article article = new Article();
        article.setArticleTitle("最近对于前后端分离的思考");
        article.setArticleContent("测试");
        article.setArticleAuthor("salt");
        article.setArticleBelong(1);
        article.setArticleShow(1);
        article.setArticleTime(articleTime);
        articleMapper.addArticle(article);
    }

    @Test
    public void findAllArticle() {
        List<Article> articleList = new ArrayList<>();
        articleList = articleMapper.findAllArticle();
        System.out.println(articleList);
    }

    @Test
    public void findByArticleShow() {
        List<Article> articleList = articleMapper.findByArticleShow(1);
        System.out.println(articleList);
    }

    @Test
    public void findByArticleId() {
        Article article = articleMapper.findByArticleId(1);
        System.out.println(article);

    }

    @Test
    public void findByArticleBelong() {
        List<Article> articleList = articleMapper.findByArticleBelong(1);
        for (Article article : articleList
        ) {
            System.out.println(article);
        }
    }

    public void updateArticle() {
        Article article = new Article();
        article.setArticleTitle("最近对于前后端分离的思考");
        article.setArticleContent("测试");
        article.setArticleAuthor("salt");
        article.setArticleBelong(1);
        article.setArticleShow(1);
    }

    /**
     * 获取时间
     */

    public void time() {
        Date date = new Date();
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //强制类型转换
        String articleTime = df.format(date);
        System.out.println(articleTime);
    }
}
