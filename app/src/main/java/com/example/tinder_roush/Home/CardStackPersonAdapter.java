package com.example.tinder_roush.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CardStackPersonAdapter extends RecyclerView.Adapter<CardStackPersonAdapter.ViewHolder> {

    private List<HomeData> cardPersonItems;
    Calendar cal;

    public CardStackPersonAdapter(List<HomeData> cardPersonItems) {
        this.cardPersonItems = cardPersonItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        cal = Calendar.getInstance();
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
        TextView name_person, job, age_person;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_person = itemView.findViewById(R.id.card_image_person);
            name_person = itemView.findViewById(R.id.card_person_name);
            job = itemView.findViewById(R.id.card_person_job);
            age_person = itemView.findViewById(R.id.card_person_age);
        }

        public void setData(HomeData data) {
            Date current_date = cal.getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            Date birth_date = null;
//            try {
//               // birth_date = dateFormat.parse(data.getPerson().getDate_birth());
//                //age_person.setText(String.valueOf(getEdad(birth_date,current_date)));
////                Picasso.get().load(data.getImage()).fit().centerCrop().into(image_person);
////                name_person.setText(data.getPerson().getFirst_name());
////                job.setText(data.getPerson().getJob());
//
//            } catch (
//                    ParseException e) { e.printStackTrace();
//            }
            age_person.setText("26");
            Picasso.get().load(data.getPerson1_image()).fit().centerCrop().into(image_person);
            name_person.setText(data.getPerson1_name());
            job.setText("Pianista");
        }
    }

    public List<HomeData> getCardPersonItems() {
        return cardPersonItems;
    }

    public void setCardPersonItems(List<HomeData> cardPersonItems) {
        this.cardPersonItems = cardPersonItems;
    }

    public  int getEdad(Date birth_date, Date current_date) {
        DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        int dIni = Integer.parseInt(formatter.format(birth_date));
        int dEnd = Integer.parseInt(formatter.format(current_date));
        int age = (dEnd-dIni)/10000;
        return age;
    }
}
