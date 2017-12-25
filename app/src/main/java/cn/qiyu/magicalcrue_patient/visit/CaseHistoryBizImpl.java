package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.CommentVisitDialogueBiz;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.CaseHistoryNumBean;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.HospitalOfficeListBean;
import cn.qiyu.magicalcrue_patient.model.InspectionReportBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.SymptomatographyBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/12/19.
 * 病历
 */

public class CaseHistoryBizImpl extends BaseBiz implements CaseHistoryBiz {

    //获取门诊信息
    @Override
    public void getOutpatientInfo(String patientUuid, String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getOutpatientInfo(patientUuid, page, pageCount).enqueue(new Callback<ResultModel<List<DischargeBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<DischargeBean>>> call, Response<ResultModel<List<DischargeBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<DischargeBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

    //获取出院小结信息
    @Override
    public void getLeaveHospitalInfo(String patientUuid, String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getLeaveHospitalInfo(patientUuid, page, pageCount).enqueue(new Callback<ResultModel<List<DischargeBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<DischargeBean>>> call, Response<ResultModel<List<DischargeBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<DischargeBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

    //获取医院列表信息
    @Override
    public void getHospitalList(String keywords, String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getHospitalList(keywords, page, pageCount).enqueue(new Callback<ResultModel<List<HospitalListBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<HospitalListBean>>> call, Response<ResultModel<List<HospitalListBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<HospitalListBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
    //获取科室列表信息
    @Override
    public void getHospitalOfficeList(String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getHospitalOfficeList(page,pageCount).enqueue(new Callback<ResultModel<List<HospitalOfficeListBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<HospitalOfficeListBean>>> call, Response<ResultModel<List<HospitalOfficeListBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<HospitalOfficeListBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

    //获取用药方案记录列表信息
    @Override
    public void getPhPharmacyRecordInfo(String patientUuid, String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getPharmacyRecordInfo(patientUuid,page,pageCount).enqueue(new Callback<ResultModel<List<PharmacyBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<PharmacyBean>>> call, Response<ResultModel<List<PharmacyBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<PharmacyBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
    //获取身体症状记录列表信息
    @Override
    public void getSymptomatographyList(String patientUuid, String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getSymptomatographyList(patientUuid,page,pageCount).enqueue(new Callback<ResultModel<List<SymptomatographyBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<SymptomatographyBean>>> call, Response<ResultModel<List<SymptomatographyBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<SymptomatographyBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });

    }
    //获取检查报告单信息
    @Override
    public void getInspectionReportInfo(String patientUuid, String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getInspectionReportInfo(patientUuid,page,pageCount).enqueue(new Callback<ResultModel<List<InspectionReportBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<InspectionReportBean>>> call, Response<ResultModel<List<InspectionReportBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<InspectionReportBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
    //获取病历数目
    @Override
    public void getCaseHistoryNum(String patientUuid, final OnLoginListener onLoginListener) {
        mApiService.getCaseHistoryNum(patientUuid).enqueue(new Callback<ResultModel<CaseHistoryNumBean>>() {
            @Override
            public void onResponse(Call<ResultModel<CaseHistoryNumBean>> call, Response<ResultModel<CaseHistoryNumBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<CaseHistoryNumBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }


}











