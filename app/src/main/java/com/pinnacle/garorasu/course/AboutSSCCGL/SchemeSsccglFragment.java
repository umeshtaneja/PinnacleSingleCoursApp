package com.pinnacle.garorasu.course.AboutSSCCGL;


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
public class SchemeSsccglFragment extends Fragment {
    TextView tv1,tv2,tv3,tv4;

    public SchemeSsccglFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_scheme_ssccgl, container, false);
        tv1=(TextView)v.findViewById(R.id.scheme1);
        tv2=(TextView)v.findViewById(R.id.scheme2);
        tv3=(TextView)v.findViewById(R.id.scheme3);
        tv4=(TextView)v.findViewById(R.id.scheme4);

        Typeface face1= Typeface.createFromAsset(getActivity().getAssets(), "fonts/RobotoSlab-Regular.ttf");
        tv1.setTypeface(face1);

        Typeface face2= Typeface.createFromAsset(getActivity().getAssets(), "fonts/CrimsonText-Roman.ttf");
        tv2.setTypeface(face2);
        Typeface face3= Typeface.createFromAsset(getActivity().getAssets(), "fonts/RobotoSlab-Regular.ttf");
        tv1.setTypeface(face3);

        Typeface face4= Typeface.createFromAsset(getActivity().getAssets(), "fonts/CrimsonText-Roman.ttf");
        tv2.setTypeface(face4);




        return v;
    }

}
