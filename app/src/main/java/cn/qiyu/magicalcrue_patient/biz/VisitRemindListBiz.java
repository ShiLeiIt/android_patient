package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2018/1/15.
 * 随访提醒
 */

public interface VisitRemindListBiz {

    //随访提醒列表
    void getRemindList(String patientUuid,
                              String page,
                              String pageCount, OnLoginListener onLoginListener);


    //删除自己创建的日程提醒
    void getDeleteRemindList(String remindUuid,String patientUuid,OnLoginListener onLoginListener);

    //创建患者的日程提醒
    void getCreateRemind(String remindUuid,
                         String eventName,
                         String eventRemark,
                         String remindTime,
                         String repeatNum,
                         String repeatType,
                         String patientUuid,
                         String userRoleType,
                         String eventReception,
                         String userStatus,
                         String receptionUserStatus,
                         OnLoginListener onLoginListener);

    //日程提醒详情
    void getRemindDetails(String remindUuid,OnLoginListener onLoginListener);

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
