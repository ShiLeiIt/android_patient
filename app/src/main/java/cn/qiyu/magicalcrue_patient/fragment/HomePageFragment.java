package cn.qiyu.magicalcrue_patient.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.AllServeActivity;
import cn.qiyu.magicalcrue_patient.activity.CourseActivity;
import cn.qiyu.magicalcrue_patient.activity.MedicalActivity;
import cn.qiyu.magicalcrue_patient.activity.OffLineActivity;
import cn.qiyu.magicalcrue_patient.adapter.CommonAdapter;
import cn.qiyu.magicalcrue_patient.adapter.ViewHolder;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.home.HomePresenter;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.view.LLImageView;
import cn.qiyu.magicalcrue_patient.view.LLTextView;
import cn.qiyu.magicalcrue_patient.view.LLTextViewNew;
import cn.qiyu.magicalcrue_patient.view.ListViewForScrollView;

/**
 * Created by Administrator on 2017/11/13.
 * 首页界面
 */

public class HomePageFragment extends Fragment implements View.OnClickListener {
    private ListViewForScrollView mLv_sv;
    private TextView mTv_topleft_visit;
    private TextView mTv_topleft_inquiry;
    private TextView mTv_topleft_report;
    private TextView mTv_topleft_record;
    private TextView mTv_diaglog;
    private TextView mTv_scale;
    private TextView mTv_newReport;
    private TextView mTv_course;
    private TextView mTv_unScra;
    private TextView mTv_doctor_name;
    private TextView mTvCourse;
    private TextView mTvMedical;
    private TextView mTvOffline;
    private TextView mTvAllserve;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        LLImageView viewById = (LLImageView) view.findViewById(R.id.iv_doctor_icon);
        mTv_doctor_name = (TextView) view.findViewById(R.id.tv_mydocter);
        LLTextView llTvVisit = (LLTextView) view.findViewById(R.id.ll_tv_visit);//加入随访
        LLTextView llTvInquiry = (LLTextView) view.findViewById(R.id.ll_inquiry);//在线问诊
        LLTextView llTvReport = (LLTextView) view.findViewById(R.id.ll_tv_report);//随访报告
        LLTextView llTvRecord = (LLTextView) view.findViewById(R.id.ll_tv_record);//病情记录
        LLTextViewNew llTvDiaglog = (LLTextViewNew) view.findViewById(R.id.ll_tv_diaglogue);//新对话
        LLTextViewNew llTvScale = (LLTextViewNew) view.findViewById(R.id.ll_tv_scale);//新量表
        LLTextViewNew llTvNewReport = (LLTextViewNew) view.findViewById(R.id.ll_tv_new_report);//新随访报告
        LLTextViewNew llTvCourse = (LLTextViewNew) view.findViewById(R.id.ll_tv_course);//患教课程
        LLTextViewNew llTvUnscramble = (LLTextViewNew) view.findViewById(R.id.ll_tv_unscramble);//待付款

        //患教课程
        mTvCourse = (TextView) view.findViewById(R.id.ll_tv_course_new);
        //医疗机构
        mTvMedical = (TextView) view.findViewById(R.id.ll_tv_medical);
        //线下沙龙
        mTvOffline = (TextView) view.findViewById(R.id.ll_tv_offline);
        //全部服务
        mTvAllserve = (TextView) view.findViewById(R.id.ll_tv_all_serve);

        mTvCourse.setOnClickListener(this);
        mTvMedical.setOnClickListener(this);
        mTvOffline.setOnClickListener(this);
        mTvAllserve.setOnClickListener(this);

        mTv_topleft_visit = (TextView) llTvVisit.findViewById(R.id.tv_top_left);
        mTv_topleft_inquiry = (TextView) llTvInquiry.findViewById(R.id.tv_top_left);
        mTv_topleft_report = (TextView) llTvReport.findViewById(R.id.tv_top_left);
        mTv_topleft_record = (TextView) llTvRecord.findViewById(R.id.tv_top_left);

        mTv_diaglog = (TextView) llTvDiaglog.findViewById(R.id.tv_top_left);
        mTv_scale = (TextView) llTvScale.findViewById(R.id.tv_top_left);
        mTv_newReport = (TextView) llTvNewReport.findViewById(R.id.tv_top_left);
        mTv_course = (TextView) llTvCourse.findViewById(R.id.tv_top_left);
        mTv_unScra = (TextView) llTvUnscramble.findViewById(R.id.tv_top_left);



        HomePresenter homePresenter = new HomePresenter(new HomeNumView() {
            @Override
            public String getUserId() {
//                return "5d9976d752c541c5a4608bc2758c54d7";
                return getActivity().getIntent().getStringExtra("uuid");
            }

            @Override
            public String getPatientId() {
//                return "";

                return getActivity().getIntent().getStringExtra("patientuuid");

            }

            @Override
            public void LoadDate(ResultModel<HomeNumBean> numBean) {
//                Toast.makeText(getActivity(), ""+numBean.getMessage(), Toast.LENGTH_SHORT).show();


                if (numBean.getData() != null) {
                    mTv_topleft_visit.setText(String.valueOf(numBean.getData().getFollowDay()));
                    mTv_topleft_inquiry.setText(String.valueOf(numBean.getData().getConstructionCount()));
                    mTv_topleft_report.setText(String.valueOf(numBean.getData().getFollowUpCount()));
                    mTv_topleft_record.setText(String.valueOf(numBean.getData().getStatusRecord()));

                    mTv_diaglog.setText(String.valueOf(numBean.getData().getNewDialogueCount()));
                    mTv_scale.setText(String.valueOf(numBean.getData().getNwePaperCount()));
                    mTv_newReport.setText(String.valueOf(numBean.getData().getNewFollowUpCount()));
//                    mTv_course.setText(String.valueOf(numBean.getData().getCourseCount()));
                    mTv_unScra.setText(String.valueOf(numBean.getData().getPendingPaymentCount()));
//                    mTv_doctor_name.setText(numBean.getData().get);

                } else {
                    Toast.makeText(getActivity(), "1111", Toast.LENGTH_SHORT).show();
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

        homePresenter.HomeLoadNumData();
//        homePresenter.HomeDoctorData();
        Toast.makeText(getActivity(), "uuid"+getActivity().getIntent().getStringExtra("uuid"), Toast.LENGTH_SHORT).show();
        Log.i("uuid++++", getActivity().getIntent().getStringExtra("uuid"));

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        getActivity().getIntent().getStringExtra("uuid");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tv_course_new:
                Toast.makeText(getActivity(), "666666666666666666", Toast.LENGTH_SHORT).show();
                getActivity().startActivityForResult(new Intent(getActivity(), CourseActivity.class),1111);
                break;
            case R.id.ll_tv_medical:
                getActivity().startActivityForResult(new Intent(getActivity(), MedicalActivity.class),2222);
                break;
            case R.id.ll_tv_offline:
                getActivity().startActivityForResult(new Intent(getActivity(), OffLineActivity.class),3333);
                break;
            case R.id.ll_tv_all_serve:
                getActivity().startActivityForResult(new Intent(getActivity(), AllServeActivity.class),4444);
                break;
        }

    }

    public class MyAdapter extends CommonAdapter<String> {
        public MyAdapter(Context context, List<String> mDatas, int itemLayoutId) {
            super(context, mDatas, itemLayoutId);
        }

        @Override
        public void convert(ViewHolder helper, String item, int positon) {
            helper.setImageResource(R.id.adapter_iv_item, R.drawable.banner);
        }
    }


}
