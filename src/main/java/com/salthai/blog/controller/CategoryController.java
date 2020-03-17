package com.salthai.blog.controller;

import com.salthai.blog.pojo.Category;
import com.salthai.blog.pojo.JsonResult;
import com.salthai.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
     * 有问题
     *
     * @param
     * @return
     */
    @ResponseBody
    @GetMapping("/category")
    public JsonResult<List> getAllCategory() {
        List<Category> categoryList = categoryService.findAllCategory();
        System.out.println("启动成功/category");
        return new JsonResult<>(categoryList, "success");
    }
}
