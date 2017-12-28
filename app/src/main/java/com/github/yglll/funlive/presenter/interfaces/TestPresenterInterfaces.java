package com.github.yglll.funlive.presenter.interfaces;

import com.github.yglll.funlive.base.BaseModel;
import com.github.yglll.funlive.base.BasePresenter;
import com.github.yglll.funlive.base.BaseView;

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
        void showString(String string);
    }

    interface Model extends BaseModel{
        Observable<String> getString(String string , Map<String,Integer> map);
        Observable<String> getGameString(Map<String,Integer> map);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract void setString();
    }
}
