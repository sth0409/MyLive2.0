package com.example.sth0409.mylive20.RongIM;

import android.app.Application;
import android.content.Context;
import android.net.Uri;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

/**
 * Created by sth0409 on 2016/6/5.
 */
public class UserManager {
    RongUser user1;
    RongUser user2;
    RongUser user3;
    RongUser user4;
    Uri uri1 = Uri.parse("http://img4.imgtn.bdimg.com/it/u=25955219,1834836773&fm=21&gp=0.jpg");
    Uri uri2 = Uri.parse("http://img0.imgtn.bdimg.com/it/u=2761703553,264202065&fm=21&gp=0.jpg");
    Uri uri3 = Uri.parse("http://img2.imgtn.bdimg.com/it/u=3630825009,3575870853&fm=21&gp=0.jpg");
    Uri uri4 = Uri.parse("http://img.woyaogexing.com/2016/06/03/4685df54058028bf!200x200.jpg");

    public UserManager(Context context) {
        user1 = new RongUser(new UserInfo("1", "用户1", uri1), "bSv8mCRHA1tNfvnOJ2JM4h3x2fR9mJp4Mtg4PrEzn8gkb7lzuFsViV9tr5yFMnQjjG36ZKo0cU6Zq8cHszTQkg");
        user2 = new RongUser(new UserInfo("2", "用户2", uri2), "C2PAsoGFy3vcPL+81W56cx3x2fR9mJp4Mtg4PrEzn8gkb7lzuFsViROLbqLHqXQt0qrTo7Nws42Zq8cHszTQkg==");
        user3 = new RongUser(new UserInfo("3", "用户3", uri3), "9rastn835FZ+6KYP4PWgMR3x2fR9mJp4Mtg4PrEzn8gkb7lzuFsViYfsc+hJTCadkBlwDJzZ+S+Zq8cHszTQkg==");
        user4 = new RongUser(new UserInfo("4", "用户4", uri4), "8Y6qiB+OqKUtOLzsMYUiFNMforR4lwlpgIimijrmmsApAE9BAcR4zzhl99knPJUL1ngjW0mO0ZY=");


    }


}
