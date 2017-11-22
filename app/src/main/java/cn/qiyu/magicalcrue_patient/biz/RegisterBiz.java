package cn.qiyu.magicalcrue_patient.biz;

import java.io.File;

import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 * 注册页面
 */

public interface RegisterBiz {
    void getVerifyInformation(String PhoneNum,OnLoginListener onLoginListener);
    void getRegisterLogin(String account,String verCode ,String jpushId,OnLoginListener onLoginListener);
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
