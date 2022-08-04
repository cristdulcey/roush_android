package com.example.tinder_roush.Home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.MatchSuccess.MatchSuccess;
import com.example.tinder_roush.Objects.ProfileData;
import com.example.tinder_roush.OtherProfile.OtherProfileActivity;
import com.example.tinder_roush.Profile.ProfileActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;
import com.example.tinder_roush.Utils.SpinnerCustom;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.slider.RangeSlider;
import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;


public class HomeActivity extends Fragment implements HomeInterfaces.fragment{

    ImageButton match, filter, swipe, like;
    ImageView goToProfile;
    Context context;
    String city;
    HomePresenters presenter;
    List<CardPersonItem> cardPersonItems = new ArrayList<>();
    List<KeyPairBoolDataCustom> allCities;
    SpinnerCustom spinnerCities;
    CardStackView cardStackView;
    LocalData localData;
    int check_man, check_woman, check_both, check_other;
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
        presenter.HomePhotoUser();
        presenter.citiesPresenter();
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

    @Override
    public void getUserPhoto(CardPersonItem person) {
        Picasso.get().load(person.getImage()).fit().centerCrop().into(goToProfile);
    }

    private void initObjets(View view) {
        cardStackView = view.findViewById(R.id.card_stack_view);
        presenter = new HomePresenters(this);
        match = view.findViewById(R.id.match_button);
        swipe = view.findViewById(R.id.swipe_button);
//        spinnerCities = view.findViewById(R.id.spinner_city_filter_home);
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
                presenter.getUserPreferencesFilter(view);
               // filters(view);
            }
        });

        goToProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performMyProfile();
            }
        });

        cardStackView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOtherProfile();
            }
        });
    }

    public void filters(View view, ProfileData data){
        Button clear_filter, save_filters, manPreference, womanPreference, bothPreference, otherPreference;
        SeekBar distance_range; RangeSlider age_range;
        TextView min_age, max_age, distance;
        check_man =1; check_woman =1; check_both = 1; check_other =1;
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
        View view_dg = LayoutInflater.from(context).inflate(R.layout.bottom_dialog_filter, (LinearLayout)view.findViewById(R.id.dialog_filter_container));
        clear_filter =view_dg.findViewById(R.id.clear_filter);
        save_filters =view_dg.findViewById(R.id.save_filters);
        distance_range = view_dg.findViewById(R.id.range_distance_filter);
        age_range = view_dg.findViewById(R.id.age_range_filter);
        distance_range.setMax(50);
        age_range.setValues(18f,60f);
        distance = view_dg.findViewById(R.id.max_range_filter);
        min_age = view_dg.findViewById(R.id.min_age_filter);
        max_age = view_dg.findViewById(R.id.max_age_filter);
        manPreference = view_dg.findViewById(R.id.filter_man_home);
        womanPreference = view_dg.findViewById(R.id.filter_woman_home);
        bothPreference = view_dg.findViewById(R.id.filter_both_home);
        otherPreference = view_dg.findViewById(R.id.filter_other_home);
        List<Float> values = new ArrayList<Float>();
        values.add(new Float(localData.getRegister("MIN_AGE")) );
        values.add(new Float(localData.getRegister("MAX_AGE")));
        age_range.setValues(values);
        //RANGE FILTERS
        distance_range.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distance.setText(""+progress+"km" );
                localData.register(String.valueOf(progress),"DISTANCE_RANGE");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
        age_range.addOnSliderTouchListener(new RangeSlider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull RangeSlider slider) { }
            @Override
            public void onStopTrackingTouch(@NonNull RangeSlider slider) {
                List<Float> values = slider.getValues();
                int year = Calendar.getInstance().get(Calendar.YEAR);
                float minf = Collections.min(values);
                float maxf = Collections.max(values);
                int min = (int) minf; localData.register(String.valueOf(min), "MIN_AGE");
                int max = (int) maxf; localData.register(String.valueOf(max), "MAX_AGE");
                min_age.setText(String.valueOf(min)); max_age.setText(String.valueOf(max));
                int date_start = year-min;
                int date_finish = year-max;
                localData.register(String.valueOf(date_start),"DATE_START");
                localData.register(String.valueOf(date_finish),"DATE_FINISH");
            }
        });
        //SEARCH
        manPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_man == 1){
                    manPreference.setBackgroundResource(R.drawable.border_left_green);
                    manPreference.setTextColor(Color.WHITE);
                    womanPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    womanPreference.setTextColor(Color.GRAY);
                    bothPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    bothPreference.setTextColor(Color.GRAY);
                    otherPreference.setBackgroundResource(R.drawable.border_rigth_white);
                    otherPreference.setTextColor(Color.GRAY);
                    String Text = "MAN";
                    localData.register(Text,"GENDER_PREFERENCE");
                    check_man = 0;
                //    presenter.changePreferencesSearch();
                }else{
                    check_man = 1;
                }
            }
        });
        womanPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_woman == 1){
                    womanPreference.setBackgroundResource(R.drawable.border_green);
                    womanPreference.setTextColor(Color.WHITE);
                    manPreference.setBackgroundResource(R.drawable.border_left_white);
                    manPreference.setTextColor(Color.GRAY);
                    bothPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    bothPreference.setTextColor(Color.GRAY);
                    otherPreference.setBackgroundResource(R.drawable.border_rigth_white);
                    otherPreference.setTextColor(Color.GRAY);
                    String Text = "WOMAN";
                    localData.register(Text,"GENDER_PREFERENCE");
                    check_woman = 0;
                 //   presenter.changePreferencesSearch();
                }else{
                    check_woman = 1;
                }
            }
        });
        bothPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_both == 1){
                    bothPreference.setBackgroundResource(R.drawable.border_green);
                    bothPreference.setTextColor(Color.WHITE);
                    manPreference.setBackgroundResource(R.drawable.border_left_white);
                    manPreference.setTextColor(Color.GRAY);
                    womanPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    womanPreference.setTextColor(Color.GRAY);
                    otherPreference.setBackgroundResource(R.drawable.border_rigth_white);
                    otherPreference.setTextColor(Color.GRAY);
                    String Text = "BOTH";
                    localData.register(Text,"GENDER_PREFERENCE");
                    check_both = 0;
                  //  presenter.changePreferencesSearch();
                }else{
                    check_both = 1;
                }
            }
        });
        otherPreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_other == 1){
                    otherPreference.setBackgroundResource(R.drawable.border_rigth_green);
                    otherPreference.setTextColor(Color.WHITE);
                    manPreference.setBackgroundResource(R.drawable.border_left_white);
                    manPreference.setTextColor(Color.GRAY);
                    womanPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    womanPreference.setTextColor(Color.GRAY);
                    bothPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                    bothPreference.setTextColor(Color.GRAY);
                    String Text = "BOTH";
                    localData.register(Text,"GENDER_PREFERENCE");
                    check_other = 0;
                   // presenter.changePreferencesSearch();
                }else{
                    check_other = 1;
                }
            }
        });
        clear_filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
        save_filters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BaseContext.getContext(),"Filtros actualizados", Toast.LENGTH_SHORT).show();
                bottomSheetDialog.dismiss();
            }
        });

        distance_range.setProgress(Integer.parseInt(localData.getRegister("DISTANCE_RANGE")));
        min_age.setText(localData.getRegister("MIN_AGE"));
        max_age.setText(localData.getRegister("MAX_AGE"));
        for (int i =0; i<4; i++){
            if (data.getSearch().equals("MAN")){
                manPreference.setBackgroundResource(R.drawable.border_left_green);
                manPreference.setTextColor(Color.WHITE);
                localData.register("MAN","GENDER_PREFERENCE");
                break;
            }else{
                manPreference.setBackgroundResource(R.drawable.border_left_white);
                manPreference.setTextColor(Color.GRAY);
                //localData.register("","GENDER_PREFERENCE");
            }
            if (data.getSearch().equals("WOMAN")){
                womanPreference.setBackgroundResource(R.drawable.border_green);
                womanPreference.setTextColor(Color.WHITE);
                localData.register("WOMAN","GENDER_PREFERENCE");
                break;
            }else {
                womanPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                womanPreference.setTextColor(Color.GRAY);
                //   localData.register("","GENDER_PREFERENCE");
            }
            if (data.getSearch().equals("BOTH")){
                bothPreference.setBackgroundResource(R.drawable.border_green);
                bothPreference.setTextColor(Color.WHITE);
                localData.register("BOTH","GENDER_PREFERENCE");
                break;
            }else {
                bothPreference.setBackgroundResource(R.drawable.border_gray_transparent);
                bothPreference.setTextColor(Color.GRAY);
                // localData.register("","GENDER_PREFERENCE");
            }
            if (data.getSearch().equals("OTHER")){
                otherPreference.setBackgroundResource(R.drawable.border_rigth_green);
                otherPreference.setTextColor(Color.WHITE);
                localData.register("OTHER","GENDER_PREFERENCE");
                break;
            }else {
                otherPreference.setBackgroundResource(R.drawable.border_rigth_white);
                otherPreference.setTextColor(Color.GRAY);
                // localData.register("","GENDER_PREFERENCE");
            }
        }
        bottomSheetDialog.setContentView(view_dg);
        bottomSheetDialog.show();
    }
//
//    public void addSpinnerBefore(){
//        List<KeyPairBoolDataCustom> listArray1 = new ArrayList<>();
//        KeyPairBoolDataCustom h = new KeyPairBoolDataCustom();
//        h.setId("0");
//        h.setExtra("--");
//        h.setName("cargando");
//        h.setSelected(false);
//        listArray1.add(h);
//        addItemsSpinnerCity(listArray1);
//    }
//
//    //Spinner Ciudades
//    public void addItemsSpinnerCity(List<KeyPairBoolDataCustom> cities){
//        allCities = cities;
//        spinnerCities.setSearchEnabled(true);
//        spinnerCities.setSearchHint("");
//        spinnerCities.setItems(cities, new SpinnerListener() {
//            @Override
//            public void onItemsSelected(KeyPairBoolDataCustom selectedItem) {
//                city=selectedItem.getId();
//            }
//            @Override
//            public void onClear() { }
//        });
//    }

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

    public void performOtherProfile(){
        Intent intent = new Intent(context, OtherProfileActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}