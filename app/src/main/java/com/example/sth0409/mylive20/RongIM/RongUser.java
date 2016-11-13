package com.example.sth0409.mylive20.RongIM;

import android.os.Parcel;
import android.os.Parcelable;

import java.security.PublicKey;

import io.rong.imlib.model.UserInfo;

/**
 * Created by sth0409 on 2016/6/5.
 */
public class RongUser implements Parcelable{
    public  UserInfo userInfo;
    public  String userToken;

    public RongUser(UserInfo userInfo, String userToken) {
        this.userInfo = userInfo;
        this.userToken = userToken;
    }

    public RongUser() {
    }

    protected RongUser(Parcel in) {
        userInfo = in.readParcelable(UserInfo.class.getClassLoader());
        userToken = in.readString();
    }

    public static final Creator<RongUser> CREATOR = new Creator<RongUser>() {
        @Override
        public RongUser createFromParcel(Parcel in) {
            return new RongUser(in);
        }

        @Override
        public RongUser[] newArray(int size) {
            return new RongUser[size];
        }
    };



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(userInfo, i);
        parcel.writeString(userToken);
    }
}
