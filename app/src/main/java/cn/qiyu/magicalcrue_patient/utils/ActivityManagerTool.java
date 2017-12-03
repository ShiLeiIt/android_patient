package cn.qiyu.magicalcrue_patient.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.LinkedList;
import java.util.List;

/**
 * 用来关闭所有的activity
 *
 * @author HuNan
 */
public class ActivityManagerTool {

    private final List<Activity> activities = new LinkedList<Activity>();

    private static ActivityManagerTool manager;

    private boolean isExist = false;// activity 存在标志

    public static Class<? extends Activity> indexActivity; // 首页所在的activity所对应的类名，必须在打开首页设置此项

    public static List<Class<?>> bottomActivities = new LinkedList<Class<?>>();// 底部导航类集合

    /**
     * 获得 activity管理对象
     *
     * @return 实例
     */
    public static ActivityManagerTool getActivityManager() {
        if (null == manager) {
            manager = new ActivityManagerTool();
        }
        return manager;
    }

    /**
     * 添加新的activity
     *
     * @param activity 要添加的activity
     * @return 添加是否成功
     */
    public boolean add(final Activity activity) {

        int position = 0;
        // 判断是否自动清除非子activity
        // if (AbsInitApplication.isUseActivityManager) {
        // 导航栏activity进栈，删除非导航栏activity
        if (isBottomActivity(activity)) {
            for (int i = 0; i < activities.size() - 1; i++) {

                if (!isBottomActivity(activities.get(i))) {
                    popActivity(activities.get(i));
                    i--;
                }
                if (i > 0) {
                    // 获得重复activity位置
                    if (activities.get(i).getClass()
                            .equals(activity.getClass())) {
                        isExist = true;
                        position = i;
                    }
                }
            }

        }
        // }

        if (!activities.add(activity)) {
            return false;
        }
        // 删除重复activity
        if (isExist) {
            isExist = false;
            activities.remove(position);
        }

        return true;
    }

    /**
     * 关闭除参数activity外的所有activity
     *
     * @param activity activity
     */
    public void finish(final Activity activity) {
        for (Activity iterable : activities) {
            if (activity != iterable) {
                iterable.finish();
            }
        }
    }

    /**
     * 关闭指定类名的activity
     *
     *
     * @param className 类名
     */
    public void finish(final String className) {
        for (Activity iterable : activities) {
            if (className.equals(iterable.getClass().getName())) {
                iterable.finish();
            }
        }
    }

    /**
     * 关闭所有的activity
     */
    public void exit() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }

        System.exit(0);
    }

    /**
     * 删除指定activity
     *
     * @param activity activity
     */
    private void popActivity(final Activity activity) {

        if (activity != null) {
            activity.finish();
            activities.remove(activity);
        }

    }

    /**
     * 删除已经finish的activity
     */
    public void removeTemporaryActivities(final Class<Activity> targetclazz,
                                          final Activity sourceActivity) {
        if (targetclazz == null || sourceActivity == null) {
            return;
        }

        int begin = -1;
        int end = -1;
        Activity activity;

        for (int i = activities.size() - 1; i >= 0; i--) {
            activity = activities.get(i);
            if (activity.getClass() == targetclazz && end == -1) {
                end = i;
            }
            if (sourceActivity == activity && begin == -1) {
                begin = i;
            }
            if (begin != -1 && end != -1) {
                break;
            }
        }

        if (end != -1 && begin > end) {
            for (int i = begin; i > end; i--) {
                activity = activities.get(i);
                popActivity(activity);
            }
        }
    }

    /**
     * 获得当前activity
     *
     * @return 当前activity
     */
    public Activity getTopActivity() {
        Activity activity = activities.get(activities.size() - 1);
        return activity;
    }

    /**
     * activity是否为底部导航
     *
     * @return 是否是底部导航
     */
    public boolean isBottomActivity(final Activity activity) {

        for (int i = 0; i < bottomActivities.size(); i++) {
            if (activity.getClass() == bottomActivities.get(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 如需返回IndexActivity则返回IndexActivity
     *
     * @param context 上下文
     */
    public void backIndex(final Context context) {

        if (activities.size() <= 0) {
            return;
        }

        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            if (isBottomActivity(activity)) {
                Intent intent = new Intent();
                intent.setClass(context, indexActivity);
                context.startActivity(intent);
            } else {
                popActivity(activity);
            }
        }
    }

    /**
     * 判断指定activity是否存在
     *
     * @param clazz class
     */
    public <E extends Activity> boolean tagActivityIsExist(final Class<E> clazz) {
        boolean flag = false;
        if (activities.size() <= 0) {
            return flag;
        }

        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            if (activity.getClass() == clazz) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 退栈操作，回到被标记得activity，被标记的activity默认不退栈
     *
     * @param clazz 被标记的activity class
     * @param <E>   继承自activity
     * @return 是否完成了退栈操作
     */
    public <E extends Activity> boolean backToActivity(final Class<E> clazz) {
        return backToActivity(clazz, true);
    }


    public <E extends Activity> void backToActivity(final Activity backActivity, boolean isRetain) {
        if (backActivity == null) {
            return;
        }
        for (int i = activities.size() - 1; i >= 0; i--) {
            Activity activity = activities.get(i);
            if (activity != backActivity) {
                popActivity(activity);
            } else {
                if (!isRetain) {
                    // 如果不保留被标记的activity
                    popActivity(activity);
                }
                break;
            }
        }
    }

    /**
     * 如需返回IndexActivity则返回IndexActivity
     *
     * @param clazz    被标记的activity class
     * @param isRetain 是否保留被标记的activity
     */
    public <E extends Activity> boolean backToActivity(final Class<E> clazz, boolean isRetain) {
        boolean flag = false;
        flag = tagActivityIsExist(clazz);
        if (flag) {
            for (int i = activities.size() - 1; i >= 0; i--) {
                Activity activity = activities.get(i);
                if (activity.getClass() != clazz) {
                    popActivity(activity);
                } else {
                    if (!isRetain) {
                        // 如果不保留被标记的activity
                        popActivity(activity);
                    }
                    break;
                }
            }
        }
        return flag;
    }

    /**
     * 删除已经finish的activity
     *
     * @param activity activity
     */
    public void removeActivity(final Activity activity) {

        if (activity != null) {
            activities.remove(activity);
        }
    }

    /**
     * 初始化，存储底部导航类
     *
     * @param activityClass activity
     */
    public void setBottomActivities(final Class<?> activityClass) {
        if (activityClass != null) {
            bottomActivities.add(activityClass);
        }
    }

    public List<Activity> getActivities() {
        return activities;
    }
}
