package cn.qiyu.magicalcrue_patient.information;

import java.util.List;
import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.InformationBiz;
import cn.qiyu.magicalcrue_patient.model.InfoUserNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InformationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class InformationBizImpl extends BaseBiz implements InformationBiz {

    //消息界面医生公告列表
    @Override
    public void getUserNoticeList(String doctorUuid, String page, String pagecount, final OnLoginListener onLoginListener) {
        mApiService.getUserNoticeList(doctorUuid, page, pagecount).enqueue(new Callback<ResultModel<List<InfoUserNoticeListBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<InfoUserNoticeListBean>>> call, Response<ResultModel<List<InfoUserNoticeListBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<ResultModel<List<InfoUserNoticeListBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

    //获取消息界面
    @Override
    public void getInformationList(String userUuid, final OnLoginListener onLoginListener) {
        mApiService.getInformationList(userUuid).enqueue(new Callback<ResultModel<InformationBean>>() {
            @Override
            public void onResponse(Call<ResultModel<InformationBean>> call, Response<ResultModel<InformationBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<InformationBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
    //获取医生公告列表已读
    @Override
    public void getDoctorNoticeRead(String userUuid, String messageUuid, final OnLoginListener onLoginListener) {
        mApiService.getDoctorNoticeRead(userUuid,messageUuid).enqueue(new Callback<ResultModel>() {
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
    //随访消息已读（Num为零）
    @Override
    public void getFollowUpMsgRead(String userUuid, final OnLoginListener onLoginListener) {
        mApiService.getFollowUpMsgRead(userUuid).enqueue(new Callback<ResultModel>() {
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


}
