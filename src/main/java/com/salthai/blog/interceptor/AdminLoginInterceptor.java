package com.salthai.blog.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台系统身份验证拦截器
 *
 * @Author: salthai
 * @Date: 2020/3/20 20:00
 * @Version 1.0
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    //请求处理前，也就是访问Controller前
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
      throws Exception {
    String uri = request.getRequestURI();
    if (uri.startsWith("/admin") && null == request.getSession().getAttribute("adminId")) {
      request.getSession().setAttribute("errorMsg", "请重新登陆");
      //request.getContextPath()得到项目虚拟路径， response.sendRedirect()重定向
      response.sendRedirect(request.getContextPath() + "/admin/login");
      return false;
    } else {
      request.getSession().removeAttribute("errorMsg");
      return true;
    }
  }

  //请求已经被处理，但在视图渲染前
  @Override
  public void postHandle(
          HttpServletRequest httpServletRequest,
          HttpServletResponse httpServletResponse,
          Object o,
          ModelAndView modelAndView)
          throws Exception {
  }

  //请求结果结果已经渲染好了，response没有进行返回但也无法修改response了（一般用于清理数据）
  @Override
  public void afterCompletion(
          HttpServletRequest httpServletRequest,
          HttpServletResponse httpServletResponse,
          Object o,
          Exception e)
          throws Exception {
  }
}
