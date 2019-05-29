package com.example.a0.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.a0.myapplication.medol.Medolimple;
import com.example.a0.myapplication.presenter.Presenterimple;
import com.example.a0.myapplication.view.Mview;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Mview {

    private RecyclerView rec;
    private List<Bean.DataBean> dataBeans;
    private Myadapter myadapter;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        rec = (RecyclerView) findViewById(R.id.rec);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        rec.setLayoutManager(ma);
        dataBeans = new ArrayList<>();
        myadapter = new Myadapter(this, dataBeans);
        rec.setAdapter(myadapter);
        initdata();
    }

    private void initdata() {
        Presenterimple presenterimple = new Presenterimple(new Medolimple(), this);
        presenterimple.getdata();
    }

    @Override
    public void seccuss(Bean bean) {
        if (bean!=null){
            List<Bean.DataBean> data = bean.getData();
            dataBeans.addAll(data);
            myadapter.notifyDataSetChanged();
        }
    }

    @Override
    public void filed(String mes) {
        Log.i(TAG, "filed: "+mes);
    }
}
