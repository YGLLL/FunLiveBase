package com.github.yglll.funlive.presenter.interfaces;

import com.github.yglll.funlive.base.BaseModel;
import com.github.yglll.funlive.base.BasePresenter;
import com.github.yglll.funlive.base.BaseView;
import com.github.yglll.funlive.model.logic.HomeCarousel;
import com.github.yglll.funlive.net.Response.HttpResponse;

import java.util.List;
import java.util.Map;

import rx.Observable;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/27   9:30
 **/
public interface TestPresenterInterfaces {
    interface View extends BaseView{
        void showString(String list);
    }

    interface Model extends BaseModel{
        Observable<String> getString(String string , Map<String,Integer> map);
        Observable<List<String>> getGameString(Map<String,Integer> map);
        Observable<HttpResponse<List<HomeCarousel>>> getCarousel();
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void setString();
    }
}
