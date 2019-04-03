package com.markfrain.mtime.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.markfrain.mtime.bean.MovieBean;

import java.util.List;

public class MainViewModel extends ViewModel {
    MutableLiveData<List<MovieBean>> liveData;

    public MutableLiveData<List<MovieBean>> getLiveData() {
        if (liveData == null) {
            liveData = new MutableLiveData<>();
        }
        return liveData;
    }

}
