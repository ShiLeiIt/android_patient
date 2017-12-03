package cn.qiyu.magicalcrue_patient.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import cn.qiyu.magicalcrue_patient.utils.ActivityManagerTool;

/**
 * Created by shilei on 2017/12/2.
 */

public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManagerTool.getActivityManager().add(this);
    }
}
