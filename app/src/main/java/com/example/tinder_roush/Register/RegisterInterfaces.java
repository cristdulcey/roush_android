package com.example.tinder_roush.Register;

import com.example.tinder_roush.Login.LoginInterfaces;
import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.LoginData;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Objects.Register2Data;
import com.example.tinder_roush.Objects.Register3Data;
import com.example.tinder_roush.Objects.Register4Data;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;

import java.util.ArrayList;
import java.util.List;

public interface RegisterInterfaces {

    interface fragment1 {
       void addItemsSpinnerCity(List<KeyPairBoolDataCustom> cities);
       void performSecondRegister();
       void register1();
    }

    interface fragment2 {
        void performRegister3();
        void register2();
    }

    interface fragment3 {
        void performRegisterFinal();
        void register3();
    }
    interface fragment4 {
        void register4();
        void performSuccessRegister();
    }

    interface models{
        void citiesModels(presenters presenter);
        void register1Model(Register1Data register1Data, RegisterInterfaces.presenters presenters);
        void register2Model(Register2Data register2Data, RegisterInterfaces.presenters presenters);
        void register3Model(Register3Data register3Data, RegisterInterfaces.presenters presenters);
        void register4Model(Register4Data register4Data, RegisterInterfaces.presenters presenters);
        void loginModel(RegisterInterfaces.presenters presenter, Register1Data data);
        void verifyTokenModel(RegisterInterfaces.presenters presenter);
    }

    interface presenters{
        void register1Presenters(Register1Data register1Data);
        void register2Presenters(Register2Data register2Data);
        void register3Presenters(Register3Data register3Data);
        void register4Presenters(Register4Data register4Data);
        void citiesPresenter();
        void citiesSuccessful(ArrayList<CityData> cities);
        void citiesError(String message);
        void sendRegister2();
        void loginPresenter(Register1Data data);
        void loginSuccessful();
        void loginError(String message);
        void sendRegisterFinal();
        void registerSuccesful();
        void registerError(String response_user);
        void onErrorPresenterRegister(String response_user);
    }

}
