package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.Comment;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/30.
 * 评论随访对话
 */

public interface CommentVisitDialogueView extends BaseView {

    String getUserUuid();
    String getConsultationId();
    String getUserRole();
    String getContent();
    String getParentId();
    String getType();
    void LoadCommentVisitDialogue(ResultModel model);
    //评论列表
    String getPage();
    String getPageCount();

   void LoadCommentList(ResultModel<List<Comment>> model);

}
