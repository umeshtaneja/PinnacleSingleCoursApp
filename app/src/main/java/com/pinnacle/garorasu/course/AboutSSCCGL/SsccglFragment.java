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
public class SsccglFragment extends Fragment {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;

    public SsccglFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_ssccgl, container, false);

        tv1=(TextView)v.findViewById(R.id.cgl1);
        tv2=(TextView)v.findViewById(R.id.cgl2);
        tv3=(TextView)v.findViewById(R.id.cgl3);
        tv4=(TextView)v.findViewById(R.id.cgl4);
        tv5=(TextView)v.findViewById(R.id.cgl5);
        tv6=(TextView)v.findViewById(R.id.cgl6);
        tv7=(TextView)v.findViewById(R.id.cgl7);


        Typeface face1= Typeface.createFromAsset(getActivity().getAssets(), "fonts/CrimsonText-Roman.ttf");
        tv1.setTypeface(face1);

        Typeface face2= Typeface.createFromAsset(getActivity().getAssets(), "fonts/RobotoSlab-Regular.ttf");
        tv2.setTypeface(face2);

        Typeface face3= Typeface.createFromAsset(getActivity().getAssets(), "fonts/CrimsonText-Roman.ttf");
        tv3.setTypeface(face3);

        Typeface face4= Typeface.createFromAsset(getActivity().getAssets(), "fonts/RobotoSlab-Regular.ttf");
        tv4.setTypeface(face4);

        Typeface face5= Typeface.createFromAsset(getActivity().getAssets(), "fonts/CrimsonText-Roman.ttf");
        tv5.setTypeface(face5);

        Typeface face6= Typeface.createFromAsset(getActivity().getAssets(), "fonts/RobotoSlab-Regular.ttf");
        tv6.setTypeface(face6);

        Typeface face7= Typeface.createFromAsset(getActivity().getAssets(), "fonts/CrimsonText-Roman.ttf");
        tv7.setTypeface(face7);




        return v;
    }

}
