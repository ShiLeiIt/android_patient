package cn.qiyu.magicalcrue_patient.city;

import cn.qiyu.magicalcrue_patient.biz.CityDistrictBiz;
import cn.qiyu.magicalcrue_patient.biz.UserInforEdtBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.userinfor.UserInforEdtBizImpl;
import cn.qiyu.magicalcrue_patient.userinfor.UserInforEdtView;

/**
 * Created by ShiLei on 2017/11/16.
 */

public class CityDistrictPresenter {

    private final CityDistrictBiz mCityDistrictBiz;
    private final CityDistrictView mCityDistrictView;

    public CityDistrictPresenter(CityDistrictView cityDistrictView) {
        mCityDistrictBiz = new CityDistrictBizImpl();
        mCityDistrictView = cityDistrictView;
    }
    public  void getCity(String code ,String lvId){
        mCityDistrictBiz.getCityInfor(code, lvId, new CityDistrictBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if(model.getResult()==0)
                    mCityDistrictView.getCityInfor(model);
                else
                    mCityDistrictView.onViewFailure(model);
            }

            @Override
            public void onFailure(String e) {
                mCityDistrictView.onServerFailure(e);
            }
        });
    }

}
