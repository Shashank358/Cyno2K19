package com.cynasure.cyno2k19.RecyclerData;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.cynasure.cyno2k19.AllBranches.ComputerEvents;
import com.cynasure.cyno2k19.R;

public class Adapter extends RecyclerView.Adapter {

    private Context context;
    private final static int FADE_DURATION = 1000; //FADE_DURATION in milliseconds

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.university_single_layout, parent, false);
        return new ListViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ListViewHolder)holder).bindView(position);

    }

    @Override
    public int getItemCount() {
        return imageData.picturePath.length;
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mItemImage;
        Context context;

        public ListViewHolder(View itemView, Context context){

            super(itemView);
            this.context = context;
            mItemImage = (ImageView) itemView.findViewById(R.id.university_image);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mItemImage.setImageResource(imageData.picturePath[position]);
        }

        public void onClick(View view){

        }

    }
}
