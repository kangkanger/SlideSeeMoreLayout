package com.kangkang.slide_layout;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    private List<String> beans;

    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }

    private void initView() {
        context = this;
        gridView = findViewById(R.id.gridView);
    }

    private void initData() {
        beans = new ArrayList<>();
        beans.add("第1个商品");
        beans.add("第2个商品");
        beans.add("第3个商品");
        beans.add("第4个商品");
        beans.add("第5个商品");
        beans.add("第6个商品");


        MyAdapter adapter = new MyAdapter();
        gridView.setAdapter(adapter);
    }

    private void initListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this,GoodDetailActivity.class));
            }
        });

    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return beans.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = LayoutInflater.from(context).inflate(R.layout.item_goods,null);
            TextView textView = view.findViewById(R.id.tv_name);
            textView.setText(beans.get(i));
            return view;
        }
    }

}
