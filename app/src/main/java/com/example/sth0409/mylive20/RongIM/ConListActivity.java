package com.example.sth0409.mylive20.RongIM;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.example.sth0409.mylive20.R;

import io.rong.imkit.RongIM;
public class ConListActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_list);
        new UserInfoProvider();
        this.findViewById(R.id.btn_userlist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ConListActivity.this, UserListActivity.class));
            }
        });

        this.findViewById(R.id.btn_logoff).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().logout();
                //    RongIM.getInstance().disconnect();

                startActivity(new Intent(ConListActivity.this, RongIM_MainActivity.class));
                finish();
            }
        });


    }


}
