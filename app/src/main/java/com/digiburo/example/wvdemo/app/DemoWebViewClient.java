package com.digiburo.example.wvdemo.app;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * WebViewClient for ClientFragment
 * @author gsc
 */
public class DemoWebViewClient extends WebViewClient {

  //
  private final String LOG_TAG = getClass().getName();

  //
  private SwitchFragmentListener switchFragmentListener;

  /**
   * ctor
   * @param arg
   */
  public DemoWebViewClient(SwitchFragmentListener arg) {
    switchFragmentListener = arg;
  }

  @Override
  public void onLoadResource(WebView webView, String url) {
    Log.i(LOG_TAG, "load:" + url);
  }

  @Override
  public void onPageFinished(WebView webView, String url) {
    Log.i(LOG_TAG, "pageFinished:" + url);
  }

  @Override
  public void onPageStarted(WebView webView, String url, Bitmap favicon) {
    Log.i(LOG_TAG, "pageStarted:" + url);
  }

  @Override
  public void onReceivedError(WebView webView, int errorCode, String description, String url) {
    Log.i(LOG_TAG, "error:" + errorCode + ":" + description + ":" + url);
  }

  @Override
  public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler handler, String host, String realm) {
    Log.i(LOG_TAG, "authRequest:" + host + ":" + realm);
  }

  @Override
  public void onReceivedLoginRequest(WebView webView, String realm, String account, String args) {
    Log.i(LOG_TAG, "loginRequest:" + realm + ":" + account);
  }

  @Override
  public void onReceivedSslError(WebView webView, SslErrorHandler handler, SslError error) {
    Log.i(LOG_TAG, "sslError");
  }

  @Override
  public void onScaleChanged(WebView webView, float oldScale, float newScale) {
    Log.i(LOG_TAG, "scaleChanged:" + oldScale + ":" + newScale);
  }

  @Override
  public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    Log.i(LOG_TAG, "unhandledKey:" + keyEvent);
  }

  @Override
  public WebResourceResponse shouldInterceptRequest(WebView webView, String url) {
    Log.i(LOG_TAG, "interceptRequest:" + url);
    return null;
  }

  @Override
  public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
    Log.i(LOG_TAG, "overrideKeyEvent:" + keyEvent);
    return true;
  }

  @Override
  public boolean shouldOverrideUrlLoading(WebView webView, String url) {
    Log.i(LOG_TAG, "overrideUrl:" + url);

    if (url.equals("http://www.digiburo.com/mobi/db_news.html")) {
      // news switches fragments
      switchFragmentListener.onUrlIntercept();
      return true;
    } else if (url.equals("http://www.digiburo.com/mobi/db_products.html")) {
      // products reloads index
      webView.loadUrl("http://www.digiburo.com/mobi/db_index.html");
      return true;
    }

    return false;
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on April 25, 2014 by gsc
 */