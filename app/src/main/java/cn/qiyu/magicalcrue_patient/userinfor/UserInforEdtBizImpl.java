package cn.qiyu.magicalcrue_patient.userinfor;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.UserInforEdtBiz;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class UserInforEdtBizImpl extends BaseBiz implements UserInforEdtBiz {


    @Override
    public void getUserInfoEdt(String id, String photoPath, String user_name, String birthday, String sex, String native_place_cd, final OnLoginListener onLoginListener) {
        mApiService.getUserInforEdt(id, photoPath, user_name, birthday, sex, native_place_cd).enqueue(new Callback<ResultModel>() {
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

    @Override
    public void getCityInfor(String parent_code, String levelId, final OnLoginListener onLoginListener) {
        mApiService.getCitiyInfor(parent_code,levelId).enqueue(new Callback<ResultModel<CityBean>>() {
            @Override
            public void onResponse(Call<ResultModel<CityBean>> call, Response<ResultModel<CityBean>> response) {
                if (response.isSuccessful()) {
                    onLoginListener.onResponse(response.body());
                } else {
                    onLoginListener.onFailure(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<ResultModel<CityBean>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
}
