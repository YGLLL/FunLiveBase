package com.github.yglll.funliveBase.base;

import android.app.Fragment;

import com.github.yglll.funliveBase.model.ContractProxy;

/**
 * 作者：YGL
 * 电话：13036804886
 * 邮箱：2369015621@qq.com
 * 版本号：1.0
 * 类描述：
 * 备注消息：
 * 创建时间：2017/12/28   9:51
 **/
public class BaseFragment<M extends BaseModel,P extends BasePresenter> extends Fragment {
    protected P p;
    @Override
    public void onStart() {
        if(p==null)
        {
            bindMVP();
        }
        super.onStart();
    }

    private void bindMVP(){
        if(getPresenterClazz()!=null)
        {
            p=getPresenterImpl();
        }
    }

    //    获得抽取接口Presenter对象
    protected    Class getPresenterClazz()  {
        return (Class<P>) ContractProxy.getPresnterClazz(getClass(), 1);
    }

    private <T> T getPresenterImpl()
    {
        return ContractProxy.getInstance().presenter(getPresenterClazz());
    }
}
