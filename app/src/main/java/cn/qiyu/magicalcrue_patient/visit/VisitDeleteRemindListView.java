package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2018/1/16.
 *  删除自己创建的日程提醒
 */

public interface VisitDeleteRemindListView extends BaseView {
    String getRemindUuid();
    String getPatientUuid();
   void LoadVisitDeleteRemindList(ResultModel model);

}
