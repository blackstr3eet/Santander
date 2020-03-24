package com.ibm.bank.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import com.google.android.material.textfield.TextInputEditText;
import com.ibm.bank.network.Credentials;
import com.ibm.bank.R;
import java.util.List;

interface LoginActivityInput {
    void displayLoginData(Credentials credentials);
    void loginDataResponse(List<String> values);
}

public class LoginActivity extends AppCompatActivity implements LoginActivityInput {

    protected TextInputEditText user;
    protected TextInputEditText password;
    protected ProgressBar progressBar;
    protected Button login;

    LoginInteractorInput interactor;
    LoginRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginConfigurator.INSTANCE.configure(this);

        bindViews();
        bindOnClick();
        interactor.loadingLoginData(this);
    }

    @Override
    public void displayLoginData(Credentials credentials) {
        LoginViewModel viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        viewModel.data.observe(this, values -> {
            user.setText(values.getUser());
            password.setText(values.getPassword());
        });

        viewModel.getInternalStorageData(credentials);
    }

    @Override
    public void loginDataResponse(List<String> values) {
        router.callNextScreen(values);
    }

    private void bindViews() {
        user = findViewById(R.id.editTextUser);
        password = findViewById(R.id.editTextPassword);
        progressBar = findViewById(R.id.progressBar);
        login = findViewById(R.id.buttonLogin);
    }

    private void bindOnClick() {
        login.setOnClickListener(router);
    }
}