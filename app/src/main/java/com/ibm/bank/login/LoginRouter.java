package com.ibm.bank.login;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import java.lang.ref.WeakReference;

interface LoginRouterInput {
    Intent navigateToSomeWhere(int position);

    void passDataToNextScene(int position, Intent intent);
}

public class LoginRouter implements LoginRouterInput, AdapterView.OnItemClickListener {

    public WeakReference<LoginActivity> activity;

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