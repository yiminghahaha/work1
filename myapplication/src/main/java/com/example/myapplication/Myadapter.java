package com.example.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder> {
    private Context context;
    private ArrayList<String> strings;
    private  item listenneritem;

    public void setListenneritem(item listenneritem) {
        this.listenneritem = listenneritem;
    }

    public Myadapter(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
    }
    public  interface  item{
        void  itemholder(View view,int position);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item_layout, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txt.setText(strings.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listenneritem.itemholder(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView txt;

        public ViewHolder(View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.show);
        }
    }
}
