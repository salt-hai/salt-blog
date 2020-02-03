package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @Author: salthai
 * @Date: 2020/2/1 22:05
 * @Version 1.0
 */
@Mapper
@Repository
public interface ArticleMapper {
    /**
     * 查询所有博客文章
     *
     * @return list
     */
    @Select("select * from article")
    public List<Article> findAllArticle();

    /**
     * 查询首页显示文章，首页展示 1为展示0为不展示，默认显示
     *
     * @param articleShow
     * @return list
     */
    @Select("select * from article where articleShow= #{articleShow} ")
    public List<Article> findByArticleShow(int articleShow);

    /**
     * 根据articleId查询文章详情
     *
     * @param articleId
     * @return Article
     */
    @Select("select * from article where articleId= #{articleId}")
    public Article findByArticleId(int articleId);

    /**
     * 保存文章信息
     *
     * @param article
     * @return int
     */
    @Insert(" insert into article ( articleTitle,articleAuthor,articleTime,articleContent,articleBelong,articleShow)" +
            " values (#{articleTitle},#{articleAuthor},#{articleTime},#{articleContent},#{articleBelong}," +
            "#{articleShow}) ")
    public int saveArticle(Article article);
}
