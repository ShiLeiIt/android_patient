package cn.qiyu.magicalcrue_patient.city;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/16.
 */

public interface CityDistrictView extends BaseView {
    String getParentCode(String code);
    String getLevelId(String lv_id);
    void getCityInfor(ResultModel<List<CityBean>> ctBean);

}
