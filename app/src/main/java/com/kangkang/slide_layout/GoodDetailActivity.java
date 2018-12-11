package com.kangkang.slide_layout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.kangkang.slide_layout.fragment.CommentFragment;
import com.kangkang.slide_layout.fragment.DetailFragment;
import com.kangkang.slide_layout.fragment.GoodsFragment;

import java.util.ArrayList;
import java.util.List;

public class GoodDetailActivity extends AppCompatActivity {
    Toolbar toolBar;
    public ViewPager viewPager;
    public TextView tv_tab1;
    public TextView tv_tab2;
    public TextView tv_tab3;
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);
        initView();
        initListener();
    }

    private void initListener() {
        //设置左侧NavigationIcon点击事件
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        tv_tab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(0);
                tv_tab1.setBackgroundResource(R.color.black);
                tv_tab2.setBackgroundResource(R.color.white);
                tv_tab3.setBackgroundResource(R.color.white);
                tv_tab1.setTextColor(getResources().getColor(R.color.white));
                tv_tab2.setTextColor(getResources().getColor(R.color.black));
                tv_tab3.setTextColor(getResources().getColor(R.color.black));
            }
        });

        tv_tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(1);
                tv_tab1.setBackgroundResource(R.color.white);
                tv_tab2.setBackgroundResource(R.color.black);
                tv_tab3.setBackgroundResource(R.color.white);
                tv_tab1.setTextColor(getResources().getColor(R.color.black));
                tv_tab2.setTextColor(getResources().getColor(R.color.white));
                tv_tab3.setTextColor(getResources().getColor(R.color.black));
            }
        });

        tv_tab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
                tv_tab1.setBackgroundResource(R.color.white);
                tv_tab2.setBackgroundResource(R.color.white);
                tv_tab3.setBackgroundResource(R.color.black);
                tv_tab1.setTextColor(getResources().getColor(R.color.black));
                tv_tab2.setTextColor(getResources().getColor(R.color.black));
                tv_tab3.setTextColor(getResources().getColor(R.color.white));
            }
        });
    }

    private void initView() {
        toolBar = findViewById(R.id.toolBar);
        tv_tab1 = findViewById(R.id.tv_tab1);
        tv_tab2 = findViewById(R.id.tv_tab2);
        tv_tab3 = findViewById(R.id.tv_tab3);
        viewPager = findViewById(R.id.viewPager);
        fragmentList = new ArrayList<>();
        fragmentList.add(new GoodsFragment());
        fragmentList.add(new DetailFragment());
        fragmentList.add(new CommentFragment());

        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private class FragmentAdapter extends FragmentPagerAdapter{

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }
}
