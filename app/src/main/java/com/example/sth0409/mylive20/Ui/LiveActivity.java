package com.example.sth0409.mylive20.Ui;

import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.sth0409.mylive20.Adapter.Adapter_Videolist;
import com.example.sth0409.mylive20.Data.Data_liveMsg;
import com.example.sth0409.mylive20.Entity.Entity_VideoMsg;
import com.example.sth0409.mylive20.R;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCBuriedPoint;
import fm.jiecao.jcvideoplayer_lib.JCBuriedPointStandard;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerManager;

public class LiveActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Adapter_Videolist adapter_videolist;
    private Data_liveMsg data_videoMsg;
    private List<Entity_VideoMsg> videoMsgList;

    JCVideoPlayer.JCAutoFullscreenListener sensorEventListener;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setTitle("LIVE");
        setContentView(R.layout.activity_live);
        initWeiget();
        setRecyclerView();
        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 5; i++) {
            Entity_VideoMsg entity_videoMsg =
                    new Entity_VideoMsg(
                            data_videoMsg.URL_LIVE[i],
                            data_videoMsg.URL_IMAGE[i],
                            data_videoMsg.URL_TITLE[i],
                            data_videoMsg.URL_MSG[i]);
            videoMsgList.add(entity_videoMsg);
        }
//        Entity_VideoMsg entity_videoMsg =
//                    new Entity_VideoMsg("http://222.36.5.53:9800/live/xktv.m3u8","http://img.sj33.cn/uploads/allimg/201402/7-140225144GK51.png","111","222");
//
//            videoMsgList.add(entity_videoMsg);
        adapter_videolist.setDataList_videoMsgs(videoMsgList);
        adapter_videolist.notifyDataSetChanged();
    }

    private void setRecyclerView() {
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                if (JCVideoPlayerManager.getFirst() != null) {
                    JCVideoPlayer videoPlayer = (JCVideoPlayer) JCVideoPlayerManager.getFirst();
                    if (((ViewGroup) view).indexOfChild(videoPlayer) != -1 && videoPlayer.currentState == JCVideoPlayer.CURRENT_STATE_PLAYING) {
                        JCVideoPlayer.releaseAllVideos();
                    }
                }
            }
        });
        recyclerView.setAdapter(adapter_videolist);
    }


    private void initWeiget() {
        recyclerView = (RecyclerView) findViewById(R.id.video_recyclerView);
        adapter_videolist = new Adapter_Videolist(LiveActivity.this);
        videoMsgList = new ArrayList<>();
        data_videoMsg = new Data_liveMsg();
        //   JCVideoPlayer.setJcBuriedPoint(new MyJCBuriedPointStandard());
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorEventListener = new JCVideoPlayer.JCAutoFullscreenListener();
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

    class MyJCBuriedPointStandard implements JCBuriedPointStandard {

        @Override
        public void onEvent(int type, String url, int screen, Object... objects) {
            switch (type) {
                case JCBuriedPoint.ON_CLICK_START_ICON:
                    Log.i("Buried_Point", "ON_CLICK_START_ICON" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_CLICK_START_ERROR:
                    Log.i("Buried_Point", "ON_CLICK_START_ERROR" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_CLICK_START_AUTO_COMPLETE:
                    Log.i("Buried_Point", "ON_CLICK_START_AUTO_COMPLETE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_CLICK_PAUSE:
                    Log.i("Buried_Point", "ON_CLICK_PAUSE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_CLICK_RESUME:
                    Log.i("Buried_Point", "ON_CLICK_RESUME" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_SEEK_POSITION:
                    Log.i("Buried_Point", "ON_SEEK_POSITION" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_AUTO_COMPLETE:
                    Log.i("Buried_Point", "ON_AUTO_COMPLETE" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_ENTER_FULLSCREEN:
                    Log.i("Buried_Point", "ON_ENTER_FULLSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_QUIT_FULLSCREEN:
                    Log.i("Buried_Point", "ON_QUIT_FULLSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_ENTER_TINYSCREEN:
                    Log.i("Buried_Point", "ON_ENTER_TINYSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_QUIT_TINYSCREEN:
                    Log.i("Buried_Point", "ON_QUIT_TINYSCREEN" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_TOUCH_SCREEN_SEEK_VOLUME:
                    Log.i("Buried_Point", "ON_TOUCH_SCREEN_SEEK_VOLUME" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPoint.ON_TOUCH_SCREEN_SEEK_POSITION:
                    Log.i("Buried_Point", "ON_TOUCH_SCREEN_SEEK_POSITION" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;

                case JCBuriedPointStandard.ON_CLICK_START_THUMB:
                    Log.i("Buried_Point", "ON_CLICK_START_THUMB" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                case JCBuriedPointStandard.ON_CLICK_BLANK:
                    Log.i("Buried_Point", "ON_CLICK_BLANK" + " title is : " + (objects.length == 0 ? "" : objects[0]) + " url is : " + url + " screen is : " + screen);
                    break;
                default:
                    Log.i("Buried_Point", "unknow");
                    break;
            }
        }
    }
}
