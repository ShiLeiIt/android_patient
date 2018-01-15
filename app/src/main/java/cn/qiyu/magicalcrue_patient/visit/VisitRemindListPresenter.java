package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.biz.PatientCourseListBiz;
import cn.qiyu.magicalcrue_patient.biz.VisitRemindListBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;


/**
 * Created by ShiLei on 2018/1/15.
 * 随访提醒列表
 */

public class VisitRemindListPresenter {
    private VisitRemindListView mVisitRemindListView;
    private VisitRemindListBiz mVisitRemindListBiz;

    public VisitRemindListPresenter(VisitRemindListView visitRemindListView) {
        mVisitRemindListBiz = new VisitRemindListBizImpl();
        mVisitRemindListView = visitRemindListView;
    }
   public void getVisitRemindList(){
       mVisitRemindListBiz.getRemindList(mVisitRemindListView.getPatientUuid(), mVisitRemindListView.getPage(), mVisitRemindListView.getPageCount(), new VisitRemindListBiz.OnLoginListener() {
           @Override
           public void onResponse(ResultModel model) {
               if (model.getResult() == 0) {
                   mVisitRemindListView.LoadVisitRemindList(model);
               } else {
                   mVisitRemindListView.onViewFailure(model);
               }
           }

           @Override
           public void onFailure(String e) {
               mVisitRemindListView.onServerFailure(e);
           }
       });
   }




}
