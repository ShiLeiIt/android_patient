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
    public void RegisterLoadMesData(){

        mRegisterBiz.getVerifyInformation(mVmView.getAccount(), new RegisterBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                Log.i("register", "232323232323");
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
    public void  RegisterLogin(){
       mRegisterBiz.getRegisterLogin(mVmView.getAccount(), mVmView.getVerCode(), mVmView.getJpushId(), new RegisterBiz.OnLoginListener() {
           @Override
           public void onResponse(ResultModel model) {
               Log.i("register", "1111111111111111111111111111111");
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
