package com.example.navigationdrawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

public class HollyViewPagerAdapter extends PagerAdapter {

    protected static final int TYPE_HEADER = 0;
    protected static final int TYPE_CELL = 1;

    public int getItemViewType(int position) {
        switch (position){
            case 0: return TYPE_HEADER;
            default: return TYPE_CELL;
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type) {
        View view;
        switch (type){
            case TYPE_HEADER:
                return new RecyclerView.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hvp_header_placeholder,viewGroup,false)) {};
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return false;
    }
}
