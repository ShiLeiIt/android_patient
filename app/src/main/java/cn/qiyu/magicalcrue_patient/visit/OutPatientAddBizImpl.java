package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.OutPatientAddBiz;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.HospitalOfficeListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/12/19.
 *
 */

public class OutPatientAddBizImpl extends BaseBiz implements OutPatientAddBiz {



    //添加门诊信息保存
    @Override
    public void addOutPatientSave(String patientUuid, String diagnosisDate, String hospitalId, String officeId, String doctorUuid, String summary, String imageList, final CaseHistoryBiz.OnLoginListener onLoginListener) {
        mApiService.getOutPatientSave(patientUuid,diagnosisDate,hospitalId,officeId,doctorUuid,summary,imageList).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
            @Override
            public void onResponse(Call<ResultModel<AddOutPatientDataSaveBean>> call, Response<ResultModel<AddOutPatientDataSaveBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<AddOutPatientDataSaveBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
    //添加门诊信息保存不带图片
    @Override
    public void addOutPatientSaveText(String patientUuid, String diagnosisDate, String hospitalId, String officeId, String doctorUuid, String summary, final CaseHistoryBiz.OnLoginListener onLoginListener) {
        mApiService.getOutPatientSaveText(patientUuid,diagnosisDate,hospitalId,officeId,doctorUuid,summary).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
            @Override
            public void onResponse(Call<ResultModel<AddOutPatientDataSaveBean>> call, Response<ResultModel<AddOutPatientDataSaveBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<AddOutPatientDataSaveBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
}











