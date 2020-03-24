package com.ibm.bank.login;

import android.content.Context;
import com.ibm.bank.util.Storage;

interface LoginInteractorInput {
    void loadingLoginData(Context context);
    void fetchLoginDataResponse(LoginRequest request);
}

public class LoginInteractor implements LoginInteractorInput {

    public LoginPresenterInput presenterInput;

    @Override
    public void loadingLoginData(Context context) {
        presenterInput.presentLoginDataStorage(Storage.retrieveDataWithSharedPreferences(context));
    }

    @Override
    public void fetchLoginDataResponse(LoginRequest request) {
        LoginResponse response = new LoginResponse();
        response.processBody(request);
        presenterInput.loginResponseBody(response);
    }
}