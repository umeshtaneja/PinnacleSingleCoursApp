package com.pinnacle.garorasu.course.AboutSSCCGL;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pinnacle.garorasu.course.R;


public class AboutSsccglFragment extends Fragment {

    ViewPager v11;
    TabLayout t11;
    public AboutSsccglFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about_ssccgl, container, false);




        t11=(TabLayout) view.findViewById(R.id.tablayout);
        v11=(ViewPager) view.findViewById(R.id.viewpager);

        v11.setAdapter(new AboutSsccglAdapter(getChildFragmentManager(),getContext()));
        t11.setupWithViewPager(v11);
        t11.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                v11.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                v11.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                v11.setCurrentItem(tab.getPosition());
            }
        });
        return view;
    }

}
