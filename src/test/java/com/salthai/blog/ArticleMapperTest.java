package com.salthai.blog;

import com.salthai.blog.mapper.ArticleMapper;
import com.salthai.blog.pojo.Article;
import com.salthai.blog.utils.Html2Text;
import com.youbenzi.mdtool.tool.MDTool;
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

    @Test
    public void saveArticle() {
        //获取当前时间
        Date date = new Date();
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //强制类型转换
        String articleTime = df.format(date);

        Article article = new Article();
        article.setArticleTitle("测试6");
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
        List<Article> articleListHtml = new ArrayList<>();
        for (Article article : articleList
        ) {
//            MD转html
            String articleContent = MDTool.markdown2Html(article.getArticleContent());
//            截取字符串用作描述
            String articleDepictText = Html2Text.getContent(articleContent);
            String articleDepict = articleDepictText.substring(0, 35);
            article.setArticleDepict(articleDepict);
//            把转换后的Html注入articleContent属性
            article.setArticleContent(articleContent);
            articleListHtml.add(article);
        }
        System.out.println(articleListHtml);
    }

    @Test
    public void findByArticleId() {
        Article article = articleMapper.findByArticleId(4);
//        String articleDepict = article.getArticleContent().substring(0, 20);
//        article.setArticleDepict(articleDepict);
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

    /**
     * 测试更新文章信息，失败
     */
    @Test
    public void updateArticle() {
        //获取当前时间
        Date date = new Date();
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //强制类型转换
        String articleTime = df.format(date);
        Article article = new Article();
        article.setArticleId(1);
        article.setArticleTitle("Markdown简单使用方法");
        article.setArticleContent("测试");
        article.setArticleAuthor("salt");
        article.setArticleBelong(1);
        article.setArticleShow(1);
        article.setArticleTime(articleTime);
        articleMapper.updateArticle(article);
        System.out.println("更新成功");
    }

    @Test
    public void updateArticleShow() {
        Article article = new Article();
        article.setArticleId(1);
        article.setArticleShow(0);
        articleMapper.updateArticleShow(article);
        System.out.println("更新状态成功");
    }

    @Test
    public void updateArticleBelong() {
        articleMapper.updateArticleBelong(1, 2);
        System.out.println("success");
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
