package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Article;
import org.apache.ibatis.annotations.*;
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
     * 查询分类下的文章
     *
     * @param articleBelong
     * @return List
     */
    @Select("select * from article where articleBelong= #{articleBelong}")
    public List<Article> findByArticleBelong(int articleBelong);

    /**
     * 添加文章
     *
     * @param article
     * @return int
     */
    @Insert(" insert into article ( articleTitle,articleAuthor,articleTime,articleContent,articleBelong,articleShow)" +
            " values (#{articleTitle},#{articleAuthor},#{articleTime},#{articleContent},#{articleBelong}," +
            "#{articleShow}) ")
    public int addArticle(Article article);

    /**
     * 更新文章信息
     *
     * @param article
     * @return int
     */
    @Update("update article set articleTitle=#{articleTitle},articleAuthor=#{articleAuthor}," +
            "articleTime=#{articleTime},articleContent=#{articleContent},articleBelong=#{articleBelong}," +
            "articleShow=#{articleShow} where articleId=#{articleId}")
    public int updateArticle(Article article);

    /**
     * 更新文章状态（是否首页显示）
     *
     * @param article
     * @return int
     */
    @Update("update article set articleShow=#{articleShow} where articleId=#{articleId}")
    public int updateArticleShow(Article article);

    /**
     * 更新文章分类
     *
     * @param articleId,articleBelong
     * @return int
     */
    @Update("update article set articleBelong=#{articleBelong} where articleId=#{articleId}")
    public int updateArticleBelong(int articleId, int articleBelong);

    /**
     * 删除文章
     *
     * @param articleId
     * @return void
     */
    @Delete("delete from article where articleId= #{articleId} ")
    public void deleteByArticleId(int articleId);
}
