package com.myapps.articlesactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;

import android.view.MenuItem;
import com.myapps.articlesactivity.model.ArticlesManager;

public class MainActivity extends FragmentActivity implements ArticlesHeadlineFragment.OnArticleHeadlineSelectedListener {

    public static final String EXTRA_ARTICLE_ID = "com.myapps.articlesactivity.EXTRA_ARTICLE_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            showFragment(new ArticlesHeadlineFragment(), false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                FragmentManager fragmentManager = getSupportFragmentManager();
                if (fragmentManager.getBackStackEntryCount() > 0){
                    fragmentManager.popBackStack();
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onArticleHeadlineSelected(int position) {
        ArticlesFragment articlesFragment = (ArticlesFragment) getSupportFragmentManager().findFragmentById(R.id
                .articles_fragment);

        boolean largeLayout = true;
        if (articlesFragment == null){
            articlesFragment = new ArticlesFragment();
            largeLayout = false;
        }

        Bundle bundle = new Bundle();
        int headlineId = ArticlesManager.get().getHeadLines().get(position).getId();
        bundle.putInt(EXTRA_ARTICLE_ID, headlineId);
        articlesFragment.setArguments(bundle);

        if (largeLayout){
            articlesFragment.updateArticleView();
        }else{
            showFragment(articlesFragment, true);
        }
    }

    private void showFragment(Fragment fragment, boolean addToBackStack) {
        if (fragment != null && findViewById(R.id.fragments_container) != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragments_container, fragment);
            if (addToBackStack){
                fragmentTransaction.addToBackStack(null);
            }
            fragmentTransaction.commit();
        }
    }
}
