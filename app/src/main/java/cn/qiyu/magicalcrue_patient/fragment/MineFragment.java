package cn.qiyu.magicalcrue_patient.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.MinePatientDataActivity;
import cn.qiyu.magicalcrue_patient.activity.MineUserInforActivity;
import cn.qiyu.magicalcrue_patient.activity.PatientDataActivity;
import cn.qiyu.magicalcrue_patient.activity.UserInforActivity;
import cn.qiyu.magicalcrue_patient.mine.MineInforView;
import cn.qiyu.magicalcrue_patient.mine.MinePresenter;
import cn.qiyu.magicalcrue_patient.model.PatientInfor;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.UserInfor;
import cn.qiyu.magicalcrue_patient.utils.ActivityManagerTool;
import cn.qiyu.magicalcrue_patient.utils.DisplayHelper;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/11/13.
 * 个人信息界面
 */

public class MineFragment extends Fragment implements View.OnClickListener {

    private ImageView mIv_patient_back;
    private ImageView mIv_case_history_back;
    private ImageView mIv_order_back;
    private ImageView mIv_collect_back;
    private ImageView mIv_service_back;
    private ImageView mIv_setting;
    private CircleImageView mIv_mine_icon;
    private TextView mTv_mine_username;
    private ImageView mIv_arrows;
    private String mUserName;
    private String mMobile;
    private String mPhotoPath;
    private String tagName = "";
    private TextView mTv_phoneNume;
    private PatientInfor mData;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        RelativeLayout rl_title_mine = (RelativeLayout) view.findViewById(R.id.rl_title_mine);

        RelativeLayout view_patient = (RelativeLayout) view.findViewById(R.id.il_patient);
        RelativeLayout view_case = (RelativeLayout) view.findViewById(R.id.il_case_history);
        RelativeLayout view_order = (RelativeLayout) view.findViewById(R.id.il_order);
        RelativeLayout view_collect = (RelativeLayout) view.findViewById(R.id.il_collect);
        RelativeLayout view_service = (RelativeLayout) view.findViewById(R.id.il_service);
        TextView tv_list_patient = (TextView) view_patient.findViewById(R.id.tv_list_item);
        ImageView iv_list_patient = (ImageView) view_patient.findViewById(R.id.iv_list_item);

        view_patient.setOnClickListener(this);
        view_case.setOnClickListener(this);
        view_order.setOnClickListener(this);
        view_collect.setOnClickListener(this);
        view_service.setOnClickListener(this);


        //头像控件
        mIv_mine_icon = (CircleImageView) view.findViewById(R.id.iv_mine_icon);


        mTv_phoneNume = (TextView) view.findViewById(R.id.tv_mine_phone_num);


        //用户名字
        mTv_mine_username = (TextView) view.findViewById(R.id.tv_mine_username);

        rl_title_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagName = "1";
                mMinePresenter.getUserBasicInfor();
            }
        });
        //用户界面
        mIv_arrows = (ImageView) view.findViewById(R.id.iv_arrows);
        mIv_arrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagName = "1";
                mMinePresenter.getUserBasicInfor();

            }
        });


        tv_list_patient.setText("患者基本资料");
        iv_list_patient.setImageResource(R.drawable.mine_patient);
        TextView tv_list_case = (TextView) view_case.findViewById(R.id.tv_list_item);
        ImageView iv_list_case_icon = (ImageView) view_case.findViewById(R.id.iv_list_item);
        tv_list_case.setText("病历");
        iv_list_case_icon.setImageResource(R.drawable.mine_case_history);
        TextView tv_list_order = (TextView) view_order.findViewById(R.id.tv_list_item);
        ImageView iv_list_order = (ImageView) view_order.findViewById(R.id.iv_list_item);
        tv_list_order.setText("订单");
        iv_list_order.setImageResource(R.drawable.mine_order);
        TextView tv_list_collect = (TextView) view_collect.findViewById(R.id.tv_list_item);
        ImageView iv_list_collect = (ImageView) view_collect.findViewById(R.id.iv_list_item);
        tv_list_collect.setText("收藏");
        iv_list_collect.setImageResource(R.drawable.mine_collect);

        TextView tv_list_service = (TextView) view_service.findViewById(R.id.tv_list_item);
        ImageView iv_list_service = (ImageView) view_service.findViewById(R.id.iv_list_item);
        tv_list_service.setText("客服");
        iv_list_service.setImageResource(R.drawable.mine_service);


        mIv_patient_back = (ImageView) view_patient.findViewById(R.id.iv_list_item_arrows);
        mIv_case_history_back = (ImageView) view_case.findViewById(R.id.iv_list_item_arrows);
        mIv_order_back = (ImageView) view_order.findViewById(R.id.iv_list_item_arrows);
        mIv_collect_back = (ImageView) view_collect.findViewById(R.id.iv_list_item_arrows);
        mIv_service_back = (ImageView) view_service.findViewById(R.id.iv_list_item_arrows);
        mIv_setting = (ImageView) view.findViewById(R.id.iv_mine_setting);

        mIv_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PreUtils.clearUserInfomation(getActivity());
                PreUtils.setParam(getActivity(), "userperfect", 0);
                PreUtils.setParam(getActivity(), "uuid", "");
                ActivityManagerTool.getActivityManager().exit();
            }
        });


        mMinePresenter.getUserBasicInfor();
        mMinePresenter.getPatientBasicInfor();
        //跳转患者信息界面
        mIv_patient_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tagName = "2";
                mMinePresenter.getPatientBasicInfor();

            }
        });

        mIv_case_history_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIv_order_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIv_collect_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mIv_service_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return view;

    }

    MinePresenter mMinePresenter = new MinePresenter(new MineInforView() {
        @Override
        public String getUserUuid() {
            Log.i("useruuid=====", (String) PreUtils.getParam(getActivity(), "uuid", ""));
            return (String) PreUtils.getParam(getActivity(), "uuid", "");
        }

        @Override
        public String getPatientBasicUuid() {
            return (String) PreUtils.getParam(getActivity(), "patientuuid", "");
        }


        //获取用户的基本信息
        @Override
        public void getUserBasicInfor(ResultModel<UserInfor> userInforResultModel) {

            mUserName = userInforResultModel.getData().getUser_name();

            mPhotoPath = userInforResultModel.getData().getPhotoPath();
            mTv_mine_username.setText(mUserName);
            String path = ApiService.GET_IMAGE_ICON + mPhotoPath;
            DisplayHelper.loadGlide(getActivity(), path, mIv_mine_icon);
            if (tagName.equals("1")) {
                Intent intent = new Intent(getActivity(), MineUserInforActivity.class);
                intent.putExtra("userInfor", userInforResultModel.getData());
                startActivity(intent);
            }
//            Log.i("username", mUserName);
//            Log.i("path", ApiService.GET_IMAGE_ICON + mPhotoPath);
//            Log.i("mPhotoPath", userInforResultModel.getData().getPhotoPath());


        }

        @Override
        public void getPatientBasicInfor(ResultModel<PatientInfor> patientInforResultModel) {
            mMobile = patientInforResultModel.getData().getMobile();
            String one = mMobile.substring(1, 4);
            String two = mMobile.substring(7, 11);

            mTv_phoneNume.setText(one + "****" + two);
            if (tagName.equals("2")) {
                Intent intent = new Intent(getActivity(), MinePatientDataActivity.class);
                intent.putExtra("patientInfor", patientInforResultModel.getData());
                startActivity(intent);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.il_patient:
                tagName = "2";
                mMinePresenter.getPatientBasicInfor();
                break;
            case R.id.il_case_history:
                break;
            case R.id.il_order:
                break;
            case R.id.il_collect:
                break;
            case R.id.il_service:
                break;

        }
    }
}
