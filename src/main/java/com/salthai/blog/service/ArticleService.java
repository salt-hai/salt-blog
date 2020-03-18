package com.salthai.blog.service;

import com.salthai.blog.mapper.ArticleMapper;
import com.salthai.blog.pojo.Article;
import com.salthai.blog.utils.Html2Text;
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
     * @return articleShowHtmlList
     */
    public List<Article> getArticleShowList(int articleShow) {
        List<Article> articleList = articleMapper.findByArticleShow(articleShow);
        return getArticleHtml(articleList);
    }

    /**
     * 查询分类文章
     *
     * @param articleBelong
     * @return articleBelongHtmlList
     */
    public List<Article> getArticleBelongList(int articleBelong) {
        List<Article> articleList = articleMapper.findByArticleBelong(articleBelong);
        return getArticleHtml(articleList);
    }

    /**
     * 获取转换后的article对象集合,工具方法
     *
     * @param articleList
     * @return articleListHtml
     */
    private List<Article> getArticleHtml(List<Article> articleList) {
        List<Article> articleListHtml = new ArrayList<>();
        for (Article article : articleList
        ) {
//            MD转html
            String articleContent = MDTool.markdown2Html(article.getArticleContent());
//            Html转text
            String articleDepictText = Html2Text.getContent(articleContent);
//            截取字符串用作描述
            String articleDepict = articleDepictText.substring(0, 80);
            article.setArticleDepict(articleDepict);
//            把转换为Html格式的文章内容重新添加进Article的articleContent属性
            article.setArticleContent(articleContent);
            articleListHtml.add(article);
        }
        return articleListHtml;
    }

    /**
     * 查看对应文章
     *
     * @param articleId
     * @return Article
     */
    public Article getArticleByArticleId(int articleId) {
        Article article = articleMapper.findByArticleId(articleId);
        Article articleHtml = new Article();
        articleHtml.setArticleContent(MDTool.markdown2Html(article.getArticleContent()));
        articleHtml.setArticleId(article.getArticleId());
        articleHtml.setArticleTitle(article.getArticleTitle());
        articleHtml.setArticleAuthor(article.getArticleAuthor());
        articleHtml.setArticleBelong(article.getArticleBelong());
        articleHtml.setArticleShow(article.getArticleShow());
        return articleHtml;
    }

    /**
     * 查看全部文章
     *
     * @return allArticleHtmlList
     */
    public List<Article> getAllArticle() {
        List<Article> allArticle = articleMapper.findAllArticle();
        return getArticleHtml(allArticle);
    }
}