package com.ibm.bank.network;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class API {

    private API() {
    }

    private Retrofit configuration(){
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://bank-app-test.herokuapp.com/api/");
        builder.addConverterFactory(JacksonConverterFactory.create());
        return builder.build();
    }

    public static Endpoint getInstanceService(){
        return new API().configuration().create(Endpoint.class);
    }
}