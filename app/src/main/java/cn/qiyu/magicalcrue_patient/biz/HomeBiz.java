package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 首页
 */

public interface HomeBiz {
    void getUserMessageInfo(String userId, OnLoginListener onLoginListener);
//    void getDoctorInfo(String userId, OnLoginListener onLoginListener);


    interface OnLoginListener {

        /**
         * 服务器响应
         *
         * @param model
         */
        void onResponse(ResultModel<HomeNumBean> model);

        /**
         * 服务器未响应
         *
         * @param e
         */
        void onFailure(String e);
    }
}
