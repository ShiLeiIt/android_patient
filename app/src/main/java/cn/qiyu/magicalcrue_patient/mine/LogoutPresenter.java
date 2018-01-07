package cn.qiyu.magicalcrue_patient.mine;

import cn.qiyu.magicalcrue_patient.biz.LogoutBiz;
import cn.qiyu.magicalcrue_patient.biz.MineBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2018/1/4.
 * 退出登录
 */

public class LogoutPresenter {
    private LogoutView mLogoutView;
    private LogoutBiz mLogoutBiz;

    public LogoutPresenter(LogoutView logoutView) {
        mLogoutBiz = new LogoutBizImpl();
        mLogoutView = logoutView;
    }

    public  void  getLogout(){
       mLogoutBiz.getLogout(mLogoutView.getUserUuid(), mLogoutView.getType(), new LogoutBiz.OnLoginListener() {
           @Override
           public void onResponse(ResultModel model) {
               if (model.getResult() == 0) {
                   mLogoutView.Logout(model);
               } else {
                   mLogoutView.onViewFailure(model);
               }
           }

           @Override
           public void onFailure(String e) {
            mLogoutView.onServerFailure(e);
           }
       });
    }






}
