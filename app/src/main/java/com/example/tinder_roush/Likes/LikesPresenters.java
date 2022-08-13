package com.example.tinder_roush.Likes;

import android.util.Log;
import android.widget.Toast;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;

public class LikesPresenters implements LikesInterfaces.presenters{

    private LikesInterfaces.fragment view;
    private LikesModels model;
    private LikesAdapter adapter;
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

    @Override
    public void getAllLikesPresenter() {
        model.getAllLikesModel(this);
    }

    @Override
    public void getAllLikesRePresenter() {
        model.getAllLikesReModel(this);
    }

    //Likes
    @Override
    public void getLikesPresenter(ArrayList<HomeData> data) {
        ArrayList<HomeData> aux = new ArrayList<>();
        for (int i =0; i <data.size(); i++){
            if (!localData.getRegister("ID_USERCURRENT").equals(data.get(i).getPerson1())){
                try {
                    if (data.get(i).isResponse_person2() == true){
                        aux.add(data.get(i));
                    }
                }catch (Exception exception){
                    Log.e("Error", exception.toString());
                }
            }else if (localData.getRegister("ID_USERCURRENT").equals(data.get(i).getPerson1())){
                try {
                    if (data.get(i).isResponse_person1() == true){
                        aux.add(data.get(i));
                    }
                }catch (Exception exception){
                    Log.e("Error", exception.toString());
                }
            }
        }
        view.recyclerLikes(aux);
    }

    @Override
    public void getLikesReceivedPresenter(ArrayList<HomeData> data) {
        ArrayList<HomeData> aux = new ArrayList<>();
        for (int i =0; i <data.size(); i++){
            if (!localData.getRegister("ID_USERCURRENT").equals(data.get(i).getPerson2())){
                try {
                    if (data.get(i).isResponse_person2() == true){
                        aux.add(data.get(i));
                    }
                }catch (Exception exception){
                    Log.e("Error", exception.toString());
                }
            }else if (localData.getRegister("ID_USERCURRENT").equals(data.get(i).getPerson2())){
                try {
                    if (data.get(i).isResponse_person1() == true){
                        aux.add(data.get(i));
                    }
                }catch (Exception exception){
                    Log.e("Error", exception.toString());
                }
            }
        }view.recyclerLikesGiven(aux);
    }

    @Override
    public void getLikesError(String message) {
        Toast.makeText(BaseContext.getContext(),"No se pudo obtener", Toast.LENGTH_SHORT).show();
    }

}
