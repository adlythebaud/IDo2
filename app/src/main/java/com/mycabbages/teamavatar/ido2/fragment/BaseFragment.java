package com.mycabbages.teamavatar.ido2.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.MenuPopupWindow;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Preston on 11/17/2017.
 */

public abstract class BaseFragment extends Fragment {

    private View mRoot;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(getLayoutResId(), container, false);
        inOnCreateView(mRoot, container, savedInstanceState);
        return mRoot;
    }

    @LayoutRes
    public abstract int getLayoutResId();

    public abstract void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}
