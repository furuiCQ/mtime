package com.markfrain.mtime.bean;

import java.util.List;

public class AttentionBean {
    String director;//导演
    int id;//
    String image;
    int rDay;//日
    int rMonth;//月
    int rYear;//年
    String title;//片名
    String type;//类型
    String actor1;//演员1
    String actor2;//演员2
    int wantedCount;//想看人数
    boolean isTicket;//是否有票
    boolean isVideo;//是否有预告片

    List<VideoBean> videos;

    public List<VideoBean> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoBean> videos) {
        this.videos = videos;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getrDay() {
        return rDay;
    }

    public void setrDay(int rDay) {
        this.rDay = rDay;
    }

    public int getrMonth() {
        return rMonth;
    }

    public void setrMonth(int rMonth) {
        this.rMonth = rMonth;
    }

    public int getrYear() {
        return rYear;
    }

    public void setrYear(int rYear) {
        this.rYear = rYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActor1() {
        return actor1;
    }

    public void setActor1(String actor1) {
        this.actor1 = actor1;
    }

    public String getActor2() {
        return actor2;
    }

    public void setActor2(String actor2) {
        this.actor2 = actor2;
    }

    public int getWantedCount() {
        return wantedCount;
    }

    public void setWantedCount(int wantedCount) {
        this.wantedCount = wantedCount;
    }

    public boolean isTicket() {
        return isTicket;
    }

    public void setTicket(boolean ticket) {
        isTicket = ticket;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }
}
