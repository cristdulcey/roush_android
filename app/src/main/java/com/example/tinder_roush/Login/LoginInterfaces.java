package com.example.tinder_roush.Login;

import com.example.tinder_roush.Objects.LoginData;

public interface LoginInterfaces {

    interface activities{
        void performLoginHome();
    }
    interface presenters{
        void loginPresenter(LoginData data);
        void loginSuccessful();
        void loginError(String message);
        void verifyTokenPresenter();
        void verifyTokenSuccessful();
        void verifyTokenError();
    }
    interface models{
        void loginModel(presenters presenter, LoginData data);
        void verifyTokenModel(presenters presenter);
        void refreshTokenModel(presenters presenter);
    }
}
