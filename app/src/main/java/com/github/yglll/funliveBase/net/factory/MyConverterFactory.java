package com.github.yglll.funliveBase.net.factory;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/23   23:38
 **/
public class MyConverterFactory extends Converter.Factory {
    private static final String TAG = "MyConverterFactory";
    private final Gson gson;

    public  static MyConverterFactory create()
    {
        return create(new Gson());
    }
    public static MyConverterFactory create(Gson gson) {
        return new MyConverterFactory(gson);
    }
    private MyConverterFactory(Gson gson) {
        if (gson == null) throw new NullPointerException("gson == null");
        this.gson = gson;
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        Log.i(TAG,"public Converter<?, RequestBody> requestBodyConverter");
        return new MyRequestBodyConverter<>();
    }
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Log.i(TAG,"responseBodyConverter:"+type.toString());
        //if (HttpResponse.class.equals(type)){
            Log.i(TAG,"HttpResponse.class.equals(type)");
            return new MyResponseBodyConverter<>(gson,type);
        //}
        //return null;
    }
}
