package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/21.
 */

public interface MyScaleBiz {
    void getMyScaleInfor(String patientUuid, String status, String page,String pagecount,MyScaleBiz.OnLoginListener onLoginListener);
    void getScaleDetailsInfor(String paperId, String paperUserId,String userId,MyScaleBiz.OnLoginListener onLoginListener);

    void getScaleDetailsCommit(String patientUuid,String questionArr,String paperUserID,OnLoginListener onLoginListener);

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
