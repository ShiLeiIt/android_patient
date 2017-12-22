package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/22.
 * 症状记录添加
 */

public interface SymptomatographyAddBiz {
    //添加症状记录保存带图片
    void addSymptomatographySave(String patientUuid, String symptomCode, String symptom, String remarks, String imageList,CaseHistoryBiz.OnLoginListener onLoginListener);

    //添加症状记录保存不带图片
    void addSymptomatographySaveText(String patientUuid, String symptomCode, String symptom, String remarks, CaseHistoryBiz.OnLoginListener onLoginListener);

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
