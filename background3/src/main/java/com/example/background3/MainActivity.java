package com.example.background3;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;

import com.example.background3.adapters.Myadapter;
import com.example.background3.adapters.Vpager;
import com.example.background3.beans.Bean;
import com.example.background3.medol.Medolimple;
import com.example.background3.presenter.Presenimple;
import com.example.background3.view.Mview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Mview {

    private RecyclerView recy;
    private List<Bean.ResultsBean> arrayList;
    private Myadapter myadapter;
    private String TAG;
    private List<Bean.ResultsBean> results;
    private ArrayList<View> views;
    private Vpager vpager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        GridLayoutManager gr = new GridLayoutManager(this, 2);
        recy.setLayoutManager(gr);
        arrayList = new ArrayList<>();
        myadapter = new Myadapter(this, arrayList);
        recy.setAdapter(myadapter);
        initdata();
        listenner();
    }

    private void listenner() {
        myadapter.setListenneritem(new Myadapter.item() {
            @Override
            public void holderitem(View view, int position) {
                setpopu(view,position);
            }
        });
    }

    private void setpopu(View view, int position) {
        View inflate = View.inflate(MainActivity.this, R.layout.popu_layout, null);
        PopupWindow window = new PopupWindow(inflate);
        window.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        window.setOutsideTouchable(true);
        window.showAsDropDown(inflate,200,200);

        views = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            View inflate1 = LayoutInflater.from(this).inflate(R.layout.image_layout, null);
            views.add(inflate1);
        }
        vpager = new Vpager(arrayList, this, views);
    }

    private void initdata() {
        Presenimple presenimple = new Presenimple(new Medolimple(), this);
        presenimple.getdata();
    }

    @Override
    public void seccuss(Bean bean) {
        results = bean.getResults();
        arrayList.addAll(results);
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void flied(String mes) {
        Log.i(TAG, "flied: "+mes);
    }
}
