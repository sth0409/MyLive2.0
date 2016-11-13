package com.example.sth0409.mylive20.RongIM;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.sth0409.mylive20.APP;
import com.example.sth0409.mylive20.R;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;


public class RongIM_MainActivity extends Activity {
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rongim_main);


        this.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect(Configer.USER1_TOKEN);
            }
        });
        this.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect(Configer.USER2_TOKEN);
            }

        });
        this.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect(Configer.USER3_TOKEN);
            }

        });
        this.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect(Configer.USER4_TOKEN);
            }

        });
    }


    /**
     * 建立与融云服务器的连接
     *
     * @param token
     */
    private void connect(String token) {
        progressDialog=ProgressDialog.show(RongIM_MainActivity.this,"","登录中，请稍候····");
        if (getApplicationInfo().packageName.equals(APP.getCurProcessName(getApplicationContext()))) {

            /**
             * IMKit SDK调用第二步,建立与服务器的连接
             */
            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误，在线上环境下主要是因为 Token 已经过期，您需要向 App Server 重新请求一个新的 Token
                 */
                @Override
                public void onTokenIncorrect() {

                    Log.d("LoginActivity", "--onTokenIncorrect");
                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token
                 */
                @Override
                public void onSuccess(String userid) {

                    Log.d("LoginActivity", "--onSuccess" + userid);
                    progressDialog.dismiss();
                    if (RongIM.getInstance() != null)
                        RongIM.getInstance().startConversationList(RongIM_MainActivity.this);
                  //  startActivity(new Intent(RongIM_MainActivity.this, ConListActivity.class));
                    finish();
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                    Log.d("LoginActivity", "--onError" + errorCode);
                }
            });
        }
    }

}
