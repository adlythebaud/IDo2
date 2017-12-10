package com.mycabbages.teamavatar.ido2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.mycabbages.teamavatar.ido2.R;

/**
 * Created by Preston on 11/17/2017
 */
public class MiscFragment extends BaseFragment {

    /*
    * Creates a MiscFragment and returns it
    */
    public static MiscFragment create() {
        return new MiscFragment();
    }

    /*
    * Returns the Misc Fragment Resource Resource ID
    */
    @Override
    public int getLayoutResId() {
        return R.layout.fragment_misc;
    }

    /*
    * Called after onCreateView after the layout is inflated.
    */
    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    }
}
