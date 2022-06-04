package com.example.tinder_roush.MenuNavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tinder_roush.Home.HomeActivity;
import com.example.tinder_roush.LikesActivity;
import com.example.tinder_roush.R;
import com.example.tinder_roush.databinding.MenuNavigationBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuNavigation extends AppCompatActivity {

    MenuNavigationBinding binding;
    Bundle extras;
    private ViewPager viewPager;
    int pager_before;
    ViewPagerAdapter adapter;
    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate. setDefaultNightMode (
                AppCompatDelegate.MODE_NIGHT_NO);
        binding = MenuNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initObjects();
        listeners();
        extras = getIntent().getExtras();
        if (extras!=null) {
            if (extras.containsKey("home")) {
                openFragment(0);
            }
        }
        if (extras!=null) {
            if (extras.containsKey("account")) {
                openFragment(3);
            }
        }
    }

    private void initObjects(){
        bottom_navigation = findViewById(R.id.bottom_navigation);
        viewPager=findViewById(R.id.container);
        pager_before=0;
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }


    private void listeners() {
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_matchs:
                        viewPager.setCurrentItem(0);
                        pager_before=0;
                        break;
                    case R.id.navigation_likes:
                        viewPager.setCurrentItem(1);
                        pager_before=1;
                        break;
                    case R.id.navigation_chats_list:
                        viewPager.setCurrentItem(2);
                        pager_before=2;
                        break;
                    case R.id.navigation_chat:
                        viewPager.setCurrentItem(3);
                        pager_before=3;
                        break;
                    case R.id.navigation_account:
                        viewPager.setCurrentItem(4);
                        pager_before=4;
                        break;
                    default:
                        viewPager.setCurrentItem(5);
                        pager_before=5;
                }
                return false;
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                if (pager_before!=position){
//                    bottom_navigation.getMenu().getItem(pager_before).setChecked(false);
//                }
                bottom_navigation.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        // define your fragments here
          final Fragment fragment1 = new HomeActivity();
          final Fragment fragment2 = new LikesActivity();
//        final Fragment fragment3 = new NotificationsActivities();
//        final Fragment fragment4 = new PqrsFragment();
//        final Fragment fragment5 = new ContainerFragment();
          adapter.addFragment(fragment1);
          adapter.addFragment(fragment2);
//        adapter.addFragment(fragment3);
//        adapter.addFragment(fragment4);
//        adapter.addFragment(fragment5);
          viewPager.setAdapter(adapter);
    }

    public void openFragment(int item) {
        viewPager.setCurrentItem(item);
    }
}