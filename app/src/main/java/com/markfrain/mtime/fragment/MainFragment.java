package com.markfrain.mtime.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;

import com.markfrain.mtime.R;
import com.markfrain.mtime.bean.MovieBean;
import com.markfrain.mtime.contact.MainContact;
import com.markfrain.mtime.mvp.BaseFragment;
import com.markfrain.mtime.presenter.MainPresenter;
import com.markfrain.mtime.viewmodel.MainViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment<MainPresenter> implements MainContact.IMain {
    private TabHost tabHost;
    private RecyclerView localRecycle;
    private RecyclerView newRecycle;

    MainViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getLiveData().observe(this, new Observer<List<MovieBean>>() {
            @Override
            public void onChanged(@Nullable List<MovieBean> data) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        return rootView;
    }

    @Override
    public void initView() {
        tabHost = rootView.findViewById(R.id.tabHost);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec(getString(R.string.tab_1))
                .setIndicator(getString(R.string.tab_1))
                .setContent(R.id.local_recycle));
        tabHost.addTab(tabHost.newTabSpec(getString(R.string.tab_2))
                .setIndicator(getString(R.string.tab_2))
                .setContent(R.id.new_recycle));

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Log.i("onTabChanged", tabId);
                mvpPre.getData(tabId);
            }
        });
        localRecycle = rootView.findViewById(R.id.local_recycle);
        newRecycle = rootView.findViewById(R.id.new_recycle);

    }


    @Override
    protected MainPresenter bindPresenter() {
        return new MainPresenter(this);
    }
}
