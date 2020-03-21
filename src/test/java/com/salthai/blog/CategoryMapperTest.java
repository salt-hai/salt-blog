package com.salthai.blog;

import com.salthai.blog.mapper.CategoryMapper;
import com.salthai.blog.pojo.Article;
import com.salthai.blog.pojo.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/2/14 13:28
 * @Version 1.0
 */
@SpringBootTest
public class CategoryMapperTest {
    @Autowired
    CategoryMapper categoryMapper;


    public void findAllCategory() {
        List<Category> categoryList = categoryMapper.findAllCategory();

        System.out.println(categoryList);
    }


    public void findByCategoryId() {
        Category category = categoryMapper.findByCategoryId(1);
        System.out.println(category);
    }

    /**
     * 两表链接查询:未成功。
     */

    public void findCategoryArticle() {
        Category category = categoryMapper.findCategoryArticle(1);
        System.out.println(category);
        System.out.println("-------------------");
        List<Article> articleList = category.getArticles();
        System.out.println(articleList);
    }


    public void addCategory() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String categoryTime = dateFormat.format(date);
        Category category = new Category();
        category.setCategoryName("其他");
        category.setCategoryTime(categoryTime);
        categoryMapper.addCategory(category);
        System.out.println("success");
    }


    public void updateCategory() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String categoryTime = dateFormat.format(date);
        Category category = new Category();
        category.setCategoryName("测试");
        category.setCategoryTime(categoryTime);
        category.setCategoryId(3);
        categoryMapper.updateCategory(category);
        System.out.println("success");
    }


    public void deleteByCategoryId() {
        categoryMapper.deleteByCategoryId(3);
        System.out.println("删除成功");
    }
}
