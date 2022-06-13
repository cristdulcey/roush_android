package com.example.tinder_roush.Likes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.Objects.LikesData;
import com.example.tinder_roush.R;

import java.util.ArrayList;

public class LikesAdapter extends RecyclerView.Adapter<LikesAdapter.ViewHolder> {

    private ArrayList<LikesData> listLikes;
    Context context;

    public LikesAdapter(Context context, ArrayList<LikesData> listLikes) {
        this.context = context;
        this.listLikes = listLikes;
    }
//    public LikesAdapter (ArrayList<LikesData> listLikes) {
//        this.listLikes = listLikes;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLikes = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_like_list,null, false);
        return new ViewHolder(itemLikes);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = listLikes.get(position).getTextname();
        holder.person_name.setText(name);
        holder.liketo.setText("te dio me gusta");
    }

    @Override
    public int getItemCount() {
        return listLikes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView person_name, liketo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            liketo = itemView.findViewById(R.id.text1_like);
            person_name = itemView.findViewById(R.id.text2_like);
        }
    }
}
