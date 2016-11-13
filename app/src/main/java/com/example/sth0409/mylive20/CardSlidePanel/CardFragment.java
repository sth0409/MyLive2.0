package com.example.sth0409.mylive20.CardSlidePanel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sth0409.mylive20.Data.Data_videoMsg;
import com.example.sth0409.mylive20.R;
import com.example.sth0409.mylive20.Ui.VideoActivity;
import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 卡片Fragment
 *
 * @author xmuSistone
 */
@SuppressLint({"HandlerLeak", "NewApi", "InflateParams"})
public class CardFragment extends Fragment {
    int num;
    private CardSlidePanel.CardSwitchListener cardSwitchListener;
    private Data_videoMsg data_videoMsg;
    private String imagePaths[] = {"asset:///wall01.jpg",
            "asset:///wall02.jpg", "asset:///wall03.jpg",
            "asset:///wall04.jpg"/*, "asset:///wall01.jpg",
            "asset:///wall02.jpg", "asset:///wall03.jpg",
            "asset:///wall04.jpg", "asset:///wall01.jpg",
            "asset:///wall02.jpg", "asset:///wall03.jpg",
            "asset:///wall04.jpg", "asset:///wall01.jpg",
            "asset:///wall02.jpg", "asset:///wall03.jpg",
            "asset:///wall04.jpg", "asset:///wall01.jpg",
            "asset:///wall02.jpg", "asset:///wall03.jpg",
            "asset:///wall04.jpg", "asset:///wall01.jpg",
            "asset:///wall02.jpg", "asset:///wall03.jpg", "asset:///wall04.jpg"*/}; // 24个图片资源名称

    private List<CardDataItem> dataList = new ArrayList<CardDataItem>();
    private Toast mtoast;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.card_layout, null);
        mContext = container.getContext();
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        final CardSlidePanel slidePanel = (CardSlidePanel) rootView
                .findViewById(R.id.image_slide_panel);
        cardSwitchListener = new CardSlidePanel.CardSwitchListener() {



            @Override
            public void onShow(int index) {
                Log.i("-----", "onShow: " + index);
             //   showToast(dataList.get(index).getTitle());
            }

            @Override
            public void onCardVanish(int index, int type) {
                if (index == dataList.size() - 1) {
                    Toast.makeText(getContext(), "没有数据了", Toast.LENGTH_SHORT).show();
//
//                    prepareDataList();
//                    slidePanel.fillData(dataList);
                }
            }

            @Override
            public void onItemClick(View cardView, int index) {
//                Toast.makeText(cardView.getContext(), "", Toast.LENGTH_SHORT).show();
//                Log.d("CardFragment", "卡片点击-" + dataList.get(index).userName);
                Intent intent = new Intent(cardView.getContext(), VideoActivity.class);
                intent.putExtra("cardDataItem", dataList.get(index));
                //cardDataItem = intent.getParcelableExtra("cardDataItem");
                startActivity(intent);
            }
        };
        slidePanel.setCardSwitchListener(cardSwitchListener);

        prepareDataList();
        slidePanel.fillData(dataList);
    }

    private void showToast(String s) {
        SuperActivityToast.create(getActivity(), new Style(), Style.TYPE_BUTTON)
//                .setButtonText("UNDO")
//                .setButtonIconResource(R.drawable.ic_undo)
//                .setOnButtonClickListener("good_tag_name", null, onButtonClickListener)
                .setProgressBarColor(Color.WHITE)
                .setText(s)
                .setHeight(250)
                .setColor(0x666666)
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_PURPLE))
                .setAnimations(Style.ANIMATIONS_POP).show();
    }

    private void prepareDataList() {
//        int num = imagePaths.length;
//
//        for (int j = 0; j < 3; j++) {
//            for (int i = 0; i < num; i++) {
//                CardDataItem dataItem = new CardDataItem();
//                dataItem.imagePath = imagePaths[i];
//                dataItem.likeNum = (int) (Math.random() * 10);
//                dataItem.imageNum = (int) (Math.random() * 6);
//                dataList.add(dataItem);
//            }
//        }
        data_videoMsg = new Data_videoMsg();
        String url_image[] = data_videoMsg.URL_IMAGE;
        String url_video[] = data_videoMsg.URL_VIDEO;
        String url_msg[] = data_videoMsg.URL_MSG;
        String url_title[] = data_videoMsg.URL_TITLE;
        num = url_image.length;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < num; i++) {
                CardDataItem dataItem = new CardDataItem();
                dataItem.setImagePath(url_image[i]);
                dataItem.setTitle(url_title[i]);
                dataItem.setAuthor(url_msg[i]);
                dataItem.setVideoUrl(url_video[i]);
                dataList.add(dataItem);
            }
        }
    }

}
