package com.mycabbages.teamavatar.ido2.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mycabbages.teamavatar.ido2.R;

/**
 * Created by Preston on 11/17/2017.
 */

public class MenuTabsView extends FrameLayout implements ViewPager.OnPageChangeListener {

    private ImageView mCenterImage;
    private ImageView mStartImage;
    private ImageView mBottomImage;
    private ImageView mEndImage;
    private View mIndicator;

    public MenuTabsView(@NonNull Context context) {
        this(context, null);
    }

    public MenuTabsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuTabsView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_menu_tabs,this, false);
        mCenterImage =(ImageView) findViewById(R.id.vmt_center_image);
        mStartImage =(ImageView) findViewById(R.id.vmt_start_image);
        mBottomImage =(ImageView) findViewById(R.id.vmt_bottom_image);
        mEndImage =(ImageView) findViewById(R.id.vmt_end_image);

        mIndicator = findViewById(R.id.vmt_indicator);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
