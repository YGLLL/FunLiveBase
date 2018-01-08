package com.github.yglll.funlive.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.github.yglll.funlive.R;
import com.github.yglll.funlive.base.BaseFragment;
import com.github.yglll.funlive.model.TempLiveVideoInfo;
import com.github.yglll.funlive.model.TestModel;
import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.presenter.impl.TestPresenter;
import com.github.yglll.funlive.presenter.interfaces.TestPresenterInterfaces;
import com.github.yglll.funlive.view.adapter.HomeCarouselAdapter;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cn.bingoogolapple.bgabanner.BGABanner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
    private List<HomeCarousel> homeCarouselList;
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
        homeCarouselList=list;
        ArrayList<String> pic_url = new ArrayList<String>();
        for (HomeCarousel homeCarousel:list) {
            pic_url.add(homeCarousel.getPic_url());
        }
        if (bgaBanner != null && pic_url.size() > 0) {
            bgaBanner.setData(R.layout.item_image_carousel, pic_url, null);
        }
    }


    // TODO: 2017/12/31 播放视频:2018.1.1-2018.1.5
    @Override
    public void onBannerItemClick(BGABanner banner, SimpleDraweeView itemView, String model, int position) {
        HomeCarousel homeCarousel=homeCarouselList.get(position);
        String str="https://m.douyu.com/html5/live?roomId="+homeCarousel.getRoom().getRoom_id();
        Log.i(TAG,"onBannerItemClick"+str);
        Request requestPost = new Request.Builder()
                .url(str)
                .get()
                .build();
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        client.newCall(requestPost).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                Log.i(TAG,"public void onFailure");
            }
            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                String json =response.body().string().toString();
                Log.i(TAG,"json"+json);
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    if (jsonObject.getInt("error")==0) {
                        Gson gson = new Gson();
                        TempLiveVideoInfo mLiveVideoInfo = gson.fromJson(json, TempLiveVideoInfo.class);
                        Intent intent=new Intent(getActivity(),VideoPlayer.class);
                        intent.putExtra("URL",mLiveVideoInfo.getData().getHls_url());
                        getActivity().startActivity(intent);
                    } else {
                        Log.i(TAG,"jsonObject.getInt(\"error\")!=0");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
