package com.digiburo.example.wvdemo.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;

import com.digiburo.example.wvdemo.R;

/**
 * React to ActionBar tab events
 */
public class TabHelper implements ActionBar.TabListener {

  //
  private MainActivity mainActivity;

  //
  private ActionBar.Tab aboutTab;
  private ActionBar.Tab clientTab;
  private ActionBar.Tab javaScriptTab;
  private ActionBar.Tab simpleTab;

  //
  private AboutFragment aboutFragment;
  private ClientFragment clientFragment;
  private JavaScriptFragment javaScriptFragment;
  private SimpleFragment simpleFragment;

  public TabHelper(MainActivity activity) {
    mainActivity = activity;

    aboutFragment = (AboutFragment) Fragment.instantiate(mainActivity, AboutFragment.class.getName());
    clientFragment = (ClientFragment) Fragment.instantiate(mainActivity, ClientFragment.class.getName());
    javaScriptFragment = (JavaScriptFragment) Fragment.instantiate(mainActivity, JavaScriptFragment.class.getName());
    simpleFragment = (SimpleFragment) Fragment.instantiate(mainActivity, SimpleFragment.class.getName());
  }

  /**
   * ActionBar.TabListener
   * @param tab
   * @param fragmentTransaction
   */
  @Override
  public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    if (tab.getTag().equals(AboutFragment.FRAGMENT_TAG)) {
      fragmentTransaction.add(R.id.layoutFragment01, aboutFragment, AboutFragment.FRAGMENT_TAG);
    } else if (tab.getTag().equals(ClientFragment.FRAGMENT_TAG)) {
      fragmentTransaction.add(R.id.layoutFragment01, clientFragment, ClientFragment.FRAGMENT_TAG);
    } else if (tab.getTag().equals(JavaScriptFragment.FRAGMENT_TAG)) {
      fragmentTransaction.add(R.id.layoutFragment01, javaScriptFragment, JavaScriptFragment.FRAGMENT_TAG);
    } else if (tab.getTag().equals(SimpleFragment.FRAGMENT_TAG)) {
      fragmentTransaction.add(R.id.layoutFragment01, simpleFragment, SimpleFragment.FRAGMENT_TAG);
    } else {
      throw new IllegalArgumentException("unknown tab:" + tab.getTag());
    }
  }

  /**
   * ActionBar.TabListener
   * @param tab
   * @param fragmentTransaction
   */
  @Override
  public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    if (tab.getTag().equals(AboutFragment.FRAGMENT_TAG)) {
      fragmentTransaction.remove(aboutFragment);
    } else if (tab.getTag().equals(ClientFragment.FRAGMENT_TAG)) {
      fragmentTransaction.remove(clientFragment);
    } else if (tab.getTag().equals(JavaScriptFragment.FRAGMENT_TAG)) {
      fragmentTransaction.remove(javaScriptFragment);
    } else if (tab.getTag().equals(SimpleFragment.FRAGMENT_TAG)) {
      fragmentTransaction.remove(simpleFragment);
    } else {
      throw new IllegalArgumentException("unknown tab:" + tab.getTag());
    }
  }

  /**
   * ActionBar.TabListener
   * @param tab
   * @param fragmentTransaction
   */
  @Override
  public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    if (tab.getTag().equals(AboutFragment.FRAGMENT_TAG)) {
      //empty
    } else if (tab.getTag().equals(ClientFragment.FRAGMENT_TAG)) {
      //empty
    } else if (tab.getTag().equals(JavaScriptFragment.FRAGMENT_TAG)) {
      //empty
    } else if (tab.getTag().equals(SimpleFragment.FRAGMENT_TAG)) {
      //empty
    } else {
      throw new IllegalArgumentException("unknown tab:" + tab.getTag());
    }
  }

  /**
   * populate ActionBar
   */
  public void initialize() {
    FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();

    ActionBar actionBar = mainActivity.getSupportActionBar();

    aboutTab = actionBar.newTab();
    clientTab = actionBar.newTab();
    javaScriptTab = actionBar.newTab();
    simpleTab = actionBar.newTab();

    aboutTab.setTabListener(this);
    clientTab.setTabListener(this);
    javaScriptTab.setTabListener(this);
    simpleTab.setTabListener(this);

    aboutTab.setTag(AboutFragment.FRAGMENT_TAG);
    clientTab.setTag(ClientFragment.FRAGMENT_TAG);
    javaScriptTab.setTag(JavaScriptFragment.FRAGMENT_TAG);
    simpleTab.setTag(SimpleFragment.FRAGMENT_TAG);

    aboutTab.setText(R.string.action_bar_tab_about);
    clientTab.setText(R.string.action_bar_tab_client);
    javaScriptTab.setText(R.string.action_bar_tab_javascript);
    simpleTab.setText(R.string.action_bar_tab_simple);

    actionBar.addTab(aboutTab);
    actionBar.addTab(clientTab);
    actionBar.addTab(javaScriptTab);
    actionBar.addTab(simpleTab);
  }
}

/*
 * Copyright 2014 Digital Burro, INC
 * Created on April 25, 2014 by gsc
 */
