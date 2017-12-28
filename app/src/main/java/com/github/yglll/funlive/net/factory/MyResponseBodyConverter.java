package com.github.yglll.funlive.net.factory;

import android.util.Log;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/23   23:43
 **/
public class MyResponseBodyConverter implements Converter<ResponseBody,String> {
    private static final String TAG = "MyConverterFactory";
    @Override
    public String convert(ResponseBody value) throws IOException {
        return value.string();
    }
}
