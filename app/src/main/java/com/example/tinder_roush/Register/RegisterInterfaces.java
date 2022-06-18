package com.example.tinder_roush.Register;

import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Objects.Register2Data;
import com.example.tinder_roush.Objects.Register3Data;
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

    }

    interface models{
        void citiesModels(presenters presenter);
        void register1Model(Register1Data register1Data, RegisterInterfaces.presenters presenters);
        void register2Model(Register2Data register2Data, RegisterInterfaces.presenters presenters);
        void register3Model(Register3Data register3Data, RegisterInterfaces.presenters presenters);
    }

    interface presenters{
        void register1Presenters(Register1Data register1Data);
        void register2Presenters(Register2Data register2Data);
        void register3Presenters(Register3Data register3Data);
        void citiesPresenter();
        void citiesSuccessful(ArrayList<CityData> cities);
        void citiesError(String message);
        void sendRegister2();
        void sendRegister3();

        void onErrorPresenterRegister(String response_user);
        //    void register2Presenters(Register2Data register2Data);
    }

}
