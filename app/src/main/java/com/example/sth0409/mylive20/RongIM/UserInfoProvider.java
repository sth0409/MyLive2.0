package com.example.sth0409.mylive20.RongIM;

import android.net.Uri;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

/**
 * Created by sth0409 on 2016/6/5.
 */
public class UserInfoProvider {

   public UserInfoProvider(){
       RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
           @Override
           public UserInfo getUserInfo(String userId) {
               return findUserById(userId);//根据 userId 去你的用户系统里查询对应的用户信息返回给融云 SDK。
           }
       }, true);
    }
    private UserInfo findUserById(String userId) {
        switch (userId) {
            case "1":
                return new UserInfo("1","用户1", Uri.parse("http://img4.imgtn.bdimg.com/it/u=25955219,1834836773&fm=21&gp=0.jpg"));
            case "2":
                return new UserInfo("2","用户2", Uri.parse("http://img0.imgtn.bdimg.com/it/u=2761703553,264202065&fm=21&gp=0.jpg"));
            case "3":
                return new UserInfo("3","用户3", Uri.parse("http://img2.imgtn.bdimg.com/it/u=3630825009,3575870853&fm=21&gp=0.jpg"));
            case "4":
                return new UserInfo("4","用户4", Uri.parse("http://img.woyaogexing.com/2016/06/03/4685df54058028bf!200x200.jpg"));
        }
        return null;
    }
}
