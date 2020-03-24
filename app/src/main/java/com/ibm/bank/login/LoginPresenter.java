package com.ibm.bank.login;

import com.ibm.bank.network.Credentials;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

interface LoginPresenterInput {
    void presentLoginDataStorage(Credentials credentials);
    void loginResponseBody(LoginResponse response);
}

public class LoginPresenter implements LoginPresenterInput {

    public WeakReference<LoginActivityInput> activity;

    @Override
    public void presentLoginDataStorage(Credentials credentials) {
        activity.get().displayLoginData(credentials);
    }

    @Override
    public void loginResponseBody(LoginResponse response) {
        List<String> values = new ArrayList();

        values.add(response.name);
        values.add(response.agency);
        values.add(response.account);
        values.add(response.balance);

        activity.get().loginDataResponse(values);
    }
}