package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2018/1/15.
 * 随访患教课堂列表
 */

public interface PatientCourseListBiz {
    //获取随访患教课堂列表
    void getPatientCourse(String patientUuid, String page,String pageCount ,OnLoginListener onLoginListener);


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
