package com.github.yglll.funlive.view;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.base.BaseFragment;
import com.github.yglll.funlive.model.TestModel;
import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.presenter.impl.TestPresenter;
import com.github.yglll.funlive.presenter.interfaces.TestPresenterInterfaces;
import com.github.yglll.funlive.view.adapter.HomeCarouselAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.bingoogolapple.bgabanner.BGABanner;
import rx.Observable;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:31
 **/
public class TestFragment extends BaseFragment<TestModel,TestPresenter> implements TestPresenterInterfaces.View, BGABanner.Delegate<SimpleDraweeView, String>{
    private static final String TAG = "TestFragment";
    private TextView textView;
    private BGABanner bgaBanner;
    private HomeCarouselAdapter homeCarouselAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_test,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        textView=getActivity().findViewById(R.id.test_string);
        textView.setText("public void onStart()");
        bgaBanner=getActivity().findViewById(R.id.bgabanner);
        homeCarouselAdapter=new HomeCarouselAdapter();
        bgaBanner.setDelegate(this);
        bgaBanner.setAdapter(homeCarouselAdapter);

        p.attactModel(new TestModel());
        p.attactView(this);
        //p.setString();
        p.setCarousel();
    }

    @Override
    public void showString(String list) {
        textView.setText(list);
    }

    @Override
    public void showCarousel(List<HomeCarousel> list){
        ArrayList<String> pic_url = new ArrayList<String>();
        for (HomeCarousel homeCarousel:list) {
            pic_url.add(homeCarousel.getPic_url());
        }
        if (bgaBanner != null && pic_url.size() > 0) {
            bgaBanner.setData(R.layout.item_image_carousel, pic_url, null);
        }
    }

    @Override
    public void onBannerItemClick(BGABanner banner, SimpleDraweeView itemView, String model, int position) {
        Log.i(TAG,"onBannerItemClic");
    }
}
