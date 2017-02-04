package sohba.sohba_travel.com.la7zaapp.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hazem
 */
public class MainPagerAdapter extends FragmentStatePagerAdapter {

    private final static int COUNT = 3;

    private final static int HORIZONTAL = 0;
    private final static int TWO_WAY = 1;


    private final static int home = 0;
    private final static int task = 1;

    public MainPagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {
        if (position==0){
            return new homeFragment();

        }else if(position==1){
            return new urgentFragment();
        }else{
            return new taskFragment();
        }
    }

    @Override
    public int getCount() {
        return COUNT;
    }
}
