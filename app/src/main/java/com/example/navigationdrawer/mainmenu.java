package com.example.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.util.ArrayList;
import java.util.List;

public class mainmenu extends AppCompatActivity {
    TextView btnFirst,btnMain,btnDesert;
    private ViewPager2 viewPager2;
    private Handler slideHandler=new Handler();
    public static final String desert="desert";
    public static final String mainOf="main";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        btnDesert=findViewById(R.id.Desert);
        btnFirst=findViewById(R.id.First);
        btnMain=findViewById(R.id.Main);
        viewPager2=findViewById(R.id.viewPagerImageSlider);
        List<SliderItem> sliderItems=new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.burger));
        sliderItems.add(new SliderItem(R.drawable.pasta));
        sliderItems.add(new SliderItem(R.drawable.sweetpotato));
        sliderItems.add(new SliderItem(R.drawable.desert));

        viewPager2.setAdapter(new SliderAdapterExample(sliderItems,viewPager2));

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                slideHandler.removeCallbacks(sliderRunnable);
                slideHandler.postDelayed(sliderRunnable,3000);

            }
        });
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=btnMain.getText().toString();
                Toast.makeText(mainmenu.this, value, Toast.LENGTH_LONG).show();
                Intent intet=new Intent(mainmenu.this,test2.class);
                intet.putExtra(mainOf,value);
                startActivity(intet);
            }
        });

        btnDesert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=btnDesert.getText().toString();
                Toast.makeText(mainmenu.this, value, Toast.LENGTH_LONG).show();
                Intent intet=new Intent(mainmenu.this,test2.class);
                intet.putExtra(desert,value);
                startActivity(intet);
            }
        });
    }
    private Runnable sliderRunnable=new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem()+1);
        }
    };
}