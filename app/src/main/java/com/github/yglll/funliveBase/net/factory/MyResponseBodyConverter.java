package com.github.yglll.funliveBase.net.factory;

import com.github.yglll.funliveBase.net.Response.HttpResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;

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
public class MyResponseBodyConverter<T> implements Converter<ResponseBody,T> {
    private static final String TAG = "MyConverterFactory";

    private final Gson gson;
    private final Type type;

    MyResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody responseBody) throws IOException {
        String value=responseBody.string();

        HttpResponse httpResponse=new HttpResponse();
        try {
            JSONObject response=new JSONObject(value);
            int error=response.getInt("error");
            if(error!=0)
            {
                httpResponse.setError(error);
                httpResponse.setData(response.getString("data"));
                return (T)gson.fromJson(value,httpResponse.getClass());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return gson.fromJson(value,type);
    }
}
