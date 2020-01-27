package com.organization.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private Context c;
    ToastUtil(Context context){
        c=context;
    }
    void shorttoast(String text){
        Toast.makeText(c,text,Toast.LENGTH_SHORT).show();
    }
    public void longtoast(String text){
        Toast.makeText(c,text,Toast.LENGTH_LONG).show();
    }
}
