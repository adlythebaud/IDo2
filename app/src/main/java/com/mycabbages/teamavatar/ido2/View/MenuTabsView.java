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
 * Controller for the MenuTabs on the main three fragments.
 *
 * @author Preston
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

    /**
     * Initializes the menu tabs
     *
     * @param context The context view which is currently displayed
     */
    public MenuTabsView(@NonNull Context context) {
        this(context, null);
    }

    /**
     * Allows access to XML Layout attributes and context that is currently displayed
     *
     * @param context The context view which is currently displayed
     * @param attrs Allows you to pull Attributes from the XML Layouts
     */
    public MenuTabsView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     *
     *
     * @param context The context view which is currently displayed
     * @param attrs Allows you to pull Attributes from the XML Layouts
     * @param defStyleAttr
     */
    public MenuTabsView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    /**
     * Sets up the Menu Tabs with the page viewer to synchronize the two.
     * @param viewPager
     */
    public void setUpWithViewPager(final ViewPager viewPager) {
        viewPager.addOnPageChangeListener(this);
        // Add an on click listener for the left button
        mStartImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 0) {
                    viewPager.setCurrentItem(0);
                }
            }
        });

        // Add an on click listener for the middle button
        mBottomImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 1) {
                    viewPager.setCurrentItem(1);
                }
            }
        });

        // Add an on click listener for the right button
        mEndImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem() != 2) {
                    viewPager.setCurrentItem(2);
                }
            }
        });
    }

    /**
     * Initializes the Menu Tabs
     */
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

    /**
     * Is called after the fragment has been scrolled. Calls the code to set the background color
     * and translate the view menu tabs
     *
     * @param position of the Fragments
     * @param positionOffset The offset the page is moved from the settled position
     * @param positionOffsetPixels The offset the page is moved from the settled position in pixels
     */
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

    /**
     * Scales the view menu tabs according to the fractional offset
     *
     * @param fractionFromCenter The fractional offset from the center the page is
     * @param position The fragment position we are currently in
     */
    private void scaleSelection(float fractionFromCenter, int position) {
        float scale = .8f + ((1 - fractionFromCenter) * .2f);

        mBottomImage.setScaleY(scale);
        mBottomImage.setScaleX(scale);
    }

    /**
     * Moves the views according to the fractional offset from the center.
     * @param fractionFromCenter The fractional offset from the center the page is
     */
    private void moveViews(float fractionFromCenter) {
        mStartImage.setTranslationX(fractionFromCenter * endViewsTranslationX);
        mEndImage.setTranslationX(-fractionFromCenter * endViewsTranslationX);
    }

    /**
     * Changes the color of your view items according to the fractional offset from the center
     * the page is.
     * @param fractionFromCenter The fractional offset from the center the page is
     */
    private void setColor(float fractionFromCenter) {
        int color = (int) argbEvaluator.evaluate(fractionFromCenter, centerColor, siderColor);
        mCenterImage.setColorFilter(color);
        mStartImage.setColorFilter(color);
        mEndImage.setColorFilter(color);
    }
}
