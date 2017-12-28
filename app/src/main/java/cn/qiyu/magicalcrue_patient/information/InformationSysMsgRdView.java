package cn.qiyu.magicalcrue_patient.information;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.InfoUserSystemMsgListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/12/27.
 * 系统消息已读
 */

public interface InformationSysMsgRdView extends BaseView {
    String getMessageId();
    void getSystemMessageRead(ResultModel<InfoUserSystemMsgListBean> model);




}
