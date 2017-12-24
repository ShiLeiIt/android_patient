package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/24.
 * 检查报告单添加
 */

public interface InspectionReportAddBiz {
    //添加检查报告单保存带图片
    void addInspectionReportSave(String patientUuid, String inspectionDate, String typeId, String inspectionDescription, String imageList,OnLoginListener onLoginListener);

    //添加检查报告单保存不带图片
    void addInspectionReportSaveText(String patientUuid, String inspectionDate, String typeId, String inspectionDescription, OnLoginListener onLoginListener);

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
