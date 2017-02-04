package sohba.sohba_travel.com.la7zaapp.Activities;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.instabug.library.InstabugTrackingDelegate;

import sohba.sohba_travel.com.la7zaapp.R;
import sohba.sohba_travel.com.la7zaapp.fragment.MainPagerAdapter;
import sohba.sohba_travel.com.la7zaapp.util.CustomTypefaceSpan;
import sohba.sohba_travel.com.la7zaapp.view.CustomViewPager;


public class mainActivity extends BaseActivity {




    private CustomViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__);
//        setupWindowAnimations();
        setupToolbar();




        viewPager = (CustomViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(2);
//        setupViewPager(viewPager);
        viewPager.setCurrentItem(1);
        viewPager.setPagingEnabled(true);



        final NavigationTabStrip navigationTabStrip = (NavigationTabStrip) findViewById(R.id.nts);
        navigationTabStrip.setTitles("Timeline", "Urgent","Category");
        navigationTabStrip.setViewPager(viewPager);


    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        InstabugTrackingDelegate
                .notifyActivityGotTouchEvent(ev,this);
        return super.dispatchTouchEvent(ev);
    }

//    private void setupWindowAnimations() {
//        // Re-enter transition is executed when returning to this activity
//        Slide slideTransition = new Slide();
//        slideTransition.setSlideEdge(Gravity.LEFT);
//        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
//        getWindow().setReenterTransition(slideTransition);
//        getWindow().setExitTransition(slideTransition);
//    }



    private void setupToolbar() {
        final ActionBar ab = getActionBarToolbar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        Typeface font = Typeface.createFromAsset(getAssets(), "diavlo/Diavlo_BOLD_II_37.otf");
        SpannableString mNewTitle = new SpannableString("la7za");
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        ab.setTitle(mNewTitle);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                openDrawer();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     * Is the container present? If so, we are using the two-pane layout.
     *
     * @return true if the two pane layout is used.
     */
//    private boolean isTwoPaneLayoutUsed() {
//        return findViewById(R.id.article_detail_container) != null;
//    }
    @Override
    protected int getSelfNavDrawerItem() {
        int r;
        r=R.id.home_m_lm;


        return r;


    }

    @Override
    public boolean providesActivityToolbar() {
        return true;
    }


}
