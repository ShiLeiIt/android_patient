package cn.qiyu.magicalcrue_patient.register_login;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.VersionUpdateBean;

/**
 * Created by ShiLei on 2017/11/16.
 */

public interface AppVersionView extends BaseView {
    String getCode();
    String getPlatform();
    String getChannel();
    String getCurrentVersion();
    void getAppVersionIsUpdate(ResultModel<VersionUpdateBean> model);




}
