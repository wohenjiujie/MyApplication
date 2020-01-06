package com.organization.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private Context c;
    private String s;
    ToastUtil(Context context){
        c=context;
    }
    void shorttoast(String s){
        Toast.makeText(c,s,Toast.LENGTH_SHORT).show();
    }
    public void longtoast(String s){
        Toast.makeText(c,s,Toast.LENGTH_LONG).show();
    }
}
