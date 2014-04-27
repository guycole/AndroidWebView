package com.digiburo.example.wvdemo.app;

//import android.os.Debug;
import android.util.Log;

/**
 * PrimeNumber number support
 *
 * @author gsc
 */
public class PrimeNumber {

  //
  private final String LOG_TAG = getClass().getName();

  /**
   * Keep the CPU busy by discovering prime numbers.
   * 
   * @param limit population of prime numbers to discover
   * @return array of boolean up to limit size, true elements are prime
   */
  public boolean[] sieveOfEratosthenes(int limit) {
    Log.d(LOG_TAG, "prime sieve");
    
    //Debug.startMethodTracing("prime");
    
    boolean[] candidates = new boolean[limit];
    
    candidates[0] = false;
    candidates[1] = false;
    for (int ii = 2; ii < limit; ii++) {
      candidates[ii] = true;
    }
    
    for (int ii = 0; ii < limit; ii++) {
      if (candidates[ii]) {
        for (int jj = ii+1; jj < limit; jj++) {
          if ((jj % ii) == 0) {
            candidates[jj] = false;
          }
        }
      }
    }
    
    //Debug.stopMethodTracing();
    
    return(candidates);
  }
}

/*
 * Copyright 2010 Digital Burro, INC
 * Created on May 7, 2010 by gsc
 */