package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CommentVisitDialogueBiz;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 *
 */

public class CommetVisitDialogueBizImpl extends BaseBiz implements CommentVisitDialogueBiz {
    //回复评论
    @Override
    public void getCommentVisitDialogue(String userUuid, String consultationUuid, String userRole, String content, String parentId, String type, final OnLoginListener onLoginListener) {
        mApiService.getCommentVisitDialogue(userUuid, consultationUuid,
                userRole, content, parentId, type).enqueue(new Callback<ResultModel>() {
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
    //评论列表
    @Override
    public void getCommentList(String consultationUuid, String page, String pagecount, final OnLoginListener onLoginListener) {
        mApiService.getCommentList(consultationUuid,page,pagecount).enqueue(new Callback<ResultModel<List<Comment>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<Comment>>> call, Response<ResultModel<List<Comment>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<List<Comment>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
}











