package com.organization.myapplication;

import android.widget.BaseAdapter;
/*
* 注册功能的activity
* 检测手机号和密码长度要用到checkpassword工具类
* */
public class RegisterActivity extends BaseActivity {
    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }
}
