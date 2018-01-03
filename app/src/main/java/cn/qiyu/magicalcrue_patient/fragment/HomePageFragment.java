package cn.qiyu.magicalcrue_patient.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ScrollingView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.AllServeActivity;
import cn.qiyu.magicalcrue_patient.activity.CourseActivity;
import cn.qiyu.magicalcrue_patient.activity.DoctorListActivity;
import cn.qiyu.magicalcrue_patient.activity.FollowUpMessageDetailActivity;
import cn.qiyu.magicalcrue_patient.activity.MainActivity;
import cn.qiyu.magicalcrue_patient.activity.MedicalActivity;
import cn.qiyu.magicalcrue_patient.activity.MyScaleActivity;
import cn.qiyu.magicalcrue_patient.activity.NewCourseActivity;
import cn.qiyu.magicalcrue_patient.activity.NewFollowupReportActivity;
import cn.qiyu.magicalcrue_patient.activity.OffLineActivity;
import cn.qiyu.magicalcrue_patient.adapter.AppAdapter;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.home.HomePresenter;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamListBean;
import cn.qiyu.magicalcrue_patient.model.HomeBannerBean;
import cn.qiyu.magicalcrue_patient.model.HomeNumBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.DisplayHelper;
import cn.qiyu.magicalcrue_patient.utils.ListViewUtility;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.utils.Utils;
import cn.qiyu.magicalcrue_patient.view.LLImageView;
import cn.qiyu.magicalcrue_patient.view.LLTextView;
import cn.qiyu.magicalcrue_patient.view.LLTextViewNew;
import cn.qiyu.magicalcrue_patient.view.ListViewForScrollView;
import cn.qiyu.magicalcrue_patient.zxing.activity.CaptureActivity;
import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by Administrator on 2017/11/13.
 * 首页界面
 */

public class HomePageFragment extends Fragment implements View.OnClickListener, EasyPermissions.PermissionCallbacks {
    @Bind(R.id.tv_mydocter)
    TextView mTvMydocter;
    @Bind(R.id.tv_mydocter_team)
    TextView mTvMydocterTeam;
    @Bind({R.id.iv_doctor_icon_one,R.id.iv_doctor_icon_two,R.id.iv_doctor_icon_three,R.id.iv_doctor_icon_four,R.id.iv_doctor_icon_five})
    CircleImageView[] civ;

    //打开扫描界面请求码
    private int REQUEST_CODE = 0x01;
    //扫描成功返回码
    private int RESULT_OK = 0xA1;
    private ListView mLv_sv;
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
    private int[] ADVERTISING = {R.drawable.banner, R.drawable.banner};
    private ImageView mIv_richsan;
    private String mDoctorUuid;
    private String mPatientuuid;
    private String mErrorCode;
    private ScrollView sv_home;
    private RelativeLayout mRlDoctorTeam;
    private List<DoctorTeamListBean> mDoctorTeamList;
    private List<DoctorTeamListBean> mQyjDoctorList;
    private LinearLayout mLlUnbindDoctor;
    private LinearLayout mLlBindDoctor;
    private ImageView mIvUnbindDoctor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        //注册EventBus，在开始的位置
        EventBus.getDefault().register(this);
//        LLImageView viewById = (LLImageView) view.findViewById(R.id.iv_doctor_icon);
        //为绑定显示二维码
        mLlUnbindDoctor = (LinearLayout) view.findViewById(R.id.ll_unbind_doctor);
        //绑定显示医生
        mLlBindDoctor = (LinearLayout) view.findViewById(R.id.ll_bind_doctor);
        mIvUnbindDoctor = (ImageView) view.findViewById(R.id.iv_unbind_doctor);
//        mIvUnbindDoctor.setOnClickListener(this);


        mTv_doctor_name = (TextView) view.findViewById(R.id.tv_mydocter);
        //医生工作组
        mRlDoctorTeam = (RelativeLayout) view.findViewById(R.id.rl_doctor_team_home);
        LLTextView llTvVisit = (LLTextView) view.findViewById(R.id.ll_tv_visit);//加入随访
        LLTextView llTvInquiry = (LLTextView) view.findViewById(R.id.ll_inquiry);//在线问诊
        LLTextView llTvReport = (LLTextView) view.findViewById(R.id.ll_tv_report);//随访报告
        LLTextView llTvRecord = (LLTextView) view.findViewById(R.id.ll_tv_record);//病情记录

        LLTextViewNew llTvDiaglog = (LLTextViewNew) view.findViewById(R.id.ll_tv_diaglogue);//新对话
        LLTextViewNew llTvScale = (LLTextViewNew) view.findViewById(R.id.ll_tv_scale);//新量表
        LLTextViewNew llTvNewReport = (LLTextViewNew) view.findViewById(R.id.ll_tv_new_report);//新随访报告
        LLTextViewNew llTvCourse = (LLTextViewNew) view.findViewById(R.id.ll_tv_course);//患教课程
        //第一版不需要
//        LLTextViewNew llTvUnscramble = (LLTextViewNew) view.findViewById(R.id.ll_tv_unscramble);//待付款
        mIv_richsan = (ImageView) view.findViewById(R.id.richscan);
        //二维码扫描
        mIv_richsan.setOnClickListener(this);
        //患教课程
        mTvCourse = (TextView) view.findViewById(R.id.ll_tv_course_new);
        //医疗机构
        mTvMedical = (TextView) view.findViewById(R.id.ll_tv_medical);
        //线下沙龙
        mTvOffline = (TextView) view.findViewById(R.id.ll_tv_offline);
        //全部服务
        mTvAllserve = (TextView) view.findViewById(R.id.ll_tv_all_serve);

        sv_home = (ScrollView) view.findViewById(R.id.sv_home);
        mRlDoctorTeam.setOnClickListener(this);
        llTvDiaglog.setOnClickListener(this);
        llTvScale.setOnClickListener(this);
        llTvNewReport.setOnClickListener(this);
        llTvCourse.setOnClickListener(this);
//        llTvUnscramble.setOnClickListener(this);



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
//        mTv_unScra = (TextView) llTvUnscramble.findViewById(R.id.tv_top_left);

        //banner图listView加载
        mLv_sv = (ListView) view.findViewById(R.id.lv_home_image);

        //通过本地获取患者uuid


        mHomePresenter.getDoctorTeamInfo();
        mHomePresenter.getHomeBanner();
        mHomePresenter.HomeLoadNumData();
        ButterKnife.bind(this, view);

//        Intent intent = getActivity().getIntent();
//        int type = intent.getIntExtra("type", 0);
//        if (type==4) {
//            MainActivity activity = (MainActivity) getActivity();
//            activity.changFragment("消息");
//        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sv_home.scrollTo(0,0);
        sv_home.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        sv_home.setFocusable(true);
        sv_home.setFocusableInTouchMode(true);
//        sv_home.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                v.requestFocusFromTouch();
//                return false;
//            }
//        });


//        mIv_richsan.setFocusableInTouchMode(true);
//        mIv_richsan.requestFocus();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //注册过的界面必须反注册，可能内存泄漏
        EventBus.getDefault().unregister(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        mHomePresenter.getDoctorTeamInfo();
        mHomePresenter.getHomeBanner();
        mHomePresenter.HomeLoadNumData();
//        if (!TextUtils.isEmpty(mErrorCode)) {
//
//        if (mErrorCode.equals("1001")) {
//
//        } else if (mErrorCode.equals("1002")) {
//
//        } else {
//            mLlBindDoctor.setVisibility(View.VISIBLE);
//            mLlUnbindDoctor.setVisibility(View.GONE);
//            mIv_richsan.setVisibility(View.INVISIBLE);
//        }
//        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String event) {
        //已经好了，你发的什么，这里接收的就是什么，类型要一致
        String doctorUuidUrl = event;
        if (doctorUuidUrl.length() > 2) {
            String[] split = doctorUuidUrl.split("=");
            if (split == null || split.length < 1) {
                return;
            }
            if (doctorUuidUrl.contains("http://www.mircalcure.com/index.html?doctor")) {
                mDoctorUuid = split[1].trim();
                //将医生uuid保存
                PreUtils.setParam(getActivity(), "doctorUuid", mDoctorUuid);
                Log.i("doctorUuid=======", mDoctorUuid);
                mHomePresenter.getDoctorQRcode();
                Toast.makeText(getActivity(), "医生随访二维码，等待医生审核", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "非医生随访二维码", Toast.LENGTH_SHORT).show();
            }
        } else {
            mHomePresenter.HomeLoadNumData();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //新对话
            case R.id.ll_tv_diaglogue:
//                MainActivity activity = (MainActivity) getActivity();
//                activity.changFragment("消息");
                startActivity(new Intent(getActivity(), FollowUpMessageDetailActivity.class));
                break;
            //新的量表
            case R.id.ll_tv_scale:
                startActivity(new Intent(getActivity(), MyScaleActivity.class));
                break;
            //新的随访报告
            case R.id.ll_tv_new_report:
                getActivity().startActivityForResult(new Intent(getActivity(), NewFollowupReportActivity.class), 0000);
                break;
            //患教课程
            case R.id.ll_tv_course:
                getActivity().startActivityForResult(new Intent(getActivity(), NewCourseActivity.class), 1111);
                break;
            //待付款
            case R.id.ll_tv_unscramble:
                break;
            //患教课程
            case R.id.ll_tv_course_new:
                getActivity().startActivityForResult(new Intent(getActivity(), CourseActivity.class), 1111);
                break;
            //医疗机构
            case R.id.ll_tv_medical:
                getActivity().startActivityForResult(new Intent(getActivity(), MedicalActivity.class), 2222);
                break;
            //线下沙龙
            case R.id.ll_tv_offline:
                getActivity().startActivityForResult(new Intent(getActivity(), OffLineActivity.class), 3333);
                break;
            //全部服务
            case R.id.ll_tv_all_serve:
                getActivity().startActivityForResult(new Intent(getActivity(), AllServeActivity.class), 4444);
                break;
            case R.id.richscan:
                initPermission();
                break;
            //跳转医生工作组列表界面
            case R.id.rl_doctor_team_home:
                Intent intent = new Intent(getActivity(), DoctorListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) mDoctorTeamList);
                bundle.putSerializable("listQyj", (Serializable) mQyjDoctorList);
                intent.putExtras(bundle);
                startActivity(intent);
                break;

        }

    }

    HomePresenter mHomePresenter = new HomePresenter(new HomeNumView() {
        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
//            //通过这mErrorCode来判断是否绑定医生
            mErrorCode = model.getErrorCode();
            Log.i("MerrorCode=-=-=-", mErrorCode);
            if (mErrorCode.equals("1001")) {
                mLlUnbindDoctor.setVisibility(View.VISIBLE);
                mLlBindDoctor.setVisibility(View.GONE);
                mIv_richsan.setVisibility(View.VISIBLE);
                mIvUnbindDoctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        initPermission();
                    }
                });

            } else if (mErrorCode.equals("1002")) {
                mLlUnbindDoctor.setVisibility(View.VISIBLE);
                mLlBindDoctor.setVisibility(View.GONE);
                mIv_richsan.setVisibility(View.VISIBLE);

                mIvUnbindDoctor.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getActivity(), "您已经加入随访\n请等待你的主诊医生审核\n审核通过后正常使用", Toast.LENGTH_LONG).show();
                    }
                });

            } else {
                mLlBindDoctor.setVisibility(View.VISIBLE);
                mLlUnbindDoctor.setVisibility(View.GONE);
                mIv_richsan.setVisibility(View.INVISIBLE);
            }


//
//            Toast.makeText(getActivity(), "ccccode"+ model.getErrorCode(), Toast.LENGTH_SHORT).show();
            //通过EventBus传值到VisitFragment中
            //现在需要将 model.getErrorCode() 传到VisitFragment
//            Toast.makeText(getActivity(), "ErrorCode==="+model.getErrorCode(), Toast.LENGTH_SHORT).show();
//            EventBus.getDefault().post(mErrorCode);
//            MainActivity activity = (MainActivity) getActivity();
//            activity.changFragment("我的");
//            Toast.makeText(getActivity(), "失败11", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
//            Toast.makeText(getActivity(), "失败-=-=-", Toast.LENGTH_SHORT).show();

        }
        @Override
        public String getUserId() {
            Log.i("userUuid", (String) PreUtils.getParam(getActivity(), "uuid", "0"));
//                return "5d9976d752c541c5a4608bc2758c54d7";
            //用户uuid
            return (String) PreUtils.getParam(getActivity(),"uuid","0");

        }

        @Override
        public void LoadDate(ResultModel<HomeNumBean> numBean) {
//                Toast.makeText(getActivity(), ""+numBean.getMessage(), Toast.LENGTH_SHORT).show();
            if (numBean.getData() != null) {
                mTv_topleft_visit.setText(String.valueOf(numBean.getData().getFollowDay()));

                mTv_topleft_inquiry.setText(String.valueOf(numBean.getData().getConstructionCount()));
                mTv_topleft_report.setText(String.valueOf(numBean.getData().getFollowUpCount()));
                mTv_topleft_record.setText(String.valueOf(numBean.getData().getStatusRecord()));
//                Log.i("duihua==", numBean.getData().getConstructionCount() + "");
//                Log.i("duihua1==", numBean.getData().getFollowUpCount() + "");
//                Log.i("duihua2==", numBean.getData().getStatusRecord() + "");

                mTv_diaglog.setText(String.valueOf(numBean.getData().getNewDialogueCount()));
//                Log.i("duihua3==", numBean.getData().getNewDialogueCount() + "");

                mTv_scale.setText(String.valueOf(numBean.getData().getNwePaperCount()));
//                Log.i("duihua4===", numBean.getData().getNwePaperCount() + "");

                mTv_newReport.setText(String.valueOf(numBean.getData().getNewFollowUpCount()));

                    mTv_course.setText(String.valueOf(numBean.getData().getCourseCount()));
//                mTv_unScra.setText(String.valueOf(numBean.getData().getPendingPaymentCount()));
//                    mTv_doctor_name.setText(numBean.getData().get);

            } else {
//                Toast.makeText(getActivity(), "1111", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public String patientUuid() {
//            Log.i("patientuuid------", (String) PreUtils.getParam(getActivity(), "patientuuid", "0"));
            return (String) PreUtils.getParam(getActivity(), "patientuuid", "0");
//            return "29bbe608070b4fd5aadda5999d46f9d7";
        }

        @Override
        public String DoctorUuid() {

            //医生uuid
            return mDoctorUuid;
        }

        @Override
        public void getDoctorQRcode(ResultModel model) {
            Toast.makeText(getActivity(), "" + model.getErrorCode(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void LoadDoctorTeamInfor(ResultModel<DoctorTeamBean> model) {

//            model.getErrorCode();
            String DcotorName = model.getData().getDoctor_name();
            String TeamName = model.getData().getTeam_name();
            mDoctorTeamList = model.getData().getDoctorTeamList();
            mQyjDoctorList = model.getData().getQyjDoctorList();
            //医生名字与团队
            mTvMydocter.setText(DcotorName);
            mTvMydocterTeam.setText(TeamName);
            //头像图片的显示
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
                if (null == model.getData().getDoctorTeamList().get(i).getPhotoPathImg())
                    path = "";
                else path =  model.getData().getDoctorTeamList().get(i).getPhotoPathImg();
                DisplayHelper.loadGlide(getActivity(), path, civ[i]);
            }
            }
        //获取Banner
        @Override
        public String getType() {
            return "patientHomeBanner";
        }

        @Override
        public void LoadHomeBanner(ResultModel<List<HomeBannerBean>> model) {

            mLv_sv.setAdapter((new AppAdapter(getActivity(), model.getData())));
            ListViewUtility.setListViewHeightBasedOnChildren(mLv_sv);

        }
    });


    /**
     * 初始化权限事件
     */
    private void initPermission() {
        //检查权限
        String[] permissions = Utils.checkPermission(getActivity());
        if (permissions.length == 0) {
            //权限都申请了,是否登录
            startActivity(new Intent(getActivity(), CaptureActivity.class));
        } else {
            //申请权限
            ActivityCompat.requestPermissions(getActivity(), permissions, 100);
        }
    }

    public static final int REQUEST_CAMERA_PERM = 101;

    /**
     * EsayPermissions接管权限处理逻辑
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
//        Toast.makeText(getActivity(), "执行onPermissionsGranted()...", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        Toast.makeText(getActivity(), "执行onPermissionsDenied()...", Toast.LENGTH_SHORT).show();
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this, "当前App需要申请camera权限,需要打开设置页面么?")
                    .setTitle("权限申请")
                    .setPositiveButton("确认")
                    .setNegativeButton("取消", null /* click listener */)
                    .setRequestCode(REQUEST_CAMERA_PERM)
                    .build()
                    .show();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    /**
     *
     * @param isVisibleToUser
     * 切换fragment时，状态
     */
//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            if (homePresenter!=null) {
//                homePresenter.HomeLoadNumData();
//                homePresenter.getDoctorTeamInfo();
//            }
//        }
//    }
}
