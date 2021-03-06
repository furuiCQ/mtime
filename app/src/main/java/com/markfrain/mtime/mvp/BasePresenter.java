package com.markfrain.mtime.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public abstract class BasePresenter<V extends IView> implements IPresenter {
    // 此处使用弱引用是因为，有时Activity关闭不一定会走onDestroy，所以这时使用弱引用可以及时回收IView
    protected Reference<V> mvpRef;

    public BasePresenter(V view) {
        attachView(view);

    }

    private void attachView(V view) {
        mvpRef = new WeakReference<V>(view);
    }

    protected V getView() {
        if (mvpRef != null) {
            return mvpRef.get();
        }
        return null;
    }

    /**
     * 主要用于判断IView的生命周期是否结束，防止出现内存泄露状况
     *
     * @return
     */
    protected boolean isViewAttach() {
        return mvpRef != null && mvpRef.get() != null;
    }

    /**
     * Activity生命周期结束时，Presenter也清除IView对象，不在持有
     */
    @Override
    public void detachView() {
        if (mvpRef != null) {
            mvpRef.clear();
            mvpRef = null;
        }
    }
}