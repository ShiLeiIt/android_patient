package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CaseHistoryBiz;
import cn.qiyu.magicalcrue_patient.biz.LeaveHospitalAddBiz;
import cn.qiyu.magicalcrue_patient.biz.OutPatientAddBiz;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/12/21.
 *  添加出院小结
 */

public class LeaveHospitalAddBizImpl extends BaseBiz implements LeaveHospitalAddBiz {


    //添加出院小结信息保存带图
    @Override
    public void addLeaveHospitalSave(String patientUuid, String beHospitalizedDate, String leaveHospitalDate, String hospitalId, String hospitalizationOfficeId, String doctorName, String summary, String imageList, final CaseHistoryBiz.OnLoginListener onLoginListener) {
        mApiService.getLeaveHospitalSave(patientUuid,beHospitalizedDate,leaveHospitalDate,hospitalId,hospitalizationOfficeId,doctorName,summary,imageList).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
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
    //添加出院小结信息保存不带图
    @Override
    public void addLeaveHospitalSaveText(String patientUuid, String beHospitalizedDate, String leaveHospitalDate, String hospitalId, String hospitalizationOfficeId, String doctorName, String summary, final CaseHistoryBiz.OnLoginListener onLoginListener) {
        mApiService.getLeaveHospitalSaveText(patientUuid,beHospitalizedDate,leaveHospitalDate,hospitalId,hospitalizationOfficeId,doctorName,summary).enqueue(new Callback<ResultModel<AddOutPatientDataSaveBean>>() {
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











