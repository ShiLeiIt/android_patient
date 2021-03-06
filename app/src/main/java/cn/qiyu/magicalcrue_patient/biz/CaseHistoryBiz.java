package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/19.
 * 病历
 */

public interface CaseHistoryBiz {
    //获取门诊信息
    void getOutpatientInfo(String patientUuid, String page,String pageCount ,OnLoginListener onLoginListener);

    //获取出院小结信息
    void getLeaveHospitalInfo(String patientUuid, String page,String pageCount ,OnLoginListener onLoginListener);

    //获取医院列表
    void getHospitalList(String keywords,String page,String pageCount ,OnLoginListener onLoginListener);

    //获取科室列表
    void getHospitalOfficeList(String page,String pageCount ,OnLoginListener onLoginListener);

    //获取用药方案记录信息
    void getPhPharmacyRecordInfo(String patientUuid, String page, String pageCount, OnLoginListener onLoginListener);

    //获取身体症状记录列表
    void getSymptomatographyList(String patientUuid, String page, String pageCount, OnLoginListener onLoginListener);

    //获取检查报告单信息
    void getInspectionReportInfo(String patientUuid, String page, String pageCount, OnLoginListener onLoginListener);

    //获取病历数目
    void getCaseHistoryNum(String patientUuid, OnLoginListener onLoginListener);


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
