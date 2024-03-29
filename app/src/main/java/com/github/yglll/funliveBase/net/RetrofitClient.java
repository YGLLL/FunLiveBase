package com.github.yglll.funliveBase.net;

import android.text.TextUtils;
import android.util.Log;

import com.github.yglll.funliveBase.api.NetWorkAPI;
import com.github.yglll.funliveBase.net.factory.MyConverterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/21   16:03
 **/
public class RetrofitClient {
    private static String baseUrl;
    private static Retrofit retrofit;

    public RetrofitClient(){
        baseUrl= NetWorkAPI.baseUrl;
    }
    public RetrofitClient(String baseUrl){
        this.baseUrl=baseUrl;
    }

    public RetrofitClient setBaseUrl(String baseUrl){
        this.baseUrl=baseUrl;
        return this;
    }

    public <T>T builder(Class<T> service){
        if(TextUtils.isEmpty(baseUrl)){
            throw new RuntimeException("baseUrl is null!");
        }
        if(service==null){
            throw new RuntimeException("api Service is null!");
        }

        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MyConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        Log.i("xiancheng","Retrofit id:"+android.os.Process.myTid());
        return retrofit.create(service);
    }
}
