package com.mycabbages.teamavatar.ido2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.mycabbages.teamavatar.ido2.R;

/**
 * Created by Preston on 11/28/2017.
 */

public class TextFragment extends BaseFragment {

    public static TextFragment create () { return new TextFragment(); }
    @Override
    public int getLayoutResId() { return R.layout.fragment_text;}

    @Override
    public void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    }
}
