package cn.qiyu.magicalcrue_patient.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.DoctorNoticeListActivity;
import cn.qiyu.magicalcrue_patient.activity.FollowUpMessageDetailActivity;
import cn.qiyu.magicalcrue_patient.activity.SystemMessagesActivity;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.home.HomePresenter;
import cn.qiyu.magicalcrue_patient.information.InformationFollowUpRdView;
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
import cn.qiyu.magicalcrue_patient.information.InformationView;
import cn.qiyu.magicalcrue_patient.mine.MineInforView;
import cn.qiyu.magicalcrue_patient.mine.MinePresenter;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeBannerBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.InfoUserNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InformationBean;
import cn.qiyu.magicalcrue_patient.model.PatientInfor;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.UserInfor;
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
    private String mPatientuuid;
    private String mErrorCode;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        ButterKnife.bind(this, view);
        mUuid = (String) PreUtils.getParam(getActivity(), "uuid", "0");
        mPatientuuid = (String) PreUtils.getParam(getActivity(), "patientuuid", "0");
//        Log.i("userUuid===", mUuid);
        //注册EventBus，在开始的位置
        EventBus.getDefault().register(this);

        return view;
    }

    InformationPresenter mPresenter = new InformationPresenter(new InformationFollowUpRdView() {
        @Override
        public String getUserUuid() {
            return mUuid;
        }

        @Override
        public void LoadFollowUpMsgRead(ResultModel model) {
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

    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationView() {


        @Override
        public String getPage() {
            return null;
        }

        @Override
        public String getPagecount() {
            return null;
        }

        @Override
        public void getDoctorNoticeList(ResultModel<List<InfoUserNoticeListBean>> model) {

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
                if (model.getData().getNoticeData().getNum() == 0) {
                    mTvDoctorNoticeNum.setVisibility(View.INVISIBLE);
                } else {
                    mTvDoctorNoticeNum.setVisibility(View.VISIBLE);
                }


            //系统公告
            mTvSystemNoticeTitle.setText(model.getData().getMessageData().getTitle());
            mTvSystemNoticeContent.setText(model.getData().getMessageData().getContent());
            mTvSystemNoticeNum.setText(String.valueOf(model.getData().getMessageData().getNum()));
                if (model.getData().getMessageData().getNum() == 0) {
                    mTvSystemNoticeNum.setVisibility(View.INVISIBLE);
                } else {
                    mTvSystemNoticeNum.setVisibility(View.VISIBLE);
                }
            //随访对话
            mTvDialogueTitle.setText(model.getData().getFollowData().getTitle());
            mTvDialogueContent.setText(model.getData().getFollowData().getContent());
            mTvDialogueNum.setText(String.valueOf(model.getData().getFollowData().getNum()));
                if (model.getData().getFollowData().getNum() == 0) {
                    mTvDialogueNum.setVisibility(View.INVISIBLE);
                } else {
                    mTvDialogueNum.setVisibility(View.VISIBLE);
                }
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
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String event) {
        //已经好了，你发的什么，这里接收的就是什么，类型要一致
        String doctorUuidUrl = event;
        if (doctorUuidUrl.length() > 2) {

        } else {

            mInformationPresenter.InformationListShow();
        }

    }


    @OnClick({R.id.rl_visit_dialogue, R.id.rl_system_notice, R.id.rl_doctor_notice})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_visit_dialogue:
                //跳转随访对话
                Intent intent = new Intent(getActivity(), FollowUpMessageDetailActivity.class);
                intent.putExtra("errorCode", mErrorCode);
                startActivity(intent);
                break;
            case R.id.rl_system_notice:
                startActivity(new Intent(getActivity(), SystemMessagesActivity.class));
                break;
            case R.id.rl_doctor_notice:
                startActivity(new Intent(getActivity(), DoctorNoticeListActivity.class));
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mInformationPresenter.InformationListShow();
                mPresenter.getFollowUpMsgRead();



            }
        });
//
//        Toast.makeText(getActivity(), "显示", Toast.LENGTH_SHORT).show();
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
