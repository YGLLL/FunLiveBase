package com.github.yglll.funlive.base;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/28   6:16
 **/
public class BasePresenter<V extends BaseView,M extends BaseModel> implements Presenter<V,M>{
    protected V view;
    protected M model;

    @Override
    public void attactView(V v) {
        view=v;
    }

    @Override
    public void attactModel(M m) {
        model=m;
    }

    @Override
    public void detachView() {
        view=null;
    }

    @Override
    public void detachModel() {
        model=null;
    }
}
