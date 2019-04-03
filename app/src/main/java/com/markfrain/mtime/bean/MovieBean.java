package com.markfrain.mtime.bean;

public class MovieBean {
    String actors;
    String img;
    String movieId;
    String movieType;
    String cC;//影院数
    String NearestShowtimeCount;//上映场次

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImg() {
        return img;
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
}
