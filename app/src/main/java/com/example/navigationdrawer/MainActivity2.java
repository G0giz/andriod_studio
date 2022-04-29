package com.example.navigationdrawer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Dish> cart = new ArrayList<Dish>(), cartBack = new ArrayList<Dish>();
    ArrayList<Integer> cart_id = new ArrayList<Integer>(), cart_id_back = new ArrayList<Integer>();
    Button btn_menu, btn_cart;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tool_bar_title);
        setContentView(R.layout.activity_main2);


        btn_menu = findViewById(R.id.btn_menu);
        btn_cart = findViewById(R.id.btn_cart);
        btn_cart.setOnClickListener(this);
        btn_menu.setOnClickListener(this);

        cartBack = (ArrayList<Dish>) getIntent().getSerializableExtra("cart");
        if (cartBack != null)
            cart = cartBack;

        cart_id_back = (ArrayList<Integer>) getIntent().getSerializableExtra("cart_id");
        if (cart_id_back != null)
            cart_id = cart_id_back;



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_menu:
                Intent i = new Intent(MainActivity2.this, test2.class);
                i.putExtra("cart", cart);
                i.putExtra("cart_id", cart_id);
                startActivity(i);
                break;
            case R.id.btn_cart:
                if (!cart.isEmpty()) {
                    Intent i_cart = new Intent(MainActivity2.this, CartActivity.class);
                    i_cart.putExtra("cart", cart);
                    i_cart.putExtra("cart_id", cart_id);
                    startActivity(i_cart);

                }
                break;
        }

    }
}