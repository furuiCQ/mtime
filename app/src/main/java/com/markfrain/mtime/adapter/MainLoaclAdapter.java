package com.markfrain.mtime.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.markfrain.mtime.R;
import com.markfrain.mtime.bean.MovieBean;

public class MainLoaclAdapter extends PagedListAdapter<MovieBean, MainLoaclAdapter.MovieLocalViewHolder> {
    public MainLoaclAdapter(@NonNull DiffUtil.ItemCallback<MovieBean> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MovieLocalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieLocalViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_main_local, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieLocalViewHolder holder, int position) {
        MovieBean movieBean = getItem(position);

        Glide.with(holder.imageView.getContext())
                .load(movieBean.getImg())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.hotView.setVisibility(movieBean.isHot() ? View.VISIBLE : View.GONE);

        holder.titleView.setText(movieBean.gettCn());
        holder.introduceView.setText(movieBean.getCommonSpecial());
        holder.countView.setText(movieBean.getcC() + "家影院上映" + movieBean.getNearestShowtimeCount());
        holder.scoreView.setVisibility(
                movieBean.getR() != null && !movieBean.getR().equals("-1") ? View.VISIBLE : View.GONE);
        holder.scoreView.setText(movieBean.getR());
    }

    class MovieLocalViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageView hotView;
        TextView titleView;
        TextView introduceView;
        TextView countView;
        TextView scoreView;

        public MovieLocalViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            hotView = itemView.findViewById(R.id.hot_img);
            titleView = itemView.findViewById(R.id.title);
            introduceView = itemView.findViewById(R.id.introduce);
            countView = itemView.findViewById(R.id.count);
            scoreView = itemView.findViewById(R.id.score);
        }
    }
}
