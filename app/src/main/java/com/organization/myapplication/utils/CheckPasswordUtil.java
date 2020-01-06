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
public class CheckPasswordUtil {
    private Context context;
    private ToastUtil toastUtil;
    public CheckPasswordUtil(Context context){
        this.context=context;
        toastUtil=new ToastUtil(context);
    }


    public void check(final String phone, final String password){
        @SuppressLint("InflateParams") View v= LayoutInflater.from(context).inflate(R.layout.activity_register,null);
        Button finish_btn=v.findViewById(R.id.finish_btn);
        finish_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.length()==11){
                    if(password.length()>=6){
                        //注册完成生成的随机账号，可以用dialog方式来完成也可以用fragment替换界面，并将屏幕截图保存到sd卡


                    }else if(password.length()==0){
                        toastUtil.shorttoast(Constant_one.NULL);
                    }else{
                        toastUtil.shorttoast(Constant_one.SMALL);
                    }
                }else{
                    toastUtil.shorttoast(Constant_one.PHONE_NUMBER);
                }
            }
        });


    }
}