package com.example.sth0409.mylive20.RongIM;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sth0409.mylive20.R;

import io.rong.imkit.RongIM;

public class UserListActivity extends Activity implements AdapterView.OnItemClickListener {
    ListView listView;
    UserAdapter userAdapter;
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        listView = (ListView) findViewById(R.id.listView);
        userManager = new UserManager(this);
        userAdapter = new UserAdapter(this);
        initData();
        listView.setAdapter(userAdapter);
        listView.setOnItemClickListener(this);
    }

    private void initData() {
        userAdapter.AddData(userManager.user1);
        userAdapter.AddData(userManager.user2);
        userAdapter.AddData(userManager.user3);
        userAdapter.AddData(userManager.user4);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (RongIM.getInstance() != null)
            RongIM.getInstance().startPrivateChat(this, userAdapter.getUserList().get(i).userInfo.getUserId(), userAdapter.getUserList().get(i).userInfo.getName());
    }
}
