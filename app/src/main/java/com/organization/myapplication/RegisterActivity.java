package com.organization.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.organization.myapplication.registration.RegistrationAccounts;
import com.organization.myapplication.utils.PasswordToggleEditText;

/*
 * 注册功能的activity
 * 检测手机号和密码长度要用到checkpassword工具类
 * */
public class RegisterActivity extends BaseActivity {
    private PasswordToggleEditText chatPassword, chatPasswordEnsure;
    private EditText chatAccount;
    private Button chatRegistration;
    private boolean consistency;
    private RegistrationAccounts registrationAccounts;
    private boolean accountEnsure;
    private boolean passwordEnsure;


    /**
     * 检测密码一致性还存在未考虑周全的问题
     *
     * @param bundle
     */
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
                    if (null != chatAccount.getText().toString()) {
                        registrationAccounts.setAccount(chatAccount.getText().toString());
                        accountEnsure = true;
                        updateStatus();
                        return true;
                    } else {
                        accountEnsure = false;
                        updateStatus();
                    }
                }
                return false;
            }
        });

        chatPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (KeyEvent.KEYCODE_ENTER == keyCode) {
                    registrationAccounts.setPassword(chatPassword.getText().toString());
                }
                return false;
            }
        });

        chatPasswordEnsure.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (KeyEvent.KEYCODE_ENTER == keyCode) {
                    if (chatPasswordEnsure.getText().toString().equals(registrationAccounts.getPassword())) {
                        passwordEnsure = true;
                        updateStatus();
                    } else {
                        passwordEnsure = false;
                        updateStatus();
                    }
                }
                return false;
            }
        });

        chatRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RegisterActivity", registrationAccounts.toString());
                if (consistency) {
                    //上传数据

                } else {
                    //输入错误
                }
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void updateStatus() {
        if (accountEnsure && passwordEnsure) {
            consistency = true;
        }
        if (consistency) {
            chatRegistration.setBackgroundColor(R.color.colorPrimary);
        } else {
            chatRegistration.setBackgroundColor(R.color.colorGrey);
        }
    }

    @Override
    protected void initView(Bundle bundle) {
        chatRegistration = this.findViewById(R.id.chat_registration);
        chatAccount = this.findViewById(R.id.chat_registration_account);
        chatPassword = this.findViewById(R.id.chat_registration_password);
        chatPasswordEnsure = this.findViewById(R.id.chat_registration_password_ensure);
        consistency = false;
        accountEnsure = false;
        passwordEnsure = false;
        registrationAccounts = new RegistrationAccounts();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }
}
