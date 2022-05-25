package com.app.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private int LISTTYPE;
    private ArrayList images;

    public Adapter(int i, ArrayList images) {
        this.LISTTYPE = i;
        this.images = images;
    }

    public Adapter(int i) {
        this.LISTTYPE = i;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (LISTTYPE ==0 || LISTTYPE == 1)
            listItem = layoutInflater.inflate(R.layout.child_item_layout, parent, false);
        else if (LISTTYPE == 3)
            listItem = layoutInflater.inflate(R.layout.child_item_moments, parent, false);
        else if (LISTTYPE == 4)
            listItem = layoutInflater.inflate(R.layout.layout_add_to_mpments, parent, false);

        return new Adapter.ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        if (LISTTYPE == 0)
        {
            holder.rlMoments.setVisibility(View.VISIBLE);
            holder.rlContacts.setVisibility(View.GONE);
        }
        else if (LISTTYPE == 1){
            holder.rlContacts.setVisibility(View.VISIBLE);
            holder.rlMoments.setVisibility(View.GONE);
        }
        else if (LISTTYPE == 3){
            holder.rlAction.setVisibility(View.VISIBLE);
        }
        else if (LISTTYPE == 4){
            if (position == 0 ){
                holder.rlAddToMoments.setVisibility(View.VISIBLE);
                holder.rlMomentsItem.setVisibility(View.GONE);
            }
            else {
                holder.rlAddToMoments.setVisibility(View.GONE);
                holder.rlMomentsItem.setVisibility(View.VISIBLE);
                int res = (int) images.get(position);
                holder.ivMoments.setImageResource(res);
            }
        }
    }

    @Override
    public int getItemCount() {
        if (LISTTYPE == 3)
            return 4;
        else if (LISTTYPE == 4)
            return images.size();
        else
            return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout rlMoments,rlContacts,rlAction,rlAddToMoments,rlMomentsItem;
        ImageView ivMoments;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (LISTTYPE ==0 || LISTTYPE == 1) {
                rlMoments = itemView.findViewById(R.id.rlMoments);
                rlContacts = itemView.findViewById(R.id.rlContacts);
            }
            else if (LISTTYPE == 3){
                rlAction = itemView.findViewById(R.id.rlAction);
            }
            else if (LISTTYPE == 4)
            {
                ivMoments = itemView.findViewById(R.id.ivMoments);
                rlAddToMoments = itemView.findViewById(R.id.rlAddToMoments);
                rlMomentsItem = itemView.findViewById(R.id.rlMomentsItem);
            }
        }
    }
}
