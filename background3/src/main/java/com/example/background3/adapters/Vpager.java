package com.example.background3.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.background3.R;
import com.example.background3.beans.Bean;
import java.util.ArrayList;
import java.util.List;

public class Vpager extends PagerAdapter {

    private List<Bean.ResultsBean> arrayList;
    private Context context;
    private  ArrayList<View> views;
    private ImageView imageView;

    public Vpager(List<Bean.ResultsBean> arrayList, Context context, ArrayList<View> views) {
        this.arrayList = arrayList;
        this.context = context;
        this.views = views;

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int i = views.size() - 1;
        View view = views.get(i - position);
        imageView = view.findViewById(R.id.item_image);
        setdata(i-position);
        container.addView(imageView);
        return super.instantiateItem(container, position);
    }

    private void setdata(int i) {
        Glide.with(context).load(arrayList.get(i).getUrl())
                .into(imageView);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(views.size()-1-position));
    }

}
