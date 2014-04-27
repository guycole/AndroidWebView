package com.digiburo.example.wvdemo.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

import com.digiburo.example.wvdemo.R;

/**
 * Displayed by selecting "News" on the "Client" tab.
 * URL override detects selection and instead of HTTP GET displays local fragment
 */
public class NewsDialogFragment extends DialogFragment {

  public static final String FRAGMENT_TAG = "TAG_NEWS";

  private UrlInterceptListener urlInterceptListener;

  /**
   * mandatory empty ctor
   */
  public NewsDialogFragment() {
    //empty
  }

  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    urlInterceptListener = (UrlInterceptListener) activity;
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setIcon(android.R.drawable.ic_dialog_alert);
    builder.setCancelable(false);
    builder.setMessage(R.string.dialog_message);
    builder.setTitle(R.string.dialog_title);

    builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {

      @Override
      public void onClick(DialogInterface dialog, int which) {
        // empty
      }
    });

    Dialog dialog = builder.create();
    return(dialog);
  }
}
/*
 * Copyright 2014 Digital Burro, INC
 * Created on April 25, 2014 by gsc
 */