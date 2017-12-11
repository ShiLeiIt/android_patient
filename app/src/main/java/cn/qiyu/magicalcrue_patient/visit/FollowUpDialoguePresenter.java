package cn.qiyu.magicalcrue_patient.visit;

import cn.qiyu.magicalcrue_patient.biz.FollowUpDialogueBiz;
import cn.qiyu.magicalcrue_patient.biz.MyScaleBiz;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/15.
 * 随访对话
 */

public class FollowUpDialoguePresenter {
    private FollowUpDialogueView mFollowUpDialogueView;
    private FollowUpDialogueBiz mFollowUpDialogueBiz;

    public FollowUpDialoguePresenter(FollowUpDialogueView followUpDialogueView) {
        mFollowUpDialogueBiz = new FollowUpDialogueBizImpl();
        mFollowUpDialogueView = followUpDialogueView;
    }

    //随访对话
    public void getFollowUpDialogue() {
        mFollowUpDialogueBiz.getFollowUpDialogueList(mFollowUpDialogueView.getUserUuid(),
                mFollowUpDialogueView.getUserType(), mFollowUpDialogueView.getPage(),
                mFollowUpDialogueView.getPagecount(), new FollowUpDialogueBiz.OnLoginListener() {
                    @Override
                    public void onResponse(ResultModel model) {
                        if (model.getResult() == 0) {
                            mFollowUpDialogueView.LoadFollowUpDialogue(model);
                        } else {
                            mFollowUpDialogueView.onViewFailure(model);
                        }
                    }

                    @Override
                    public void onFailure(String e) {
                        mFollowUpDialogueView.onServerFailure(e);
                    }
                });
    }


}
