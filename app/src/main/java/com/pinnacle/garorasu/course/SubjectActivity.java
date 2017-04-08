package com.pinnacle.garorasu.course;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.Lesson.Lesson;
import com.pinnacle.garorasu.course.Lesson.LessonListener;
import com.pinnacle.garorasu.course.Practice.Practice;
import com.pinnacle.garorasu.course.Practice.PracticeListener;
import com.pinnacle.garorasu.course.Video.Video;
import com.pinnacle.garorasu.course.Video.VideoListener;

public class SubjectActivity extends AppCompatActivity implements LessonListener,PracticeListener,VideoListener {
    private Subject subjectObject;
    String subject;
    Toolbar toolbar;
    String color;
    ViewPager subjectViewPager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        Log.d("SubjectActivity","Transparent Navigation Bar");


        Intent i =getIntent();
        subjectObject = (Subject) i.getSerializableExtra("subjectObject");
        subject=subjectObject.getTitle();
        color = subjectObject.getColor();
        toolbar=(Toolbar)findViewById(R.id.toolbar);


        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(subjectObject.getTitle());
            Log.d("khkj","jkhjkhkjjk");
        }
        // Set background color dynamically!!!

        toolbar.setBackgroundColor(Color.parseColor(color));


        Window window=getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLACK);

        subjectViewPager=(ViewPager) findViewById(R.id.v1);
        subjectViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),getApplicationContext(),subjectObject));

        subjectViewPager.setPageTransformer(false, new ViewPager.PageTransformer() {
            //Added animation on view Pager!!!

            @Override
            public void transformPage(View page, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setAlpha(normalizedposition);
            }
        });

        tabLayout=(TabLayout) findViewById(R.id.t1);
        tabLayout.setupWithViewPager(subjectViewPager);

        tabLayout.setBackgroundColor(Color.parseColor(color));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                subjectViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                subjectViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                subjectViewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void lessonSelect(Lesson lesson) {
        Log.d("SubjectActivity","lesson select"+lesson.getTitle());


        String url = "https://firebasestorage.googleapis.com/v0/b/kuch-hee.appspot.com/o/23s.html?alt=media&token=2a1852f4-8f33-48e4-a9d2-81a9a814e2d0";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.blue));

    }

    @Override
    public void videoSelect(Video video) {
        Intent intent= new Intent(getApplicationContext(),DetailActivity.class);
        intent.putExtra("position",1);
        Log.d("SubjectActivity","video select"+video.getTitle());
        //intent.putExtra("subject", subject.tColor());
        startActivity(intent);

    }
    
    @Override
    public void practiceSelect(Practice practice) {
        Log.d("SubjectActivity","practice selected"+practice.getTitle());


        String url = "https://firebasestorage.googleapis.com/v0/b/kuch-hee.appspot.com/o/23s.html?alt=media&token=2a1852f4-8f33-48e4-a9d2-81a9a814e2d0";
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.blue));
    }

}

