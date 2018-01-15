package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.biz.PatientCourseListBiz;
import cn.qiyu.magicalcrue_patient.biz.VisitDialogueQuizBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;


/**
 * Created by ShiLei on 2018/1/15.
 * 随访患教课堂
 */

public class PatientCourseListPresenter {
    private PatientCourseListView mPatientCourseListView;
    private PatientCourseListBiz mPatientCourseListBiz;

    public PatientCourseListPresenter(PatientCourseListView patientCourseListView) {
        mPatientCourseListBiz = new PatientCourseListBizImpl();
        mPatientCourseListView = patientCourseListView;
    }
   public void getPatientCourseList(){
       mPatientCourseListBiz.getPatientCourse(mPatientCourseListView.getPatientUuid(), mPatientCourseListView.getPage(), mPatientCourseListView.getPageCount(), new PatientCourseListBiz.OnLoginListener() {
           @Override
           public void onResponse(ResultModel model) {
               if (model.getResult() == 0) {
                   mPatientCourseListView.LoadPatientCourseList(model);
               } else {
                   mPatientCourseListView.onViewFailure(model);
               }
           }

           @Override
           public void onFailure(String e) {
            mPatientCourseListView.onServerFailure(e);
           }
       });
   }




}
