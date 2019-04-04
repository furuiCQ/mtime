package com.markfrain.mtime.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PagedList;

import com.markfrain.mtime.bean.AttentionBean;
import com.markfrain.mtime.bean.MovieBean;
import com.markfrain.mtime.datasource.factory.LocalMovieDataFactory;
import com.markfrain.mtime.datasource.factory.NewMovieDataFactory;

public class MainViewModel extends ViewModel {
    public LiveData<PagedList<MovieBean>> localData;
    public LiveData<PagedList<AttentionBean>> moviecomingsData;

    int pageSize = 10;
    int pageIndex = 1;

    public void initLocalData() {
        localData = new LivePagedListBuilder(
                new LocalMovieDataFactory()
                , new PagedList.Config.Builder().setPageSize(pageSize)
                .setPrefetchDistance(pageSize)
                .setEnablePlaceholders(false).setInitialLoadSizeHint(pageSize)
                .build()).build();
    }

    public void initNewData() {
        moviecomingsData=new LivePagedListBuilder(
                new NewMovieDataFactory(),
                new PagedList.Config.Builder().setPageSize(pageSize)
                .setPrefetchDistance(pageSize)
                .setEnablePlaceholders(false).setInitialLoadSizeHint(pageSize)
                .build()).build();
    }

//    public void getData(String tabId) {
//        if (tabId.equals("tab1")) {
//            initLocalData();
//        } else {
//            initNewData();
//        }
//    }
}





