package com.example.tinder_roush.Home;

import androidx.recyclerview.widget.DiffUtil;

import com.example.tinder_roush.Objects.HomeData;

import java.util.List;

public class CardStackCallback extends DiffUtil.Callback {

    private List<HomeData> old, fresh;

    public CardStackCallback(List<HomeData> old, List<HomeData> fresh) {
        this.old = old;
        this.fresh = fresh;
    }

    @Override
    public int getOldListSize() {
        return old.size();
    }

    @Override
    public int getNewListSize() {
        return fresh.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition).getPerson1_image() == fresh.get(newItemPosition).getPerson2_image();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == fresh.get(newItemPosition);
    }
}
