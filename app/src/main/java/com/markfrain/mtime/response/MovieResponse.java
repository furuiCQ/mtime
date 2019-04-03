package com.markfrain.mtime.response;

import com.markfrain.mtime.bean.MovieBean;

import java.util.List;

public class MovieResponse {
    String lid;
    List<MovieBean> list;

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public List<MovieBean> getList() {
        return list;
    }

    public void setList(List<MovieBean> list) {
        this.list = list;
    }
}
