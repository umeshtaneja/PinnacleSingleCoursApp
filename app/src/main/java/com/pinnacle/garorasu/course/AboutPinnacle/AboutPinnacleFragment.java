package com.pinnacle.garorasu.course.AboutPinnacle;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pinnacle.garorasu.course.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutPinnacleFragment extends Fragment {
    TextView tv1,tv2;


    public AboutPinnacleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_about_pinnacle, container, false);

        tv1=(TextView)v.findViewById(R.id.Pinnacle1);
        tv2=(TextView)v.findViewById(R.id.Pinnacle2);

        Typeface face= Typeface.createFromAsset(getActivity().getAssets(), "fonts/RobotoSlab-Regular.ttf");
        tv1.setTypeface(face);

        Typeface face1= Typeface.createFromAsset(getActivity().getAssets(), "fonts/CrimsonText-Roman.ttf");
        tv2.setTypeface(face1);





        return v;
    }

}
