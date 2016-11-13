package com.example.sth0409.mylive20.RongIM;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sth0409.mylive20.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sth0409 on 2016/6/5.
 */
public class UserAdapter extends BaseAdapter {

    LayoutInflater inflater;

    public List<RongUser> getUserList() {
        return userList;
    }

    public void setUserList(List<RongUser> userList) {
        this.userList = userList;
    }

    public void  AddData( RongUser rongUser){
        userList.add(rongUser);
    }



    private List<RongUser> userList;
    Context context;

    public UserAdapter(Context context){
        this.context=context;

        inflater=LayoutInflater.from(context);
        userList=new ArrayList<>();

    }
    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view=inflater.inflate(R.layout.item_user,null);
        RongUser user=userList.get(i);
        ImageView imageView= (ImageView) view.findViewById(R.id.imageView);
        TextView textView= (TextView) view.findViewById(R.id.textView);
        Glide.with(context).load(user.userInfo.getPortraitUri()).into(imageView);
        textView.setText(user.userInfo.getName());
        return view;
    }
}
