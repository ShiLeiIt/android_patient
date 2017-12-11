package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/11.
 * 随访对话
 */

public interface FollowUpDialogueBiz {

    //随访消息列表
    void getFollowUpDialogueList(String userUuid,
                                 String userType,
                                 String page,
                                 String pagecount, OnLoginListener onLoginListener);


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
