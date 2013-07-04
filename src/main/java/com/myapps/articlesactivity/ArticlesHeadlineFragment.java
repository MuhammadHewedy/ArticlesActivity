package com.myapps.articlesactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.myapps.articlesactivity.model.ArticleHeadline;
import com.myapps.articlesactivity.model.ArticlesManager;

/**
 * Created by mhewedy on 6/30/13.
 */
public class ArticlesHeadlineFragment extends ListFragment {

    private final String TAG = ArticlesHeadlineFragment.class.getSimpleName();

    OnArticleHeadlineSelectedListener mOnArticleHeadlineSelectedListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_articles_headline, null);

        setListAdapter(new ArrayAdapter<ArticleHeadline>(getActivity(),
                android.R.layout.simple_list_item_1, ArticlesManager.get().getHeadLines()));

        getActivity().getActionBar().setDisplayHomeAsUpEnabled(false);

        return linearLayout;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mOnArticleHeadlineSelectedListener.onArticleHeadlineSelected(position);
    }

    public interface OnArticleHeadlineSelectedListener {
        public void onArticleHeadlineSelected(int position);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            mOnArticleHeadlineSelectedListener = (OnArticleHeadlineSelectedListener) activity;
        }catch (ClassCastException ex){
            Log.e(TAG, "Fragment Activity should implement OnArticleHeadlineSelectedListener " +
                    ex.getMessage());
        }
    }
}
