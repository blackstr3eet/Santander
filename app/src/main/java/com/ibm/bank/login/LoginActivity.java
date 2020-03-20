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
        bindOnClick();

        LoginConfigurator.INSTANCE.configure(this);

//        LoginRequest loginRequest = new LoginRequest();
//        output.fetchLoginData(loginRequest);
    }

    @Override
    public void displayLoginData(LoginViewModel viewModel) {
        // set values in activity
    }

    @Override
    public void onClick(View v) {
        if(validInputDataUser() && validInputDataPassword()) {
            Intent intent = new Intent(this, ExtractActivity.class);
            startActivity(intent);
        }
        else if(!validInputDataUser()) {
            // call error in field
        }
        else if(!validInputDataPassword()) {
            // call error in field
        }
    }

    private void bindViews() {
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void bindOnClick() {
        btnLogin.setOnClickListener(this);
    }

    private boolean validInputDataUser() {
        //
        return true;
    }

    private boolean validInputDataPassword() {
        //
        return true;
    }
}