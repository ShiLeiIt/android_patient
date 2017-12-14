package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.biz.CommentVisitDialogueBiz;
import cn.qiyu.magicalcrue_patient.biz.VisitDialogueQuizBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;


/**
 * Created by ShiLei on 2017/12/13.
 * 随访对话提问
 */

public class VisitDialogueQuizPresenter {
    private VisitDialogueQuizView mVisitDialogueQuizView;
    private VisitDialogueQuizBiz mVisitDialogueQuizBiz;

    public VisitDialogueQuizPresenter(VisitDialogueQuizView visitDialogueQuizView) {
        mVisitDialogueQuizBiz = new VisitDialogueQuizBizImpl();
        mVisitDialogueQuizView = visitDialogueQuizView;
    }
    //提问带图片
   public void getVisitDialogueQuiz(){
       mVisitDialogueQuizBiz.getVisitDialogueQuiz(mVisitDialogueQuizView.getDoctorUuid(),
               mVisitDialogueQuizView.getUserUuid(),
               mVisitDialogueQuizView.getUserType(),
               mVisitDialogueQuizView.getComplaint(),
               mVisitDialogueQuizView.getImageArray(), new VisitDialogueQuizBiz.OnLoginListener() {
                   @Override
                   public void onResponse(ResultModel model) {
                       if (model.getResult() == 0) {
                           mVisitDialogueQuizView.LoadVisitDialogueQuiz(model);
                       } else {
                           mVisitDialogueQuizView.onViewFailure(model);
                       }
                   }

                   @Override
                   public void onFailure(String e) {
                    mVisitDialogueQuizView.onServerFailure(e);
                   }
               });
   }
   //提问不带图片
   public void getVisitDialogQuizText(){
       mVisitDialogueQuizBiz.getVisitDialogueQuizText(mVisitDialogueQuizView.getDoctorUuid(),
               mVisitDialogueQuizView.getUserUuid(),
               mVisitDialogueQuizView.getUserType(),
               mVisitDialogueQuizView.getComplaint(),
                new VisitDialogueQuizBiz.OnLoginListener() {
                   @Override
                   public void onResponse(ResultModel model) {
                       if (model.getResult() == 0) {
                           mVisitDialogueQuizView.LoadVisitDialogueQuizText(model);
                       } else {
                           mVisitDialogueQuizView.onViewFailure(model);
                       }
                   }

                   @Override
                   public void onFailure(String e) {
                       mVisitDialogueQuizView.onServerFailure(e);
                   }
               });
   }



}
