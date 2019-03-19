package com.cynasure.cyno2k19.RecyclerData;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import com.cynasure.cyno2k19.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SponsorsAdapter extends RecyclerView.Adapter<SponsorsAdapter.ViewHolder> {
    @NonNull

    private Context context;
    private List<Sponsors> mSpons;
    private final static int FADE_DURATION = 1000; //FADE_DURATION in milliseconds

    public SponsorsAdapter(@NonNull Context context, List<Sponsors> mSpons) {
        this.context = context;
        this.mSpons = mSpons;
    }

    @Override
    public SponsorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.spons_single_layout, viewGroup, false);
        return new SponsorsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SponsorsAdapter.ViewHolder viewHolder, int i) {

        final Sponsors sponsors = mSpons.get(i);

        final Picasso picasso = Picasso.get();
        picasso.setIndicatorsEnabled(false);
        picasso.load(sponsors.getImage()).placeholder(R.drawable.line)
                .networkPolicy(NetworkPolicy.OFFLINE).into(viewHolder.mItemImage, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                picasso.load(sponsors.getImage()).placeholder(R.drawable.line)
                        .into(viewHolder.mItemImage);
            }
        });

        setScaleAnimation(viewHolder.itemView);
    }

    private void setScaleAnimation(View view) {
        ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }

    @Override
    public int getItemCount() {
        return mSpons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mItemImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemImage = (ImageView) itemView.findViewById(R.id.sponsors_image);

        }
    }
}
