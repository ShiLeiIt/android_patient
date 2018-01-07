package cn.qiyu.magicalcrue_patient.mine;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.UserInfor;

/**
 * Created by ShiLei on 2018/1/4.
 */

public interface LogoutView extends BaseView {
    String  getUserUuid();
    String  getType();
    void Logout(ResultModel model);
}
