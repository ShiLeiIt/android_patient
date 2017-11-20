package cn.qiyu.magicalcrue_patient.register_login;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public interface RegisterVmView extends BaseView {
    String getAccount();
    String getVerCode();
    String getJpushId();

    void getVerifyMessage(ResultModel rlBean);
    void getRegisterLogin(ResultModel<RegisterLoginBean> model);




}
