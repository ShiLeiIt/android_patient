package cn.qiyu.magicalcrue_patient.base;

/**
 * Created by Administrator on 2017/11/13.
 */

public interface BaseView {

    void showProgress();

    void hideProgress();

    /**
     * 服务器返回的不是 200
     * <p>
     * 服务器返回  200 400 403 405 500
     *
     * @param model
     */
//    void onViewFailure(ResultModel model);

    /**
     * 服务断开
     *
     * @param e
     */
    void onServerFailure(String e);
}
