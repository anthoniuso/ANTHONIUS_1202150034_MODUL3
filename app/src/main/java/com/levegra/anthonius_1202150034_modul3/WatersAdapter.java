package com.levegra.anthonius_1202150034_modul3;

/**
 * Created by antoniusongkowijoyo on 23/02/18.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the sports data
 */
class WatersAdapter extends RecyclerView.Adapter<WatersAdapter.WatersViewHolder>  {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Water> mWatersData;
    private Context mContext;

    WatersAdapter(Context context, ArrayList<Water> waterData) {
        this.mWatersData = waterData;
        this.mContext = context;

        //Membuat placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Menyamakan ukuran placeholder dengan gambar
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.aqua);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    @Override
    public WatersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WatersViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(WatersViewHolder holder, int position) {

        //Ambil data water
        Water currentWater = mWatersData.get(position);

        //Taruh data pada view
        holder.bindTo(currentWater);

    }

    @Override
    public int getItemCount() {
        return mWatersData.size();
    }

    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class WatersViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mWatersImage;
        private Context mContext;
        private Water mCurrentWater;
        private GradientDrawable mGradientDrawable;

        WatersViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mWatersImage = (ImageView)itemView.findViewById(R.id.waterImages);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Water currentWater){
            //Populate the textviews with data
            mTitleText.setText(currentWater.getTitle());
            mInfoText.setText(currentWater.getInfo());

            //Get the current sport
            mCurrentWater = currentWater;

            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentWater.
                    getImageResource()).placeholder(mGradientDrawable).into(mWatersImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Water.starter(mContext, mCurrentWater.getTitle(),
                    mCurrentWater.getImageResource());

            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}