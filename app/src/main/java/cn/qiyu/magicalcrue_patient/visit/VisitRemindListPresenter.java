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
    private VisitDeleteRemindListView mVisitDeleteRemindListView;
    private VisitRemindListBiz mVisitRemindListBiz;

    public VisitRemindListPresenter(VisitRemindListView visitRemindListView) {
        mVisitRemindListBiz = new VisitRemindListBizImpl();
        mVisitRemindListView = visitRemindListView;
    }
    public VisitRemindListPresenter(VisitDeleteRemindListView visitDeleteRemindListView) {
        mVisitRemindListBiz = new VisitRemindListBizImpl();
        mVisitDeleteRemindListView = visitDeleteRemindListView;
    }

    //获取提醒列表
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
    //  删除自己创建的日程提醒
    public  void getVisitDeleteRemindList(){
        mVisitRemindListBiz.getDeleteRemindList(mVisitDeleteRemindListView.getRemindUuid(), mVisitDeleteRemindListView.getPatientUuid(), new VisitRemindListBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mVisitDeleteRemindListView.LoadVisitDeleteRemindList(model);
                } else {
                    mVisitDeleteRemindListView.onViewFailure(model);
                }

            }

            @Override
            public void onFailure(String e) {
               mVisitDeleteRemindListView.onServerFailure(e);
            }
        });
    }


}
