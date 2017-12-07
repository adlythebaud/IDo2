package com.mycabbages.teamavatar.ido2;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.view.WindowManager;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mycabbages.teamavatar.ido2.View.MenuTabsView;
import com.mycabbages.teamavatar.ido2.adapter.MainPagerAdapter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseUser user;

    public static ArrayList<Goal> goals;
    ListView listView;

    Date date;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // To ensure the editText is not covered up by the soft keyboard in the TextFragment
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View background = findViewById(R.id.middle_background_view);
        ViewPager viewPager = (ViewPager)findViewById(R.id.middle_viewpager);
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1); // Sets initial fragment to be GoalsFragment

        MenuTabsView menuTabsView = (MenuTabsView) findViewById(R.id.am_menu_tabs);
        menuTabsView.setUpWithViewPager(viewPager);

        user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        String firstName = mDatabase.child("users").child(user.getUid()).child("firstName").getKey();





        //listView = new ListView(findViewById(R.id.goal_list));



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
    }
}
