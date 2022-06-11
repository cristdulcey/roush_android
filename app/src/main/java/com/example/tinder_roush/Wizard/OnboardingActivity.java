package com.example.tinder_roush.Wizard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;

import java.util.ArrayList;
import java.util.List;

public class OnboardingActivity extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter adapter;
    private LinearLayout layoutOnboardIndicator;
    private LocalData localData;

    List<Fragment> list = new ArrayList<>();

    TextView[] indicator;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layoutOnboardIndicator = findViewById(R.id.layoutOnboardIndicator);
        localData = new LocalData();
        if (localData.getwizard() == true){
            startActivity(new Intent(BaseContext.getContext(), LoginActivities.class));
            finish();
        }

        list.add(new Onboarding1());
        list.add(new Onboarding2());
        list.add(new Onboarding3());

        pager = findViewById(R.id.onboarding_viewpager);
        adapter = new OnboardingAdapter(getSupportFragmentManager(), list);

        pager.setAdapter(adapter);
        setUpindicator(0);
        pager.addOnPageChangeListener(viewListener);
    }


    @SuppressLint("ResourceType")
    public void setUpindicator(int position) {

        indicator = new TextView[3];
        layoutOnboardIndicator.removeAllViews();

        for (int i = 0; i < indicator.length; i++) {
            indicator[i] = new TextView(this);
            indicator[i].setText(Html.fromHtml("&#8226"));
            indicator[i].setTextSize(35);
            indicator[i].setTextColor(Color.parseColor(getResources().getString(R.color.unselected)));
           // indicator[i].setTextColor(getResources().getColor(R.color.white,getApplicationContext().getTheme()));
            layoutOnboardIndicator.addView(indicator[i]);
        }
        indicator[position].setTextColor(Color.parseColor(getResources().getString(R.color.selected)));
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {

        private int pagePosition;
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        public void onPageSelected(int position) {
            setUpindicator(position);
            pagePosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == pager.SCROLL_STATE_DRAGGING) {
                if (pagePosition == list.size()-1) {
                    localData.wizard();
                    Intent intent = new Intent(OnboardingActivity.this, LoginActivities.class);
                    startActivity(intent);
                    finish();
                }
            }
        }
    };
}
