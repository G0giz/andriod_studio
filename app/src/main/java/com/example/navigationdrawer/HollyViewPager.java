package com.example.navigationdrawer;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.github.florent37.hollyviewpager.HollyViewPagerBus;
import com.github.florent37.hollyviewpager.HollyViewPagerConfigurator;

import java.util.ArrayList;

public class HollyViewPager extends AppCompatActivity {

    com.github.florent37.hollyviewpager.HollyViewPager hollyViewPager;
    HollyViewPagerAdapter hollyViewPagerAdapter=new HollyViewPagerAdapter();
    RecyclerView recyclerView;
    int images[] = {R.drawable.spaghetti_bolognese, R.drawable.mushroom_pizza, R.drawable.hamburger, R.drawable.nodels
            ,R.drawable.chocolate_cake,R.drawable.soofle};
    MenuCardAdapter menuCardAdapter;
    ArrayList<Dish> mains = new ArrayList<Dish>();
    Dish[] arr = new Dish[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holly_view_pager);

        hollyViewPager=findViewById(R.id.hollyViewPager);
        hollyViewPager.setAdapter(hollyViewPagerAdapter);
        recyclerView = findViewById(R.id.recycleViewMenu2);
        intDish();
        intViews();

        HollyViewPagerBus.registerRecyclerView(this, recyclerView);

        hollyViewPager.setConfigurator(new HollyViewPagerConfigurator() {
            @Override
            public float getHeightPercentForPage(int page) {
                return page;
            }
        });

    }

    private void intAdapter(ArrayList<Dish> list) {

       //menuCardAdapter = new MenuCardAdapter(this, list);
        recyclerView.setAdapter((menuCardAdapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void intDish() {
        arr[0] = new Dish(1,"ספגטי בולונז", "ממש טעים ממש טעיםממש טעיםממש טעיםממש טעיםממש טעיםממשים",95, images[0]);
        arr[1] = new Dish(2,"פיצה פיטריות", "ממש טעים ממש טעיםממש טעיםממש טעיםממעים",84, images[1]);
        arr[2] = new Dish(4,"המבורגר", "ממש טעים ממש טעיםממש טעיםממש טעיםטעים",100.5, images[2]);
        arr[3] = new Dish(4, "נודלס"  , "ממש טעים ממש טעיםממש טעיםממש טעיםממש טמש טעים",72, images[3]);

    }

    private void intViews() {



        mains.add(arr[0]);
        mains.add(arr[1]);
        mains.add(arr[2]);
        mains.add(arr[3]);
        intAdapter(mains);


    }
}