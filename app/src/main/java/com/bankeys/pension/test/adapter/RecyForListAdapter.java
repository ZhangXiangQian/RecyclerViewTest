package com.bankeys.pension.test.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bankeys.pension.test.R;


/**
 * Created by zhang on 2016/6/23.
 */
public class RecyForListAdapter extends RecyclerView.Adapter<RecyForListAdapter.RecyForList> implements View.OnClickListener{
    private RecyForListClickListener listener;

    public void setListener(RecyForListClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyForList onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_list_item,parent,false);
        return new RecyForList(v);
    }

    @Override
    public void onBindViewHolder(RecyForList holder, int position) {
        //数据绑定
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onRecyForListClickListener();
        }
    }

    public  static class RecyForList extends RecyclerView.ViewHolder{
        TextView tv_title ,tv_content;
        public RecyForList(View itemView) {
            super(itemView);
        }
    }

    public interface  RecyForListClickListener{
        public void onRecyForListClickListener();
    }
}
