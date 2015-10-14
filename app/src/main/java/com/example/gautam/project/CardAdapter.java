package com.example.gautam.project;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gts on 13/10/15.
 */

/**
 * Created by gts on 29/9/15.
 */
public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<NatureItem> mItems;
    private Context context;

    public CardAdapter(Context context) {
        super();
        this.context = context;
        mItems = new ArrayList<NatureItem>();
        NatureItem nature = new NatureItem();

        nature.setmDes("TYPE A PLACE AND GET THE DIRECTION.");
        nature.setmThumbnail(R.mipmap.s);
        mItems.add(nature);

        nature = new NatureItem();

        nature.setmDes("NEAR BY KNOW WHAT'S AROUND.");
        nature.setmThumbnail(R.mipmap.m);
        mItems.add(nature);
        nature = new NatureItem();

        nature.setmDes("DEALS                              ");
        nature.setmThumbnail(R.mipmap.d1);
        mItems.add(nature);
        nature = new NatureItem();

        nature.setmDes("VIEW YOUR TRIP        ");
        nature.setmThumbnail(R.mipmap.star);
        mItems.add(nature);
        nature = new NatureItem();

        nature.setmDes("CUSTOMIZE YOUR TRIP ");
        nature.setmThumbnail(R.mipmap.star);
        mItems.add(nature);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_main, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder,final int i) {
        NatureItem nature = mItems.get(i);
        viewHolder.tvNature.setText(nature.getmDes());
        viewHolder.imgThumbnail.setImageResource(nature.getmThumbnail());
        viewHolder.imgThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Activity2.class);
                intent.putExtra("POSITION",i);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        public ImageView imgThumbnail;
        public TextView tvNature;
        public ViewHolder(View itemView) {
            super(itemView);
            cv=(CardView)itemView.findViewById(R.id.card_view);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.imageView1);
            tvNature = (TextView)itemView.findViewById(R.id.textView1);
        }
    }
}