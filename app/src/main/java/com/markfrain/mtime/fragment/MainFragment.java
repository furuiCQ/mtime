package com.markfrain.mtime.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.markfrain.mtime.R;
import com.markfrain.mtime.adapter.MainLoaclAdapter;
import com.markfrain.mtime.adapter.MainNewAdapter;
import com.markfrain.mtime.bean.AttentionBean;
import com.markfrain.mtime.bean.MovieBean;
import com.markfrain.mtime.contact.MainContact;
import com.markfrain.mtime.mvp.BaseFragment;
import com.markfrain.mtime.presenter.MainPresenter;
import com.markfrain.mtime.utils.ItemDeraction;
import com.markfrain.mtime.viewmodel.MainViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends BaseFragment<MainPresenter> implements MainContact.IMain {
    private TabHost tabHost;
    private RecyclerView localRecycle;
    private MainLoaclAdapter localAdapter;

    private RecyclerView newRecycle;
    private MainNewAdapter newAdapter;
    MainViewModel viewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.initLocalData();
        viewModel.initNewData();
        viewModel.localData.observe(this, new Observer<PagedList<MovieBean>>() {
            @Override
            public void onChanged(@Nullable PagedList<MovieBean> list) {
                if (list != null) {
                    localAdapter.submitList(list);
                }
            }
        });
        viewModel.moviecomingsData.observe(this, new Observer<PagedList<AttentionBean>>() {
            @Override
            public void onChanged(@Nullable PagedList<AttentionBean> list) {
                if (list != null) {
                    newAdapter.submitList(list);
                }
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

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator(getString(R.string.tab_1))
                .setContent(R.id.local_recycle));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator(getString(R.string.tab_2))
                .setContent(R.id.new_recycle));

        localRecycle = rootView.findViewById(R.id.local_recycle);
        newRecycle = rootView.findViewById(R.id.new_recycle);


        localAdapter = new MainLoaclAdapter(new DiffUtil.ItemCallback<MovieBean>() {
            @Override
            public boolean areItemsTheSame(MovieBean oldItem, MovieBean newItem) {
                return oldItem.getMovieId().equals(newItem.getMovieId());
            }

            @Override
            public boolean areContentsTheSame(MovieBean oldItem, MovieBean newItem) {
                return oldItem.getMovieId().equals(newItem.getMovieId());
            }
        });
        newAdapter = new MainNewAdapter(new DiffUtil.ItemCallback<AttentionBean>() {
            @Override
            public boolean areItemsTheSame(AttentionBean oldItem, AttentionBean newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(AttentionBean oldItem, AttentionBean newItem) {
                return oldItem.getId() == newItem.getId();
            }
        });


        localRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        localRecycle.addItemDecoration(new ItemDeraction(2));
        localRecycle.setAdapter(localAdapter);

        newRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
        newRecycle.addItemDecoration(new ItemDeraction(2));
        newRecycle.setAdapter(newAdapter);
    }


    @Override
    protected MainPresenter bindPresenter() {
        return new MainPresenter(this);
    }
}
