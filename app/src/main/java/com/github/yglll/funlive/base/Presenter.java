package com.github.yglll.funlive.base;

import android.view.View;

import com.github.yglll.funlive.presenter.interfaces.TestPresenterInterfaces;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/28   8:15
 **/
public interface Presenter<V,M> {
    //绑定View
    void attactView(V v);
    //绑定Model
    void attactModel(M m);
    //注销View
    void detachView();
    //注销Model
    void detachModel();
}
