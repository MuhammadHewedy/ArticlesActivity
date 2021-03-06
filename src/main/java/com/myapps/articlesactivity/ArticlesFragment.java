package com.myapps.articlesactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.myapps.articlesactivity.model.Article;
import com.myapps.articlesactivity.model.ArticlesManager;

/**
 * Created by mhewedy on 6/30/13.
 */
public class ArticlesFragment extends Fragment {

    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_articles, null);

        mTextView = (TextView) linearLayout.findViewById(R.id.articles_text);

        boolean dynamicFragments = getArguments() != null;

        if (dynamicFragments){
            getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);
            updateArticleView(getArguments().getInt(MainActivity.EXTRA_ARTICLE_ID));
        }

        return linearLayout;
    }

    public void updateArticleView(int headlineId) {
        Article article = ArticlesManager.get().getArticle(headlineId);
        mTextView.setText(article.getBody());
    }
}
