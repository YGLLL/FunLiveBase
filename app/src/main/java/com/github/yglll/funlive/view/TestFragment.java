package com.github.yglll.funlive.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.base.BaseFragment;
import com.github.yglll.funlive.model.TestModel;
import com.github.yglll.funlive.presenter.impl.TestPresenter;
import com.github.yglll.funlive.presenter.interfaces.TestPresenterInterfaces;

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
 * 创建时间：2017/12/27   9:31
 **/
public class TestFragment extends BaseFragment<TestModel,TestPresenter> implements TestPresenterInterfaces.View{
    private static final String TAG = "TestFragment";
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_test,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        textView=getActivity().findViewById(R.id.test_string);
        textView.setText("public void onStart()");
        p.attactModel(new TestModel());
        p.attactView(this);
        p.setString();
    }

    @Override
    public void showString(String list) {
        textView.setText(list);
    }

    // TODO: 2017/12/28 增加轮播图 
}
