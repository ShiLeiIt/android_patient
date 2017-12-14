package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/13.
 * 随访对话提问
 */

public interface VisitDialogueQuizBiz {

    //随访对话提问
    void getVisitDialogueQuiz(String doctorUuid,
                              String userUuid,
                              String userType,
                              String complaint, String imageArray, OnLoginListener onLoginListener);

    //随访对话提问不带图片
    void getVisitDialogueQuizText(String doctorUuid,
                              String userUuid,
                              String userType,
                              String complaint, OnLoginListener onLoginListener);



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
