package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 首页
 */

public interface HomeBiz {
    void getUserMessageInfo(String userId, OnLoginListener onLoginListener);

    void getDoctorQRcode(String patientUuid,String DoctorUuid,OnLoginListener onLoginListener);


    void getDoctorTeamInfor(String patientId,OnLoginListener onLoginListener);

    //获取首页Banner图
    void getHomeBanner(String type,OnLoginListener onLoginListener);

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
