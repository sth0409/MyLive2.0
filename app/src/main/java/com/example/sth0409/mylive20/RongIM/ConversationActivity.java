package com.example.sth0409.mylive20.RongIM;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.example.sth0409.mylive20.R;

import io.rong.imlib.model.Conversation;

public class ConversationActivity extends FragmentActivity {

    /**
     * 目标 Id
     */
    private String mTargetId;

    /**
     * 刚刚创建完讨论组后获得讨论组的id 为targetIds，需要根据 为targetIds 获取 targetId
     */
    private String mTargetIds;

    /**
     * 会话类型
     */
    private Conversation.ConversationType mConversationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_conversation);
        new UserInfoProvider();
        getWindow().setBackgroundDrawableResource(R.drawable.back);

    }

}
