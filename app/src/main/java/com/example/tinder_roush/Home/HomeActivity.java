package com.example.tinder_roush.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tinder_roush.MatchSuccess.MatchSuccess;

import com.example.tinder_roush.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Fragment {

    ImageButton match, filter, swipe, like;
    Context context;

    public HomeActivity() {
        // Required empty public constructor
    }

    private CardStackLayoutManager managerCard;
    private CardStackPersonAdapter adapterCardPerson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match_, container, false);
        context = view.getContext();

        CardStackView cardStackView = view.findViewById(R.id.card_stack_view);
        managerCard = new CardStackLayoutManager(context, new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {

            }

            @Override
            public void onCardSwiped(Direction direction) {
                if(direction == Direction.Right){
                    Toast.makeText(context,"derecha",Toast.LENGTH_SHORT);
                }
                if(direction == Direction.Left){
                    Toast.makeText(context,"izquierda",Toast.LENGTH_SHORT);
                }

                if(managerCard.getTopPosition() == adapterCardPerson.getItemCount() - 5){
                    paginate();
                }
            }

            @Override
            public void onCardRewound() {
            }

            @Override
            public void onCardCanceled() {
            }

            @Override
            public void onCardAppeared(View view, int position) {
                TextView tv = view.findViewById(R.id.card_person_name);
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                TextView tv = view.findViewById(R.id.card_person_name);
            }
        });
        managerCard.setStackFrom(StackFrom.None);
        managerCard.setVisibleCount(3);
        managerCard.setTranslationInterval(8.0f);
        managerCard.setScaleInterval(0.95f);
        managerCard.setSwipeThreshold(0.3f);
        managerCard.setMaxDegree(20.0f);
        managerCard.setDirections(Direction.FREEDOM);
        managerCard.setCanScrollHorizontal(true);
        managerCard.setSwipeableMethod(SwipeableMethod.Manual);
        managerCard.setOverlayInterpolator(new LinearInterpolator());
        adapterCardPerson = new CardStackPersonAdapter(addList());
        cardStackView.setLayoutManager(managerCard);
        cardStackView.setAdapter(adapterCardPerson);
        cardStackView.setItemAnimator(new DefaultItemAnimator());

        initObjets(view);
        listeners();
        return view;
    }

    private void paginate() {

        List<CardPersonItem> old = adapterCardPerson.getCardPersonItems();
        List<CardPersonItem> fresh = new ArrayList<>(addList());
        CardStackCallback callback = new CardStackCallback(old, fresh);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapterCardPerson.setCardPersonItems(fresh);
        hasil.dispatchUpdatesTo(adapterCardPerson);

    }

    private List<CardPersonItem> addList() {
        List<CardPersonItem> cardPersonItems = new ArrayList<>();
        cardPersonItems.add(new CardPersonItem(R.drawable.image_onboarding1,"alguien","20"));
        cardPersonItems.add(new CardPersonItem(R.drawable.image_onboarding2,"otra persona","34"));
        cardPersonItems.add(new CardPersonItem(R.drawable.image_onboarding3,"este man","29"));
        return cardPersonItems;
    }

    private void initObjets(View view) {
        match = view.findViewById(R.id.match_button);
        filter = view.findViewById(R.id.filter_home);
//        register = findViewById(R.id.button_make_account);
//        forgot_password = findViewById(R.id.button_forgot_password);
//        email = findViewById(R.id.field_email);
//        password = findViewById(R.id.field_password);
    }

    private void listeners() {
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performMatchSuccess();
            }
        });
        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
                View bottomSheetView = LayoutInflater.from(context).inflate(R.layout.bottom_dialog_filter, (LinearLayout)view.findViewById(R.id.dialog_filter_container));
                bottomSheetView.findViewById(R.id.clear_filter).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });
    }

    public void performMatchSuccess() {
        Intent intent = new Intent(context, MatchSuccess.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}