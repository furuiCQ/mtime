package com.markfrain.mtime.presenter;

import com.markfrain.mtime.MyApplication;
import com.markfrain.mtime.R;
import com.markfrain.mtime.contact.MainContact;
import com.markfrain.mtime.mvp.BasePresenter;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter extends BasePresenter<MainContact.IMain> implements MainContact.IMainPre {

    public MainPresenter(MainContact.IMain view) {
        super(view);
    }

    public void getData(String tabId) {
        if (tabId.equals(getView().
                getSelfActivity().getString(R.string.tab_1))) {
            //正在热映列表
            MyApplication.httpContact.newData("291")
                    .subscribeOn(Schedulers.io())
                    .observeOn(Android)

        } else {
            //即将上映列表

        }
    }
}
