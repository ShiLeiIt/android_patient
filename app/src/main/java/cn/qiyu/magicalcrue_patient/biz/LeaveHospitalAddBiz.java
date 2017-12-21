package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/21.
 * 出院小结信息添加
 */

public interface LeaveHospitalAddBiz {
    //添加门诊信息保存带图片
    void addLeaveHospitalSave(String patientUuid,
                           String beHospitalizedDate,
                           String leaveHospitalDate,
                           String hospitalId,
                           String hospitalizationOfficeId,
                           String doctorName,
                           String summary,
                           String imageList, CaseHistoryBiz.OnLoginListener onLoginListener);

    //添加门诊信息保存不带图片
    void addLeaveHospitalSaveText(String patientUuid,
                                  String beHospitalizedDate,
                                  String leaveHospitalDate,
                                  String hospitalId,
                                  String hospitalizationOfficeId,
                                  String doctorName,
                                  String summary, CaseHistoryBiz.OnLoginListener onLoginListener);


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
