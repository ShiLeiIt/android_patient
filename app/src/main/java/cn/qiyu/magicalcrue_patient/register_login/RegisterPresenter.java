package cn.qiyu.magicalcrue_patient.register_login;

import android.util.Log;
import android.widget.Toast;

import cn.qiyu.magicalcrue_patient.activity.RegisterActivity;
import cn.qiyu.magicalcrue_patient.biz.RegisterBiz;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginVerBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public class RegisterPresenter {

    private final RegisterBiz mRegisterBiz;
    private final RegisterVmView mVmView;





    public RegisterPresenter(RegisterVmView vmView){
        mRegisterBiz = new RegisterBizImpl();
        mVmView = vmView;
    }
    //获取验证信息
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
    //登录成功
    public void  RegisterLogin(){
       mRegisterBiz.getRegisterLogin(mVmView.getAccount(), mVmView.getVerCode(), mVmView.getJpushId(), new RegisterBiz.OnLoginListener() {
           @Override
           public void onResponse(ResultModel model) {
               if (model.getResult() == 0) {
                   mVmView.getRegisterLogin(model);
               } else {
                   mVmView.onViewFailure(model);
               }
           }

           @Override
           public void onFailure(String e) {
                mVmView.onServerFailure(e);
           }
           });
    }
}
