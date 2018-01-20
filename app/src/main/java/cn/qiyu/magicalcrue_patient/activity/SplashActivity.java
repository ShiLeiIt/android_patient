package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;

/**
 * Created by ShiLei on 2018/1/20.
 * 启动页面展示
 */

public class SplashActivity extends BaseActivity {
    private Handler mHandler=new Handler();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String token=   (String) PreUtils.getParam(SplashActivity.this,"token","0");
                if(token.equals("")||token.equals("0"))
                {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }else {
                    startActivity(  new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }
                finish();
            }
        }, 500);
    }
}
