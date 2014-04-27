package com.digiburo.example.wvdemo.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.digiburo.example.wvdemo.R;

/**
 * Simple WebView HTTP GET w/WebViewClient to intercept
 */
public class ClientFragment extends Fragment {

  public static final String FRAGMENT_TAG = "TAG_CLIENT";

  private UrlInterceptListener switchFragmentListener;

  private WebView webView;

  /**
   * mandatory empty ctor
   */
  public ClientFragment() {
    //empty
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    switchFragmentListener = (UrlInterceptListener) activity;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View view = inflater.inflate(R.layout.fragment_webview, container, false);
    return(view);
  }

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    webView = (WebView) getActivity().findViewById(R.id.webView);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.setWebViewClient(new DemoWebViewClient(switchFragmentListener));
    webView.loadUrl("http://www.digiburo.com/mobi/db_index.html");
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on April 25, 2014 by gsc
 */