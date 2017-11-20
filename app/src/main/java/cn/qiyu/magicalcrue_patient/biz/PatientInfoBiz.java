package cn.qiyu.magicalcrue_patient.biz;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/19.
 * 患者关系
 */

public interface PatientInfoBiz  {
    void getPatientRelation(String bianma,String type, OnLoginListener onLoginListener);



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
