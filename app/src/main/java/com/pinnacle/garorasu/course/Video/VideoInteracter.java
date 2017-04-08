package com.pinnacle.garorasu.course.Video;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class VideoInteracter implements VideoInteracterView {
    private final VideoPresenter presenter;
  //  DatabaseReference firebaseDatabase = FirebaseDatabase.getInstance().getReference("videos");


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();
    DatabaseReference myTopPostsQuery  = database.getReference("videos");

    public VideoInteracter(VideoPresenter videoPresenter) {
        this.presenter=videoPresenter;
    }

    @Override
    public void requestVideo() {
/*        ArrayList<Video> allVideo = VideoInfo.getAllVideo();

        for(Video video:allVideo){
            presenter.sendVideoToAdapter(video);
        }
        presenter.onSuccess();
*/

        read_data();
    }


    public void read_data() {
        // My top posts by number of stars
        myTopPostsQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    // TODO: handle the post
                    Video video = postSnapshot.getValue(Video.class);

                    Log.d("Title is", String.valueOf(video.getTitle()));
                    Log.d("serialno is", String.valueOf(video.getSerialno()));
                    Log.d("Url is", String.valueOf(video.getUrl()));
                    Log.d("Description is", String.valueOf(video.getvideoDescription()));
                    presenter.sendVideoToAdapter(video);
                }
                presenter.onSuccess();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w("one", "loadPost:onCancelled", databaseError.toException());
                // ...
            }
        });
    }

}

