package com.example.background3.api;

import com.example.background3.beans.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    String url = " http://gank.io/api/data/";
    @GET("%E7%A6%8F%E5%88%A9/20/1")
    Observable<Bean> geturl();
}
