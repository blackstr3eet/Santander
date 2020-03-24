package com.ibm.bank.extract;

import java.lang.ref.WeakReference;

interface ExtractPresenterInput {
    void presentExtractData(ExtractResponse response);
}

public class ExtractPresenter implements ExtractPresenterInput {

    public WeakReference<ExtractActivityInput> activityInput;

    @Override
    public void presentExtractData(ExtractResponse response) {

    }
}