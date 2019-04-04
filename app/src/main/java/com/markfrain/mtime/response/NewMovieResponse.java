package com.markfrain.mtime.response;

import com.markfrain.mtime.bean.AttentionBean;

import java.util.List;

public class NewMovieResponse {
    List<AttentionBean> attention;
    List<AttentionBean> moviecomings;

    public List<AttentionBean> getAttention() {
        return attention;
    }

    public void setAttention(List<AttentionBean> attention) {
        this.attention = attention;
    }

    public List<AttentionBean> getMoviecomings() {
        return moviecomings;
    }

    public void setMoviecomings(List<AttentionBean> moviecomings) {
        this.moviecomings = moviecomings;
    }
}
