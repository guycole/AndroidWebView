package com.digiburo.example.wvdemo.app;

import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * @author gsc
 */
public class DemoWebChromeClient extends WebChromeClient {

  //
  private final String LOG_TAG = getClass().getName();

  @Override
  public void onProgressChanged(WebView webView, int newProgress) {
    Log.d(LOG_TAG, "onProgressChanged:" + newProgress);
  }

  @Override
  public boolean onJsAlert(WebView webView, String url, String message, JsResult result) {
    Log.i(LOG_TAG, "onJsAlert:" + url + ":" + message);
    return super.onJsAlert(webView, url, message, result);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on April 25, 2014 by gsc
 */