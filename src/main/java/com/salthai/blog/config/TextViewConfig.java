package com.salthai.blog.config;

import com.salthai.blog.controller.ArticleController;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** @Author: salthai @Date: 2020/3/12 21:48 @Version 1.0 */
@Configuration
public class TextViewConfig implements WebMvcConfigurer {
  /**
   * 设置默认页
   *
   * @param registry
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/admin/adminCategory").setViewName("/admin/adminCategory");
    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    WebMvcConfigurer.super.addViewControllers(registry);
  }
}
