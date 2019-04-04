package com.markfrain.mtime.datasource.factory;

import android.arch.paging.DataSource;

import com.markfrain.mtime.datasource.LocalMovieDataSource;

public class LocalMovieDataFactory extends DataSource.Factory {
    public LocalMovieDataSource dataSource;
    @Override
    public DataSource create() {
        dataSource=new LocalMovieDataSource();
        return dataSource;
    }
}
