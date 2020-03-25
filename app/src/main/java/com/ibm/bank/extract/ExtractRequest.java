package com.ibm.bank.extract;

import android.util.Log;
import com.ibm.bank.domain.Statement;
import com.ibm.bank.network.API;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExtractRequest {

    private static String TAG = ExtractRequest.class.getSimpleName();

    private Statement body;

    public void details() {
        Call<Statement> statement = API.getInstanceService().details();

        statement.enqueue(new Callback<Statement>() {
            @Override
            public void onResponse(Call<Statement> call, Response<Statement> response) {
                if(response.isSuccessful()) {
                    body = response.body();
                }
            }

            @Override
            public void onFailure(Call<Statement> call, Throwable t) {
                Log.e(TAG, "details request failure", t);
            }
        });
    }

    public Statement getBody() {
        return body;
    }
}