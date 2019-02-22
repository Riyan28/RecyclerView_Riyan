package com.riyan.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by PLJC-PC on 22/02/2019.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.CardViewHolder>{

    @Override
    public RvAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RvAdapter.CardViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class CardViewHolder extends RecyclerView.ViewHolder {
        public CardViewHolder(View itemView) {
            super(itemView);
        }
    }
}
