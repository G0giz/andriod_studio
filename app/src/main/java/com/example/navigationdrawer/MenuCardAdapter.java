package com.example.navigationdrawer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MenuCardAdapter extends RecyclerView.Adapter<MenuCardAdapter.MyViewHolder>  {


    ArrayList<Dish> dishList;

    Context context;


    public MenuCardAdapter(Context context , ArrayList<Dish> dishList) {
        this.dishList = dishList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_view, parent, false);
        return new MyViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.title.setText(dishList.get(position).getName());
        holder.price.setText("" + (dishList.get(position).getPrice())+" " + "ש\"ח");
        holder.myImage.setImageResource(dishList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, price;
        ImageView myImage;
        MaterialCardView card;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textTitleMenuCard);
            price = itemView.findViewById(R.id.textPriceMenuCard);
            card = itemView.findViewById(R.id.menuCard);
            myImage = itemView.findViewById(R.id.imageMenuCard);

            card.setOnClickListener(v -> {
                ((test2)context).showPopUpWindow(dishList.get(getAdapterPosition()));
            });
        }
    }
}
