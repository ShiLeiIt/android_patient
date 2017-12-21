package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/20.
 * 门诊信息添加
 */

public interface OutPatientAddBiz  {
    //添加门诊信息保存带图片
    void addOutPatientSave(String patientUuid,String diagnosisDate,String hospitalId, String officeId,String doctorUuid,String summary,String imageList,CaseHistoryBiz.OnLoginListener onLoginListener);

    //添加门诊信息保存不带图片
    void addOutPatientSaveText(String patientUuid,String diagnosisDate,String hospitalId, String officeId,String doctorName,String summary,CaseHistoryBiz.OnLoginListener onLoginListener);



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
