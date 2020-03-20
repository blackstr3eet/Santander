package com.ibm.bank.extract;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import java.lang.ref.WeakReference;

interface ExtractRouterInput {
    Intent navigateToSomeWhere(int position);

    void passDataToNextScene(int position, Intent intent);
}

public class ExtractRouter implements ExtractRouterInput, AdapterView.OnItemClickListener {

    public WeakReference<ExtractActivity> activity;

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public Intent navigateToSomeWhere(int position) {
        return null;
    }

    @Override
    public void passDataToNextScene(int position, Intent intent) {

    }
}