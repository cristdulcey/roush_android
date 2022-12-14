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
        if (old.get(oldItemPosition).getPerson1().equals("ID_USERCURRENT")){
            return old.get(oldItemPosition).getPerson2_image().equals(fresh.get(newItemPosition).getPerson2_image());
        }else {
            return old.get(oldItemPosition).getPerson1_image().equals(fresh.get(newItemPosition).getPerson1_image());
        }
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == fresh.get(newItemPosition);
    }
}
