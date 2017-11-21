package cn.qiyu.magicalcrue_patient.city;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseBiz;
import cn.qiyu.magicalcrue_patient.biz.CityDistrictBiz;
import cn.qiyu.magicalcrue_patient.biz.UserInforEdtBiz;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ShiLei on 2017/11/15.
 */

public class CityDistrictBizImpl extends BaseBiz implements CityDistrictBiz {

    @Override
    public void getCityInfor(String parent_code, String levelId, final OnLoginListener onLoginListener) {
        mApiService.getCitiyInfor(parent_code,levelId).enqueue(new Callback<ResultModel<List<CityBean>>>() {
            @Override
            public void onResponse(Call<ResultModel<List<CityBean>>> call, Response<ResultModel<List<CityBean>>> response) {
                if(response.isSuccessful())
                    onLoginListener.onResponse(response.body());
                else
                    onLoginListener.onFailure(response.body().getMessage());
            }

            @Override
            public void onFailure(Call<ResultModel<List<CityBean>>> call, Throwable throwable) {
                onLoginListener.onFailure(throwable.getMessage());
            }
        });
    }
}
