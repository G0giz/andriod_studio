package com.example.navigationdrawer;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CartCardAdapter cardAdapter;

    ArrayList<Dish> cart = new ArrayList<Dish>();
    ArrayList<Integer> cart_id = new ArrayList<Integer>();

    @Override
    public void onBackPressed() {
        Intent i = new Intent(CartActivity.this, MainActivity2.class);
        i.putExtra("cart", cart);
        i.putExtra("cart_id", cart_id);
        startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cart);

        cart = (ArrayList<Dish>) getIntent().getSerializableExtra("cart");
        cart_id = (ArrayList<Integer>) getIntent().getSerializableExtra("cart_id");
        Toast.makeText(this, "" + cart.size(), Toast.LENGTH_SHORT).show();
        recyclerView = findViewById(R.id.recycleViewCart);
        intAdapter();

    }

    private void intAdapter() {

        cardAdapter = new CartCardAdapter(this, cart, cart_id);
        recyclerView.setAdapter((cardAdapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}


