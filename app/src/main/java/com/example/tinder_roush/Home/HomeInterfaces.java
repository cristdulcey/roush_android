package com.example.tinder_roush.Home;

import android.view.View;

import com.example.tinder_roush.Objects.CityData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Objects.ProfileData;

import java.util.ArrayList;

public interface HomeInterfaces {

    interface fragment{
       void addList(ArrayList<HomeData> person);
       void getUser(ProfileData data);
       void getUserPhoto(String person);
       void performMatchSuccess();
       void filters(View view, ProfileData data);
   //    void addItemsSpinnerCity(List<KeyPairBoolDataCustom> cities);
    }

    interface presenters{
        void citiesPresenter();
        void citiesSuccessful(ArrayList<CityData> cities);
        //Get match and photos
        void getUserPreferencesFilter(View view);
        void HomeFilterSuccessful(View view,ProfileData data);
        void HomePhotoUser();
        void getPhotoProfileSuccess(String data);

        void HomePresenterPostMatch();
        void HomePresenterSuccess(ArrayList<HomeData> person);

        //Get response match
        void HomeResponseMatchTrue();
        void HomeResponseMatchFalse();
        void HomeBackResponseMatchSuccess();
        void HomePersonCurrent();
        void HomePersonCurrentSuccess(ProfileData data);

        void HomeError(String message);
    }

    interface models{
        void citiesModels(HomeInterfaces.presenters presenter);
        void HomeFilterUserPreferences(View view,presenters presenter);
        //Get match and photos
        void HomeModelPostMatch(presenters presenter);

        //Get response match
        void HomeModelResponseMatchTrue(presenters presenter);
        void HomeModelResponseMatchFalse(presenters presenter);
        void HomeModelPersonCurrent(presenters presenter);

        void getUserCurrentPhoto(presenters presenter);
    }

}
