package com.example.tinder_roush.RecoveryPassword;

public interface RecoveryPasswordInterfaces {

    interface activities{
        void performLogin();
    }
    interface presenters{
        void recoverPasswordPresenter(String username);
        void recoverPasswordSuccess(String message);
        void recoverPasswordError(String message);
    }
    interface models{
        void recoverPasswordModel(presenters presenter, String username);
    }

}
