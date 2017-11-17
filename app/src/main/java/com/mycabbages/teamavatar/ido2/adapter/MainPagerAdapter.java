package com.mycabbages.teamavatar.ido2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.mycabbages.teamavatar.ido2.fragment.ChatFragment;
import com.mycabbages.teamavatar.ido2.fragment.GoalsFragment;
import com.mycabbages.teamavatar.ido2.fragment.MiscFragment;

/**
 * Created by Preston on 11/17/2017.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return MiscFragment.create();
            case 1:
                return GoalsFragment.create();
            case 2:
                return ChatFragment.create();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}