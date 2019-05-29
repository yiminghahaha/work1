package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recy;
    private ArrayList<String> string;
    private Myadapter myadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recy = (RecyclerView) findViewById(R.id.recy);
        LinearLayoutManager ma = new LinearLayoutManager(this);
        recy.setLayoutManager(ma);
        string = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            string.add("呵呵"+i);
        }
        myadapter = new Myadapter(this, string);
        recy.setAdapter(myadapter);


        myadapter.setListenneritem(new Myadapter.item() {
            @Override
            public void itemholder(View view, int position) {
                Student student = new Student();
                student.setId(null);
                student.setName(string.get(position));
                DaoUtils.getDaoUtils().insertAll(student);
                Toast.makeText(MainActivity.this, "插入成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
