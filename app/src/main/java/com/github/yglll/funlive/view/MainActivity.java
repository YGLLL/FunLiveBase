package com.github.yglll.funlive.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.yglll.funlive.R;
import com.github.yglll.funlive.model.TestModel;

import java.util.LinkedHashMap;
import java.util.Map;

import rx.Observer;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        final TextView text=(TextView)findViewById(R.id.text);
        Map<String,Integer> map=new LinkedHashMap<>();
        map.put("offset",0);
        map.put("limit",1);
        TestModel testModel=new TestModel();
        testModel.getString("lol",map).subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted()");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,"onError:"+e);
            }

            @Override
            public void onNext(String string) {
                Log.i(TAG,"public void onNext(ResponseBody responseBody)");
                text.setText(string);
                text.append("-YGL");
            }
        });
        */
    }
}