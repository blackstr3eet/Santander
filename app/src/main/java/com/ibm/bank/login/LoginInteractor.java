package com.ibm.bank.login;

interface LoginInteractorInput {
    void fetchLoginData(LoginRequest request);
}

public class LoginInteractor implements LoginInteractorInput {

    public LoginPresenterInput output;

    @Override
    public void fetchLoginData(LoginRequest request) {

    }
}