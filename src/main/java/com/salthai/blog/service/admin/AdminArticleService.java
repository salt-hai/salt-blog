package com.salthai.blog.service.admin;

import com.salthai.blog.mapper.ArticleMapper;
import com.salthai.blog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** 文章服务 @Author: salthai @Date: 2020/3/24 16:05 @Version 1.0 */
@Service
public class AdminArticleService {
  private ArticleMapper articleMapper;

  @Autowired
  public void setArticleMapper(ArticleMapper articleMapper) {
    this.articleMapper = articleMapper;
  }

  /**
   * 添加文章
   *
   * @param article
   * @return
   */
  public int addArticle(Article article) {
    return articleMapper.addArticle(article);
  }

  /**
   * 删除文章
   *
   * @param articleId
   * @return
   */
  public boolean deleteArticleByArticleId(int articleId) {
    return articleMapper.deleteByArticleId(articleId);
  }
}
