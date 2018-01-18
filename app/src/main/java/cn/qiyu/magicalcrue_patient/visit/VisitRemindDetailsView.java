package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.CreateRemindBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2018/1/18.
 *  日程提醒详情
 */

public interface VisitRemindDetailsView extends BaseView {
    String getRemindUuid();
   void LoadVisiteRemindDetails(ResultModel<CreateRemindBean> model);

}
