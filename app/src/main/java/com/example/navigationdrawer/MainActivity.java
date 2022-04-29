package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    RecyclerView recyclerView;
    int images[] = {R.drawable.spaghetti_bolognese, R.drawable.mushroom_pizza, R.drawable.hamburger, R.drawable.nodels
    ,R.drawable.chocolate_cake,R.drawable.soofle};
    MenuCardAdapter menuCardAdapter;
    ArrayList<Dish> mains = new ArrayList<Dish>();
    ArrayList<Dish> dessert = new ArrayList<Dish>();
    Dish[] arr = new Dish[4];
    Dish[] dessert_arr = new Dish[2];
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intDish();
        intViews();
        intActions();



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

        dessert_arr[0] = new Dish(5, "עוגת מוס שוקולד"  , "ממש טעים ממש טעיםממש טעיםממש טעיםממש טמש טעים",65, images[4]);
        dessert_arr[1] = new Dish(6, "סופלה שוקולד"  , "ממש טעים ממש טעיםממש טעיםממש טעיםממש טמש טעים",44, images[5]);

    }

    private void intViews() {

        // drawer layout instance to toggle the menu icon to open
        // drawer and back button to close drawer
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //recyclerView
        recyclerView = findViewById(R.id.recycleViewMenu);
        mains.add(arr[0]);
        mains.add(arr[1]);
        mains.add(arr[2]);
        mains.add(arr[3]);
        dessert.add(dessert_arr[0]);
        dessert.add(dessert_arr[1]);
        intAdapter(mains);


    }

    private void intActions() {
        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    // override the onOptionsItemSelected()
    // function to implement
    // the item click listener callback
    // to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {



        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.dessert_dish:
                intAdapter(dessert);
                break;
            case R.id.main_dish:
                intAdapter(mains);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}