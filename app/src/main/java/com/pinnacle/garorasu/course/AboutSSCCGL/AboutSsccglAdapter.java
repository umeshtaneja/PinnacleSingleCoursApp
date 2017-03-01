package com.pinnacle.garorasu.course.AboutSSCCGL;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by ideal on 2/23/2017.
 */
public class AboutSsccglAdapter extends FragmentPagerAdapter {
    String[] a={"SSC CGL","Scheme of SSC CGL"};
    public AboutSsccglAdapter(FragmentManager supportFragmentManager, Object applicationContext) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SsccglFragment();
            case 1:
                return new SchemeSsccglFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return a.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return a[position];
    }

}
