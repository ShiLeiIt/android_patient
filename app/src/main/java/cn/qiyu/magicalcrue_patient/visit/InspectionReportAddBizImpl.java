package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.InspectionReportAddBiz;
import cn.qiyu.magicalcrue_patient.biz.SymptomatographyAddBiz;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/12/24.
 *  添加检查报告单
 */

public class InspectionReportAddBizImpl extends BaseBiz implements InspectionReportAddBiz {

    //添加检查报告单带图片
    @Override
    public void addInspectionReportSave(String patientUuid, String inspectionDate, String typeId, String inspectionDescription, String imageList, final OnLoginListener onLoginListener) {
        mApiService.getInspectionReportSave(patientUuid,inspectionDate,typeId,inspectionDescription,imageList).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
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
    //添加检查报告单不带图片
    @Override
    public void addInspectionReportSaveText(String patientUuid, String inspectionDate, String typeId, String inspectionDescription, final OnLoginListener onLoginListener) {
    mApiService.getInspectionReportSaveText(patientUuid,inspectionDate,typeId,inspectionDescription).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
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











