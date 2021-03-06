package com.pinnacle.garorasu.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.pinnacle.garorasu.course.Lesson.Lesson;
import com.pinnacle.garorasu.course.Practice.Practice;
import com.pinnacle.garorasu.course.Video.Video;
import com.pinnacle.garorasu.course.Video.VideoFragment;

public class DetailActivity extends AppCompatActivity implements DetailActivityView , View.OnClickListener{
    int position;


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Intent intent = getIntent();
            position = intent.getExtras().getInt("position");
            Log.d("position", String.valueOf(position));
            setContentView(R.layout.activity_detail);


        switch (position) {

                case 0: {
                  getSupportFragmentManager().beginTransaction().replace(R.id.container, new LessonDisplayFragment()).commit();
                   break;
                }
                case 1: {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new VideoPlayFragment()).commit();
                    Log.d("position","video play fragment selected");
                    break;
                }
                case 2: {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new PracticeDisplayFragment()).commit();
                    break;
                }
                default: {}

            }

        }

    @Override
    public void lessonSelected(Lesson lesson) {

    }

    @Override
    public void practiceSelected(Practice practice) {

    }

    @Override
    public void videoSelected(Video video) {

    }

    @Override
    public void onClick(View v) {

    }
}
