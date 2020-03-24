package com.ibm.bank.network;

import com.ibm.bank.domain.Statement;
import com.ibm.bank.domain.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Endpoint {

    @POST("login")
    Call<User> login(@Body Credentials credentials);

    @FormUrlEncoded
    @GET("statements/1")
    Call<Statement> details();
}