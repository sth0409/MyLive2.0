package com.example.sth0409.mylive20.Data;

import com.example.sth0409.mylive20.Entity.Entity_CommentUser;

/**
 * Created by STH0409 on 2016/11/1.
 */

public class Data_commentsMsg {
    Entity_CommentUser entity_commentUser;
    String likedCount;

    public Data_commentsMsg() {
    }

    public Data_commentsMsg(Entity_CommentUser entity_commentUser, String likedCount, String content) {
        this.entity_commentUser = entity_commentUser;
        this.likedCount = likedCount;

        this.content = content;
    }

    public Entity_CommentUser getEntity_commentUser() {
        return entity_commentUser;
    }

    public void setEntity_commentUser(Entity_CommentUser entity_commentUser) {
        this.entity_commentUser = entity_commentUser;
    }

    public String getLikedCount() {
        return likedCount;
    }

    public void setLikedCount(String likedCount) {
        this.likedCount = likedCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    String content;


}
