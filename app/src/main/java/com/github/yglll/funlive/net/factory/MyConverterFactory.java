package com.github.yglll.funlive.net.factory;

import android.util.Log;

import java.io.IOException;
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
    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        Log.i(TAG,"public Converter<?, RequestBody> requestBodyConverter");
        return new MyRequestBodyConverter<>();
    }
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Log.i(TAG,"public Converter<ResponseBody, ?> responseBodyConverter");
        if (String.class.equals(type)){
            return new MyResponseBodyConverter();
        }
        return null;
    }
}
