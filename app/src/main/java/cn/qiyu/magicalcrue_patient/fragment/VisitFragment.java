package cn.qiyu.magicalcrue_patient.fragment;

import android.app.Dialog;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.CaseHistoryActivity;
import cn.qiyu.magicalcrue_patient.activity.DoctorListActivity;
import cn.qiyu.magicalcrue_patient.activity.FollowUpMessageDetailActivity;
import cn.qiyu.magicalcrue_patient.activity.InspectionReportInfoListActivity;
import cn.qiyu.magicalcrue_patient.activity.LeaveHospitalInfoListActivity;
import cn.qiyu.magicalcrue_patient.activity.MainActivity;
import cn.qiyu.magicalcrue_patient.activity.MyScaleActivity;
import cn.qiyu.magicalcrue_patient.activity.NewCourseActivity;
import cn.qiyu.magicalcrue_patient.activity.NewFollowupReportActivity;
import cn.qiyu.magicalcrue_patient.activity.OutpatientInformationListActivity;
import cn.qiyu.magicalcrue_patient.activity.PatientDataActivity;
import cn.qiyu.magicalcrue_patient.activity.PharmacyPlanRecordInfoListActivity;
import cn.qiyu.magicalcrue_patient.activity.SymgraphyInfoListActivity;
import cn.qiyu.magicalcrue_patient.activity.UserInforActivity;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.home.HomePresenter;
import cn.qiyu.magicalcrue_patient.mine.MineInforView;
import cn.qiyu.magicalcrue_patient.mine.MinePresenter;
import cn.qiyu.magicalcrue_patient.model.DoctorInfoBean;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.HomeBannerBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.PatientInfor;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.UserInfor;
import cn.qiyu.magicalcrue_patient.utils.DisplayHelper;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.utils.Utils;
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
                    "对话", "病历", "症状", "用药", "量表", "随访报告", "患教", "急救", "套餐",
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
    private TextView mTv_mere_updata;
    private String mErrorCode;
    private ImageView mIv_patientInfor;
    private String mNamewe = "";
    private Dialog mDialog;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_visit, container, false);
        //注册EventBus，在开始的位置 ok
//        EventBus.getDefault().register(this);

        mGridView = (MyGridView) view.findViewById(R.id.gridview);
        LLTextView llTvVisit = (LLTextView) view.findViewById(R.id.ll_tv_visit);//加入随访
        LLTextView llTvInquiry = (LLTextView) view.findViewById(R.id.ll_inquiry);//在线问诊
        LLTextView llTvReport = (LLTextView) view.findViewById(R.id.ll_tv_report);//随访报告
        LLTextView llTvRecord = (LLTextView) view.findViewById(R.id.ll_tv_record);//病情记录
        mTv_doc_tem_name = (TextView) view.findViewById(R.id.tv_doc_team);
        mTv_patient_name = (TextView) view.findViewById(R.id.tv_patient_name);
        RelativeLayout rl_pa_inf_vi = (RelativeLayout) view.findViewById(R.id.rl_patient_infor_visit);
        RelativeLayout rl_doc_tem_vi = (RelativeLayout) view.findViewById(R.id.rl_doctor_team_visit);

        //跳医生列表
        mIv_visit_arrows = (ImageView) view.findViewById(R.id.iv_visit_arrows);
        //病历更新
        mTv_mere_updata = (TextView) view.findViewById(R.id.tv_mere_update);
        //患者界面
        mIv_patientInfor = (ImageView) view.findViewById(R.id.iv_patient_arrows);
        rl_doc_tem_vi.setOnClickListener(this);
        rl_pa_inf_vi.setOnClickListener(this);
        mTv_mere_updata.setOnClickListener(this);
        mIv_visit_arrows.setOnClickListener(this);
        mIv_patientInfor.setOnClickListener(this);

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
        mMinePresenter.getPatientBasicInfor();


        return view;
    }


    MinePresenter mMinePresenter = new MinePresenter(new MineInforView() {
        @Override
        public String getUserUuid() {
            return (String) PreUtils.getParam(getActivity(), "uuid", "0");
        }

        @Override
        public String getPatientBasicUuid() {
            return (String) PreUtils.getParam(getActivity(), "patientuuid", "0");
        }

        @Override
        public void getUserBasicInfor(ResultModel<UserInfor> userInforResultModel) {

        }

        @Override
        public void getPatientBasicInfor(ResultModel<PatientInfor> patientInforResultModel) {
            String patient_user_name = patientInforResultModel.getData().getName();
            Log.i("patient_user_name", patient_user_name);
            mTv_patient_name.setText(patient_user_name);

            if (mNamewe.equals("123")) {
                Intent intent = new Intent(getActivity(), PatientDataActivity.class);
                intent.putExtra("patientInfor", patientInforResultModel.getData());
                intent.putExtra("visitFragment", "1");
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


    HomePresenter homePresenter = new HomePresenter(new HomeNumView() {
        @Override
        public String getUserId() {
            return (String) PreUtils.getParam(getActivity(), "uuid", "0");
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
            Log.i("patientuuid-=-=-=-=-", (String) PreUtils.getParam(getActivity(), "patientuuid", "0"));
            return (String) PreUtils.getParam(getActivity(), "patientuuid", "0");
        }

        @Override
        public String DoctorUuid() {
            return null;
        }

        @Override
        public void getDoctorQRcode(ResultModel model) {

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
                else
                    path = ApiService.GET_IMAGE_ICON + model.getData().getDoctorTeamList().get(i).getPhoto_path();
                DisplayHelper.loadGlide(getActivity(), path, civ[i]);
            }
        }
        //首页Banner
        @Override
        public String getType() {
            return null;
        }

        @Override
        public void LoadHomeBanner(ResultModel<List<HomeBannerBean>> model) {

        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            mErrorCode = model.getErrorCode();
            if (mErrorCode.equals("1001")) {
                Toast.makeText(getActivity(), "您还未加入任何随访,请扫描医生二维码", Toast.LENGTH_SHORT).show();
                String[] permissions = Utils.checkPermission(getActivity());
                if (permissions.length == 0) {

//                    startActivity(new Intent(getActivity(), CaptureActivity.class));
                } else {
                    //申请权限
                    ActivityCompat.requestPermissions(getActivity(), permissions, 100);
                }
//                initPermission();


            } else if (mErrorCode.equals("1002")) {
                Toast.makeText(getActivity(), "您已经加入随访了，请等待您的主治医生审核", Toast.LENGTH_SHORT).show();

            } else {
                String userperfect = String.valueOf(PreUtils.getParam(getActivity(), "userperfect", 0));
                if (userperfect.equals("1")) {
                    startActivity(new Intent(getActivity(), UserInforActivity.class));

                } else if (userperfect.equals("2")) {
                    startActivity(new Intent(getActivity(), PatientDataActivity.class));
                }
            }
//            Toast.makeText(getActivity(), "code======" + mErrorCode, Toast.LENGTH_SHORT).show();

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
        mGridView.setOnItemClickListener(

                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        switch (position) {
                            case 0:
                                //随访对话
                                startActivity(new Intent(getActivity(), FollowUpMessageDetailActivity.class));

//                        Intent intent = new Intent(getActivity(), WorkGroupActivity.class);
//                        intent.putExtra("by_doctor_uuid", "desk");
//                        startActivity(intent);
                                break;
                            case 1:
                                //病历
                                startActivity(new Intent(getActivity(), CaseHistoryActivity.class));
//                        Toast.makeText(getActivity(), "病历", Toast.LENGTH_SHORT).show();

                                break;
                            case 2:
//                        Toast.makeText(getActivity(), "症状", Toast.LENGTH_SHORT).show();
                                Intent intentS = new Intent(getActivity(), SymgraphyInfoListActivity.class);
                                startActivity(intentS);
                                break;
                            case 3:
//                        Toast.makeText(getActivity(), "用药", Toast.LENGTH_SHORT).show();
                                Intent intentP = new Intent(getActivity(), PharmacyPlanRecordInfoListActivity.class);
                                startActivity(intentP);
                                break;
                            case 4:
                                startActivity(new Intent(getActivity(), MyScaleActivity.class));
//                                Toast.makeText(getActivity(), "量表", Toast.LENGTH_SHORT).show();
                                break;
                            case 5:
                                startActivity(new Intent(getActivity(),NewFollowupReportActivity.class));
//                                Toast.makeText(getActivity(), "随访报告", Toast.LENGTH_SHORT).show();
                                break;
                            case 6:

//                        Toast.makeText(getActivity(), "患教课程", Toast.LENGTH_SHORT).show();
                                getActivity().startActivityForResult(new Intent(getActivity(), NewCourseActivity.class), 1111);
                                break;
                            case 7:
//                        Toast.makeText(getActivity(), "急救", Toast.LENGTH_SHORT).show();
                                break;
                            case 8:
//                        Toast.makeText(getActivity(), "套餐", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }
                });
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {

            //写你每次进入这个fragment需要调用的代码
//            homePresenter.getDoctorTeamInfo();
//            homePresenter.HomeLoadNumData();
            Log.i("=======123", "进入visit");
        }
    }

    /**
     * 初始化权限事件
     */
    private void initPermission() {
        //检查权限
        String[] permissions = Utils.checkPermission(getActivity());
        if (permissions.length == 0) {
            //权限都申请了,是否登录

        } else {
            //申请权限
            ActivityCompat.requestPermissions(getActivity(), permissions, 100);

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_visit_arrows:
                Intent intent = new Intent(getActivity(), DoctorListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) mDoctorTeamList);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.rl_doctor_team_visit:
                Intent intent1 = new Intent(getActivity(), DoctorListActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("list", (Serializable) mDoctorTeamList);
                intent1.putExtras(bundle1);
                startActivity(intent1);
                break;
            case R.id.tv_mere_update:
                updateCase();
                break;
            case R.id.rl_patient_infor_visit:
                mNamewe = "123";
                mMinePresenter.getPatientBasicInfor();
                break;
            case R.id.iv_patient_arrows:
                mNamewe = "123";
                mMinePresenter.getPatientBasicInfor();
                break;
            //检查报告单
            case R.id.tv_examine:
//                Toast.makeText(getActivity(), "检查报告单", Toast.LENGTH_SHORT).show();
                Intent intentI = new Intent(getActivity(), InspectionReportInfoListActivity.class);
                startActivity(intentI);

                break;
            //症状记录
            case R.id.tv_symptomatography:
//                Toast.makeText(getActivity(), "症状记录", Toast.LENGTH_SHORT).show();
                Intent intentS = new Intent(getActivity(), SymgraphyInfoListActivity.class);
                startActivity(intentS);
                break;

            //用药方案
            case R.id.tv_pharmacy:
//                Toast.makeText(getActivity(), "用药方案", Toast.LENGTH_SHORT).show();
                Intent intentP = new Intent(getActivity(), PharmacyPlanRecordInfoListActivity.class);
                startActivity(intentP);
                break;
            //出院小结
            case R.id.tv_leave_hospital:
//                Toast.makeText(getActivity(), "出院小结", Toast.LENGTH_SHORT).show();
                Intent intentL = new Intent(getActivity(), LeaveHospitalInfoListActivity.class);
                intentL.putExtra("leaveHospital", "leaveHospital");
                startActivity(intentL);
                break;
            //门诊资料
            case R.id.tv_outpatient:
//                Toast.makeText(getActivity(), "门诊资料", Toast.LENGTH_SHORT).show();
                Intent intentO = new Intent(getActivity(), OutpatientInformationListActivity.class);
                intentO.putExtra("outPatient", "outPatient");
                startActivity(intentO);
                break;
            case R.id.iv_update_delete:
                mDialog.dismiss();
                break;

        }

    }

    //更新病历弹出dialog
    public void updateCase() {

        View diaolgView = View.inflate(getActivity(), R.layout.dialog_update_case, null);
        mDialog = new Dialog(getActivity(), R.style.selectorDialog);
        mDialog.setContentView(diaolgView);

        //检查报告单
        TextView tvExamine = (TextView) mDialog.findViewById(R.id.tv_examine);

        TextView tv_symptomatography = (TextView) mDialog.findViewById(R.id.tv_symptomatography);
        TextView tv_pharmacy = (TextView) mDialog.findViewById(R.id.tv_pharmacy);
        TextView tv_leave_hospital = (TextView) mDialog.findViewById(R.id.tv_leave_hospital);
        TextView tv_outpatient = (TextView) mDialog.findViewById(R.id.tv_outpatient);
        ImageView iv_update_detele = (ImageView) mDialog.findViewById(R.id.iv_update_delete);

        tvExamine.setOnClickListener(this);
        tv_symptomatography.setOnClickListener(this);
        tv_pharmacy.setOnClickListener(this);
        tv_leave_hospital.setOnClickListener(this);
        tv_outpatient.setOnClickListener(this);

        iv_update_detele.setOnClickListener(this);

        mDialog.show();
        Window dialog1Window = mDialog.getWindow();
        WindowManager m1 = getActivity().getWindowManager();
        DisplayMetrics dm = new DisplayMetrics();
        m1.getDefaultDisplay().getMetrics(dm);
        WindowManager.LayoutParams p1 = dialog1Window.getAttributes();
        p1.height = (int) (dm.heightPixels * 1.0);
        p1.width = (int) (dm.widthPixels * 1.0);
        p1.alpha = 1.0f;
        dialog1Window.setAttributes(p1);
    }


}
