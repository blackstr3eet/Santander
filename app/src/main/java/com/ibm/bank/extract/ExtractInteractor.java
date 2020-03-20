package com.ibm.bank.extract;

interface ExtractInteractorInput {
    void fetchExtractData(ExtractRequest request);
}

public class ExtractInteractor implements ExtractInteractorInput {

    public ExtractPresenterInput output;

    @Override
    public void fetchExtractData(ExtractRequest request) {

    }
}