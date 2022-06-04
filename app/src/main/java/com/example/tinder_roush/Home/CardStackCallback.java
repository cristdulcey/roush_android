package com.example.tinder_roush.Home;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

public class CardStackCallback extends DiffUtil.Callback {

    private List<CardPersonItem> old, fresh;

    public CardStackCallback(List<CardPersonItem> old, List<CardPersonItem> fresh) {
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
        return old.get(oldItemPosition).getImage() == fresh.get(newItemPosition).getImage();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == fresh.get(newItemPosition);
    }
}
