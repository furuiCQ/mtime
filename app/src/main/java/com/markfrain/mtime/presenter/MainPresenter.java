package com.markfrain.mtime.presenter;

import com.markfrain.mtime.MyApplication;
import com.markfrain.mtime.R;
import com.markfrain.mtime.contact.MainContact;
import com.markfrain.mtime.mvp.BasePresenter;
import com.markfrain.mtime.response.LocalMovieResponse;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContact.IMain> implements MainContact.IMainPre {

    public MainPresenter(MainContact.IMain view) {
        super(view);
    }


}
