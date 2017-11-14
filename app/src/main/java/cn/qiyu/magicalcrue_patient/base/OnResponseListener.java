package cn.qiyu.magicalcrue_patient.base;

/**
 * Created by Administrator on 2017/11/13.
 */

public interface OnResponseListener<T> {
    /**
     * 服务器响应
     *
     * @param t
     */
    void onResponse(T t);

    /**
     * 服务器断开
     *
     * @param e
     */
    void onServerFailure(String e);
}
