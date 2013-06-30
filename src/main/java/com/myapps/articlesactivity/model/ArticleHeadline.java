package com.myapps.articlesactivity.model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by mhewedy on 6/30/13.
 */
public class ArticleHeadline {
    private int id;
    private String headline;

    static AtomicInteger sAtomicInteger = new AtomicInteger();

    public ArticleHeadline(String headline) {
        this.headline = headline;
        this.id = sAtomicInteger.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @Override
    public String toString() {
        return headline;
    }
}
