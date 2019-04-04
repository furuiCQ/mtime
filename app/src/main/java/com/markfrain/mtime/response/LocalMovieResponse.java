package com.markfrain.mtime.response;

import com.markfrain.mtime.bean.MovieBean;

import java.util.List;

public class LocalMovieResponse {
    String lid;
    String bImg;
    List<MovieBean> ms;

    public String getbImg() {
        return bImg;
    }

    public void setbImg(String bImg) {
        this.bImg = bImg;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public List<MovieBean> getMs() {
        return ms;
    }

    public void setMs(List<MovieBean> ms) {
        this.ms = ms;
    }
}
