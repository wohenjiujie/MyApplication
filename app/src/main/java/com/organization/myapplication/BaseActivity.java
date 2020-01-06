package com.organization.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * Created by INvo
 * on 2020-01-06.
 */
public abstract class BaseActivity extends Activity {
    private static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(getContentViewId());
    }

    /**
     * 全局返回Context参数
     *
     * @return
     */
    protected static Context getContext() {

        return context;
    }

    /**
     * 抽象方法返回Layout布局
     *
     * @return
     */
    protected abstract int getContentViewId();

    /**
     * 全局的字符串Toast工具
     *
     * @param text
     */
    protected void ToastText(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * 全局的整型数Toast工具
     *
     * @param msg
     */
    protected void ToastMsg(int msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
