package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.PatientCourseListBiz;
import cn.qiyu.magicalcrue_patient.model.CaseHistoryNumBean;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.HospitalOfficeListBean;
import cn.qiyu.magicalcrue_patient.model.InspectionReportBean;
import cn.qiyu.magicalcrue_patient.model.PatientCourseListBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.SymptomatographyBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2018/1/15.
 * 患教课堂
 */

public class PatientCourseListBizImpl extends BaseBiz implements PatientCourseListBiz {
    //获取患教课堂
    @Override
    public void getPatientCourse(String patientUuid, String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getPatientCoureseList(patientUuid,page,pageCount).enqueue(new Callback<ResultModel<List<PatientCourseListBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<PatientCourseListBean>>> call, Response<ResultModel<List<PatientCourseListBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<PatientCourseListBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }








}











