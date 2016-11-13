package com.example.sth0409.mylive20.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sth0409.mylive20.Entity.Entity_VideoMsg;
import com.example.sth0409.mylive20.R;
import com.example.sth0409.mylive20.View.JCVideoPlayerLiveUI;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by STH0409 on 2016/10/19.
 */

public class Adapter_Videolist extends RecyclerView.Adapter<Adapter_Videolist.MyVideoHolder> {
    private Context context;
    private List<Entity_VideoMsg> dataList_videoMsgs;

    public Adapter_Videolist(Context context) {
        this.context = context;
        dataList_videoMsgs = new ArrayList<>();
    }

    public List<Entity_VideoMsg> getDataList_videoMsgs() {
        return dataList_videoMsgs;
    }

    public void setDataList_videoMsgs(List<Entity_VideoMsg> dataList_videoMsgs) {
        this.dataList_videoMsgs = dataList_videoMsgs;
    }

    @Override
    public MyVideoHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        MyVideoHolder myVideoHolder = new MyVideoHolder(LayoutInflater.from(context).inflate(R.layout.item_videoplayer, viewGroup, false));
        return myVideoHolder;
    }

    @Override
    public void onBindViewHolder(MyVideoHolder myVideoHolder, int i) {
        boolean isLoadVideo =
                myVideoHolder.jcVideoPlayerLiveUI
                        .setUp(dataList_videoMsgs.get(i).getUrl_video(),
                                JCVideoPlayer.SCREEN_LAYOUT_LIST,
                                dataList_videoMsgs.get(i).getTv_title());
        if (isLoadVideo) {
            Glide.with(context).
                    load(dataList_videoMsgs.get(i).getUrl_img()).
                    into(myVideoHolder.jcVideoPlayerLiveUI.thumbImageView);
            Glide.with(context).
                    load(dataList_videoMsgs.get(i).getUrl_img()).
                    into(myVideoHolder.imageView);
            myVideoHolder.tv_title.setText(dataList_videoMsgs.get(i).getTv_title());
            myVideoHolder.tv_msg.setText(dataList_videoMsgs.get(i).getTv_msg());
        }
    }

    @Override
    public int getItemCount() {
        return dataList_videoMsgs.size();
    }

    class MyVideoHolder extends RecyclerView.ViewHolder {
        JCVideoPlayerLiveUI jcVideoPlayerLiveUI;

        ImageView imageView;
        TextView tv_title;
        TextView tv_msg;

        public MyVideoHolder(View itemView) {
            super(itemView);

            jcVideoPlayerLiveUI = (JCVideoPlayerLiveUI) itemView.findViewById(R.id.video_list_item_player);
          //  jcVideoPlayerStandard.setLive(true);
            imageView = (ImageView) itemView.findViewById(R.id.video_list_item_image);
            tv_title = (TextView) itemView.findViewById(R.id.video_list_item_text_title);
            tv_msg = (TextView) itemView.findViewById(R.id.video_list_item_text_context);
        }

    }

}
