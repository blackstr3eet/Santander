package com.ibm.bank.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ibm.bank.R;
import com.ibm.bank.extract.ExtractActivity;

interface LoginActivityInput {
    void displayLoginData(LoginViewModel viewModel);
}

public class LoginActivity extends AppCompatActivity implements LoginActivityInput, View.OnClickListener {

    private Button btnLogin;

    LoginInteractorInput output;
    LoginRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();

        LoginConfigurator.INSTANCE.configure(this);
        LoginRequest loginRequest = new LoginRequest();

        output.fetchLoginData(loginRequest);
    }

    @Override
    public void displayLoginData(LoginViewModel viewModel) {

    }

    private void bindViews() {
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ExtractActivity.class);
        startActivity(intent);
    }
}