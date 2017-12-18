package cn.qiyu.magicalcrue_patient.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.DoctorNoticeListActivity;
import cn.qiyu.magicalcrue_patient.activity.FollowUpMessageDetailActivity;
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
import cn.qiyu.magicalcrue_patient.information.InformationView;
import cn.qiyu.magicalcrue_patient.model.InfoDoctorNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InformationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;


/**
 * Created by Administrator on 2017/11/13.
 * 消息界面
 */

public class InformationFragment extends Fragment {

    @Bind(R.id.tv_dialogue_title)
    TextView mTvDialogueTitle;
    @Bind(R.id.tv_dialogue_content)
    TextView mTvDialogueContent;
    @Bind(R.id.tv_dialogue_num)
    TextView mTvDialogueNum;
    @Bind(R.id.rl_visit_dialogue)
    RelativeLayout mRlVisitDialogue;
    @Bind(R.id.tv_system_notice_title)
    TextView mTvSystemNoticeTitle;
    @Bind(R.id.tv_system_notice_content)
    TextView mTvSystemNoticeContent;
    @Bind(R.id.tv_system_notice_num)
    TextView mTvSystemNoticeNum;
    @Bind(R.id.rl_system_notice)
    RelativeLayout mRlSystemNotice;
    @Bind(R.id.tv_doctor_notice_title)
    TextView mTvDoctorNoticeTitle;
    @Bind(R.id.tv_doctor_notice_content)
    TextView mTvDoctorNoticeContent;
    @Bind(R.id.tv_doctor_notice_num)
    TextView mTvDoctorNoticeNum;
    @Bind(R.id.rl_doctor_notice)
    RelativeLayout mRlDoctorNotice;
    private String mUuid;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        ButterKnife.bind(this, view);
        mUuid = (String) PreUtils.getParam(getActivity(), "uuid", "0");
        Log.i("userUuid===", mUuid);
        mInformationPresenter.InformationListShow();
        return view;
    }

    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationView() {
        @Override
        public String getDoctorUuid() {
            return null;
        }

        @Override
        public String getPage() {
            return null;
        }

        @Override
        public String getPagecount() {
            return null;
        }

        @Override
        public void getDoctorNoticeList(ResultModel<List<InfoDoctorNoticeListBean>> model) {

        }

        @Override
        public String getUserUuid() {
            return mUuid;
        }

        @Override
        public void getInformationList(ResultModel<InformationBean> model) {
            if (model!=null) {
            //医生公告
            mTvDoctorNoticeTitle.setText(model.getData().getNoticeData().getTitle());
            mTvDoctorNoticeContent.setText(model.getData().getNoticeData().getContent());
            mTvDoctorNoticeNum.setText(String.valueOf(model.getData().getNoticeData().getNum()));
            //系统公告
            mTvSystemNoticeTitle.setText(model.getData().getMessageData().getTitle());
            mTvSystemNoticeContent.setText(model.getData().getMessageData().getContent());
            mTvSystemNoticeNum.setText(String.valueOf(model.getData().getMessageData().getNum()));
            //随访对话
            mTvDialogueTitle.setText(model.getData().getFollowData().getTitle());
            mTvDialogueContent.setText(model.getData().getFollowData().getContent());
            mTvDialogueNum.setText(String.valueOf(model.getData().getFollowData().getNum()));
            }
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {

        }

        @Override
        public void onServerFailure(String e) {

        }
    });


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.rl_visit_dialogue, R.id.rl_system_notice, R.id.rl_doctor_notice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_visit_dialogue:
                //跳转随访对话
                startActivity(new Intent(getActivity(), FollowUpMessageDetailActivity.class));
                break;
            case R.id.rl_system_notice:
                break;
            case R.id.rl_doctor_notice:
                startActivity(new Intent(getActivity(), DoctorNoticeListActivity.class));
                break;
        }
    }

    /**
     *
     * @param isVisibleToUser
     * 切换fragment时，状态
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if (mInformationPresenter!=null) {
                mInformationPresenter.InformationListShow();
            }
        }
    }
}
