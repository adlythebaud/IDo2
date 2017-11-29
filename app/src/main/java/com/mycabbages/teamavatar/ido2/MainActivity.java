package com.mycabbages.teamavatar.ido2;


import android.media.Image;
import android.provider.ContactsContract;
import android.app.Notification;
import android.content.SharedPreferences;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mycabbages.teamavatar.ido2.View.MenuTabsView;
import com.mycabbages.teamavatar.ido2.adapter.MainPagerAdapter;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View background = findViewById(R.id.middle_background_view);
        ViewPager viewPager = (ViewPager)findViewById(R.id.middle_viewpager);
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1); // Sets initial fragment to be GoalsFragment

        MenuTabsView menuTabsView = (MenuTabsView) findViewById(R.id.am_menu_tabs);
        menuTabsView.setUpWithViewPager(viewPager);

        final int colorBlue = ContextCompat.getColor(this, R.color.light_blue);
        final int colorPurple = ContextCompat.getColor(this, R.color.light_purple);



        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//


    }

}
