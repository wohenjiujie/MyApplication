package com.organization.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.organization.myapplication.utils.PasswordToggleEditText;

/*
 * 注册功能的activity
 * 检测手机号和密码长度要用到checkpassword工具类
 * */
public class RegisterActivity extends BaseActivity {
    private PasswordToggleEditText chatAccount, chatPassword, chatPasswordEnsure;
    private Button chatRegistration;
    private boolean consistency;

    @Override
    protected void runOnProcess(Bundle bundle) {
        chatRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (consistency) {
                    ToastText("注册成功");
                } else {
                    ToastText("填写正确的信息");
                }
            }
        });

        chatAccount.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (KeyEvent.KEYCODE_ENTER == keyCode) {
                    chatAccount.getText().toString();
                }
                return false;
            }
        });
    }

    @Override
    protected void initView(Bundle bundle) {
        chatRegistration = this.findViewById(R.id.chat_registration);
        chatAccount = this.findViewById(R.id.chat_registration_account);
        chatPassword = this.findViewById(R.id.chat_registration_password);
        chatPasswordEnsure = this.findViewById(R.id.chat_registration_password_ensure);
        consistency = false;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }
}
