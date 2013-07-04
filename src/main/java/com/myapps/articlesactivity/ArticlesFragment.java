package com.myapps.articlesactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
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
        updateArticleView();

        getActivity().getActionBar().setDisplayHomeAsUpEnabled(true);

        return linearLayout;
    }

    public void updateArticleView() {
        int headlineId = getArguments().getInt(MainActivity.EXTRA_ARTICLE_ID);
        Article article = ArticlesManager.get().getArticle(headlineId);
        mTextView.setText(article.getBody());
    }
}
