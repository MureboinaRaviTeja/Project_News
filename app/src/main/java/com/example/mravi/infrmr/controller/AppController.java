package com.example.mravi.infrmr.controller;

import android.app.Application;
import android.app.DownloadManager;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static android.R.attr.tag;

/**
 * Created by mravi on 20-12-2017.
 */


public class AppController extends Application {

public static final String  TAG=AppController.class.getSimpleName();
    private static AppController mInstance;
    private RequestQueue mRequestQueue;

    public static synchronized  AppController getInstance(){
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    mInstance=this;
    }

public RequestQueue getRequestQueue(){
    if(mRequestQueue==null)
    {
        mRequestQueue= Volley.newRequestQueue(getApplicationContext());

    }
    return mRequestQueue;

}

public <T>  void  addToRequestQueue(Request<T> req, String tag){
    req.setTag(TextUtils.isEmpty(tag) ?TAG: tag);
    getRequestQueue().add(req);


}

public <T> void addToRequestQueue(Request<T> req){
    req.setTag(TAG);

    getRequestQueue().add(req);

}

public void cancelPendingRequest(Object tag){
    if(mRequestQueue!=null){
        mRequestQueue.cancelAll(tag);
    }

}


}
