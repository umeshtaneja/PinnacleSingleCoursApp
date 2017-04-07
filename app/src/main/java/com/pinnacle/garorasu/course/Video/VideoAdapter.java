package com.pinnacle.garorasu.course.Video;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.pinnacle.garorasu.course.R;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/18/2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> implements VideoAdapterView {

    private final Context context;

    //private final VideoView videoView;
    private final VideoPresenterView videoPresenter;
    private final String color;
    private final ArrayList<Video> allVideo = new ArrayList<>();

    public static int videoPosition;


    public VideoAdapter(VideoView videoView, Context context,String color) {
        this.context = context;
        this.color = color;
        //  this.videoView = videoView;
        videoPresenter= new VideoPresenter(this, videoView);
    }

    public static int getVideoPosition() {
        return videoPosition;
    }

    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list_item, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(VideoAdapter.ViewHolder holder, int position) {
        Video video = allVideo.get(position);
        holder.mvideoSerialno.setText(video.getSerialno());
        holder.mvideoTitle.setText(video.getTitle());

        holder.mvideodescription.setText(video.getvideoDescription());

        setFadeAnimations(holder.itemView);
    }
       private void setFadeAnimations(View view){
         AlphaAnimation anim = new AlphaAnimation(0.0f,20.f);
          anim.setDuration(18000);
           view.startAnimation(anim);

        }


    @Override
    public int getItemCount() {

        return allVideo.size();
    }

    @Override
    public void requstVideo() {
        videoPresenter.requestVideo();
    }

    @Override
    public void addVideo(Video video) {
        allVideo.add(video);
        notifyItemInserted(allVideo.size() - 1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mvideoSerialno, mvideoTitle, mvideodescription;
        public ImageView mVideoImg;

        public ViewHolder(View itemView) {
            super(itemView);
            mvideoSerialno = (TextView) itemView.findViewById(R.id.video_serial_no);
            mvideoTitle = (TextView) itemView.findViewById(R.id.video_title);
            mvideodescription = (TextView) itemView.findViewById(R.id.video_brief);
            mVideoImg=(ImageView)itemView.findViewById(R.id.video_icon);
            mvideoSerialno.setBackgroundResource(R.drawable.circletextshape);
            GradientDrawable g = (GradientDrawable) mvideoSerialno.getBackground().getCurrent();
            g.setColor(Color.parseColor(color));
            itemView.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {
                    videoPresenter.onVideoSelect(allVideo.get(getAdapterPosition()));
                   Log.d("oneeeeeeeeeeeee", String.valueOf(getAdapterPosition()));
                   videoPosition = getAdapterPosition();
                   Log.d("video position is", String.valueOf(videoPosition));
                }
            });

        }
    }

}
