package com.ibm.bank.extract;

import java.lang.ref.WeakReference;

public enum ExtractConfigurator {
    INSTANCE;

    public void configure(ExtractActivity activity) {

        ExtractPresenter presenter = new ExtractPresenter();
        presenter.activityInput = new WeakReference<>(activity);

        ExtractInteractor interactor = new ExtractInteractor();
        interactor.presenterInput = presenter;

        if (activity.interactorInput == null) {
            activity.interactorInput = interactor;
        }
    }
}