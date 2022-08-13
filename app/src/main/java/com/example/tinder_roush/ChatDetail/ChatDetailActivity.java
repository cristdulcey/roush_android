package com.example.tinder_roush.ChatDetail;

import static org.asynchttpclient.Dsl.asyncHttpClient;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Objects.ChatDetailData;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.ws.WebSocket;
import org.asynchttpclient.ws.WebSocketListener;
import org.asynchttpclient.ws.WebSocketUpgradeHandler;

import java.util.ArrayList;

public class ChatDetailActivity extends AppCompatActivity implements ChatDetailInterfaces.fragment {

    private RecyclerView recyclerViewChatsDetail;
    private ChatDetailAdapter ChatDetailAdapter;
    ImageView goMyProfile, like_person_image;
    ChatDetailPresenters presenter;
    WebSocket websocket;
    EditText message;
    TextView name_person;
    Button sendMessage;
    String id_chat, person1_name, person2_name, person1, person2, person1_image, person2_image;
    LocalData localData;
    ArrayList<ChatDetailData> list_chats_aux = new ArrayList<ChatDetailData>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_chats_detail);
        initObjects();
        listeners();

    }


    private void initObjects() {
        this.localData = new LocalData();
        recyclerViewChatsDetail = findViewById(R.id.recycler_chats);
        goMyProfile = findViewById(R.id.profile_from_chats);
        like_person_image = findViewById(R.id.like_person_image);
        message = findViewById(R.id.message_chat);
        name_person = findViewById(R.id.name_person);
        sendMessage = findViewById(R.id.send_message);
        presenter = new ChatDetailPresenters(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            id_chat = extras.getString("id_chat");
            person1_name = extras.getString("person1_name");
            person2_name = extras.getString("person2_name");
            person1 = extras.getString("person1");
            person2 = extras.getString("person2");
            person1_image = extras.getString("person1_image");
            person2_image = extras.getString("person2_image");
        }
        name_person.setText(person1_name);
        if (!person2.equals(localData.getRegister("ID_USERCURRENT"))) {
            name_person.setText(person2_name);
            Picasso.get().load(person2_image).fit().centerCrop().into(like_person_image);
        }else {
            name_person.setText(person1_name);
            Picasso.get().load(person1_image).fit().centerCrop().into(like_person_image);
        }

        presenter.getChatDetailPresenter(id_chat);
        presenter.getPhotoProfile();
        AsyncHttpClient asyncHttpClient = asyncHttpClient();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // ws://192.168.31.9 or wss://roush.loducode.com
                    websocket = asyncHttpClient.prepareGet("wss://roush.loducode.com/ws/chat/" + id_chat + "/").execute(new WebSocketUpgradeHandler.Builder().addWebSocketListener(
                            new WebSocketListener() {

                                @Override
                                public void onOpen(WebSocket websocket) {
//                                    Log.e("onOpen", websocket.toString());
                                    //                                websocket.sendTextFrame("...").sendTextFrame("...");
                                }

                                @Override
                                public void onClose(WebSocket websocket, int code, String reason) {
//                                    Log.e("onClose", reason.toString());
                                    closeChat();
                                }

                                @Override
                                public void onTextFrame(String payload, boolean finalFragment, int rsv) {
//                                    Log.e("receive", payload);
                                    Gson g = new Gson();
                                    ChatDetailData s = g.fromJson(payload, ChatDetailData.class);
                                    if (s.getMessage().equals(message.getText().toString())){
                                        removeTextChat();
                                    }
                                    recyclerUpdateChatsDetail(s);
                                }

                                @Override
                                public void onPingFrame(byte[] payload) {
//                                    Log.e("onPingFrame", payload.toString());
                                    WebSocketListener.super.onPingFrame(payload);
                                }

                                @Override
                                public void onPongFrame(byte[] payload) {
//                                    Log.e("onPingFrame", payload.toString());
                                    WebSocketListener.super.onPongFrame(payload);
                                }

                                @Override
                                public void onError(Throwable t) {
//                                    Log.e("error connect", t.toString());
                                    closeChat();
                                }

                                @Override
                                public void onBinaryFrame(byte[] payload, boolean finalFragment, int rsv) {
//                                    Log.e("onPingFrame", payload.toString());
                                    WebSocketListener.super.onBinaryFrame(payload, finalFragment, rsv);
                                }
                            }).build()).get();

//                    if(websocket.isOpen()){
//                        Log.e("isOpen ws","YES");
//                    }else {
//                        Log.e("isOpen ws","NO");
//                    }
                } catch (Exception ex) {
//                    Log.e("error ws", ex.toString());
                    closeChat();
                    ex.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    protected void onPause() {
        websocket.sendCloseFrame();
        super.onPause();
    }

    public void closeChat() {
        finishActivity(404);
    }

    public void listeners() {
        goMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performToMyProfile();
            }
        });
        sendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (message.getText().toString().isEmpty()) {
//                    username.setError(BaseContext.getContext().getString(R.string.message_empty_field));
//                    username.requestFocus();
                    return;
                }
                websocket.sendTextFrame("{\n" +
                        "\"message\":\"" +
                        message.getText().toString() +
                        "\",\n" +
                        "\"sender\":\"" +
                        localData.getRegister("ID_USERCURRENT") +
                        "\"\n" +
                        "}");

            }
        });
    }


    @Override
    public void showPhotoProfile(String data) {
        Picasso.get().load(data).fit().centerCrop().into(goMyProfile);
    }

    @Override
    public void recyclerChatsDetail(ArrayList<ChatDetailData> listChatsDetail) {
        list_chats_aux = listChatsDetail;
        ChatDetailAdapter = new ChatDetailAdapter(BaseContext.getContext(), listChatsDetail);
        recyclerViewChatsDetail.setAdapter(ChatDetailAdapter);
        recyclerViewChatsDetail.setLayoutManager(new LinearLayoutManager(BaseContext.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerViewChatsDetail.smoothScrollToPosition(ChatDetailAdapter.getItemCount());
    }

    public void recyclerUpdateChatsDetail(ChatDetailData listChatsDetail) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int last = list_chats_aux.size();
                list_chats_aux.add(last, listChatsDetail);
                ChatDetailAdapter.notifyItemInserted(last);
                recyclerViewChatsDetail.scrollToPosition(last);
            }
        });

    }

    public void removeTextChat() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                message.setText("");
            }
        });

    }

    public void performToMyProfile() {
        Intent intent = new Intent(BaseContext.getContext(), ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}