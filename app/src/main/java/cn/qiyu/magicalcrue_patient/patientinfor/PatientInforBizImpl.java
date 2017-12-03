package cn.qiyu.magicalcrue_patient.patientinfor;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.PatientInforBiz;
import cn.qiyu.magicalcrue_patient.biz.PatientRelationInfoBiz;
import cn.qiyu.magicalcrue_patient.model.PatientInforSaveBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class PatientInforBizImpl extends BaseBiz implements PatientInforBiz {


    @Override
    public void getPatientInfor(String patientUuid, String userId, String name, String sex, String birthday, String idCardNO, final String mobile, String native_place_cd, String attending_doctor, String firstVisitTime, String relationship, String disease_id, String appFirstVisitTime, final OnLoginListener onLoginListener) {
        mApiService.getPatientInfor(patientUuid, userId,
                name,
                sex,
                birthday,
                idCardNO,
                mobile,
                native_place_cd,
                attending_doctor,
                firstVisitTime,
                relationship,
                disease_id,
                appFirstVisitTime).enqueue(new Callback<ResultModel<PatientInforSaveBean>>() {
            @Override
            public void onResponse(Call<ResultModel<PatientInforSaveBean>> call, Response<ResultModel<PatientInforSaveBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<PatientInforSaveBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });

    }
}
