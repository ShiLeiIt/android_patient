package cn.qiyu.magicalcrue_patient.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.DoctorListActivity;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.home.HomePresenter;
import cn.qiyu.magicalcrue_patient.model.DoctorInfoBean;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.DisplayHelper;
import cn.qiyu.magicalcrue_patient.view.LLTextView;
import cn.qiyu.magicalcrue_patient.view.MyGridView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/11/13.
 * 随访界面
 */

public class VisitFragment extends Fragment implements View.OnClickListener {

    private static int ICON_HOME[] = {
            R.drawable.visit_dialogue, R.drawable.visit_case_history, R.drawable.visit_symptom, R.drawable.visit_pharmacy,
            R.drawable.visit_scale, R.drawable.visit_report, R.drawable.visit_teaching, R.drawable.visit_first_aid,
            R.drawable.visit_combo
    };

    private static String TITLE_INFO[] =
            {
                    "对话", "简历", "症状", "用药", "量表", "随访报告", "患教", "急救", "套餐",
            };
    private MyGridView mGridView;
    private TextView mTv_topleft_visit;
    private TextView mTv_topleft_inquiry;
    private TextView mTv_topleft_report;
    private TextView mTv_topleft_record;

    private TextView mTv_doc_tem_name;
    private TextView mTv_patient_name;
    private CircleImageView[] civ;
    private ImageView mIv_visit_arrows;
    private List<DoctorInfoBean> mDoctorTeamList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_visit, container, false);
        mGridView = (MyGridView) view.findViewById(R.id.gridview);
        LLTextView llTvVisit = (LLTextView) view.findViewById(R.id.ll_tv_visit);//加入随访
        LLTextView llTvInquiry = (LLTextView) view.findViewById(R.id.ll_inquiry);//在线问诊
        LLTextView llTvReport = (LLTextView) view.findViewById(R.id.ll_tv_report);//随访报告
        LLTextView llTvRecord = (LLTextView) view.findViewById(R.id.ll_tv_record);//病情记录
        mTv_doc_tem_name = (TextView) view.findViewById(R.id.tv_doc_team);
        mTv_patient_name = (TextView) view.findViewById(R.id.tv_patient_name);
        String patientName = getActivity().getIntent().getStringExtra("patientName");

        mTv_patient_name.setText(patientName);
        mIv_visit_arrows = (ImageView) view.findViewById(R.id.iv_visit_arrows);
        mIv_visit_arrows.setOnClickListener(this);

        CircleImageView mCiv_one = (CircleImageView) view.findViewById(R.id.iv_doctor_icon_one);
        CircleImageView civ_two = (CircleImageView) view.findViewById(R.id.iv_doctor_icon_two);
        CircleImageView civ_three = (CircleImageView) view.findViewById(R.id.iv_doctor_icon_three);
        CircleImageView civ_four = (CircleImageView) view.findViewById(R.id.iv_doctor_icon_four);
        CircleImageView civ_five = (CircleImageView) view.findViewById(R.id.iv_doctor_icon_five);
        civ = new CircleImageView[]{mCiv_one, civ_two, civ_three, civ_four, civ_five};


        mTv_topleft_visit = (TextView) llTvVisit.findViewById(R.id.tv_top_left);
        mTv_topleft_inquiry = (TextView) llTvInquiry.findViewById(R.id.tv_top_left);
        mTv_topleft_report = (TextView) llTvReport.findViewById(R.id.tv_top_left);
        mTv_topleft_record = (TextView) llTvRecord.findViewById(R.id.tv_top_left);

        setGridView();
        homePresenter.HomeLoadNumData();
        homePresenter.getDoctorTeamInfo();

        return view;
    }
    HomePresenter homePresenter = new HomePresenter(new HomeNumView() {
        @Override
        public String getUserId() {
            return getActivity().getIntent().getStringExtra("uuid");
        }

        @Override
        public void LoadDate(ResultModel<HomeNumBean> numBean) {
            if (numBean.getData() != null) {
                mTv_topleft_visit.setText(String.valueOf(numBean.getData().getFollowDay()));
                mTv_topleft_inquiry.setText(String.valueOf(numBean.getData().getConstructionCount()));
                mTv_topleft_report.setText(String.valueOf(numBean.getData().getFollowUpCount()));
                mTv_topleft_record.setText(String.valueOf(numBean.getData().getStatusRecord()));
            } else {
                Toast.makeText(getActivity(), "1111", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public String patientUuid() {
            return getActivity().getIntent().getStringExtra("patientUuid");
        }

        @Override
        public String DoctorUuid() {
            return null;
        }

        @Override
        public void getDoctorQRcode(ResultModel model) {


        }

        @Override
        public String patientId() {
            return getActivity().getIntent().getStringExtra("patientUuid");
        }

        @Override
        public void LoadDoctorTeamInfor(ResultModel<DoctorTeamBean> model) {
            String teamName = model.getData().getTeam_name();
            mDoctorTeamList = model.getData().getDoctorTeamList();

            mTv_doc_tem_name.setText(teamName);
            int DoctorIcon = 0;
            switch (model.getData().getDoctorTeamList().size()) {
                case 1:
                    DoctorIcon = 1;
                    break;
                case 2:
                    DoctorIcon = 2;
                    break;
                case 3:
                    DoctorIcon = 3;
                    break;
                case 4:
                    DoctorIcon = 4;
                    break;
                case 5:
                default:
                    DoctorIcon = 5;
                    break;
            }
            for (int i = 0; i < DoctorIcon; i++) {
                String path = "";
                if (null == model.getData().getDoctorTeamList().get(i).getPhoto_path())
                    path = "";
                else path = ApiService.GET_IMAGE_ICON + model.getData().getDoctorTeamList().get(i).getPhoto_path();
                DisplayHelper.loadGlide(getActivity(), path, civ[i]);
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

    private void setGridView() {
        ArrayList<HashMap<String, Object>> meumList = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < 9; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", ICON_HOME[i]);
            map.put("ItemText", TITLE_INFO[i]);
            meumList.add(map);
        }
        SimpleAdapter saMenuItem = new SimpleAdapter(getActivity(),
                meumList, //数据源
                R.layout.meunitem, //xml实现
                new String[]{"ItemImage", "ItemText"}, //对应map的Key
                new int[]{R.id.ItemImage, R.id.ItemText});  //对应R的Id
//添加Item到网格中
        mGridView.setAdapter(saMenuItem);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
//                        Intent intent = new Intent(getActivity(), WorkGroupActivity.class);
//                        intent.putExtra("by_doctor_uuid", "desk");
//                        startActivity(intent);
                        break;
                    case 1:
//                        Toast.makeText(getActivity(), "量表", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
//                        Toast.makeText(getActivity(), "随访报告", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.iv_course_back, R.id.tv_mere_update, R.id.iv_visit_arrows, R.id.gridview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_course_back:
                break;
            case R.id.tv_mere_update:
                break;
            case R.id.iv_visit_arrows:
                break;
            case R.id.gridview:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), DoctorListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("list", (Serializable) mDoctorTeamList);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
