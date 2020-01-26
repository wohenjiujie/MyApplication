package com.organization.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.organization.myapplication.utils.PasswordToggleEditText;

/*登录界面的activity*/
public class MainActivity extends BaseActivity {
    private TextView tv_register,tv_forget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        tv_register=findViewById(R.id.register_text);
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        tv_forget=findViewById(R.id.forget_text);
        tv_forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ForgetActivity.class));
            }
        });

    }

    @Override
    protected void runOnProcess(Bundle bundle) {

    }

    @Override
    protected void initView(Bundle bundle) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
