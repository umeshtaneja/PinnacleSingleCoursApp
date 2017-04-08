package com.pinnacle.garorasu.course.Video;

/**
 * Created by Ideal on 2/18/2017.
 */

public class Video {
    private String serialno;
    private String title;
    private String videoDescription;
    private String url;


   // private String id;

    public Video(){};

    public Video(String serialno,String title, String videoDescription,String url) {

        this.serialno = serialno;
        this.title = title;
        this.videoDescription = videoDescription;
        this.url=url;

       // this.id=id;
    }


    public String getSerialno() {
        return serialno;
    }

    public String getTitle() {
        return title;
    }

    public String getvideoDescription() {
        return videoDescription;
    }

  //  public String getId() {return id; }

    public String getUrl() {return url;}

    public void setSerialno(String serialno) {
        this.serialno = serialno;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setvideoDescription(String videoDescription) {
        this.videoDescription = videoDescription;
    }

      //  public void setId(String id) {this.id = id;}

       public void setUrl(String url) {this.url = url;}
}
