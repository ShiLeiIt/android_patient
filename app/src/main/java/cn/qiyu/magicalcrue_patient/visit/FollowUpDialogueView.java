package cn.qiyu.magicalcrue_patient.visit;

import java.util.List;

import cn.qiyu.magicalcrue_patient.base.BaseView;
import cn.qiyu.magicalcrue_patient.model.FollowUpMessageDetaild;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;

/**
 * Created by ShiLei on 2017/11/30.
 * 随访对话
 */

public interface FollowUpDialogueView extends BaseView {
    String getPage();
    String getPagecount();
    String getUserUuid();
    String getUserType();
    void LoadFollowUpDialogue(ResultModel<List<FollowUpMessageDetaild>> model);

}
