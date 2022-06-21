package com.example.tinder_roush.Likes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tinder_roush.R;
public class LikesGivenReceivedFragment extends Fragment {

    public LikesGivenReceivedFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_likes_given_received, container, false);
        return view;
    }

}