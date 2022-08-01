package com.example.tinder_roush.RecoveryPassword;

import android.widget.Toast;

import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

public class RecoveryPasswordPresenters implements RecoveryPasswordInterfaces.presenters{

    private RecoveryPasswordInterfaces.activities view;
    private RecoveryPasswordModels model;

    public RecoveryPasswordPresenters(RecoveryPasswordInterfaces.activities view) {
        this.view = view;
        this.model = new RecoveryPasswordModels();
    }
    @Override
    public void recoverPasswordPresenter(String username) {
        model.recoverPasswordModel(this, username);
    }

    @Override
    public void recoverPasswordSuccess(String message) {
        Toast.makeText(BaseContext.getContext(), "Nueva contraseña enviada", Toast.LENGTH_SHORT).show();
        view.performLogin();    }

    @Override
    public void recoverPasswordError(String message) {

    }
}
