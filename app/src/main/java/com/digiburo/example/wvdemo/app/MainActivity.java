package com.digiburo.example.wvdemo.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.digiburo.example.wvdemo.R;

/**
 * AndroidWebView demonstrates WebView functionality
 * Four fragments (managed by TabHelper)
 * AboutFragment = display simple HTML content from local file
 * ClientFragment = display remote HTML augmented by DemoWebViewClient (WebViewClient)
 * JavaScriptFragment = display local HTML w/JavaScript functions (DemoWebChromeClient/WebChromeClient)
 * SimpleFragment = display remote HTML (simple web page use case)
 */
public class MainActivity extends ActionBarActivity implements UrlInterceptListener {

  private TabHelper tabHelper;

  /**
   * Pressing "News" from "Client" tab displays a Dialog rather than perform HTTP GET
   */
  @Override
  public void onUrlIntercept() {
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment oldFragment = fragmentManager.findFragmentByTag(NewsDialogFragment.FRAGMENT_TAG);
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    if (oldFragment != null) {
      fragmentTransaction.remove(oldFragment);
    }

    NewsDialogFragment newsDialogFragment = new NewsDialogFragment();
    newsDialogFragment.show(fragmentManager, NewsDialogFragment.FRAGMENT_TAG);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ActionBar actionBar = getSupportActionBar();
    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

    tabHelper = new TabHelper(this);
    tabHelper.initialize();
  }
}