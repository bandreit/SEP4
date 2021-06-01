package com.warehouse.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;

import com.warehouse.R;

public class LoadingDialog
{
   public FragmentActivity fragmentActivity;
     public AlertDialog dialog;
    public LoadingDialog(FragmentActivity myActivity)
    {
        fragmentActivity=myActivity;

    }
    public void startLoadingDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(fragmentActivity);
        LayoutInflater inflater = fragmentActivity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog,null));
        builder.setCancelable(true);
        dialog = builder.create();
        dialog.show();
    }
     void dismissDialog()
    {
        dialog.dismiss();
    }
}
