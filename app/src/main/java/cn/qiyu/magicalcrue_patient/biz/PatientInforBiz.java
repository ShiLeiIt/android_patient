package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/20.
 * 患者基本信息
 */

public interface PatientInforBiz {
    void getPatientInfor(String patientUuid,
            String userId,
                         String name,
                         String sex,
                         String birthday,
                         String idCardNO,
                         String mobile,
                         String native_place_cd,
                         String attending_doctor,
                         String firstVisitTime,
                         String relationship,
                         String disease_id,
                         String appFirstVisitTime,
                         OnLoginListener onLoginListener);

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
