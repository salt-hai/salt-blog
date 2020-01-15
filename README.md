---
开发历程

---

1）确定使用的技术：SpringBoot+Mybatis+Thymeleaf+局部Ajax异步请求+HTML（后续加上Token Redis shiro）+MySQL，版本管理 git

2）系统的使用者：用户浏览者，管理员Admin

3)开发顺序：

- 需求分析说明书

- 数据库设计。（用脑子想字段这种也叫数据库设计？）

- 前端出模板。

- 持久层接口的编写，单元测试。

- 模板的加入，开始写业务。

- 最后测试。

  

4）前台的功能：

- 首页浏览部分文章。
- 文章详情页。
- 文章分类页。
- 资源下载页。
- 关于页面和友链。

5）前台页面（有几个页面）



6）后台功能（Admin）：

- 博客网站的管理，管理员信息的修改。
- 管理员个人信息的显示。
- 撰写文章。（MarkDown）
- 文章管理，分类管理，资源文件的管理。

7)后台页面（Admin）



8）数据库字段设计（出文档）



9）搭建框架。





10)如需进行跨域请求，添加SpringBoot config

```java
/** 设置允许跨域*/
@Configuration
public class CorsConfig {
    /**
     *允许任何域名使用
     *允许任何头
     *允许任何方法（post、get等）
     */
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // addAllowedOrigin 不能设置为* 因为与 allowCredential 冲突,需要设置为具体前端开发地址
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        // allowCredential 需设置为true
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());
        return new CorsFilter(source);
    }
}

```

