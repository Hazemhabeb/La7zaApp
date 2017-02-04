package sohba.sohba_travel.com.la7zaapp.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import sohba.sohba_travel.com.la7zaapp.R;
import sohba.sohba_travel.com.la7zaapp.util.CustomTypefaceSpan;
import sohba.sohba_travel.com.la7zaapp.util.LogUtil;
import sohba.sohba_travel.com.la7zaapp.util.SetFont;

/**
 * The base class for all Activity classes.
 * This class creates and provides the navigation drawer and toolbar.
 * The navigation logic is handled in {@link BaseActivity#goToNavDrawerItem(int)}
 * <p>
 * Created by Andreas Schrade on 14.12.2015.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = LogUtil.makeLogTag( BaseActivity.class );

    protected static final int NAV_DRAWER_ITEM_INVALID = -1;

    private DrawerLayout drawerLayout;
    private Toolbar actionBarToolbar;


    static final String EXTRA_SAMPLE = "sample";
    static final String EXTRA_TYPE = "type";
    static final int TYPE_PROGRAMMATICALLY = 0;
    static final int TYPE_XML = 1;


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate( savedInstanceState );

        setupNavDrawer();

    }

    /**
     * Sets up the navigation drawer.
     */

    private void setupNavDrawer() {
        drawerLayout = (DrawerLayout) findViewById( R.id.drawer_layout );

        if (drawerLayout == null) {
            // current activity does not have a drawer.
            return;
        }

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );

        navigationView.setItemIconTintList( null );

        View hView =  navigationView.getHeaderView(0);
        TextView nav_user = (TextView)hView.findViewById(R.id.nav_name);
        ImageView nav_image=(ImageView)hView.findViewById(R.id.nav_image);

        SetFont setFont = new SetFont();
        setFont.changeFonts(this, (LinearLayout) hView.findViewById(R.id.parent_id));

        nav_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseActivity.this,ProfileActivity.class));
            }
        });
        nav_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseActivity.this,ProfileActivity.class));
            }
        });


//        MenuItem menuItem = navigationView.getMenu().findItem( R.id.home_main_lm );
//        SpannableString s = new SpannableString( menuItem.getTitle() );
//        s.setSpan( new TextAppearanceSpan( this, R.style.TextAppearance ), 0, s.length(), 0 );
//        menuItem.setTitle( s );

//        MenuItem menuItem1 = navigationView.getMenu().findItem(R.id.setting_lm);
//        MenuItem menuItem12 = navigationView.getMenu().findItem(R.id.about_lm);
//        MenuItem menuItem13 = navigationView.getMenu().findItem(R.id.logout_lm);
//        leftmenu_color(menuItem1);leftmenu_color(menuItem12);leftmenu_color(menuItem13);
//        SpannableString s1 = new SpannableString(menuItem1.getTitle());
//        s1.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance), 0, s.length(), 0);
//        menuItem.setTitle(s1);


        /**  to change font for app*/
        Menu m = navigationView.getMenu();
        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem( i );

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem( j );
                    leftmenu_color( subMenuItem );
                    applyFontToMenuItem( subMenuItem );
                }
            }
            //the method we have create in activity
            leftmenu_color( mi );
            applyFontToMenuItem( mi );
        }


        if (navigationView != null) {
            setupDrawerSelectListener( navigationView );
            setSelectedItem( navigationView );

        }


        LogUtil.logD( TAG, "navigation drawer setup finished" );


    }

    private void leftmenu_color(MenuItem menuItem) {
        SpannableString s = new SpannableString( menuItem.getTitle() );
        s.setSpan( new TextAppearanceSpan( this, R.style.TextAppearance ), 0, s.length(), 0 );

        menuItem.setTitle( s );
    }

    /**
     * Updated the checked item in the navigation drawer
     *
     * @param navigationView the navigation view
     */
    private void setSelectedItem(NavigationView navigationView) {
        // Which navigation item should be selected?
        int selectedItem = getSelfNavDrawerItem(); // subclass has to override this method
        navigationView.setCheckedItem( selectedItem );
    }


    /**
     * Creates the item click listener.
     *
     * @param navigationView the navigation view
     */
    private void setupDrawerSelectListener(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        drawerLayout.closeDrawers();
                        onNavigationItemClicked( menuItem.getItemId() );
                        return true;
                    }
                } );
    }

    /**
     * Handles the navigation item click.
     *
     * @param itemId the clicked item
     */
    private void onNavigationItemClicked(final int itemId) {
        if (itemId == getSelfNavDrawerItem()) {
            // Already selected
            closeDrawer();
            return;
        }

        goToNavDrawerItem( itemId );
    }

    /**
     * Handles the navigation item click and starts the corresponding activity.
     *
     * @param item the selected navigation item
     */
    private void goToNavDrawerItem(int item) {
        switch (item) {
            case R.id.home_main_lm:
//                Intent i5 = new Intent( this, mainActivity.class );
//                i5.putExtra( "tab", 0 );
//                transitionTo( i5 );
//                Intent i=new Intent(this,studient_activities.class);
//                i.putExtra("type",1);
//                startActivity(i);
                break;
            case R.id.depart_lm:
//                Intent i5 = new Intent( this, mainActivity.class );
//                i5.putExtra( "tab", 0 );
//                transitionTo( i5 );
//                Intent i1=new Intent(this,studient_activities.class);
//                i1.putExtra("type",2);
//                startActivity(i1);
                break;
            case R.id.home_m_lm:
//                startActivity(new Intent(this,mainActivity.class));
                startActivity(new Intent(this, addRequest.class));

                break;
//            case R.id.contact_lm:
////                startActivity(new Intent(this,party_activity.class));
//
//                break;

            case R.id.favorite_lm:
//                startActivity(new Intent(this,studyActivity.class));

                break;
            case R.id.setting_lm:
//                startActivity(new Intent(this,settings.class));

                break;
        }
    }

//    @SuppressWarnings("unchecked")
//    void transitionTo(Intent i) {
//
//        final Pair<View, String>[] pairs = TransitionHelper.createSafeTransitionParticipants( this, true );
//        ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation( this, pairs );
//        if (i.getExtras()!= null){
//            if (getClass().equals(mainActivity.class)){
//                return;
//            }
//            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(i);
//        }else {
//            startActivity( i, transitionActivityOptions.toBundle() );
//        }
//
//
//
//    }

    /**
     * Provides the action bar instance.
     *
     * @return the action bar.
     */
    protected ActionBar getActionBarToolbar() {
        if (actionBarToolbar == null) {
            actionBarToolbar = (Toolbar) findViewById( R.id.toolbar );
            if (actionBarToolbar != null) {
                setSupportActionBar( actionBarToolbar );
            }
        }
        return getSupportActionBar();
    }


    /**
     * Returns the navigation drawer item that corresponds to this Activity. Subclasses
     * have to override this method.
     */
    protected int getSelfNavDrawerItem() {
        return NAV_DRAWER_ITEM_INVALID;
    }

    protected void openDrawer() {
        if (drawerLayout == null)
            return;

        drawerLayout.openDrawer( GravityCompat.START );
    }

    protected void closeDrawer() {
        if (drawerLayout == null)
            return;

        drawerLayout.closeDrawer( GravityCompat.START );
    }

    public abstract boolean providesActivityToolbar();

    public void setToolbar(Toolbar toolbar) {
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset( getAssets(), "diavlo/Diavlo_BOLD_II_37.otf" );
        SpannableString mNewTitle = new SpannableString( mi.getTitle() );
        mNewTitle.setSpan( new CustomTypefaceSpan( "", font ), 0, mNewTitle.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE );
        mi.setTitle( mNewTitle );
    }


}
