package com.salthai.blog.mapper;

import com.salthai.blog.pojo.Article;
import com.salthai.blog.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/2/1 22:06
 * @Version 1.0
 */
@Mapper
@Repository
public interface CategoryMapper {
    /**
     * 查询全部分类
     *
     * @return List
     */
    @Select("select * from category ")
    public List<Category> findAllCategory();

    /**
     * 查询分类详细信息(findByCategoryId)
     *
     * @param categoryId
     * @return Category
     */
    @Select("select * from category where categoryId= #{categoryId} ")
    public Category findByCategoryId(int categoryId);

    /**
     * 查询分类下全部文章（两表链接查询，一对多关系，一条分类对应多条文章articles）
     *
     * @param categoryId
     * @return List
     */
    // 用于封装category（“一”的一方）
    @Results(id = "categoryMap", value = {
            //id为主键
            @Result(id = true, column = "categoryId", property = "categoryId"),
            @Result(column = "categoryName", property = "categoryName"),
            @Result(column = "categoryTime", property = "categoryTime"),
            //定义一对多的关系映射，实现对article的封装（对应多的一方）
            //        @Many注解用于一对多或多对多查询使用
            //        select属性指定内容：查询用户的唯一标识
            //        column属性指定内容：用户根据 uid 查询账户是所需要的参数，当前uid是articleBelong
            //        fetchType属性指定内容:指定延时查询FetchType.LAZY或立即查询FetchType.EAGER
            @Result(property = "articles", column = "articleBelong",
                    many = @Many(select = "mapper.ArticleMapper.findByArticleBelong",
                            fetchType = FetchType.LAZY))
    })
    @Select("select * from category where categoryId=#{categoryId}")
    public Category findCategoryArticle(int categoryId);

    /**
     * 添加一条分类
     *
     * @param category
     * @return int
     */
    @Insert(" insert into category ( categoryName,categoryTime) values (#{categoryName},#{categoryTime}) ")
    public int addCategory(Category category);

    /**
     * 删除分类
     *
     * @param categoryId
     * @return int
     */
    @Delete("delete from category where categoryId= #{categoryId} ")
    public int deleteByCategoryId(int categoryId);

    /**
     * 更新修改一条分类
     *
     * @param category
     * @return int1
     */
    @Update("update category set categoryName=#{categoryName},categoryTime=#{categoryTime} " +
            "where categoryId=#{categoryId} ")
    public int updateCategory(Category category);
}
