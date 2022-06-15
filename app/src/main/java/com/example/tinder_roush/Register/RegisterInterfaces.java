package com.example.tinder_roush.Register;

import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;

import java.util.ArrayList;
import java.util.List;

public interface RegisterInterfaces {

    interface fragment1 {
       void register1();
       void addItemsSpinnerCity(List<KeyPairBoolDataCustom> cities);
       void performSecondRegister();
    }

    interface fragment2 {

    }

    interface fragment3 {

    }

    interface models{
        void citiesModels(presenters presenter);
    }

    interface presenters{
        void register1Presenters(Register1Data register1Data);
        void citiesPresenter();
        void citiesSuccessful(ArrayList<CityData> cities);
        void citiesError(String message);
    //    void register2Presenters(Register2Data register2Data);
    }

}
