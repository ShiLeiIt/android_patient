package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.FollowUpDialogueBiz;
import cn.qiyu.magicalcrue_patient.biz.MyScaleBiz;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 * 随访对话列表
 */

public class FollowUpDialogueBizImpl extends BaseBiz implements FollowUpDialogueBiz {

    @Override
    public void getFollowUpDialogueList(String userUuid, String userType, String page, String pagecount, final OnLoginListener onLoginListener) {
        mApiService.getFollowUpDialogueList(userUuid, userType, page, pagecount).enqueue(new Callback<ResultModel<List<FollowUpMessageDetaild>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<FollowUpMessageDetaild>>> call, Response<ResultModel<List<FollowUpMessageDetaild>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<FollowUpMessageDetaild>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
}











