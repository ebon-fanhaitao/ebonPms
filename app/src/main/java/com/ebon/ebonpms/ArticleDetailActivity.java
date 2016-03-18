package com.ebon.ebonpms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ArticleDetailActivity extends FragmentActivity {

    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
//        getActionBar().setDisplayHomeAsUpEnabled(true);

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(ArticleDetailFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(ArticleDetailFragment.ARG_ITEM_ID));

            arguments.putSerializable(Article.KEY, getIntent().getSerializableExtra(Article.KEY));
            ArticleDetailFragment fragment = new ArticleDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.article_detail_container, fragment)
                    .commit();
        }
//        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        // Makes Progress bar Visible
//        getWindow().setFeatureInt(Window.FEATURE_PROGRESS, Window.PROGRESS_VISIBILITY_ON);

//        WebView webview = (WebView)findViewById(R.id.article_detail);

//        pd = new ProgressDialog(this);
//        pd.setMessage("Please wait Loading...");
//        pd.show();
//
//        webview.setWebChromeClient(new WebChromeClient() {
//            public void onProgressChanged(WebView view, int progress)
//            {
//                //Make the bar disappear after URL is loaded, and changes string to Loading...
//                setTitle("Loading...");
//                setProgress(progress * 100); //Make the bar disappear after URL is loaded
//
//                // Return the app name after finish loading
//                if(progress == 100)
//                    setTitle(R.string.app_name);
//            }
//        });
//        webview.setWebViewClient(new WebViewClient() {
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                if (!pd.isShowing()) {
//                    pd.show();
//                }
//                return true;
//            }
//            public void onPageFinished(WebView view, String url) {
//                System.out.println("on finish");
//                if (pd.isShowing()) {
//                    pd.dismiss();
//                }
//            }
//        });
//        Article article = (Article)getIntent().getSerializableExtra(Article.KEY);
//        webview.getSettings().setJavaScriptEnabled(true);
//        webview.loadUrl(article.getLink());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, ArticleListFragment.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
}
