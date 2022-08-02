package com.example.tinder_roush.Likes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.R;

import java.util.ArrayList;

public class LikesAdapter extends RecyclerView.Adapter<LikesAdapter.ViewHolder>{
    private ArrayList<HomeData> listLikes;
    Context context;
    LikesPresenters presenter;
    LocalData localData;

    public LikesAdapter(Context context, ArrayList<HomeData> listLikes) {
        this.context = context;
        this.listLikes = listLikes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLikes = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_like_list,null, false);
        initObjets();
        return new ViewHolder(itemLikes);
    }

    public void initObjets(){
        presenter = new LikesPresenters(new LikesActivity());
        localData = new LocalData();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        String url = localData.getRegister("IMAGE_LIKE");
//        if (!localData.getRegister("ID_USERCURRENT").equals("PERSON2")){
//            Picasso.get().load(url).into(holder.image_person);
            holder.person_name.setText(listLikes.get(position).getPerson2_name());
//        }else {
//            Picasso.get().load(url).into(holder.image_person);
//            holder.person_name.setText(listLikes.get(position).getPerson1_name());
//        }
    }

    @Override
    public int getItemCount() {
        return listLikes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_person;
        private TextView person_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            person_name = itemView.findViewById(R.id.text2_like);
            image_person = itemView.findViewById(R.id.like_person_image);
        }
    }
}
