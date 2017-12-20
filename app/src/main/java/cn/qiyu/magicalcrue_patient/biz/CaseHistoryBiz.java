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
