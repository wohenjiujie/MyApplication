package com.organization.myapplication.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import com.organization.myapplication.Constants.Constant_one;
import com.organization.myapplication.R;

/*
* created on 2020/1/6
* created by wen
* 检测密码长度
* */
public class CheckUtil {
    private Context context;
    private ToastUtil toastUtil;
    public CheckUtil(Context context){
        this.context=context;
        toastUtil=new ToastUtil(context);
    }


    public void check(final String phone, final String password){
        if(phone.length()==11){
            if(password.length()>=6){
                //注册完成生成账号，可以用dialog方式来完成也可以用fragment替换界面，并将屏幕截图保存到sd卡

            }else if(password.length()==0){
                toastUtil.shorttoast(Constant_one.NULL);
            }else{
                toastUtil.shorttoast(Constant_one.SMALL);
            }
        }else{
            toastUtil.shorttoast(Constant_one.PHONE_NUMBER);
        }
    }
}
