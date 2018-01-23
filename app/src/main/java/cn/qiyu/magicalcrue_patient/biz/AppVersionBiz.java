package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2018/1/23.
 * App版本号对应是否升级
 */

public interface AppVersionBiz {

    void getAppVersionIsUpdate(String patient, String platform,String channel,String current_version, OnLoginListener onLoginListener);
    interface OnLoginListener<T> {
        /**
         * 服务器响应
         *
         * @param model
         */
        void onResponse(ResultModel<T> model);

        /**
         * 服务器未响应
         *
         * @param e
         */
        void onFailure(String e);
    }
}
