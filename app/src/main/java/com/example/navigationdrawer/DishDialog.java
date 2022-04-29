package com.example.navigationdrawer;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DishDialog extends AppCompatDialogFragment implements View.OnClickListener {

    Dish dish;
    LinearLayout pop_up_image_layout;
    TextView title, desc, amount_view, price_view;
    Button btn_add_to_cart, btn_plus, btn_minus;
    View view;
    DishDialogListener listener;
    int amount_num;
    double price_num;


    public DishDialog(Dish dish) {
        this.dish = dish;
    }

    public Dish getDish() {
        return dish;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.pop_up, null);
        builder.setView(view);

        pop_up_image_layout = view.findViewById(R.id.pop_up_image_layout);
        pop_up_image_layout.setBackgroundResource(dish.getImg());
        title = view.findViewById(R.id.pop_up_title);
        title.setText(dish.getName());
        desc = view.findViewById(R.id.pop_up_desc);
        desc.setText(dish.getDesc());
        amount_view = view.findViewById(R.id.pop_up_amount);
        amount_num = dish.getAmount();
        amount_view.setText("" + amount_num);
        price_view = view.findViewById(R.id.pop_up_price);
        price_num = dish.getPrice();
        if (amount_num == 0)
            price_view.setText("0 ש\"ח");
        else
            price_view.setText("" + dish.getTotal_price() +" " + "ש\"ח");



        btn_add_to_cart = view.findViewById(R.id.btn_add_to_cart);
        btn_plus = view.findViewById(R.id.btn_pop_up_plus);
        btn_minus = view.findViewById(R.id.btn_pop_up_minus);

        buttonInt();
        // Now create object of AlertDialog from the Builder.
        final AlertDialog dialog = builder.create();

// Let's start with animation work. We just need to create a style and use it here as follows.
        if (dialog.getWindow() != null)
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        return dialog;
    }


    private void buttonInt() {
        btn_add_to_cart.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        listener = (DishDialogListener) context;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_add_to_cart:
                if (amount_num == 0)
                    return;
                dish.setAmount(amount_num);
                dish.setTotal_price(amount_num*price_num);
                listener.AddDish(dish);
                break;
            case R.id.btn_pop_up_plus:
                amount_num++;
                amount_view.setText("" + amount_num);
                price_view.setText("" + (price_num * amount_num) + " " + "ש\"ח");
                break;
            case R.id.btn_pop_up_minus:
                if (amount_num == 0)
                    return;
                amount_num--;
                amount_view.setText("" + amount_num);
                price_view.setText("" + (price_num * amount_num) + " " + "ש\"ח");
                break;

        }
    }

    public interface DishDialogListener {
        void AddDish(Dish dish);
    }

}
