package com.markfrain.mtime.adapter;

import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.markfrain.mtime.R;
import com.markfrain.mtime.bean.AttentionBean;
import com.markfrain.mtime.bean.MovieBean;

public class MainNewAdapter extends PagedListAdapter<AttentionBean, MainNewAdapter.MovieLocalViewHolder> {
    ItemClickListener itemClickListener;

    public MainNewAdapter(@NonNull DiffUtil.ItemCallback<AttentionBean> diffCallback, ItemClickListener itemClickListener) {
        super(diffCallback);
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public MovieLocalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieLocalViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_main_new, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MovieLocalViewHolder holder, int position) {
        AttentionBean movieBean = getItem(position);

        Glide.with(holder.imageView.getContext())
                .load(movieBean.getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
        holder.titleView.setText(movieBean.getTitle());
        holder.typeView.setText("人想看-" + movieBean.getType());
        holder.wantView.setText(movieBean.getWantedCount() + "");
        holder.directorView.setText(movieBean.getDirector());
        holder.actorView.setText(movieBean.getActor1() + " " + movieBean.getActor2());

        holder.ticketView.setVisibility(movieBean.isTicket() ? View.VISIBLE : View.GONE);
        holder.videoView.setVisibility(movieBean.isVideo() ? View.VISIBLE : View.INVISIBLE);

        holder.ticketView.setTag(R.string.app_name, movieBean.getId());
        holder.ticketView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    int id = (Integer) (v.getTag(R.string.app_name));
                    itemClickListener.buy(id);
                }
            }
        });

        holder.videoView.setTag(R.string.app_name, movieBean.getId());
        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    int id = (Integer) (v.getTag(R.string.app_name));
                    itemClickListener.video(id);
                }
            }
        });

        holder.itemView.setTag(R.string.app_name, movieBean.getId());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    int id = (Integer) (v.getTag(R.string.app_name));
                    itemClickListener.click(id);
                }
            }
        });
    }

    public interface ItemClickListener {
        void click(int id);

        void buy(int id);

        void video(int id);
    }

    class MovieLocalViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView;
        TextView wantView;
        TextView typeView;
        TextView directorView;
        TextView actorView;
        TextView ticketView;
        TextView videoView;
        RelativeLayout rootView;

        public MovieLocalViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            titleView = itemView.findViewById(R.id.title);
            wantView = itemView.findViewById(R.id.want);
            typeView = itemView.findViewById(R.id.type);
            directorView = itemView.findViewById(R.id.director);
            actorView = itemView.findViewById(R.id.actor);
            ticketView = itemView.findViewById(R.id.ticket);
            videoView = itemView.findViewById(R.id.video);

        }
    }
}
