package com.warehouse.ui.loading;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.warehouse.R;

public class LoadingDialog
{
    public FragmentActivity activity;
    public Fragment fragment;
    public AlertDialog dialog;

    public LoadingDialog(FragmentActivity myActivity)
    {
        activity = myActivity;

    }
    public void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.custom_dialog, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }
    public void dismissDialog(){
        dialog.dismiss();
    }
}
