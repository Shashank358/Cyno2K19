package com.cynasure.cyno2k19;

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
import android.widget.TextView;

import com.cynasure.cyno2k19.AllBranches.ComputerEvents;
import com.cynasure.cyno2k19.RecyclerData.OurData;

public class ListAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private final static int FADE_DURATION = 1000; //FADE_DURATION in milliseconds

    public ListAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void onItemClicked(int pos);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.branch_single_layout, parent, false);
        return new ListViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {

        ((ListViewHolder)holder).bindView(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClicked(holder.getAdapterPosition());
            }
        });

        setScaleAnimation(holder.itemView);
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return OurData.picturePath.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView mItemImage;
        private TextView mTitle;
        Context context;

        public ListViewHolder(View itemView, Context context){

            super(itemView);
            this.context = context;
            mItemImage = (ImageView) itemView.findViewById(R.id.branch_logo);
            mTitle = (TextView) itemView.findViewById(R.id.branch_name);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            mItemImage.setImageResource(OurData.picturePath[position]);
            mTitle.setText(OurData.movies_title[position]);
        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
        }
    }
}
