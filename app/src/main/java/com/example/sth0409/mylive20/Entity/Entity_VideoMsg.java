package com.example.sth0409.mylive20.Entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by STH0409 on 2016/10/19.
 */

public class Entity_VideoMsg implements Parcelable {
    public String Url_video;
    public String Url_img;
    public String tv_title;
    public String tv_msg;

    public String getUrl_video() {
        return Url_video;
    }

    public void setUrl_video(String url_video) {
        Url_video = url_video;
    }

    public String getUrl_img() {
        return Url_img;
    }

    public void setUrl_img(String url_img) {
        Url_img = url_img;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_msg() {
        return tv_msg;
    }

    public void setTv_msg(String tv_msg) {
        this.tv_msg = tv_msg;
    }

    public Entity_VideoMsg() {
    }

    public Entity_VideoMsg(String url_video, String url_img, String tv_title, String tv_msg) {
        Url_video = url_video;
        Url_img = url_img;
        this.tv_title = tv_title;
        this.tv_msg = tv_msg;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Url_video);
        dest.writeString(this.Url_img);
        dest.writeString(this.tv_title);
        dest.writeString(this.tv_msg);
    }

    protected Entity_VideoMsg(Parcel in) {
        this.Url_video = in.readString();
        this.Url_img = in.readString();
        this.tv_title = in.readString();
        this.tv_msg = in.readString();
    }

    public static final Creator<Entity_VideoMsg> CREATOR = new Creator<Entity_VideoMsg>() {
        @Override
        public Entity_VideoMsg createFromParcel(Parcel source) {
            return new Entity_VideoMsg(source);
        }

        @Override
        public Entity_VideoMsg[] newArray(int size) {
            return new Entity_VideoMsg[size];
        }
    };
}
