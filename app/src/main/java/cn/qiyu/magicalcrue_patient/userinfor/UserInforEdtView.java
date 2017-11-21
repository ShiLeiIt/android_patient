package cn.qiyu.magicalcrue_patient.userinfor;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.RegisterLoginBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public interface UserInforEdtView extends BaseView {
    String getUuId();

    String getPhotoPath();

    String getUser_name();

    String getBirthday();

    String getSex();

    String getNative_place_cd();

    void getUserInforEdt(ResultModel rlBean);


}
