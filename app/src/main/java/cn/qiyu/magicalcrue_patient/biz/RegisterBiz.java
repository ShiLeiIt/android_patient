package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public interface RegisterBiz {
    void getVerifyInformation(String PhoneNum,OnLoginListener onLoginListener);
    interface OnLoginListener {
        /**
         * 服务器响应
         *
         * @param model
         */
        void onResponse(ResultModel<RegisterLoginVerBean> model);

        /**
         * 服务器未响应
         *
         * @param e
         */
        void onFailure(String e);
    }
}
