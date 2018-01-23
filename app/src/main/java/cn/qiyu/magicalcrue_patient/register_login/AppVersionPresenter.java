package cn.qiyu.magicalcrue_patient.register_login;

import cn.qiyu.magicalcrue_patient.biz.AppVersionBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;


/**
 * Created by ShiLei on 2017/11/16.
 */

public class AppVersionPresenter {

    private final AppVersionBiz mAppVersionBiz;
    private final AppVersionView mAppVersionView;
    public AppVersionPresenter(AppVersionView appVersionView){
        mAppVersionBiz = new AppVersionBizImpl();
        mAppVersionView = appVersionView;
    }
    //获取App版本号对应升级
    public void getAppVersionIsUpdate(){
        mAppVersionBiz.getAppVersionIsUpdate(mAppVersionView.getCode(), mAppVersionView.getPlatform(), mAppVersionView.getChannel(), mAppVersionView.getCurrentVersion(), new AppVersionBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mAppVersionView.getAppVersionIsUpdate(model);
                } else {
                    mAppVersionView.onViewFailure(model);
                }
            }

            @Override
            public void onFailure(String e) {
                mAppVersionView.onServerFailure(e);
            }
        });
    }

}
