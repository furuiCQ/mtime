package com.markfrain.mtime.bean;

import android.arch.paging.PagedList;

public class MainBean {
    PagedList<MovieBean> list;

    public PagedList<MovieBean> getList() {
        return list;
    }

    public void setList(PagedList<MovieBean> list) {
        this.list = list;
    }
}
