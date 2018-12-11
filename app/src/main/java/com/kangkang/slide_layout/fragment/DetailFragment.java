package com.kangkang.slide_layout.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.kangkang.slide_layout.R;
import com.kangkang.slide_layout.SlideSeeMoreLayout;

/**
 * 详情fragment
 * Created by Administrator on 2018/12/11.
 */

public class DetailFragment extends Fragment {
    WebView webView;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_detail,null);
        webView = view.findViewById(R.id.webView);

        webView.loadUrl("https://github.com/kangkanger/SlideSeeMoreLayout");
        return view;
    }
}
