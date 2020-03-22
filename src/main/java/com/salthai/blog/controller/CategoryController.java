package com.salthai.blog.controller;

import com.salthai.blog.pojo.Category;
import com.salthai.blog.service.CategoryService;
import com.salthai.blog.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/3/16 22:31
 * @Version 1.0
 */
@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    /**
     * SpringBoot默认传输Json
     *
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/category")
    public List<Category> getAllCategory() {
        List<Category> categoryList = categoryService.findAllCategory();
        System.out.println("启动成功/category");
        return categoryList;
    }

    /**
     * 阿里FastJson传输
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/category/getFastJsonCategory")
    public JsonResult<List> getFastJsonCategory() {
        List<Category> categoryList = categoryService.findAllCategory();
        return new JsonResult<>(categoryList, "success");
    }
}
