package com.example.navigationdrawer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CartCardAdapter cardAdapter;
    double total_order_pay = 0;
    TextView total_order_pay_view;

    ArrayList<Dish> cart = new ArrayList<Dish>();
    ArrayList<Integer> cart_id = new ArrayList<Integer>();
    MaterialToolbar materialToolbar;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cart);

        cart = (ArrayList<Dish>) getIntent().getSerializableExtra("cart");
        cart_id = (ArrayList<Integer>) getIntent().getSerializableExtra("cart_id");
        Toast.makeText(this, "" + cart.size(), Toast.LENGTH_SHORT).show();
        materialToolbar = findViewById(R.id.topAppBarCart);
        recyclerView = findViewById(R.id.recycleViewCart);
        total_order_pay_view = findViewById(R.id.total_order_pay);
        intAdapter();
        totalPriceCalc();
        total_order_pay_view.setText("סכום כולל:" + " " + total_order_pay + " " + "ש\"ח");

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this, MainActivity2.class);
                i.putExtra("cart", cart);
                i.putExtra("cart_id", cart_id);
                startActivity(i);
            }
        });

    }

    private void totalPriceCalc() {

        for (int i = 0; i < cart.size(); i++) {
            total_order_pay += cart.get(i).getTotal_price();
        }
    }

    private void intAdapter() {

        cardAdapter = new CartCardAdapter(this, cart, cart_id);
        recyclerView.setAdapter((cardAdapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    protected void SetPaytext(double price) {
        total_order_pay += price;
        total_order_pay_view.setText("סכום כולל:" + " " + total_order_pay + " " + "ש\"ח");
    }

}


