package cn.qiyu.magicalcrue_patient.userinfor;


import cn.qiyu.magicalcrue_patient.biz.UserInforEdtBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;


/**
 * Created by ShiLei on 2017/11/16.
 */

public class UserInforEdtPresenter {

    private final UserInforEdtBiz mUserInforEdtBiz;
    private final UserInforEdtView mUserInforEdtView;

    public UserInforEdtPresenter(UserInforEdtView userInforEdtView) {
        mUserInforEdtBiz = new UserInforEdtBizImpl();
        mUserInforEdtView = userInforEdtView;
    }
    public void getUserInforEdt() {
        mUserInforEdtView.showProgress();
        mUserInforEdtBiz.getUserInfoEdt(mUserInforEdtView.getUuId(), mUserInforEdtView.getPhotoPath(),
                mUserInforEdtView.getUser_name(), mUserInforEdtView.getBirthday(), mUserInforEdtView.getSex(),
                mUserInforEdtView.getNative_place_cd(), new UserInforEdtBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mUserInforEdtView.getUserInforEdt(model);
                            mUserInforEdtView.hideProgress();
                        } else {
                            mUserInforEdtView.onViewFailure(model);
                            mUserInforEdtView.hideProgress();
                        }
                    }
                    @Override
                    public void onFailure(String e) {
                        mUserInforEdtView.onServerFailure(e);
                        mUserInforEdtView.hideProgress();
                    }
                }

        );
    }

}
