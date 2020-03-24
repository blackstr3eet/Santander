package com.ibm.bank.login;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.ibm.bank.network.Credentials;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<Credentials> data = new MutableLiveData();

    public void getInternalStorageData(Credentials credentials) {
        data.setValue(credentials);
    }
}