package com.markfrain.mtime.datasource.factory;

import android.arch.paging.DataSource;

import com.markfrain.mtime.datasource.NewMovieDataSource;

public class NewMovieDataFactory extends DataSource.Factory {
    public NewMovieDataSource dataSource;
    @Override
    public DataSource create() {
        dataSource=new NewMovieDataSource();
        return dataSource;
    }
}
