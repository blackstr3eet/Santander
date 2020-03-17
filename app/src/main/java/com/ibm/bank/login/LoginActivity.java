package com.ibm.bank.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ibm.bank.R;

interface LoginActivityInput {
    void displayLoginData(LoginViewModel viewModel);
}

public class LoginActivity extends AppCompatActivity implements LoginActivityInput {

    LoginInteractorInput output;
    LoginRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        bindViews();

        LoginConfigurator.INSTANCE.configure(this);
        LoginRequest loginRequest = new LoginRequest();

        output.fetchLoginData(loginRequest);
    }

    @Override
    public void displayLoginData(LoginViewModel viewModel) {

    }
}