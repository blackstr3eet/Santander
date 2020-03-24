package com.ibm.bank.login;

import java.lang.ref.WeakReference;

public enum LoginConfigurator {
    INSTANCE;

    public void configure(LoginActivity activity) {

        LoginRouter router = new LoginRouter();
        router.activity = new WeakReference<>(activity);

        LoginPresenter presenter = new LoginPresenter();
        presenter.activityInput = new WeakReference<>(activity);

        LoginInteractor interactor = new LoginInteractor();
        interactor.presenterInput = presenter;

        if (activity.interactor == null) {
            activity.interactor = interactor;
        }

        if (activity.router == null) {
            activity.router = router;
        }
    }
}