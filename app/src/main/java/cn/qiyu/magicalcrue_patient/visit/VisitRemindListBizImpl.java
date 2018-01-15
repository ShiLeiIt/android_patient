package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.PatientCourseListBiz;
import cn.qiyu.magicalcrue_patient.biz.VisitRemindListBiz;
import cn.qiyu.magicalcrue_patient.model.PatientCourseListBean;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2018/1/15.
 * 随访提醒列表
 */

public class VisitRemindListBizImpl extends BaseBiz implements VisitRemindListBiz {

    //随访提醒列表
    @Override
    public void getRemindList(String patientUuid, String page, String pageCount, final OnLoginListener onLoginListener) {
        mApiService.getVisitRemindList(patientUuid,page,pageCount).enqueue(new Callback<ResultModel<List<RemindListBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<RemindListBean>>> call, Response<ResultModel<List<RemindListBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<RemindListBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
}











