package com.markfrain.mtime.datasource;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import com.markfrain.mtime.MyApplication;
import com.markfrain.mtime.bean.AttentionBean;
import com.markfrain.mtime.bean.MovieBean;
import com.markfrain.mtime.response.LocalMovieResponse;
import com.markfrain.mtime.response.NewMovieResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class NewMovieDataSource extends PositionalDataSource<AttentionBean> {
    int pageIndex = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams params,
                            @NonNull final LoadInitialCallback<AttentionBean> callback) {
        MyApplication.httpContact.newData("291")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NewMovieResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(NewMovieResponse response) {
                        callback.onResult(response.getMoviecomings(), pageIndex);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<AttentionBean> callback) {

    }
}
