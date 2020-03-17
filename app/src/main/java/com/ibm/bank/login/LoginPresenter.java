package com.ibm.bank.login;

import java.lang.ref.WeakReference;

interface LoginPresenterInput {
    void presentLoginData(LoginResponse response);
}

public class LoginPresenter implements LoginPresenterInput {

    public WeakReference<LoginActivityInput> output;

    @Override
    public void presentLoginData(LoginResponse response) {

    }
}