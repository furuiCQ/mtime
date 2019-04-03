package com.markfrain.mtime.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {
    // Presenter对象
    protected P mvpPre;
    protected View rootView;

    @Override
    public Activity getSelfActivity() {
        return getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mvpPre = bindPresenter();
    }

    public abstract void initView();

    // 绑定Presenter
    protected abstract P bindPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        /**
         * 在生命周期结束时，将presenter与view之间的联系断开，防止出现内存泄露
         */
        if (mvpPre != null) {
            mvpPre.detachView();
        }
    }
}
