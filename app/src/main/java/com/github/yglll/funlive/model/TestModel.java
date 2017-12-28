package com.github.yglll.funlive.model;

import com.github.yglll.funlive.api.Live;
import com.github.yglll.funlive.net.RetrofitClient;
import com.github.yglll.funlive.presenter.impl.TestPresenter;
import com.github.yglll.funlive.presenter.interfaces.TestPresenterInterfaces;

import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/21   15:53
 **/
public class TestModel implements TestPresenterInterfaces.Model{
    @Override
    public Observable<String> getString(String string , Map<String,Integer> map){
        return new RetrofitClient()
                .builder(Live.class)
                .getLiveList(string,map)
                .subscribeOn(Schedulers.io())//在io线程发出事件
                .observeOn(AndroidSchedulers.mainThread());//在ui线程订阅事件
    }

    @Override
    public Observable<String> getGameString(Map<String, Integer> map) {
        return new RetrofitClient()
                .builder(Live.class)
                .getGameString(map)
                .subscribeOn(Schedulers.io())//在io线程发出事件
                .observeOn(AndroidSchedulers.mainThread());
    }
}
