package com.pinnacle.garorasu.course.Video;

import java.util.ArrayList;

/**
 * Created by Ideal on 2/20/2017.
 */

public class VideoInfo {
    public static String[] videoSerialno={"1","2","3","4","5","6","7","8","9","10"};
    private static String[] videoTitle = {"JobAssure","JobAssure", "JobAssure Tier1", "JobAssure Tier2", "JobAssure Tier3","JobAssure", "JobAssure Tier1", "JobAssure Tier2", "JobAssure Tier1", "JobAssure Tier2",};
    private static String videoUrl = "https://dl.pagal.link/upload_file/367/382/6821/Cricket%20Videos%202015%20MP4/Harbhajan%20Singh%2064%20From%2024%20Balls%20IPL%202015%20-%20MP4.mp4";
    private static String videoBrief = "comprehensive program";
    //private static String[] videoColor = {"#689F38", "#FF8F00", "#00B0FF", "#F44336"};

    public static ArrayList<Video> getAllVideo() {
        ArrayList<Video> allVideo = new ArrayList<>();
        for (int i = 0; i < videoSerialno.length; i++) {
            allVideo.add(new Video(videoSerialno[i], videoTitle[i], videoBrief,videoUrl));
        }
        return allVideo;
    }
}

