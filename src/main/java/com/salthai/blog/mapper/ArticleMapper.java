package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Article;
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
     * 查询首页显示文章
     *
     * @param articleShow
     * @return list
     */
    @Select("select * from article where id= #{adminId} ")
    public List<Article> findByArticleShow(int articleShow);
}
