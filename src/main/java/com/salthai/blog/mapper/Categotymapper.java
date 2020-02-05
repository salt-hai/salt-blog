package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/2/1 22:06
 * @Version 1.0
 */
@Mapper
@Repository
public interface Categotymapper {
    /**
     * 查询全部分类
     *
     * @return List
     */
    @Select("select * form category ")
    public List<Category> findAllCategory();

    /**
     * 查询分类详细信息
     *
     * @param categoryId
     * @return Category
     */
    @Select("select * from category where categoryId= #{categoryId} ")
    public Category findByCategoryId(int categoryId);

    /**
     * 查询分类下文章（两表链接查询，一对多关系，一条分类对应多条文章）
     *
     * @param categoryId
     * @return ArticleList
     */

    public List<Category> findCategoryArticle(int categoryId);
}
