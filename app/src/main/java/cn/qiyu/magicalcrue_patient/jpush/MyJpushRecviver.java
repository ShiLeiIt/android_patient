package cn.qiyu.magicalcrue_patient.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;

import org.json.JSONException;
import org.json.JSONObject;

import cn.jpush.android.api.JPushInterface;
import cn.qiyu.magicalcrue_patient.activity.DoctorListActivity;
import cn.qiyu.magicalcrue_patient.activity.DoctorNoticeListActivity;
import cn.qiyu.magicalcrue_patient.activity.MainActivity;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;

/**
 * Created by dev on 2017/11/27.
 */

public class MyJpushRecviver extends BroadcastReceiver {
    private static final String TAG = "MyJpushRecviver";
//    private int mTypeId;


    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            /**
             * 用户注册SDK的intent
             */
//            String jpushId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
//            Log.i("jpushid=-=-=-", jpushId);
//            PreUtils.setParam(context,"jpushId",jpushId);
            Log.e(TAG, "onReceive1: ");
        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            /**
             * 用户接受SDK消息的intent
             */
//            Log.e(TAG, "收到了自定义消息消息是2");
//            Log. d ( TAG ,  "接收到推送下来的自定义消息: "  + bundle.getString(JPushInterface. EXTRA_MESSAGE ));

        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            /**
             * 用户接收SDK通知栏信息的intent
             */
//            Log.e(TAG, "收到了自定义消息消息是3");
            //保存服务器推送下来的消息的标题。
            String extra1 = bundle.getString(JPushInterface.EXTRA_TITLE);
            //消息内容
            String extra2 = bundle.getString(JPushInterface.EXTRA_MESSAGE);
            //附加字段。这是个 JSON 字符串。
            String extra3 = bundle.getString(JPushInterface.EXTRA_EXTRA);

            //唯一标识消息的 ID, 可用于上报统计等。
            String extra4 = bundle.getString(JPushInterface.EXTRA_MSG_ID);
            //通知的标题
            String extra5 = bundle.getString(JPushInterface.EXTRA_NOTIFICATION_TITLE);
            //通知内容
            String extra6 = bundle.getString(JPushInterface.EXTRA_ALERT);
            //通知栏的Notification ID，可以用于清除Notification
            //如果服务端内容（alert）字段为空，则notification id 为0
//
            int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            Log.i("extra7==", notifactionId + "");

            //富媒体通知推送下载的HTML的文件路径,用于展现WebView
            String extra8 = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_PATH);
            //富媒体通知推送下载的图片资源的文件名,多个文件名用 “，” 分开。
            // 与 “JPushInterface.EXTRA_RICHPUSH_HTML_PATH” 位于同一个路径。
            String extra9 = bundle.getString(JPushInterface.EXTRA_RICHPUSH_HTML_RES);


            //这里做自己的操作，关于EventBus后续会讲的
            //匹配对应的内容发送通知
            if (extra6.contains("Hello World")) {
                Log.e(TAG, "onReceive包含: ");
                //  EventBus.getDefault().post(new HomeRecviverEvent());
            }

            Log.e(TAG, "收到了自定义消息消息内容是-extra1:" + extra1);
            Log.e(TAG, "收到了自定义消息消息extra是-extra2:" + extra2);
            Log.e(TAG, "收到了自定义消息消息extra是-extra3:" + extra3);
            Log.e(TAG, "收到了自定义消息消息extra是-extra4:" + extra4);
            Log.e(TAG, "收到了自定义消息消息extra是-extra5:" + extra5);
            Log.e(TAG, "收到了自定义消息消息extra是-extra6:" + extra6);
            Log.e(TAG, "收到了自定义消息消息extra是-notifactionId:" + notifactionId + "");
            Log.e(TAG, "收到了自定义消息消息extra是-extra8:" + extra8);
            Log.e(TAG, "收到了自定义消息消息extra是-extra9:" + extra9);
//            Log.e(TAG, "收到了自定义消息消息extra是2:" + extra10);
        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            /**
             * 用户打开自定义通知栏的intent
             */
//            String extra6 = bundle.getString(JPushInterface.EXTRA_ALERT);
            //如果包含 跳转至对应的界面,这里跳转我现在那个解析不出来
//            if (extra6.contains("Hello World")) {
//                Log.e(TAG, "onReceive包含: ");
//                Log.e(TAG, "收到了自定义消息消息extra是4:");
//                Intent in = new Intent(context, NewFriendActivity.class);
//                in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(in);
//            } else {
//                Log.e(TAG, "onReceive不包含: ");
//            }
            //JSON
            String extra10 = bundle.getString(JPushInterface.EXTRA_EXTRA);

            String js = "";
            try {
                JSONObject json = new JSONObject(extra10);
                String value = json.getString("androidNotification extras key");
                js = value.replace("\\", "");
                JSONObject jsonObject = new JSONObject(js);
                int mTypeId = jsonObject.getInt("typeId");

                if (mTypeId == 1) {
                    Intent intentMain = new Intent(context, DoctorNoticeListActivity.class);
                    intentMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intentMain.putExtra("doctorNotice", "doctorNotice");
                    intentMain.putExtras(bundle);
                    context.startActivity(intentMain);
                }

                Log.i(TAG, "typeId--------------" + mTypeId);
//                String data = js.getString("typeId");
                Log.i("js-----------", js);
            } catch (JSONException e) {
                e.printStackTrace();
            }


        } else {
            Log.e(TAG, "Unhandled intent - " + intent.getAction());
            Log.e(TAG, "收到了自定义消息消息extra是5:");
        }
    }

    // 打印所有的 intent extra 数据
    private static String printBundle(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String key : bundle.keySet()) {
            if (key.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getInt(key));
            } else if (key.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + key + ", value:" + bundle.getBoolean(key));
            } else {
                sb.append("\nkey:" + key + ", value:" + bundle.getString(key));
            }
        }
        return sb.toString();
    }

}