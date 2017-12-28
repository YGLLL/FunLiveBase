package com.github.yglll.funlive.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.github.yglll.funlive.api.NetWorkAPI.game;
import static com.github.yglll.funlive.api.NetWorkAPI.roomList;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/21   13:47
 **/
public interface Live {
    @GET(roomList+"{id}")
    Observable<String> getLiveList(@Path("id") String id, @QueryMap Map<String, Integer> params);

    @GET(game)
    Observable<String> getGameString(@QueryMap Map<String, Integer> params);
}
