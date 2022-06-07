package com.example.tinder_roush.Likes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.R;

import java.util.ArrayList;

public class LikesAdapter extends RecyclerView.Adapter<LikesAdapter.ViewHolder> {

    private ArrayList<LikesData> listLikes;

    public LikesAdapter(Context context, ArrayList<LikesData> listLikes) {
        this.listLikes = listLikes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_like_list,null, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.person_name.setText("Una persona");

    }

    @Override
    public int getItemCount() {
        return 15;
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
