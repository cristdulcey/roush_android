package com.example.tinder_roush.Likes;

import android.annotation.SuppressLint;
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
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LikesAdapter extends RecyclerView.Adapter<LikesAdapter.ViewHolder>{
    private ArrayList<HomeData> listLikes;
    Context context;
    LikesPresenters presenter;
    LocalData localData;
    DateFormat dateFormat;
    Calendar cal;

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
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZZZZZ", Locale.getDefault());
        cal = Calendar.getInstance();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String created = listLikes.get(position).getCreated_at();

        if (listLikes.get(position).isResponse_person1()!= null || listLikes.get(position).isResponse_person2()!=null) {
            String url = "";
            String name = "";
            if (listLikes.get(position).getPerson1().equals(localData.getRegister("ID_USERCURRENT")) && listLikes.get(position).isResponse_person1().equals("true")) {
                url = listLikes.get(position).getPerson2_image();
                name = listLikes.get(position).getPerson2_name();
                Picasso.get().load(url).fit().centerCrop().into(holder.image_person);
                holder.person_name.setText(name);
            } else if (!listLikes.get(position).getPerson1().equals(localData.getRegister("ID_USERCURRENT")) && listLikes.get(position).isResponse_person2().equals("true")) {
                url = listLikes.get(position).getPerson1_image();
                name = listLikes.get(position).getPerson1_name();
                Picasso.get().load(url).fit().centerCrop().into(holder.image_person);
                holder.person_name.setText(name);
            }
        }

        Date current_date = cal.getTime();

            try {
                Date final_date = dateFormat.parse(created);
                long difDates = (current_date.getTime()-final_date.getTime());
                int min = (int) (difDates/60000);
                int hr = min/60;
                int d = hr/24;

                if (min < 60) { holder.time.setText(min+"min");
                }else if(min>60 && min<1440){ holder.time.setText(hr+"h");
                }else if(min>1440){ holder.time.setText(d+"d"); }

            }
            catch (ParseException e) { e.printStackTrace(); }
    }

    @Override
    public int getItemCount() {
        return listLikes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_person;
        private TextView person_name;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            person_name = itemView.findViewById(R.id.text2_like);
            image_person = itemView.findViewById(R.id.like_person_image);
            time = itemView.findViewById(R.id.text_hour_like);
        }
    }
}
