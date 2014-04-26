package com.digiburo.example.wvdemo.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.digiburo.example.wvdemo.R;

public class MainActivity extends ActionBarActivity implements SwitchFragmentListener {

  private TabHelper tabHelper;

  @Override
  public void onUrlIntercept() {
    FragmentManager fragmentManager = getSupportFragmentManager();
    Fragment oldFragment = fragmentManager.findFragmentByTag(FreshFragment.FRAGMENT_TAG);

    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    if (oldFragment != null) {
      fragmentTransaction.remove(oldFragment);
    }

    fragmentTransaction.replace(R.id.layoutFragment01, new FreshFragment(), FreshFragment.FRAGMENT_TAG);
    fragmentTransaction.commit();
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

