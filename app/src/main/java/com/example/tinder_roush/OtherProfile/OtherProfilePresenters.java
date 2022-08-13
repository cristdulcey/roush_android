package com.example.tinder_roush.OtherProfile;

import android.widget.Toast;

import com.example.tinder_roush.Home.CardPersonItem;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class OtherProfilePresenters implements OtherProfileInterfaces.presenters{

    private OtherProfileInterfaces.activities view;

    private OtherProfileModels model;

    public OtherProfilePresenters(OtherProfileInterfaces.activities view) {
        this.view = view;
        this.model = new OtherProfileModels();
    }
    @Override
    public void getOtherInformation() {
        model.getOtherInformationModel(this);
    }

    @Override
    public void getOtherInformationSuccess(ArrayList<CardPersonItem> data) {
        view.showOtherData(data);
    }

    @Override
    public void getOtherInformationError(String message) {
        Toast.makeText(BaseContext.getContext(),"No se pudo obtener", Toast.LENGTH_SHORT).show();
    }
}
