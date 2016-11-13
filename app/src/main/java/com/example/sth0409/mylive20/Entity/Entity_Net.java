package com.example.sth0409.mylive20.Entity;

import android.os.Parcelable;

import java.util.Map;

/**
 * Created by STH0409 on 2016/11/1.
 */

public class Entity_Net {
    Map<String,String> Url;
    Map<String,String>  params;
    Map<String,String>  encSecKey;
    Map<String,String>  csrf_token;
    Map<String,String>  Host;
    Map<String,String> Referer;
    public Entity_Net() {
    }

    public Entity_Net(Map url, Map params, Map encSecKey, Map csrf_token, Map host, Map referer) {
        Url = url;
        this.params = params;
        this.encSecKey = encSecKey;
        this.csrf_token = csrf_token;
        Host = host;
        Referer = referer;
    }


    public Map getUrl() {
        return Url;
    }

    public void setUrl(Map url) {
        Url = url;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public Map getEncSecKey() {
        return encSecKey;
    }

    public void setEncSecKey(Map encSecKey) {
        this.encSecKey = encSecKey;
    }

    public Map getCsrf_token() {
        return csrf_token;
    }

    public void setCsrf_token(Map csrf_token) {
        this.csrf_token = csrf_token;
    }

    public Map getHost() {
        return Host;
    }

    public void setHost(Map host) {
        Host = host;
    }

    public Map getReferer() {
        return Referer;
    }

    public void setReferer(Map referer) {
        Referer = referer;
    }


}
