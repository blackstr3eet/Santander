package com.ibm.bank.extract;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ibm.bank.domain.StatementList;

import java.util.List;

public class ExtractViewModel extends ViewModel {

    public MutableLiveData<List<StatementList>> data = new MutableLiveData();

    public void getStatementList(List<StatementList> statements) {
        data.setValue(statements);
    }
}