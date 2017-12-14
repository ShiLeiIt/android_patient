package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.VisitDialogueQuizBiz;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.VisitDialogueQuizBean;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/12/13.
 */

public class VisitDialogueQuizBizImpl extends BaseBiz implements VisitDialogueQuizBiz {
    //随访对话提问
    @Override
    public void getVisitDialogueQuiz(String doctorUuid, String userUuid, String userType, String complaint, String imageArray, final OnLoginListener onLoginListener) {
        mApiService.getVisitDialogueQuiz(doctorUuid, userUuid, userType, complaint, imageArray).enqueue(new Callback<ResultModel<VisitDialogueQuizBean>>() {
            @Override
            public void onResponse(Call<ResultModel<VisitDialogueQuizBean>> call, Response<ResultModel<VisitDialogueQuizBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<VisitDialogueQuizBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

    @Override
    public void getVisitDialogueQuizText(String doctorUuid, String userUuid, String userType, String complaint, final OnLoginListener onLoginListener) {
        mApiService.getVisitDialogueQuizText(doctorUuid,userUuid,userType,complaint).enqueue(new Callback<ResultModel<VisitDialogueQuizBean>>() {
            @Override
            public void onResponse(Call<ResultModel<VisitDialogueQuizBean>> call, Response<ResultModel<VisitDialogueQuizBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<VisitDialogueQuizBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }

}











