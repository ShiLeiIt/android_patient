package cn.qiyu.magicalcrue_patient.biz;

import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/20.
 * 用户基本信息编辑
 */

public interface UserInforEdtBiz {
    void getUserInfoEdt(String id,String photoPath,String user_name,String birthday,
                        String sex,String native_place_cd,
                        OnLoginListener onLoginListener);

    void getCityInfor(String parent_code,String levelId,OnLoginListener onLoginListener);

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
