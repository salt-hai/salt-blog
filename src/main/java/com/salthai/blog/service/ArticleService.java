package com.salthai.blog.service;

import com.salthai.blog.mapper.ArticleMapper;
import com.salthai.blog.pojo.Article;
import com.youbenzi.mdtool.tool.MDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: salthai
 * @Date: 2020/3/14 22:02
 * @Version 1.0
 */
@Service
public class ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    /**
     * 查询首页显示文章
     *
     * @param articleShow
     * @return
     */
    public List<Article> getArticleShowList(int articleShow) {
        List<Article> articleList = articleMapper.findByArticleShow(articleShow);
        List<Article> articleListHtml = new ArrayList<>();
        for (Article article : articleList
        ) {
//            MD转html
            String articleContent = MDTool.markdown2Html(article.getArticleContent());
//            把转换为Html格式的文章内容重新添加进Article的articleContent属性
            article.setArticleContent(articleContent);
            articleListHtml.add(article);
        }
//        返回转换后article集合
        return articleListHtml;
    }
}