package com.markfrain.mtime.bean;

public class MovieBean {
    String actors;
    String img;
    String movieId;
    String movieType;
    String cC;//影院数
    String NearestShowtimeCount;//上映场次
    String commonSpecial;//简介
    String tCn;//片名
    String r;//评分
    boolean isHot = false;

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImg() {
        return img == null ? "" : img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getcC() {
        return cC;
    }

    public void setcC(String cC) {
        this.cC = cC;
    }

    public String getNearestShowtimeCount() {
        return NearestShowtimeCount;
    }

    public void setNearestShowtimeCount(String nearestShowtimeCount) {
        NearestShowtimeCount = nearestShowtimeCount;
    }

    public String getCommonSpecial() {
        return commonSpecial;
    }

    public void setCommonSpecial(String commonSpecial) {
        this.commonSpecial = commonSpecial;
    }

    public String gettCn() {
        return tCn;
    }

    public void settCn(String tCn) {
        this.tCn = tCn;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }
}
