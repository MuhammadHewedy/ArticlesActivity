package com.myapps.articlesactivity.model;

/**
 * Created by mhewedy on 6/30/13.
 */
public class Article {

    private ArticleHeadline headline;
    private String body;

    public Article(String headline, String body) {
        this.headline = new ArticleHeadline(headline);
        this.body = body;
    }

    public ArticleHeadline getHeadline() {
        return headline;
    }

    public void setHeadline(ArticleHeadline headline) {
        this.headline = headline;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
