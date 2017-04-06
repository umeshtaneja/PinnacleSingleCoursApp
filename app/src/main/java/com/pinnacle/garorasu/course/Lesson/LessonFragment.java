package com.pinnacle.garorasu.course.Lesson;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pinnacle.garorasu.course.Explore.Subject;
import com.pinnacle.garorasu.course.R;
import com.pinnacle.garorasu.course.SimpleDividerItemDecoration;

public class LessonFragment extends Fragment implements LessonView {
    private RecyclerView recyclerView;
    private LessonAdapter adapter;
    private ProgressBar progressBar;
    private TextView textview;
    private Subject subject;
    LessonListener mLessonListener;
   NestedScrollView revealLesson;


    public LessonFragment() {
        // Required empty public constructor
    }

    public static LessonFragment newInstance(Subject subject) {

        Bundle args = new Bundle();
        LessonFragment fragment = new LessonFragment();
        args.putSerializable("subject",subject);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.lessonfragment, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.lesson_recyclerView);
        textview = (TextView) view.findViewById(R.id.lesson_textview);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_lesson_fragment);
        if (getArguments() != null) {
            subject = (Subject) getArguments().getSerializable("subject");
        }


        adapter = new LessonAdapter(this, getContext(), subject.getColor());
        adapter.requstLesson();
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
                   toggleInformationView(view);
                }
            });
        }
            return view;
        }


  private void toggleInformationView(View view) {
        revealLesson = (NestedScrollView) view.findViewById(R.id.revealLesson);

        int cx = (revealLesson.getLeft() + revealLesson.getRight());
        int cy = (revealLesson.getTop() + revealLesson.getBottom());
        int finalRadius = (int) Math.hypot((double) revealLesson.getWidth(), (double) revealLesson.getHeight());

        Animator anim = ViewAnimationUtils.createCircularReveal(revealLesson, cx, cy, 0, finalRadius);
        revealLesson.setVisibility(View.VISIBLE);
        anim.setDuration(1000);
        anim.setInterpolator(new AccelerateDecelerateInterpolator());
        anim.start();

    }

    @Override
    public void onLessonClick(Lesson lesson) {
        mLessonListener.lessonSelect(lesson);
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
        if (context instanceof LessonListener) {
            mLessonListener = (LessonListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement LessonListener");
        }
    }
}