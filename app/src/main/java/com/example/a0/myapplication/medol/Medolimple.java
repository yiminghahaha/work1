package com.example.a0.myapplication.medol;

import com.example.a0.myapplication.Api;
import com.example.a0.myapplication.Bean;
import com.example.a0.myapplication.presenter.Callback;
import com.example.a0.myapplication.utils.BaseObserver;
import com.example.a0.myapplication.utils.HttpUtils;
import com.example.a0.myapplication.utils.RxUtils;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Medolimple implements Medol{

    @Override
    public void getdata(final Callback callback) {
        final CompositeDisposable compositeDisposable = new CompositeDisposable();

       // compositeDisposable.add(d);
        //网络抽取三步骤
        Api apiService = HttpUtils.getInstance().getApiService(Api.url, Api.class);
        Observable<Bean> geturl = apiService.geturl();
        geturl.compose(RxUtils.<Bean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                           // compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(Bean bean) {
                        callback.seccuss(bean);
                    }
                });
    }
}
