package com.organization.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.organization.myapplication.Bean.RegistrationBean;
import com.organization.myapplication.utils.PasswordToggleEditText;

/*
 * 注册功能的activity
 * 检测手机号和密码长度要用到checkpassword工具类
 * */
public class RegisterActivity extends BaseActivity {
    //密码，确认密码
    private PasswordToggleEditText chatPassword, chatPasswordEnsure;
    //账号，验证码
    private EditText chatAccount,chatCheck;
    //完成注册，获取验证码
    private Button register_finish,get_check;
    //检测账号，密码
    private boolean consistency;
    private RegistrationBean registrationBean;
    //账号唯一性检测
    private boolean accountEnsure;
    //密码一致性检测
    private boolean passwordEnsure;
    //验证码检测
    private boolean checkEnsure;

    /**
     * 检测密码一致性还存在未考虑周全的问题
     *
     * @param bundle
     */
    @Override
    protected void runOnProcess(Bundle bundle) {

        get_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //下发短信验证码

            }
        });
        register_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //账号唯一性检测
                /*
                * if(true){
                * accountEnsure=true;
                * }
                * else{
                * accountEnsure=false;
                * }
                * */
                //密码一致性检测,同上
                passwordEnsure=true;
                //验证码检测,同上
                checkEnsure=true;
                updateStatus();
                if (consistency) {
                    ToastText("注册成功");
                } else {
                    ToastText("填写正确的信息");
                }
            }
        });
    }
    //密码账号检测
    @SuppressLint("ResourceAsColor")
    private void updateStatus() {
        if (accountEnsure && passwordEnsure && checkEnsure) {
            consistency = true;
        }
        if (consistency) {
            register_finish.setBackgroundColor(R.color.colorGrey);
        } else {
            register_finish.setBackgroundColor(R.color.colorPrimary);
        }
    }

    @Override
    protected void initView(Bundle bundle) {
        chatAccount = this.findViewById(R.id.chat_account);
        chatPassword = this.findViewById(R.id.chat_registration_password);
        chatPasswordEnsure = this.findViewById(R.id.chat_registration_password_ensure);
        chatCheck = this.findViewById(R.id.chat_registration_account);
        get_check=this.findViewById(R.id.get_check);
        register_finish=this.findViewById(R.id.register_finish);
        accountEnsure = false;
        passwordEnsure = false;
        consistency = false;
        registrationBean = new RegistrationBean();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }
}
