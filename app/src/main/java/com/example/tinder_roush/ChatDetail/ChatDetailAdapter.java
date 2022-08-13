package com.example.tinder_roush.ChatDetail;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.Likes.LikesActivity;
import com.example.tinder_roush.Likes.LikesPresenters;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.Objects.ChatDetailData;
import com.example.tinder_roush.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class ChatDetailAdapter extends RecyclerView.Adapter<ChatDetailAdapter.ViewHolder>{
    private ArrayList<ChatDetailData> listChats;
    Context context;
    LikesPresenters presenter;
    LocalData localData;
    DateFormat dateFormat;
    Calendar cal;

    private static final int TYPE_ONE = 1;
    private static final int TYPE_TWO = 2;


    public ChatDetailAdapter(Context context, ArrayList<ChatDetailData> listLikes) {
        this.context = context;
        this.listChats = listLikes;
        this.localData = new LocalData();
    }

    @Override
    public int getItemViewType(int position) {
        ChatDetailData item = listChats.get(position);
        if (item.getPerson().equals(localData.getRegister("ID_USERCURRENT"))) {
            return TYPE_ONE;
        } else {
            return TYPE_TWO;
        }
    }

    @NonNull
    @Override
    public ChatDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ONE) {
            View itemLikes = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_detail,null, false);
            initObjets();
            return new ChatDetailAdapter.ViewHolder(itemLikes);
        } else {
            View itemLikes = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_detail_left,null, false);
            initObjets();
            return new ChatDetailAdapter.ViewHolder(itemLikes);
        }

    }

    public void initObjets(){
        presenter = new LikesPresenters(new LikesActivity());
        localData = new LocalData();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSZZZZZ", Locale.getDefault());
        cal = Calendar.getInstance();
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ChatDetailAdapter.ViewHolder holder, int position) {
        String created = listChats.get(position).getCreated_at();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        holder.itemView.setLayoutParams(params);
        String url, name="";
        holder.text_message.setText(listChats.get(position).getMessage());
//
        Date current_date = cal.getTime();
//
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
        private TextView text_message;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text_message = itemView.findViewById(R.id.text1_like);
            image_person = itemView.findViewById(R.id.chat_person_image);
            time = itemView.findViewById(R.id.text2_like);
        }
    }
}
