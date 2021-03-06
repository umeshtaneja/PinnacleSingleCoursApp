package com.pinnacle.garorasu.course.Lesson;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import com.pinnacle.garorasu.course.R;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.ViewHolder> implements LessonAdapterView {

    private final Context context;
    private final ArrayList<Lesson> allLessons = new ArrayList<>();
    private final LessonPresenterView lessonPresenter;
    private final String color;

    public LessonAdapter(LessonView lessonView,Context context,String color){
        this.context = context;
        this.color = color;
        lessonPresenter = new LessonPresenter(this,lessonView);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_list_item, parent, false);
        return new ViewHolder(v);

    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lesson lesson = allLessons.get(position);
        holder.mlessonserialno.setText(lesson.getSerialno());
        holder.mlessonTitle.setText(lesson.getTitle());
        holder.mlessondescription.setText(lesson.getLessonDescription());
        setScaleAnimation(holder.itemView);
    }
    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }
    @Override
    public int getItemCount() {
        return allLessons.size();
    }

    @Override
    public void addLesson(Lesson lesson) {
        allLessons.add(lesson);
        notifyItemInserted(allLessons.size()-1);
    }

    @Override
    public void requstLesson() {
        lessonPresenter.requestLesson();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mlessonTitle,mlessondescription,mlessonserialno;

        public ViewHolder(View itemView) {
            super(itemView);
            mlessonserialno=(TextView)itemView.findViewById(R.id.lesson_serial_no);
            mlessonTitle = (TextView) itemView.findViewById(R.id.lesson_title);
            mlessondescription = (TextView) itemView.findViewById(R.id.lesson_brief);
            mlessonserialno.setBackgroundResource(R.drawable.circletextshape);
            GradientDrawable g = (GradientDrawable) mlessonserialno.getBackground().getCurrent();
            g.setColor(Color.parseColor(color));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    lessonPresenter.onLessonSelect(allLessons.get(getAdapterPosition()));

                }
            });

        }
    }
}
