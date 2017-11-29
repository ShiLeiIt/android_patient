package cn.qiyu.magicalcrue_patient;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 *
 */

public class MyApplication extends Application{
    private List<Activity> mActivities = new LinkedList<>();
    private static MyApplication instance;
    public static MyApplication getInstance(){
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }
    public void addActivity(Activity activity){
        mActivities.add(activity);

    }
    public void  exit(){
        for (Activity activity : mActivities) {
            activity.finish();
        }
        System.exit(0);
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }
}
