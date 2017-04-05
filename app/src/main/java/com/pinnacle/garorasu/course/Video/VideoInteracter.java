package com.pinnacle.garorasu.course.Video;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class VideoInteracter implements VideoInteracterView {
    private final VideoPresenter presenter;
    DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("videos");


    public VideoInteracter(VideoPresenter videoPresenter) {
        this.presenter=videoPresenter;
    }

    @Override
    public void requestVideo() {
        ArrayList<Video> allVideo = VideoInfo.getAllVideo();

        for(Video video:allVideo){
            presenter.sendVideoToAdapter(video);
        }
        presenter.onSuccess();

    }

    }

