package cn.qiyu.magicalcrue_patient.register_login;

import cn.qiyu.magicalcrue_patient.biz.RegisterBiz;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public class RegisterPresenter {

    private final RegisterBizImpl mRegisterBiz;
    private final RegisterVmView mVmView;

    public RegisterPresenter(RegisterVmView vmView){
        mRegisterBiz = new RegisterBizImpl();
        mVmView = vmView;
    }
    public void RegisterLoadMesData(){
        mRegisterBiz.getVerifyInformation(mVmView.getAccount(), new RegisterBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mVmView.getVerifyMessage(model);
                } else {
                    mVmView.onServerFailure(model.getMessage());
                }
            }

            @Override
            public void onFailure(String e) {

            }
        });
    }
}
