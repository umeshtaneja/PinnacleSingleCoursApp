package com.pinnacle.garorasu.course.Video;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/20/2017.
 */


public class VideoInfo {
    public static String[] videoSerialno ={};
    private static String[] videoTitle = {};
    private static String[] videoUrl = {};
    private static String[] videoBrief = {};
    //private static String[] videoColor = {"#689F38", "#FF8F00", "#00B0FF", "#F44336"};



    public static ArrayList<Video> getAllVideo() {
        ArrayList<Video> allVideo = new ArrayList<>();
        for (int i = 0; i < videoSerialno.length; i++) {
            allVideo.add(new Video(videoSerialno[i], videoTitle[i], videoBrief[i],videoUrl[i]));
        }
        return allVideo;
    }

}

