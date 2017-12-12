package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/11.
 * 评论随访对话
 */

public interface CommentVisitDialogueBiz {

    //评论随访对话
    void getCommentVisitDialogue(String userUuid,
                                 String consultationUuid,
                                 String userRole,
                                 String content, String parentId, String type, OnLoginListener onLoginListener);
    //评论列表
    void getCommentList(String consultationUuid,String page,String pagecount,OnLoginListener onLoginListener);


    interface OnLoginListener<T> {

        /**
         * 服务器响应
         *
         * @param model
         */
        void onResponse(ResultModel<T> model);

        /**
         * 服务器未响应
         *
         * @param e
         */
        void onFailure(String e);
    }
}
