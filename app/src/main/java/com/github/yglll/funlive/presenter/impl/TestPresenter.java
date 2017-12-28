package com.github.yglll.funlive.presenter.impl;

import android.util.Log;

import com.github.yglll.funlive.presenter.interfaces.TestPresenterInterfaces;

import java.util.LinkedHashMap;
import java.util.Map;

import rx.Observer;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:30
 **/
public class TestPresenter extends TestPresenterInterfaces.Presenter{
    private static final String TAG = "TestPresenter";
    @Override
    public void setString() {
        Map<String,Integer> map=new LinkedHashMap<>();
        map.put("offset",0);
        map.put("limit",1);
        model.getGameString(map).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"public void onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"public void onError(Throwable e)");
            }

            @Override
            public void onNext(String string) {
                view.showString(string);
            }
        });
    }
}
