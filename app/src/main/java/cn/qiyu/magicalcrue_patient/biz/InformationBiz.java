package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 消息界面
 */

public interface InformationBiz {
    //医生公告列表
    void getDoctorNoticeList(String doctorUuid, String page,String pagecount,OnLoginListener onLoginListener);

    //消息列表
    void getInformationList(String userUuid,OnLoginListener onLoginListener);

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
