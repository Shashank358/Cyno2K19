package com.cynasure.cyno2k19.RecyclerData;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cynasure.cyno2k19.ListAdapter;
import com.cynasure.cyno2k19.R;

public class TeamAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private final static int FADE_DURATION = 1000; //FADE_DURATION in milliseconds
    private OnItemClickListener mOnItemClickListener;
    private OnItemClickListener mEmailClickListener;

    public TeamAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public OnItemClickListener getOnItemClickListener() {
        return mOnItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClicked(int pos);
    }

    public OnItemClickListener getOnEmailClickListener() {
        return mEmailClickListener;
    }

    public void setOnEmailClickListener(OnItemClickListener onItemClickListener) {
        mEmailClickListener = onItemClickListener;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.team_single_layout, viewGroup, false);
        return new ViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int i) {

        ((TeamAdapter.ViewHolder)holder).bindView(i);

        ((ViewHolder) holder).mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClicked(holder.getAdapterPosition());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClicked(holder.getAdapterPosition());
            }
        });

        ((ViewHolder) holder).email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmailClickListener.onItemClicked(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return teamData.profile.length;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView mItemImage, teamBack;
        private TextView name, mobile, email;
        Context context;

        public ViewHolder(View itemView, Context context){

            super(itemView);
            this.context = context;
            mItemImage = (ImageView) itemView.findViewById(R.id.member_profile);
            teamBack = (ImageView) itemView.findViewById(R.id.team_background);
            name = (TextView) itemView.findViewById(R.id.member_name1);
            mobile = (TextView) itemView.findViewById(R.id.member_mobile1);
            email = (TextView) itemView.findViewById(R.id.member_email);

        }

        public void bindView(int position){
            mItemImage.setImageResource(teamData.profile[position]);
            teamBack.setImageResource(teamData.team_back[position]);
            name.setText(teamData.member_name[position]);
            mobile.setText(teamData.member_mob_number[position]);
            email.setText(teamData.member_email[position]);

        }
    }

}
