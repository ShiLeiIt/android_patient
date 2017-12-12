package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.biz.CommentVisitDialogueBiz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 评论随访对话
 */

public class CommentVisitDialoguePresenter {
    private CommentVisitDialogueView mCommentVisitDialogueView;
    private CommentVisitDialogueBiz mCommentVisitDialogueBiz;

    public CommentVisitDialoguePresenter(CommentVisitDialogueView commentVisitDialogueView) {
        mCommentVisitDialogueBiz = new CommetVisitDialogueBizImpl();
        mCommentVisitDialogueView = commentVisitDialogueView;
    }

    //评论随访对话
    public void getCommentVisitDialogue() {
        mCommentVisitDialogueBiz.getCommentVisitDialogue(mCommentVisitDialogueView.getUserUuid(),
                mCommentVisitDialogueView.getConsultationId(),
                mCommentVisitDialogueView.getUserRole(),
                mCommentVisitDialogueView.getContent(),
                mCommentVisitDialogueView.getParentId(),
                mCommentVisitDialogueView.getType(), new CommentVisitDialogueBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mCommentVisitDialogueView.LoadCommentVisitDialogue(model);
                        } else {
                            mCommentVisitDialogueView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mCommentVisitDialogueView.onServerFailure(e);
                    }
                });
    }
    //评论列表
    public  void getCommentList(){
        mCommentVisitDialogueBiz.getCommentList(mCommentVisitDialogueView.getConsultationId(), mCommentVisitDialogueView.getPage(), mCommentVisitDialogueView.getPageCount(), new CommentVisitDialogueBiz.OnLoginListener() {
            @Override
            public void onResponse(ResultModel model) {
                if (model.getResult() == 0) {
                    mCommentVisitDialogueView.LoadCommentList(model);
                } else {
                    mCommentVisitDialogueView.onViewFailure(model);
                }
            }

            @Override
            public void onFailure(String e) {
            mCommentVisitDialogueView.onServerFailure(e);
            }
        });
    }


}
