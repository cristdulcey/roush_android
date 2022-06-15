package com.example.tinder_roush.Register;

import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;

import java.util.ArrayList;
import java.util.List;

public class RegisterPresenters implements RegisterInterfaces.presenters{

    private RegisterInterfaces.fragment1 view;
    private RegisterModels model;

    public RegisterPresenters(RegisterInterfaces.fragment1 view) {
        this.view = view;
        this.model = new RegisterModels();
    }
    @Override
    public void register1Presenters(Register1Data register1Data) {

    }

    @Override
    public void citiesPresenter() {
        model.citiesModels(this);
    }

    @Override
    public void citiesSuccessful(ArrayList<CityData> cities) {
        List<KeyPairBoolDataCustom> listArray0 = new ArrayList<>();
        for (int i = 0; i < cities.size(); i++) {
            CityData originsList = cities.get(i);
            KeyPairBoolDataCustom h = new KeyPairBoolDataCustom();
            h.setId(originsList.getId());
            h.setExtra("lo que sea");
            h.setName(originsList.getName());
            h.setSelected(false);
            listArray0.add(h);
        }
        view.addItemsSpinnerCity(listArray0);
    }

    @Override
    public void citiesError(String message) {

    }
}
