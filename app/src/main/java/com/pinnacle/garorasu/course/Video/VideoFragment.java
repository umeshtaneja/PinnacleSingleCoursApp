package com.pinnacle.garorasu.course.Video;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.R;
import com.pinnacle.garorasu.course.SimpleDividerItemDecoration;

/**
 * Created by Ideal on 2/18/2017.
 */

public class VideoFragment extends Fragment implements VideoView {
    private RecyclerView recyclerView;
    private VideoAdapter adapter;
    private  VideoView view;
    private ProgressBar progressBar;
    private TextView textview;
    private Subject subject;
    VideoListener mVideoListener;



    public VideoFragment() {
        // Required empty public constructor
    }
    public static VideoFragment newInstance(Subject subject) {

        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        args.putSerializable("subject",subject);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View view = inflater.inflate(R.layout.videofragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.video_recyclerView);
        textview=(TextView)view.findViewById(R.id.video_textview);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_video_fragment);
        if(getArguments() != null){
            subject = (Subject) getArguments().getSerializable("subject");
        }

        adapter = new VideoAdapter(this,getContext(),subject.getColor());
        adapter.requstVideo();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new SimpleDividerItemDecoration(getContext()));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    v.removeOnLayoutChangeListener(this);

                }
            });
        }
        return view;
    }

    @Override
    public void onVideoClick(Video video) {
        mVideoListener.videoSelect(video);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

        recyclerView.setVisibility(View.INVISIBLE);
        textview.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        recyclerView.setVisibility(View.VISIBLE);

        progressBar.setVisibility(View.INVISIBLE);
        textview.setVisibility(View.INVISIBLE);
    }

    @Override
    public void networkUnavailable() {
        textview.setVisibility(View.VISIBLE);

        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof VideoListener) {
            mVideoListener = (VideoListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement VideoListener");
        }
    }
}
