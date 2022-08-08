package com.example.tinder_roush.Chats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder>{
    private ArrayList<ChatData> listChats;
    Context context;
    ChatsPresenters presenter;
    LocalData localData;
    DateFormat dateFormat;
    Calendar cal;

    public ChatsAdapter(Context context, ArrayList<ChatData> listLikes) {
        this.context = context;
        this.listChats = listLikes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLikes = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_list,null);
        initObjets();
        int height = parent.getMeasuredHeight();
        int width = parent.getMeasuredWidth();

        itemLikes.setLayoutParams(new RecyclerView.LayoutParams(width, height));

        return new ViewHolder(itemLikes);
    }

    public void initObjets(){
        presenter = new ChatsPresenters(new ChatsActivity());
        localData = new LocalData();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZZZZZ", Locale.getDefault());
        cal = Calendar.getInstance();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ChatsAdapter.ViewHolder holder, int position) {
        String created = listChats.get(position).getCreated_at();

        String url, name="";
        if (listChats.get(position).getMatch().getPerson1().equals(localData.getRegister("ID_USERCURRENT"))){
            url = listChats.get(position).getMatch().getPerson2_image();
            name = listChats.get(position).getMatch().getPerson2_name();
        }else {
            url = listChats.get(position).getMatch().getPerson1_image();
            name = listChats.get(position).getMatch().getPerson1_name();
        }
        Log.e("image chat user",url);
        Picasso.get().load(url).fit().centerCrop().into(holder.image_person);
        holder.person_name.setText(name);
        holder.person_message.setText("Test message");

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
        return listChats.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_person;
        private TextView person_name;
        private TextView person_message;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            person_name = itemView.findViewById(R.id.text1_like);
            person_message = itemView.findViewById(R.id.text2_like);
            image_person = itemView.findViewById(R.id.chat_person_image);
            time = itemView.findViewById(R.id.text_hour_like);
        }
    }
}
