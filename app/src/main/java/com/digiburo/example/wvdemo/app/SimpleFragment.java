package com.digiburo.example.wvdemo.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.digiburo.example.wvdemo.R;

/**
 * Simple WebView HTTP GET
 */
public class SimpleFragment extends Fragment {

  public static final String FRAGMENT_TAG = "TAG_SIMPLE";

  /**
   * mandatory empty ctor
   */
  public SimpleFragment() {
    //empty
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

    WebView webView = (WebView) getActivity().findViewById(R.id.webView);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.loadUrl("http://www.digiburo.com/mobi/db_index.html");
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on April 25, 2014 by gsc
 */