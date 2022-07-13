package com.example.tinder_roush.Home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.MatchSuccess.MatchSuccess;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.Profile.ProfileActivity;
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


public class HomeActivity extends Fragment implements HomeInterfaces.fragment{

    ImageButton match, filter, swipe, like;
    ImageView goToProfile;
    Context context;
    HomePresenters presenter;
    List<CardPersonItem> cardPersonItems = new ArrayList<>();
    CardStackView cardStackView;
    LocalData localData;
    Boolean wait_response = false;
    public HomeActivity() {
        // Required empty public constructor
    }

    private CardStackLayoutManager managerCard;
    private CardStackPersonAdapter adapterCardPerson;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match_, container, false);
        context = view.getContext();
        //  adapterCardPerson = new CardStackPersonAdapter(addList());
        initObjets(view);
        presenter.HomePersonCurrent();
        listeners();
        swipeCards();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (wait_response == false){
            presenter.HomePresenterGetMatch();
            wait_response = true;
        }
    }

    public void swipeCards(){
        managerCard = new CardStackLayoutManager(context, new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) { }

            @Override
            public void onCardSwiped(Direction direction) {
                if(direction == Direction.Right){
                    presenter.HomeResponseMatchTrue();
                    paginate();
                    presenter.HomePresenterGetMatch();
                }
                if(direction == Direction.Left){
                    presenter.HomeResponseMatchFalse();
                    paginate();
                    presenter.HomePresenterGetMatch();
                }
//                if(managerCard.getTopPosition() == adapterCardPerson.getItemCount() - 5){
//                    paginate();
//                }
            }
            @Override
            public void onCardRewound() { }
            @Override
            public void onCardCanceled() { }
            @Override
            public void onCardAppeared(View view, int position) { TextView tv = view.findViewById(R.id.card_person_name); }
            @Override
            public void onCardDisappeared(View view, int position) { TextView tv = view.findViewById(R.id.card_person_name); }
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
    }

    private void paginate() {
        List<CardPersonItem> old = adapterCardPerson.getCardPersonItems();
//        List<CardPersonItem> fresh = new ArrayList<>(addList());
        CardStackCallback callback = new CardStackCallback(old, cardPersonItems);
        DiffUtil.DiffResult hasil = DiffUtil.calculateDiff(callback);
        adapterCardPerson.setCardPersonItems(cardPersonItems);
        hasil.dispatchUpdatesTo(adapterCardPerson);
    }

    public void addList(ArrayList<CardPersonItem> person) {
        adapterCardPerson = new CardStackPersonAdapter(person);
        cardStackView.setLayoutManager(managerCard);
        cardStackView.setAdapter(adapterCardPerson);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
//        return cardPersonItems;
    }

    @Override
    public void getUser(ProfileData data) {
        String userCurrent = data.getId();
        localData.register(userCurrent,"ID_USERCURRENT");
    }


    private void initObjets(View view) {
        cardStackView = view.findViewById(R.id.card_stack_view);
        presenter = new HomePresenters(this);
        match = view.findViewById(R.id.match_button);
        swipe = view.findViewById(R.id.swipe_button);
        filter = view.findViewById(R.id.filter_home);
        goToProfile = view.findViewById(R.id.profile_from_home);
        localData = new LocalData();
    }

    private void listeners() {
        match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.HomeResponseMatchTrue();
                paginate();
                presenter.HomePresenterGetMatch();
            }
        });
        swipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.HomeResponseMatchFalse();
                paginate();
                presenter.HomePresenterGetMatch();
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

        goToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performMyProfile();
            }
        });
    }

    //Methods
    public void performMatchSuccess() {
        Intent intent = new Intent(context, MatchSuccess.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void performMyProfile(){
        Intent intent = new Intent(context, ProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}