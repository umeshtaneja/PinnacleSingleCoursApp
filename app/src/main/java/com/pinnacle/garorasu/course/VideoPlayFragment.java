package com.pinnacle.garorasu.course;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.github.rubensousa.previewseekbar.PreviewSeekBar;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveVideoTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.pinnacle.garorasu.course.Video.VideoAdapter;


/**
 * Created by Ideal on 3/27/2017.
 */
public class VideoPlayFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private PreviewSeekBar seekBar;
    private SimpleExoPlayer previewPlayer;
    private SimpleExoPlayerView previewPlayerView;

    private int videovalue;
    public String videoPositionUrl;

    public VideoPlayFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        videovalue = VideoAdapter.getVideoPosition();
        Log.d("selected video value is", String.valueOf(videovalue));

       //returnString();
        switch(videovalue){
            case 0:
            {
                videoPositionUrl = "https://dl.pagal.link/upload_file/367/382/6821/Cricket%20Videos%202015%20MP4/Harbhajan%20Singh%2064%20From%2024%20Balls%20IPL%202015%20-%20MP4.mp4";
                Log.d("value","case 0 selected");
                break;
             }

            case 1:
            {
                videoPositionUrl = "https://firebasestorage.googleapis.com/v0/b/kuch-hee.appspot.com/o/220%20Android%20Navigation%20Drawer%20Tutorial%20Part%203%20-%20coursetro.com.mp4?alt=media&token=a4703569-e291-4da9-bede-931d5c5c9039";
                Log.d("value","case 1 selected");
                break;
              }
            default: {

            }
        }

       //videoPositionUrl = "https://dl.pagal.link/upload_file/367/382/6821/Cricket%20Videos%202015%20MP4/Harbhajan%20Singh%2064%20From%2024%20Balls%20IPL%202015%20-%20MP4.mp4";


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_play_video, container, false);
        previewPlayerView = (SimpleExoPlayerView) view.findViewById(R.id.player_view);
        seekBar = (PreviewSeekBar) view.findViewById(R.id.exo_progress);
        seekBar.addOnSeekBarChangeListener(this);


        Handler mainHandler = new Handler();
        BandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        TrackSelection.Factory videoTrackSelectionFactory =
                new AdaptiveVideoTrackSelection.Factory(bandwidthMeter);
        TrackSelector trackSelector =
                new DefaultTrackSelector(videoTrackSelectionFactory);

// 2. Create a default LoadControl
        LoadControl loadControl = new DefaultLoadControl();

// 3. Create the player
        previewPlayer =
                ExoPlayerFactory.newSimpleInstance(getContext(), trackSelector, loadControl);
                previewPlayerView.setPlayer(previewPlayer);


// Produces DataSource instances through which media data is loaded.
        Context context = getContext();
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
// Produces DataSource instances through which media data is loaded.
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext(),
                Util.getUserAgent(getContext(), "ExoPlayer"), defaultBandwidthMeter);
// Produces Extractor instances for parsing the media data.
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
// This is the MediaSource representing the media to be played.


        Uri mp4VideoUri = Uri.parse(videoPositionUrl);
        MediaSource videoSource = new ExtractorMediaSource(mp4VideoUri,
                dataSourceFactory, extractorsFactory, null, null);
// Prepare the player with the source.
        previewPlayer.prepare(videoSource);

        return view;
      }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if(fromUser){
            // Round the offset before seeking. The sample uses 1% or 10% of the video per each thumbnail
            previewPlayer.seekTo((long) ((float) (seekBar.getProgress() / seekBar.getMax()) * previewPlayer.getDuration()));
            previewPlayer.setPlayWhenReady(false);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

   // public String returnString(){


   // }
}



