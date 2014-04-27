package com.digiburo.example.wvdemo.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import com.digiburo.example.wvdemo.R;

/**
 * Demonstrate interaction w/JavaScript.
 */
public class JavaScriptFragment extends Fragment {

  public static final String FRAGMENT_TAG = "TAG_JAVASCRIPT";

  private final DemoJavaScript demoJavaScript = new DemoJavaScript();
  private final DemoWebChromeClient demoWebChromeClient = new DemoWebChromeClient();

  private WebView webView;

  /**
   * mandatory empty ctor
   */
  public JavaScriptFragment() {
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

    Button javaScriptButton = (Button) getActivity().findViewById(R.id.buttonJavaScript);
    javaScriptButton.setVisibility(View.VISIBLE);
    javaScriptButton.setOnClickListener(new View.OnClickListener() {

      /**
       * invoke javascript function
       * @param view
       */
      @Override
      public void onClick(View view) {
        webView.loadUrl("javascript:generateLog()");
      }
    });

    webView = (WebView) getActivity().findViewById(R.id.webView);
    webView.getSettings().setJavaScriptEnabled(true);
    webView.addJavascriptInterface(demoJavaScript, "demoJavaScript");
    webView.setWebChromeClient(demoWebChromeClient);
    webView.loadUrl("file:///android_asset/html/bridge.html");
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on April 25, 2014 by gsc
 */