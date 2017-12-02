package com.mycabbages.teamavatar.ido2.View;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mycabbages.teamavatar.ido2.R;

/**
 * Created by Preston on 11/17/2017.
 */

public class MenuTabsView extends FrameLayout implements ViewPager.OnPageChangeListener{
    final static String cameraLog = "Camera_log";

    private ImageView mCenterImage;
    private ImageView mStartImage;
    private ImageView mBottomImage;
    private ImageView mEndImage;
    private View mIndicator;
    private int centerColor;
    private int siderColor;

    private int endViewsTranslationX;
    private int indicatorTranslationX; //The distance the indicator will move left and right
    private int centerTranslationY;

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

    public void setUpWithViewPager(final ViewPager viewPager) {
        viewPager.addOnPageChangeListener(this);

        mStartImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 0) {
                    viewPager.setCurrentItem(0);
                }
            }
        });

        mBottomImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 1) {
                    viewPager.setCurrentItem(1);
                }
            }
        });

        mEndImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 2) {
                    viewPager.setCurrentItem(2);
                }
            }
        });
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_menu_tabs,this, true);
        mCenterImage = findViewById(R.id.vmt_center_image);
        mStartImage = findViewById(R.id.vmt_start_image);
        mBottomImage = findViewById(R.id.vmt_bottom_image);
        mEndImage = findViewById(R.id.vmt_end_image);
        mIndicator = findViewById(R.id.vmt_indicator);

        argbEvaluator = new ArgbEvaluator();
        centerColor = ContextCompat.getColor(getContext(), R.color.white);
        siderColor = ContextCompat.getColor(getContext(), R.color.dark_grey);

        indicatorTranslationX = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 80, getResources().getDisplayMetrics());

        mBottomImage.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                endViewsTranslationX = (int) ((mBottomImage.getX() - mStartImage.getX())  - indicatorTranslationX);
                mBottomImage.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                centerTranslationY = getHeight() - mBottomImage.getBottom();
            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == 0) {
            setColor(1 - positionOffset);
            moveViews(1 - positionOffset);

            scaleSelection(1 - positionOffset, position);

            mIndicator.setTranslationX((positionOffset - 1) * indicatorTranslationX);
        } else if (position == 1) {
            setColor(positionOffset);
            moveViews(positionOffset);

            scaleSelection(positionOffset, position);

            mIndicator.setTranslationX(positionOffset * indicatorTranslationX);
        } else if (position == 2) {
        } else if (position == 3) {

        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void scaleSelection(float fractionFromCenter, int position) {
        float scale = .8f + ((1 - fractionFromCenter) * .2f);

        mBottomImage.setScaleY(scale);
        mBottomImage.setScaleX(scale);
    }

    private void moveViews(float fractionFromCenter) {
        mStartImage.setTranslationX(fractionFromCenter * endViewsTranslationX);
        mEndImage.setTranslationX(-fractionFromCenter * endViewsTranslationX);
    }

    private void setColor(float fractionFromCenter) {
        int color = (int) argbEvaluator.evaluate(fractionFromCenter, centerColor, siderColor);
        mCenterImage.setColorFilter(color);
        mStartImage.setColorFilter(color);
        mEndImage.setColorFilter(color);
    }
}
