package com.bankeys.pension.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bankeys.pension.test.adapter.RecyForListAdapter;
import com.bankeys.pension.test.adapter.RecyForStaggeredAdapter;

public class RecyclerViewActivity extends AppCompatActivity {
    public static final int LIST = 1;
    public static final int GRID = 2;
    public static final int PBL = 3;
    private int activity_type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        activity_type = getIntent().getIntExtra("activity_type", -1);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        if (activity_type == LIST) {
            LinearLayoutManager manager = new LinearLayoutManager(this);

            mRecyclerView.setLayoutManager(manager);
            mRecyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
                @Override
                public void onViewRecycled(RecyclerView.ViewHolder holder) {
                }
            });
        } else if (activity_type == GRID) {
            GridLayoutManager grid = new GridLayoutManager(this,3);
            mRecyclerView.setLayoutManager(grid);
            mRecyclerView.setAdapter(new RecyForListAdapter());

        } else if (activity_type == PBL) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
            mRecyclerView.setAdapter(new RecyForStaggeredAdapter(this));
        }
    }
}
