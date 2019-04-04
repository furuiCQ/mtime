package com.markfrain.mtime.datasource;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import com.markfrain.mtime.MyApplication;
import com.markfrain.mtime.bean.MovieBean;
import com.markfrain.mtime.response.LocalMovieResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LocalMovieDataSource extends PositionalDataSource<MovieBean> {
    int pageSize = 10;
    int pageIndex = 1;
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull final LoadInitialCallback<MovieBean> callback) {
        MyApplication.httpContact.liveData("291")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LocalMovieResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LocalMovieResponse localMovieResponse) {
                        callback.onResult(localMovieResponse.getMs(), pageIndex);
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
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<MovieBean> callback) {

    }
}
