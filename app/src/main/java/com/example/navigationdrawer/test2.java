package com.example.navigationdrawer;

import static android.graphics.Color.parseColor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class test2 extends AppCompatActivity implements View.OnClickListener, DishDialog.DishDialogListener {


    MaterialButton dessert_lay, first_lay, main_lay, drink_lay;
    ArrayList<View> menu_view = new ArrayList<>();
    RecyclerView recyclerView;
    int images[] = {R.drawable.spaghetti_bolognese, R.drawable.pizza, R.drawable.hamburger, R.drawable.nodels
            , R.drawable.chocolate_cake, R.drawable.soofle};
    MenuCardAdapter menuCardAdapter;
    ArrayList<Dish> mains = new ArrayList<Dish>(), dessert = new ArrayList<Dish>(),
            cart = new ArrayList<Dish>(), cartBack = new ArrayList<Dish>();
    Dish[] arr = new Dish[4];
    ArrayList<Integer> cart_id = new ArrayList<Integer>(),cart_id_back = new ArrayList<Integer>();
    Dish[] dessert_arr = new Dish[2];
    LinearLayout parent;
    String message,message2;
    MaterialButton select_button = null;
    DishDialog dishDialog;
    MaterialToolbar materialToolbar;
<<<<<<< HEAD
    ImageButton shop;

=======
>>>>>>> 699a77898240aaf05429ee443fd67ed37fc5238e

    @Override
    public void onBackPressed() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
<<<<<<< HEAD

        setContentView(R.layout.test);

        Intent intent=getIntent();
        message=intent.getStringExtra(mainmenu.desert);
        message2=intent.getStringExtra(mainmenu.mainOf);
        if (message==null)
            message=message2;


=======
        /*
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tool_bar_title);
        */

        setContentView(R.layout.test);

        /*
        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // Customize the back button
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_home_24);
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
*/
>>>>>>> 699a77898240aaf05429ee443fd67ed37fc5238e

        intDish();
        intViews();
        intButtons();


    }

<<<<<<< HEAD


=======
    /*
    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(test2.this, MainActivity2.class);
                i.putExtra("cart", cart);
                i.putExtra("cart_id", cart_id);
                startActivity(i);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/
>>>>>>> 699a77898240aaf05429ee443fd67ed37fc5238e
    private void intButtons() {
        shop.setOnClickListener(this);
        first_lay.setOnClickListener(this);
        main_lay.setOnClickListener(this);
        drink_lay.setOnClickListener(this);
        dessert_lay.setOnClickListener(this);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(test2.this,mainmenu.class);
                i.putExtra("cart",cart);
                i.putExtra("cart_id",cart_id);
                startActivity(i);
            }
        });

        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(test2.this, MainActivity2.class);
                i.putExtra("cart", cart);
                i.putExtra("cart_id", cart_id);
                startActivity(i);
            }
        });

    }

    private void intViews() {
<<<<<<< HEAD
        shop=findViewById(R.id.cart);
        materialToolbar=findViewById(R.id.topAppBar);
=======

        materialToolbar = findViewById(R.id.topAppBar);
>>>>>>> 699a77898240aaf05429ee443fd67ed37fc5238e
        parent = findViewById(R.id.parent_layout);
        recyclerView = findViewById(R.id.recycleViewMenu5);
        mains.add(arr[0]);
        mains.add(arr[1]);
        mains.add(arr[2]);
        mains.add(arr[3]);
        dessert.add(dessert_arr[0]);
        dessert.add(dessert_arr[1]);
        switch (message)
        {
            case "עקריות":
                intAdapter(mains);
                break;
            case "קינוחים":
                intAdapter(dessert);
                break;
        }

        //layout
        first_lay = findViewById(R.id.first_menu);
        main_lay = findViewById(R.id.main_menu);
        drink_lay = findViewById(R.id.drink_menu);
        dessert_lay = findViewById(R.id.dessert_menu);

        menu_view.add(findViewById(R.id.first_menu));
        menu_view.add(findViewById(R.id.main_menu));
        menu_view.add(findViewById(R.id.drink_menu));
        menu_view.add(findViewById(R.id.dessert_menu));


        cartBack = (ArrayList<Dish>) getIntent().getSerializableExtra("cart");
        if (cartBack != null)
            cart = cartBack;

        cart_id_back = (ArrayList<Integer>) getIntent().getSerializableExtra("cart_id");
        if (cart_id_back != null)
            cart_id = cart_id_back;



    }

    private void intAdapter(ArrayList<Dish> list) {

        menuCardAdapter = new MenuCardAdapter(this, list);
        recyclerView.setAdapter((menuCardAdapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void intDish() {
        arr[0] = new Dish(1, "ספגטי בולונז", "ממש טעים ממש טעיםממש טעיםממש טעיםממש טעיםממש טעיםממשים", 95, images[0]);
        arr[1] = new Dish(2, "פיצה פיטריות", "ממש טעים ממש טעיםממש טעיםממש טעיםממעים", 84, images[1]);
        arr[2] = new Dish(3, "המבורגר", "ממש טעים ממש טעיםממש טעיםממש טעיםטעים", 100.5, images[2]);
        arr[3] = new Dish(4, "נודלס", "ממש טעים ממש טעיםממש טעיםממש טעיםממש טמש טעים", 72, images[3]);

        dessert_arr[0] = new Dish(5, "עוגת מוס שוקולד", "ממש טעים ממש טעיםממש טעיםממש טעיםממש טמש טעים", 65, images[4]);
        dessert_arr[1] = new Dish(6, "סופלה שוקולד", "ממש טעים ממש טעיםממש טעיםממש טעיםממש טמש טעים", 44, images[5]);

    }


    @Override
    public void onClick(View v) {

        if (menu_view.contains(v)) {
            if (select_button != null) {
                select_button.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
                select_button.setTextColor(Color.parseColor("#808080"));
            }
            select_button = getButton(v);
            Toast.makeText(test2.this, select_button.getText(), Toast.LENGTH_LONG).show();
            select_button.setBackgroundColor(Color.parseColor("#3B5BBDED"));
            select_button.setTextColor(Color.parseColor("#1684E4"));
        }
        switch (v.getId()) {
            case R.id.first_menu:
                break;
            case R.id.main_menu:
                intAdapter(mains);
                break;
            case R.id.drink_menu:
                break;
            case R.id.dessert_menu:
                intAdapter(dessert);
                break;
<<<<<<< HEAD
            case R.id.cart:
                if(cart.isEmpty())
                {
                    return;
                }
                Intent i=new Intent(test2.this,CartActivity.class);
                i.putExtra("cart",cart);
                i.putExtra("cart_id",cart_id);
                startActivity(i);
                break;


=======
>>>>>>> 699a77898240aaf05429ee443fd67ed37fc5238e
        }

    }

    private MaterialButton getButton(View v) {
        MaterialButton button = null;
        switch (v.getId()) {
            case R.id.first_menu:
                button = first_lay;
                break;
            case R.id.main_menu:
                button = main_lay;
                break;
            case R.id.drink_menu:
                button = drink_lay;
                break;
            case R.id.dessert_menu:
                button = dessert_lay;
                break;
        }
        return button;
    }

    private void addToCart(Dish dish) {

        int index = CheckCartExist(dish.getID());

        if (index != -1) {
            cart.get(index).setAmount(dish.getAmount());
            return;
        }

        cart.add(dish);
        cart_id.add(dish.getID());
    }

    private int CheckCartExist(int id)
    {
         return cart_id.indexOf(id);
    }



    public void showPopUpWindow(Dish dish) {


        int index = CheckCartExist(dish.getID());

        if(index!=-1)
        {
            dish=cart.get(index);
        }
        dishDialog = new DishDialog(dish);
        dishDialog.show(getSupportFragmentManager(), "dish dialog");

    }



    @Override
    public void AddDish(Dish dish) {
        addToCart(dish);
        dishDialog.dismiss();
    }
}