package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.PatientCourseListBiz;
import cn.qiyu.magicalcrue_patient.biz.VisitRemindListBiz;
import cn.qiyu.magicalcrue_patient.model.CreateRemindBean;
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
    //删除自己创建的日程提醒
    @Override
    public void getDeleteRemindList(final String remindUuid, String patientUuid, final OnLoginListener onLoginListener) {
    mApiService.deleteOneselfRemindEvent(remindUuid,patientUuid).enqueue(new Callback<ResultModel>() {
        @Override
        public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
            if (response.isSuccessful()) {
                onLoginListener.onResponse(response.body());
            } else {
                onLoginListener.onFailure(response.body().getMessage());
            }
        }

        @Override
        public void onFailure(Call<ResultModel> call, Throwable throwable) {
        onLoginListener.onFailure(throwable.getMessage());
        }
    });
    }

    //创建患者的日程提醒
    @Override
    public void getCreateRemind(String remindUuid, String eventName, String eventRemark, String remindTime, String repeatNum, String repeatType, String patientUuid, String userRoleType, String eventReception, String userStatus, String receptionUserStatus, final OnLoginListener onLoginListener) {
        mApiService.CreatRemindEvent(remindUuid,eventName,
                                     eventRemark,remindTime,repeatNum,
                                     repeatType,patientUuid,userRoleType,eventReception,userStatus,receptionUserStatus).enqueue(new Callback<ResultModel<CreateRemindBean>>() {
            @Override
            public void onResponse(Call<ResultModel<CreateRemindBean>> call, Response<ResultModel<CreateRemindBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<CreateRemindBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

    //提醒日程详情
    @Override
    public void getRemindDetails(final String remindUuid, final OnLoginListener onLoginListener) {
        mApiService.getEventRemindDetails(remindUuid).enqueue(new Callback<ResultModel<CreateRemindBean>>() {
            @Override
            public void onResponse(Call<ResultModel<CreateRemindBean>> call, Response<ResultModel<CreateRemindBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<CreateRemindBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });

    }
}











