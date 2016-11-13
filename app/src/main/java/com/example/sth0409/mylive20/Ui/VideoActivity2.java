package com.example.sth0409.mylive20.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.sth0409.mylive20.CardSlidePanel.CardDataItem;
import com.example.sth0409.mylive20.Data.Data_EntityMsgList;
import com.example.sth0409.mylive20.Entity.Entity_Net;
import com.example.sth0409.mylive20.R;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import okhttp3.Call;
import okhttp3.Response;

public class VideoActivity2 extends AppCompatActivity {
    JCVideoPlayerStandard jcVideoPlayerStandard;
    CardDataItem cardDataItem;
    Intent intent;
    Entity_Net entity_net;
    Data_EntityMsgList data_entityMsgList;
    Map<String, Entity_Net> stringEntity_netMap;
SuperRecyclerView superRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBar();
        intent = getIntent();
        cardDataItem = intent.getParcelableExtra("cardDataItem");
        setContentView(R.layout.activity_video);
        loadEntity_Net();


        loadComments(cardDataItem.getTitle());

        jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoactivity_videoplayer_standard);
        jcVideoPlayerStandard.setUp(cardDataItem.getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, cardDataItem.getTitle());
        Glide.with(this).load(
                cardDataItem.getImagePath()
        ).into(jcVideoPlayerStandard.thumbImageView);
        jcVideoPlayerStandard.startPlayLogic();

    }

    private void loadEntity_Net() {
        data_entityMsgList = new Data_EntityMsgList();
        stringEntity_netMap = data_entityMsgList.getEntity_netMap();
    }

    private void loadComments(String title) {
        Log.i("----", "onSuccess: 2" + title);
        entity_net = stringEntity_netMap.get(title);
        Map<String, String> url = entity_net.getUrl();
        Map<String, String> params = entity_net.getParams();
        Map<String, String> encSecKey = entity_net.getEncSecKey();
        Map<String, String> csrf_token = entity_net.getCsrf_token();
        Map<String, String> host = entity_net.getHost();
        Map<String, String> referer = entity_net.getReferer();
        try {
            OkGo.post((String) url.get("url"))
                    .headers("Host", host.get("Host"))
                    .headers("Referer", referer.get("Referer"))
                    .params("params", params.get("params"))
                    .params("encSecKey", encSecKey.get("encSecKey"))
                    .params("csrf_token", csrf_token.get("csrf_token"))
                    .tag(this)
                    .cacheKey("cacheKey")            // 设置当前请求的缓存key,建议每个不同功能的请求设置一个
                    .cacheMode(CacheMode.DEFAULT)    // 缓存模式，详细请看缓存介绍
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(String s, Call call, Response response) {
                            Log.i("----", "onSuccess: " + s + response);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("VIDEO");
    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }

}
