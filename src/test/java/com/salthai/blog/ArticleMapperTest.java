package com.salthai.blog;

import com.salthai.blog.mapper.ArticleMapper;
import com.salthai.blog.pojo.Article;
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
  @Autowired ArticleMapper articleMapper;


  public void saveArticle() {
    // 获取当前时间
    Date date = new Date();
    // 设置日期格式
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 强制类型转换
    String articleTime = df.format(date);

    Article article = new Article();
    article.setArticleTitle("测试6");
    article.setArticleContent("测试");
    article.setArticleAuthor("salt");
    article.setArticleBelong(1);
    article.setCategoryName("技术");
    article.setArticleShow(1);
    article.setArticleTime(articleTime);
    articleMapper.addArticle(article);
  }


  public void findAllArticle() {
    List<Article> articleList = new ArrayList<>();
    articleList = articleMapper.findAllArticle();
    articleList.forEach(article -> {
      System.out.println(article);
    });
  }


  public void findByArticleShow() {
    List<Article> articleList = articleMapper.findByArticleShow(1);
    System.out.println(articleList);
  }


  public void findByArticleId() {
    Article article = articleMapper.findByArticleId(11);
    System.out.println(article);
  }


  public void findByArticleBelong() {
    List<Article> articleList = articleMapper.findByArticleBelong(1);
    for (Article article : articleList) {
      System.out.println(article);
    }
  }


  public void updateArticle() {
    // 获取当前时间
    Date date = new Date();
    // 设置日期格式
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 强制类型转换
    String articleTime = df.format(date);
    Article article = new Article();
    article.setArticleId(11);
    article.setArticleTitle("Markdown简单使用方法");
    article.setArticleContent("测试");
    article.setArticleAuthor("salt");
    article.setArticleBelong(1);
    article.setArticleShow(1);
    article.setCategoryName("技术");
    article.setArticleTime(articleTime);
    articleMapper.updateArticle(article);
    System.out.println("更新成功");
  }


  public void updateArticleShow() {
    Article article = new Article();
    article.setArticleId(1);
    article.setArticleShow(0);
    articleMapper.updateArticleShow(article);
    System.out.println("更新状态成功");
  }


  /**
   * 获取时间
   */
  public void time() {
    Date date = new Date();
    // 设置日期格式
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    // 强制类型转换
    String articleTime = df.format(date);
    System.out.println(articleTime);
  }

  public void deleteArticle() {

    if (articleMapper.deleteByArticleId(11)) {
      System.out.println("success");
    } else {
      System.out.println("失败");
    }

  }
}
