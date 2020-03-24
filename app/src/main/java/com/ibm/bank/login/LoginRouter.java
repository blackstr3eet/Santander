package com.ibm.bank.login;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import com.ibm.bank.network.Credentials;
import com.ibm.bank.R;
import com.ibm.bank.extract.ExtractActivity;
import com.ibm.bank.util.Validation;
import java.lang.ref.WeakReference;
import java.util.List;

interface LoginRouterInput {
    void callNextScreen(List<String> putExtrasIntent);
}

public class LoginRouter implements LoginRouterInput, View.OnClickListener {

    public static final String KEY_BUNDLE_NAME = "name";
    public static final String KEY_BUNDLE_AGENCY = "agency";
    public static final String KEY_BUNDLE_ACCOUNT = "account";
    public static final String KEY_BUNDLE_BALANCE = "balance";

    public WeakReference<LoginActivity> activity;

    @Override
    public void callNextScreen(List<String> putExtrasIntent) {
        Intent intent = createIntentForNextScreen().
                putExtra(KEY_BUNDLE_NAME, putExtrasIntent.get(0)).
                putExtra(KEY_BUNDLE_AGENCY, putExtrasIntent.get(1)).
                putExtra(KEY_BUNDLE_ACCOUNT, putExtrasIntent.get(2)).
                putExtra(KEY_BUNDLE_BALANCE, putExtrasIntent.get(3));

        activity.get().startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        // realize validation on fields login
        String user = activity.get().user.getText().toString();
        String password = activity.get().password.getText().toString();

        if(checkFields(user, password)) {
            LoginRequest request = new LoginRequest();
            request.login(new Credentials(user, password));

            changeStatusLoading(true);

            // delay for wait response of request
            Handler handler = new Handler();
            handler.postDelayed( () -> {
                activity.get().interactorInput.fetchLoginDataResponse(request);
                changeStatusLoading(false);
            }, 5000);
        }
    }

    private Intent createIntentForNextScreen() {
        Intent intent = new Intent(activity.get(), ExtractActivity.class);
        return intent;
    }

    private void changeStatusLoading(boolean loading) {
        if(loading) {
            activity.get().progressBar.setVisibility(View.VISIBLE);
            activity.get().login.setEnabled(false);
            activity.get().login.setBackgroundColor(activity.get().getResources().getColor(R.color.colorPrimaryDark));
        }
        else {
            activity.get().progressBar.setVisibility(View.INVISIBLE);
            activity.get().login.setEnabled(true);
            activity.get().login.setBackgroundColor(activity.get().getResources().getColor(R.color.colorBlue));
        }
    }

    private boolean checkFields(String user, String password) {

        if(user.trim().isEmpty() && password.trim().isEmpty()) {
            showMessageError("usuário e senha não preenchidos");
            return false;
        }

        if(user.trim().isEmpty()) {
            showMessageError("campo usuário não preenchido");
            return false;
        }

        if(password.trim().isEmpty()) {
            showMessageError("campo senha não preenchida");
            return false;
        }

        if(!Validation.checkUserLogin(user.trim())) {
            showMessageError("cpf ou e-mail inserido não é válido");
            return false;
        }

        if(!Validation.checkPasswordLogin(password.trim())) {
            showMessageError("a senha não atende aos requisitos mínimos");
            return false;
        }

        return true;
    }

    private void showMessageError(String message) {
        Toast.makeText(activity.get(), message, Toast.LENGTH_LONG).show();
    }
}