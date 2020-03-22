package com.salthai.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: salthai
 * @Date: 2020/3/12 21:48
 * @Version 1.0
 */
@Configuration
public class TextViewConfig implements WebMvcConfigurer {
  /**
   * 用于页面测试
   *
   * @param registry
   */
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/admin/adminInfo").setViewName("/admin/adminInfo");
//    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    WebMvcConfigurer.super.addViewControllers(registry);
  }
}
