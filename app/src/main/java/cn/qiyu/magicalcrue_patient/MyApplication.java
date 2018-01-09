package cn.qiyu.magicalcrue_patient;

import android.app.Application;
import android.util.Log;

import cn.jpush.android.api.JPushInterface;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;

/**
 *
 */

public class MyApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        String jpushId = JPushInterface.getRegistrationID(this);
        Log.i("jpushId=-applicatio-------=", jpushId);
        PreUtils.setParam(this,"jpushId",jpushId);

    }}
