package com.digiburo.example.wvdemo.app;

import android.util.Log;
import android.webkit.JavascriptInterface;

import java.util.Random;

/**
 * Android/JavasScript bridge
 * @author gsc
 */
public class DemoJavaScript {

  //
  private final String LOG_TAG = getClass().getName();

  //
  private final PrimeNumber primeNumber = new PrimeNumber();

  //
  private final Random random = new Random();

  @JavascriptInterface
  public void simpleLogEntry(String arg) {
    Log.i(LOG_TAG, arg);
  }

  @JavascriptInterface
  public String simpleString() {
    return("simpleString");
  }

  /**
   * must return as JSON because arrays are not supported
   * @param limit
   * @return JSON array
   */
  @JavascriptInterface
  public String generatePrimes(int limit) {
    Log.d(LOG_TAG, "generatePrimes:" + limit);

    String candidates = "";
    boolean[] result = primeNumber.sieveOfEratosthenes(limit);
    for (int ii = 0; ii < result.length; ii++) {
      if (result[ii]) {
        if (candidates.isEmpty()) {
          candidates = Integer.toString(ii);
        } else {
          candidates += ("," + Integer.toString(ii));
        }
      }
    }

    return("{primeNumbers:[" + candidates + "]}");
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on April 25, 2014 by gsc
 */