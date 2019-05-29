package com.example.a0.myapplication.presenter;

import com.example.a0.myapplication.Bean;
import com.example.a0.myapplication.medol.Medol;
import com.example.a0.myapplication.view.Mview;

public class Presenterimple implements Presen{
    private Medol medol;
    private Mview mview;

    public Presenterimple(Medol medol, Mview mview) {
        this.medol = medol;
        this.mview = mview;
    }

    @Override
    public void getdata() {
        medol.getdata(new Callback() {
            @Override
            public void seccuss(Bean bean) {
                mview.seccuss(bean);
            }

            @Override
            public void filed(String mes) {
                mview.filed(mes);
            }
        });
    }
}
