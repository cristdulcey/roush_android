package com.example.tinder_roush.Register;

import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Objects.Register2Data;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;

import java.util.ArrayList;
import java.util.List;

public class RegisterPresenters implements RegisterInterfaces.presenters{

    private RegisterInterfaces.fragment1 view;
    private RegisterInterfaces.fragment2 view2;
    private RegisterInterfaces.fragment3 view3;
    private RegisterInterfaces.fragment4 view4;
    private RegisterModels model;

    public RegisterPresenters(RegisterInterfaces.fragment1 view, RegisterInterfaces.fragment2 view2, RegisterInterfaces.fragment3 view3, RegisterInterfaces.fragment4 view4) {
        this.view = view;
        this.view2 = view2;
        this.view3 = view3;
        this.view4 = view4;
        this.model = new RegisterModels();
    }
    @Override
    public void register1Presenters(Register1Data register1Data) {
        model.register1Model(register1Data, this);
    }

    @Override
    public void register2Presenters(Register2Data register2Data) {
        model.register2Model(register2Data,this);
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

    @Override
    public void sendRegister2() {
        view.performSecondRegister();
    }

    @Override
    public void sendRegister3() {
        view2.performRegister3();
    }

    @Override
    public void onErrorPresenterRegister(String response_user) {

    }
}
