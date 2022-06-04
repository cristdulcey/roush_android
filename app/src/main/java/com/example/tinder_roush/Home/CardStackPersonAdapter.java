package com.example.tinder_roush.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardStackPersonAdapter extends RecyclerView.Adapter<CardStackPersonAdapter.ViewHolder> {

    private List<CardPersonItem> cardPersonItems;

    public CardStackPersonAdapter(List<CardPersonItem> addList) {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(cardPersonItems.get(position));
    }

    @Override
    public int getItemCount() {
        return cardPersonItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_person;
        TextView name_person, age_person;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_person = itemView.findViewById(R.id.card_image_person);
            name_person = itemView.findViewById(R.id.card_person_name);
            age_person = itemView.findViewById(R.id.card_person_age);
        }

        public void setData(CardPersonItem data) {
            Picasso.get().load(data.getImage()).fit().centerCrop().into(image_person);
            name_person.setText(data.getName());
            age_person.setText(data.getAge());
        }
    }
}
