package com.github.yglll.funliveBase.api;

import com.github.yglll.funliveBase.model.logic.HomeCarousel;
import com.github.yglll.funliveBase.net.Response.HttpResponse;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.github.yglll.funliveBase.api.NetWorkAPI.game;
import static com.github.yglll.funliveBase.api.NetWorkAPI.getCarousel;
import static com.github.yglll.funliveBase.api.NetWorkAPI.roomList;

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
    Observable<List<String>> getGameString(@QueryMap Map<String, Integer> params);

    /**
     * 首页   推荐轮播图
     *
     * @return
     */
    @GET(getCarousel)
    Observable<HttpResponse<List<HomeCarousel>>> getCarousel();
}
