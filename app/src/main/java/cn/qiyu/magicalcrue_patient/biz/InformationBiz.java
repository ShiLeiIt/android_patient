package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 消息界面
 */

public interface InformationBiz {
    //用户公告列表
    void getUserNoticeList(String userUuid, String page, String pagecount, OnLoginListener onLoginListener);

    //消息列表
    void getInformationList(String userUuid, OnLoginListener onLoginListener);

    //医生公告列表已读
    void getDoctorNoticeRead(String userUuid,String messageUuid,OnLoginListener onLoginListener);

    //随访对话已读（Num为零）
    void getFollowUpMsgRead(String userUuid,OnLoginListener onLoginListener);

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
