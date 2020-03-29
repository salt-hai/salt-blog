package com.salthai.blog.config;

import com.salthai.blog.interceptor.AdminLoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 添加一个拦截器，拦截以/admin为前缀的url路径
 *
 * @Author: salthai
 * @Date: 2020/3/22 22:05
 * @Version 1.0
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
  // set属性注入
  private AdminLoginInterceptor adminLoginInterceptor;

  @Autowired
  public void setAdminLoginInterceptor(AdminLoginInterceptor adminLoginInterceptor) {
    this.adminLoginInterceptor = adminLoginInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 添加一个拦截器，拦截以/admin为前缀的url路径
    // 通过registry来注册拦截器，通过addPathPatterns来添加拦截路径
    registry
            .addInterceptor(adminLoginInterceptor)
            .addPathPatterns("/admin/**")
            .excludePathPatterns("/admin/login");
  }
}
