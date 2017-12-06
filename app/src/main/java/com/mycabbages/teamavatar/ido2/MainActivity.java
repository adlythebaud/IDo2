package com.mycabbages.teamavatar.ido2;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mycabbages.teamavatar.ido2.View.MenuTabsView;
import com.mycabbages.teamavatar.ido2.adapter.MainPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private FirebaseUser user;



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

        user = FirebaseAuth.getInstance().getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();
//        String firstName = mDatabase.child("users").child(user.getUid()).child("firstName").getKey();





//        final ListView goalList = (ListView) findViewById(R.id.goal_list);
//        List<Goal> goals = new ArrayList<>();
//        goals.add()


//        final List<String> goal_list = new ArrayList<String>(Arrays.asList(goals));
//
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
//                (this, R.layout.goal_view , goal_list);

        // Add a header to the ListView
//        LayoutInflater inflater = getLayoutInflater();
//        ViewGroup header = (ViewGroup)inflater.inflate(R.layout.header,goalList,false);
        //goalList.addHeaderView(header);

        //DataBind ListView with items from ArrayAdapter
        //goalList.setAdapter(arrayAdapter);



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
