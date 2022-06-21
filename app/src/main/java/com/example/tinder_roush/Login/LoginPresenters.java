package com.example.tinder_roush.Login;

import android.util.Log;
import android.widget.Toast;

import com.example.tinder_roush.Objects.LoginData;
import com.example.tinder_roush.Utils.BaseContext;

public class LoginPresenters implements LoginInterfaces.presenters{

    private LoginInterfaces.activities view;
    private LoginModels model;

    public LoginPresenters(LoginInterfaces.activities view) {
        this.view = view;
        this.model = new LoginModels();
    }

    @Override
    public void loginPresenter(LoginData data) {
        model.loginModel(this, data);
    }

    @Override
    public void loginSuccessful() {
        view.performLoginHome();
    }

    @Override
    public void loginError(String message) {
        Log.e("Error Login", message);
        Toast.makeText(BaseContext.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void verifyTokenPresenter() {
        model.verifyTokenModel(this);
    }

    @Override
    public void verifyTokenSuccessful() {
        view.performLoginHome();
    }

    @Override
    public void verifyTokenError() {
        Toast.makeText(BaseContext.getContext(), "Iniciar sesión", Toast.LENGTH_SHORT).show();
    }
}
