package com.example.tinder_roush.Chats;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tinder_roush.ChatDetail.ChatDetailActivity;
import com.example.tinder_roush.Objects.ChatData;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.RecyclerTouchListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatsActivity extends Fragment implements ChatsInterfaces.fragment {

    private RecyclerView recyclerViewChats;
    private ChatsAdapter chatsAdapter;
    ImageView goProfile;
    EditText searchChat;
    ChatsPresenters presenter;
    ArrayList<ChatData> list_chats_aux = new ArrayList<ChatData>();

    public ChatsActivity() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        initObjects(view);
        listeners();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getChatsPresenter(searchChat.getText().toString());
        presenter.getPhotoProfile();
    }

    private void initObjects(View view) {
        recyclerViewChats = view.findViewById(R.id.recycler_chats);
        searchChat = view.findViewById(R.id.search_chat);
        goProfile = view.findViewById(R.id.profile_from_chats);
        presenter = new ChatsPresenters(this);
    }

    public void listeners() {
        goProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performToMyProfile();
            }
        });
        recyclerViewChats.addOnItemTouchListener(new RecyclerTouchListener(BaseContext.getContext(), recyclerViewChats, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(BaseContext.getContext(), ChatDetailActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("id_chat", list_chats_aux.get(position).getId());
                intent.putExtra("person1_name", list_chats_aux.get(position).getMatch().getPerson1_name());
                intent.putExtra("person2_name", list_chats_aux.get(position).getMatch().getPerson2_name());
                intent.putExtra("person1", list_chats_aux.get(position).getMatch().getPerson1());
                intent.putExtra("person2", list_chats_aux.get(position).getMatch().getPerson2());
                intent.putExtra("person2", list_chats_aux.get(position).getMatch().getPerson2());
                intent.putExtra("person1_image", list_chats_aux.get(position).getMatch().getPerson1_image());
                intent.putExtra("person2_image", list_chats_aux.get(position).getMatch().getPerson2_image());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
//                Log.e("click long", String.valueOf(position));
                Toast.makeText(BaseContext.getContext(), ":)", Toast.LENGTH_SHORT).show();
            }
        }));
        searchChat.addTextChangedListener(new TextWatcher() {


            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {

                presenter.getChatsPresenter(searchChat.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    @Override
    public void showPhotoProfile(String data) {
        Picasso.get().load(data).fit().centerCrop().into(goProfile);
    }

    @Override
    public void recyclerChats(ArrayList<ChatData> listChats) {
//        Log.e("chats", String.valueOf(listChats.size()));
        list_chats_aux = listChats;
        chatsAdapter = new ChatsAdapter(BaseContext.getContext(), listChats);
        recyclerViewChats.setAdapter(chatsAdapter);
        recyclerViewChats.setLayoutManager(new LinearLayoutManager(BaseContext.getContext(), LinearLayoutManager.VERTICAL, false));
    }

    public void performToMyProfile() {
        Intent intent = new Intent(BaseContext.getContext(), ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}