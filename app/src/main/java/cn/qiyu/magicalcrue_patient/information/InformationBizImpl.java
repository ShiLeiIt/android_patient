package cn.qiyu.magicalcrue_patient.information;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.HomeBiz;
import cn.qiyu.magicalcrue_patient.biz.InformationBiz;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.InfoDoctorNoticeListBean;
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
    public void getDoctorNoticeList(String doctorUuid, String page, String pagecount, final OnLoginListener onLoginListener) {
        mApiService.getDoctorNoticeList(doctorUuid, page, pagecount).enqueue(new Callback<ResultModel<List<InfoDoctorNoticeListBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<InfoDoctorNoticeListBean>>> call, Response<ResultModel<List<InfoDoctorNoticeListBean>>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<ResultModel<List<InfoDoctorNoticeListBean>>> call, Throwable throwable) {
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


}
