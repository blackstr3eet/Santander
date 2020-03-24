package com.ibm.bank.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.ibm.bank.network.Credentials;

public class Storage {

    private static final String KEY_SHARED_PREFERENCES = "credentials" ;

    public static Credentials retrieveDataWithSharedPreferences(Context context) {
        String user = getSharedPreferences(context).getString("user", "");
        String password = getSharedPreferences(context).getString("password", "");
        return new Credentials(user, password);
    }

    public static void saveDataWithSharedPreferences(Context context, Credentials credentials) {
        clearDataInSharedPreferences(context);

        getSharedPreferences(context).
                edit().
                putString("user", credentials.getUser()).
                putString("password", credentials.getPassword()).
                commit();
    }

    private static void clearDataInSharedPreferences(Context context) {
        getSharedPreferences(context).
                edit().
                clear();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(KEY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
    }
}