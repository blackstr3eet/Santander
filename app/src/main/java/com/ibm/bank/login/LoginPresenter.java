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

    public WeakReference<LoginActivityInput> activityInput;

    @Override
    public void presentLoginDataStorage(Credentials credentials) {
        activityInput.get().displayLoginData(credentials);
    }

    @Override
    public void loginResponseBody(LoginResponse response) {
        List<String> values = new ArrayList();

        values.add(response.getName());
        values.add(response.getAgency());
        values.add(response.getAccount());
        values.add(response.getBalance());

        activityInput.get().loginDataResponse(values);
    }
}