package com.salthai.blog.service;

import com.salthai.blog.mapper.CategoryMapper;
import com.salthai.blog.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/3/16 22:28
 * @Version 1.0
 */
@Service
public class CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 获取category对象集合
     *
     * @return list
     */
    public List<Category> findAllCategory() {
        List<Category> categoryList = categoryMapper.findAllCategory();
        return categoryList;
    }
}
