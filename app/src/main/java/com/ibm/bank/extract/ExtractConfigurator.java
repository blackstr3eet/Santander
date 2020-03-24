package com.ibm.bank.extract;

import java.lang.ref.WeakReference;

public enum ExtractConfigurator {
    INSTANCE;

    public void configure(ExtractActivity activity) {

        ExtractRouter router = new ExtractRouter();
        router.activity = new WeakReference<>(activity);

        ExtractPresenter presenter = new ExtractPresenter();
        presenter.activityInput = new WeakReference<>(activity);

        ExtractInteractor interactor = new ExtractInteractor();
        interactor.presenterInput = presenter;

        if (activity.output == null) {
            activity.output = interactor;
        }
        if (activity.router == null) {
            activity.router = router;
        }
    }
}