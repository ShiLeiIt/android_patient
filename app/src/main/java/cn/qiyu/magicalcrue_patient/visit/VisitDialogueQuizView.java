package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.VisitDialogueQuizBean;

/**
 * Created by ShiLei on 2017/12/13.
 * 随访对话提问
 */

public interface VisitDialogueQuizView extends BaseView {
    String getDoctorUuid();
    String getUserUuid();
    String getUserType();
    String getComplaint();
    String getImageArray();
    //提问带图片
   void LoadVisitDialogueQuiz(ResultModel<VisitDialogueQuizBean> model);
    //不带图片
   void LoadVisitDialogueQuizText(ResultModel<VisitDialogueQuizBean> model);

}
