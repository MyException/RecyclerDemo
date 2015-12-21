package com.longjian.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private String[] mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitData();
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        /**
         * 设置布局管理器
         */
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        /**
         * 添加分割线
         * 竖直的分割线
         */
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        /**
         * 设置适配器
         */
        recyclerView.setAdapter(homeAdapter = new HomeAdapter());
    }

    private void InitData() {
        mData = new String[20];
        for (int i = 0; i < 20; i++) {
            mData[i] = i + "";
        }
    }

    class HomeAdapter extends RecyclerView.Adapter<MyHodlerView> {
        /**
         * 使用viewHolder进行数据复用
         *
         * @param viewGroup
         * @param i
         * @return
         */
        @Override
        public MyHodlerView onCreateViewHolder(ViewGroup viewGroup, int i) {
            MyHodlerView myHodlerView = new MyHodlerView(MainActivity.this.getLayoutInflater().inflate(R.layout.item_view, null));
            return myHodlerView;
        }

        /**
         * 使用onBindingViewHolder进行数据与View的绑定
         *
         * @param myHodlerView
         * @param i
         */
        @Override
        public void onBindViewHolder(MyHodlerView myHodlerView, int i) {
            myHodlerView.tv.setText(mData[i]);
        }

        /**
         * 有多少条目的item
         *
         * @return
         */
        @Override
        public int getItemCount() {
            return mData.length;
        }
    }

    class MyHodlerView extends RecyclerView.ViewHolder {
        TextView tv;

        public MyHodlerView(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_item);

        }

    }
}
