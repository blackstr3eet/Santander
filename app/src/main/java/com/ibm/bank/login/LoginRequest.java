package com.ibm.bank.login;

import android.util.Log;
import com.ibm.bank.network.API;
import com.ibm.bank.network.Credentials;
import com.ibm.bank.domain.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRequest {

    public static String TAG = LoginRequest.class.getSimpleName();

    public User body;

    public void login(Credentials credentials) {
        Call<User> user = API.getInstanceService().login(credentials);

        user.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    body = response.body();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "login request failure", t);
            }
        });
    }
}