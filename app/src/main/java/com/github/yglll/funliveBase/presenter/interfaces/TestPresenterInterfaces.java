package com.github.yglll.funliveBase.presenter.interfaces;

import com.github.yglll.funliveBase.base.BaseModel;
import com.github.yglll.funliveBase.base.BasePresenter;
import com.github.yglll.funliveBase.base.BaseView;
import com.github.yglll.funliveBase.model.logic.HomeCarousel;

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
        void showCarousel(List<HomeCarousel> list);
    }

    interface Model extends BaseModel{
        Observable<String> getString(String string , Map<String,Integer> map);
        Observable<List<String>> getGameString(Map<String,Integer> map);
        Observable<List<HomeCarousel>> getCarousel();
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void setString();
        public abstract void setCarousel();
    }
}
