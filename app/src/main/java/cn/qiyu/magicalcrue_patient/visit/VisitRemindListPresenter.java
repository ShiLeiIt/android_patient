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
    private VisitCreateRemindView mVisitCreateRemindView;

    private VisitRemindListBiz mVisitRemindListBiz;
    //显示日程列表
    public VisitRemindListPresenter(VisitRemindListView visitRemindListView) {
        mVisitRemindListBiz = new VisitRemindListBizImpl();
        mVisitRemindListView = visitRemindListView;
    }
    //删除日程
    public VisitRemindListPresenter(VisitDeleteRemindListView visitDeleteRemindListView) {
        mVisitRemindListBiz = new VisitRemindListBizImpl();
        mVisitDeleteRemindListView = visitDeleteRemindListView;
    }
    //创建患者日程
    public VisitRemindListPresenter(VisitCreateRemindView visitCreateRemindView) {
        mVisitRemindListBiz = new VisitRemindListBizImpl();
        mVisitCreateRemindView = visitCreateRemindView;
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
    //创建患者的日程提醒
    public void getVisitCreateRemind(){
        mVisitRemindListBiz.getCreateRemind(mVisitCreateRemindView.getRemindUuid(),
                                            mVisitCreateRemindView.getEventName(),
                                            mVisitCreateRemindView.getEventRemark(),
                                            mVisitCreateRemindView.getRemindTime(),
                                            mVisitCreateRemindView.getRepeatNum(),
                                            mVisitCreateRemindView.getRepeatType(),
                                            mVisitCreateRemindView.getPatientUuid(),
                                            mVisitCreateRemindView.getUserRoleType(),
                                            mVisitCreateRemindView.getEventReception(),
                                            mVisitCreateRemindView.getUserStatus(),
                                            mVisitCreateRemindView.getReceptionUserStatus(), new VisitRemindListBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mVisitCreateRemindView.LoadVisiteCreateRemind(model);
                        } else {
                            mVisitCreateRemindView.onViewFailure(model);
                        }

                    }

                    @Override
                    public void onFailure(String e) {
                        mVisitCreateRemindView.onServerFailure(e);
                    }
                }
        );
    }

}
