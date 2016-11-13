package com.example.sth0409.mylive20.CardSlidePanel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 卡片数据装载对象
 *
 * @author xmuSistone
 */
public class CardDataItem implements Parcelable {
    public String imagePath;

    public CardDataItem() {
    }

    public CardDataItem(String imagePath, String author, String title, String videoUrl) {
        this.imagePath = imagePath;
        this.author = author;
        this.title = title;
        this.videoUrl = videoUrl;
    }

    public String getImagePath() {
        return imagePath;

    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public  String author;
    public  String title;
    public  String videoUrl;
    // String userName;
//    int likeNum;
//    int imageNum;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imagePath);
        dest.writeString(this.author);
        dest.writeString(this.title);
        dest.writeString(this.videoUrl);
    }

    protected CardDataItem(Parcel in) {
        this.imagePath = in.readString();
        this.author = in.readString();
        this.title = in.readString();
        this.videoUrl = in.readString();
    }

    public static final Parcelable.Creator<CardDataItem> CREATOR = new Parcelable.Creator<CardDataItem>() {
        @Override
        public CardDataItem createFromParcel(Parcel source) {
            return new CardDataItem(source);
        }

        @Override
        public CardDataItem[] newArray(int size) {
            return new CardDataItem[size];
        }
    };
}
