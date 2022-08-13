package com.example.tinder_roush.Home;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.HomeData;
import com.example.tinder_roush.OtherProfile.OtherProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CardStackPersonAdapter extends RecyclerView.Adapter<CardStackPersonAdapter.ViewHolder> {

    private List<HomeData> cardPersonItems;
    LocalData localData;
    Calendar cal;

    public CardStackPersonAdapter(List<HomeData> cardPersonItems) {
        this.cardPersonItems = cardPersonItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        cal = Calendar.getInstance();
        localData = new LocalData();
        View view = inflater.inflate(R.layout.card_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String per1=cardPersonItems.get(position).getPerson1();
        String per2= cardPersonItems.get(position).getPerson2();
        String id = cardPersonItems.get(position).getId();
        localData.register(id, "ID_MATCH");
        localData.register(per1, "PERSON1");
        localData.register(per2, "PERSON2");
        holder.setData(cardPersonItems.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOtherProfile();
            }
        });
    }

    public void performOtherProfile(){
        Intent intent = new Intent(BaseContext.getContext(), OtherProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        BaseContext.getContext().startActivity(intent);
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

            if (data.getPerson1().equals(localData.getRegister("ID_USERCURRENT"))){
                try {
                    birth_date = dateFormat.parse(data.getPerson2_date_birth());
                    age_person.setText(String.valueOf(getEdad(birth_date,current_date)));
                    Picasso.get().load(data.getPerson2_image()).fit().centerCrop().into(image_person);
                    name_person.setText(data.getPerson2_name());
                    job.setText(data.getPerson2_job());
                } catch (ParseException e) { e.printStackTrace(); }
            }else{
                try {
                    birth_date = dateFormat.parse(data.getPerson1_date_birth());
                    age_person.setText(String.valueOf(getEdad(birth_date,current_date)));
                    Picasso.get().load(data.getPerson1_image()).fit().centerCrop().into(image_person);
                    name_person.setText(data.getPerson1_name());
                    job.setText(data.getPerson1_job());
                } catch (ParseException e) { e.printStackTrace(); }
            }
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
