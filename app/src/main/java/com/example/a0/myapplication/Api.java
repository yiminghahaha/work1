package com.example.a0.myapplication;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = "https://www.wanandroid.com/";
    @GET("banner/json")
    Observable<Bean> geturl();
}
