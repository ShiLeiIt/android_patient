package cn.qiyu.magicalcrue_patient.home;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;

/**
 * Created by ShiLei on 2017/11/15.
 */

public interface HomeNumView extends BaseView {
     String  getUserId();

    void LoadDate(HomeNumBean numBean);
}
