package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.CreateRemindBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2018/1/17.
 *  创建的日程提醒
 */

public interface VisitCreateRemindView extends BaseView {
    String getRemindUuid();
    String getEventName();
    String getEventRemark();
    String getRemindTime();
    String getRepeatNum();
    String getRepeatType();
    String getPatientUuid();
    String getUserRoleType();
    String getEventReception();
    String getUserStatus();
    String getReceptionUserStatus();

   void LoadVisiteCreateRemind(ResultModel<CreateRemindBean> model);

}
