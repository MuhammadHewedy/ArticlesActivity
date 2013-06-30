package com.myapps.articlesactivity.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhewedy on 6/30/13.
 */
public class ArticlesManager {

    static List<Article> articleList = new ArrayList<Article>();

    static {
        articleList.add(new Article("Morsi to visit Quods", "Morsi has visited Quods today"));
        articleList.add(new Article("Obama to visit Cairo", "Obama has visited Cairo next week"));
    }

    private static ArticlesManager INSTANCE = new ArticlesManager();


    private ArticlesManager() {
    }

    public static ArticlesManager get() {
        return INSTANCE;
    }

    public List<ArticleHeadline> getHeadLines() {
        List<ArticleHeadline> ret = new ArrayList<ArticleHeadline>();

        for (Article article : articleList) {
            ret.add(article.getHeadline());
        }

        return ret;
    }

    public Article getArticle(int headlineId){
        for (Article article : articleList){
            if (article.getHeadline().getId() == headlineId)
                return article;
        }
        return null;
    }
}
