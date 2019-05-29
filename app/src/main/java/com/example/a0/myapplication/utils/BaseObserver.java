package com.example.a0.myapplication.utils;

import android.util.Log;
import io.reactivex.Observer;

/**
 * Created by $lzj on 2019/5/6.
 */
public abstract class BaseObserver<T> implements Observer<T> {

    private final String Tag = getClass().getName();

    @Override
    public void onComplete() {
        Log.i(Tag, "onComplete: ");
    }

    @Override
    public void onError(Throwable e) {
        Log.i(Tag, "onComplete: "+e.getMessage());
    }
}
