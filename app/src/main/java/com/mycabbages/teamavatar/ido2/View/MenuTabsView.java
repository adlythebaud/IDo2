package com.mycabbages.teamavatar.ido2.View;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
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
    private int centerColor;
    private int siderColor;

    private ArgbEvaluator argbEvaluator;

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

    public void setUpWithViewPager(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(this);
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_menu_tabs,this, true);
        mCenterImage =(ImageView) findViewById(R.id.vmt_center_image);
        mStartImage =(ImageView) findViewById(R.id.vmt_start_image);
        mBottomImage =(ImageView) findViewById(R.id.vmt_bottom_image);
        mEndImage =(ImageView) findViewById(R.id.vmt_end_image);
        mIndicator = findViewById(R.id.vmt_indicator);

        argbEvaluator = new ArgbEvaluator();
        centerColor = ContextCompat.getColor(getContext(), R.color.white);
        siderColor = ContextCompat.getColor(getContext(), R.color.dark_grey);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == 0) {
            setColor(1 - positionOffset);
        } else if (position == 1) {
            setColor(positionOffset);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void setColor(float fractionFromCenter) {
        int color = (int) argbEvaluator.evaluate(fractionFromCenter, centerColor, siderColor);
        mCenterImage.setColorFilter(color);
        mStartImage.setColorFilter(color);
        mEndImage.setColorFilter(color);
    }
}
