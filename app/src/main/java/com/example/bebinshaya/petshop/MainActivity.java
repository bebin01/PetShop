package com.example.bebinshaya.petshop;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3, R.drawable.slide4 };
        flipper = findViewById(R.id.flipper);

        //for loop
        for(int i = 0; i < images.length; i++){
            flipperImages(images[i]);
        }for (int image : images){
            flipperImages(image);
        }


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.nav_setting:
                Toast.makeText(this, "Setting is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.nav_help:
                Toast.makeText(this, "Help is selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.nav_faq:
                Toast.makeText(this, "FAQ is selected", Toast.LENGTH_SHORT).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_submenu, menu);
        return true;
    }


     public void flipperImages(int image){

         ImageView imageView = new ImageView(this);
         imageView.setBackgroundResource(image);

         flipper.addView(imageView);
         flipper.setFlipInterval(4000);
         flipper.setAutoStart(true);

         //animation
         flipper.setInAnimation(this, android.R.anim.slide_in_left);
         flipper.setOutAnimation(this, android.R.anim.slide_out_right);

     }


}
