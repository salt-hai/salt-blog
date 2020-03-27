package com.salthai.blog.service.admin;

import com.salthai.blog.mapper.CategoryMapper;
import com.salthai.blog.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** 文章分类服务 @Author: salthai @Date: 2020/3/27 20:22 @Version 1.0 */
@Service
public class AdminCategoryService {
  private CategoryMapper categoryMapper;

  @Autowired
  public void setCategoryMapper(CategoryMapper categoryMapper) {
    this.categoryMapper = categoryMapper;
  }

  /**
   * 查询所有分类
   *
   * @return
   */
  public List<Category> findAllCategory() {
    return categoryMapper.findAllCategory();
  }

  /**
   * 删除某个分类
   *
   * @param categoryId 分类Id
   * @return
   */
  public boolean deleteByCategoryId(int categoryId) {
    return categoryMapper.deleteByCategoryId(categoryId);
  }
}
