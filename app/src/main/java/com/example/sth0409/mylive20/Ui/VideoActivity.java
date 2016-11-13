package com.example.sth0409.mylive20.Ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.sth0409.mylive20.Adapter.Adapter_HeaderFooter;
import com.example.sth0409.mylive20.CardSlidePanel.CardDataItem;
import com.example.sth0409.mylive20.Data.Data_EntityMsgList;
import com.example.sth0409.mylive20.Data.Data_commentsMsg;
import com.example.sth0409.mylive20.Entity.Entity_CommentUser;
import com.example.sth0409.mylive20.Entity.Entity_Net;
import com.example.sth0409.mylive20.R;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.superrecycleview.superlibrary.recycleview.SuperRecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fm.jiecao.jcvideoplayer_lib.JCMediaManager;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import okhttp3.Call;
import okhttp3.Response;

public class VideoActivity extends AppCompatActivity implements JCVideoPlayerStandard.OnPlayerEndListenier {
    JCVideoPlayerStandard jcVideoPlayerStandard;
    CardDataItem cardDataItem;
    Intent intent;
    Entity_Net entity_net;
    Data_EntityMsgList data_entityMsgList;
    Map<String, Entity_Net> stringEntity_netMap;
    SuperRecyclerView superRecyclerView;
    private View headerView;
    private List<Data_commentsMsg> data_commentsMsgs;
    private Adapter_HeaderFooter adapter_headerFooter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBar();
        intent = getIntent();
        cardDataItem = intent.getParcelableExtra("cardDataItem");
        setContentView(R.layout.activity_video);
        //初始化组件
        initWeiget();



        //初始化，加载请求体
        loadEntity_Net();
        //加载评论
        loadComments(cardDataItem.getTitle());
        loadJCplayer();


    }

    private void loadJCplayer() {
        jcVideoPlayerStandard.setUp(cardDataItem.getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_LIST, cardDataItem.getTitle());
        Glide.with(this).load(
                cardDataItem.getImagePath()
        ).into(jcVideoPlayerStandard.thumbImageView);
        jcVideoPlayerStandard.setOnPlayerEndListenier(this);
        jcVideoPlayerStandard.startPlayLogic();
    }

    private void initAdapter() {
        adapter_headerFooter = new Adapter_HeaderFooter(this, data_commentsMsgs);
        adapter_headerFooter.addHeaderView(headerView);
        superRecyclerView.setAdapter(adapter_headerFooter);
    }

    private void initWeiget() {
        superRecyclerView = (SuperRecyclerView) findViewById(R.id.superrecycleview_header_footer);
        headerView = getLayoutInflater().inflate(R.layout.video_header, (ViewGroup) superRecyclerView.getParent(), false);
        jcVideoPlayerStandard = (JCVideoPlayerStandard) headerView.findViewById(R.id.videoactivity_videoplayer_standard);
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        superRecyclerView.setLayoutManager(layoutManager);
        superRecyclerView.setRefreshEnabled(false);
        superRecyclerView.setLoadMoreEnabled(false);

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
                            formatJson(s);
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void formatJson(String s) {
        try {
            JSONObject jsonObjectBean = new JSONObject(s);
            JSONArray hotCommentsArray = jsonObjectBean.getJSONArray("hotComments");
            data_commentsMsgs = new ArrayList<>();
            for (int i = 0; i < hotCommentsArray.length(); i++) {
                JSONObject jsonObjectCom = hotCommentsArray.getJSONObject(i);
                Data_commentsMsg data_commentsMsg = new Data_commentsMsg();

                data_commentsMsg.setContent(jsonObjectCom.getString("content"));
                data_commentsMsg.setLikedCount(jsonObjectCom.getString("likedCount"));
                //取user信息
                JSONObject jsonObjectUser = jsonObjectCom.getJSONObject("user");
                Entity_CommentUser entity_commentUser = new Entity_CommentUser();
                entity_commentUser.setAvatarUrl(jsonObjectUser.getString("avatarUrl"));
                entity_commentUser.setNickname(jsonObjectUser.getString("nickname"));
                data_commentsMsg.setEntity_commentUser(entity_commentUser);
                data_commentsMsgs.add(data_commentsMsg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        initRecyclerView();
        initAdapter();
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

    @Override
    public void PlayerEndEnvent() {
        Toast.makeText(this, "播放完毕", Toast.LENGTH_SHORT).show();
    }
}
