package com.mycabbages.teamavatar.ido2.fragment;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.MenuPopupWindow;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A Base class for the fragments we will be using.
 *
 * @author Preston
 */

public abstract class BaseFragment extends Fragment {
    private View mRoot;

    /**
     * Creates the fragment recieved by inflating its view.
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(getLayoutResId(), container, false);
        inOnCreateView(mRoot, container, savedInstanceState);
        return mRoot;
    }

    /**
     * Sends the Layout Resource ID.
     *
     * @return The layout resource ID
     */
    @LayoutRes
    public abstract int getLayoutResId();

    public abstract void inOnCreateView(View root, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);
}
