package com.kangkang.slide_layout.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kangkang.slide_layout.GoodDetailActivity;
import com.kangkang.slide_layout.R;
import com.kangkang.slide_layout.SlideSeeMoreLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品fragment
 * Created by Administrator on 2018/12/11.
 */

public class GoodsFragment extends Fragment {
    SlideSeeMoreLayout layout;
    GoodDetailActivity activity;

    TextView tvTab1;
    TextView tvTab2;

    FloatingActionButton actionButton;
    ScrollView scrollView;

    private Fragment indexFragment;
    private FragmentManager fragmentManager;

    private List<Fragment> fragmentList = new ArrayList<>();
    private FragmentTransaction fragmentTransaction;
    private DetailFragment detailFragment;
    private CommentFragment commentFragment;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (GoodDetailActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_goods,null);
        layout = view.findViewById(R.id.layout);
        tvTab1 = view.findViewById(R.id.tv_tab1);
        tvTab2 = view.findViewById(R.id.tv_tab2);
        actionButton = view.findViewById(R.id.actionButton);
        scrollView = view.findViewById(R.id.scrollView);
        initView();
        initListener();
        return view;
    }

    private void initView() {
        detailFragment = new DetailFragment();
        commentFragment = new CommentFragment();

        indexFragment = detailFragment;
        fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fl_content,indexFragment).commitAllowingStateLoss();
        actionButton.hide();
    }

    private void initListener() {
        layout.setOnSlideDetailsListener(new SlideSeeMoreLayout.OnSlideDetailsListener() {
            @Override
            public void onStateChanged(SlideSeeMoreLayout.Status status) {
                if (status == SlideSeeMoreLayout.Status.OPEN){
                    //当前为查看更多页
                    activity.tv_tab1.setBackgroundResource(R.color.white);
                    activity.tv_tab2.setBackgroundResource(R.color.black);
                    activity.tv_tab3.setBackgroundResource(R.color.white);
                    activity.tv_tab1.setTextColor(getResources().getColor(R.color.black));
                    activity.tv_tab2.setTextColor(getResources().getColor(R.color.white));
                    activity.tv_tab3.setTextColor(getResources().getColor(R.color.black));
                    actionButton.show();
                }else {
                    //当前为商品页
                    activity.tv_tab1.setBackgroundResource(R.color.black);
                    activity.tv_tab2.setBackgroundResource(R.color.white);
                    activity.tv_tab3.setBackgroundResource(R.color.white);
                    activity.tv_tab1.setTextColor(getResources().getColor(R.color.white));
                    activity.tv_tab2.setTextColor(getResources().getColor(R.color.black));
                    activity.tv_tab3.setTextColor(getResources().getColor(R.color.black));
                    actionButton.hide();
                }
            }
        });

        tvTab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTab1.setBackgroundResource(R.color.black);
                tvTab2.setBackgroundResource(R.color.colorPrimary);
                switchFragment(indexFragment,detailFragment);
                indexFragment = detailFragment;
            }
        });

        tvTab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvTab1.setBackgroundResource(R.color.colorPrimary);
                tvTab2.setBackgroundResource(R.color.black);
                switchFragment(indexFragment,commentFragment);
                indexFragment = commentFragment;
            }
        });

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollView.scrollTo(0,0);
                layout.smoothClose(true);
            }
        });
    }

    /**
     * 切换Fragment
     * <p>(hide、show、add)
     * @param fromFragment
     * @param toFragment
     */
    private void switchFragment(Fragment fromFragment, Fragment toFragment) {
        if (indexFragment != toFragment) {
            fragmentTransaction = fragmentManager.beginTransaction();
            if (!toFragment.isAdded()) {    // 先判断是否被add过
                fragmentTransaction.hide(fromFragment).add(R.id.fl_content, toFragment).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到activity中
            } else {
                fragmentTransaction.hide(fromFragment).show(toFragment).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
            }
        }
    }

}
