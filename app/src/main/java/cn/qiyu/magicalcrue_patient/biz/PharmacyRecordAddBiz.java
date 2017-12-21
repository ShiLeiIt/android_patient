package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/20.
 * 用药方案记录添加
 */

public interface PharmacyRecordAddBiz {
    //添加用药方案记录保存带图片
    void addPharmacyRecordSave(String patientUuid, String drugName, String usaged, String amount, String remarks,String imageList, OnLoginListener onLoginListener);
    //添加用药方案记录保存不带图片
    void addPharmacyRecordSaveText(String patientUuid, String drugName, String usaged, String amount, String remarks, OnLoginListener onLoginListener);

    //获取用药方式
    void getPharmacyWay(String bianma,String type,OnLoginListener onLoginListener);

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
