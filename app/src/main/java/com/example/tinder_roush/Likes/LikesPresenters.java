package com.example.tinder_roush.Likes;

import android.widget.Toast;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class LikesPresenters implements LikesInterfaces.presenters{

    private LikesInterfaces.fragment view;
    private LikesModels model;
    LocalData localData = new LocalData();

    public LikesPresenters(LikesInterfaces.fragment view) {
        this.view = view;
        this.model = new LikesModels();
    }

    //Photo
    @Override
    public void getPhotoProfile() {
        model.getUserCurrentPhoto(this);
    }

    @Override
    public void getPhotoProfileSuccess(String data) {
        view.showPhotoProfile(data);
    }

    //Likes
    @Override
    public void getAllLikesRePresenter() {
        model.getAllLikesReModel(this);
    }

    @Override
    public void getLikesPresenter(ArrayList<HomeData> data) {
        ArrayList<HomeData> aux = new ArrayList<>();
        for (int i =0; i <data.size(); i++){
            if (data.get(i).getPerson1().equals(localData.getRegister("ID_USERCURRENT")) && data.get(i).isResponse_person1().equals("true")
                ){
                aux.add(data.get(i));
            }
        }
        view.recyclerLikes(data);
    }

    public void getLikesReceivedPresenter(ArrayList<HomeData> data) {
        view.recyclerLikesGiven(data);
    }

    @Override
    public void getLikesError(String message) {
        Toast.makeText(BaseContext.getContext(),"No se pudo obtener", Toast.LENGTH_SHORT).show();
    }

}
