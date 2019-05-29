package com.example.background3.presenter;

import com.example.background3.beans.Bean;
import com.example.background3.medol.Medol;
import com.example.background3.view.Mview;

public class Presenimple implements Presen{
    private Medol medol;
    private Mview mview;

    public Presenimple(Medol medol, Mview mview) {
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
            public void flied(String mes) {
                mview.flied(mes);
            }
        });
    }
}
