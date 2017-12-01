package cn.qiyu.magicalcrue_patient.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ScrollingView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.Api.ApiService;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.activity.AllServeActivity;
import cn.qiyu.magicalcrue_patient.activity.CourseActivity;
import cn.qiyu.magicalcrue_patient.activity.MainActivity;
import cn.qiyu.magicalcrue_patient.activity.MedicalActivity;
import cn.qiyu.magicalcrue_patient.activity.OffLineActivity;
import cn.qiyu.magicalcrue_patient.adapter.AppAdapter;
import cn.qiyu.magicalcrue_patient.home.HomeNumView;
import cn.qiyu.magicalcrue_patient.home.HomePresenter;
import cn.qiyu.magicalcrue_patient.model.DoctorTeamBean;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        //注册EventBus，在开始的位置 ok
        EventBus.getDefault().register(this);
//        LLImageView viewById = (LLImageView) view.findViewById(R.id.iv_doctor_icon);
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

        //banner图listView加载
        mLv_sv = (ListView) view.findViewById(R.id.lv_home_image);
        mLv_sv.setAdapter((new AppAdapter(view.getContext(), ADVERTISING)));
        ListViewUtility.setListViewHeightBasedOnChildren(mLv_sv);
        //通过本地获取患者uuid

        homePresenter.HomeLoadNumData();
      homePresenter.getDoctorTeamInfo();

        ButterKnife.bind(this, view);
        //这里设置fragment 点击事件就是我给你发的Demo

        Log.i("patientuuid---", (String) PreUtils.getParam(getActivity(), "patientuuid", "0"));

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //注册过的界面必须反注册，可能内存泄漏
        EventBus.getDefault().unregister(this);

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String event) {
        //已经好了，你发的什么，这里接收的就是什么，类型要一致
        String doctorUuidUrl = event;
        String[] split = doctorUuidUrl.split("=");
        if (split == null || split.length < 1) {
            return;
        }
        if (doctorUuidUrl.contains("http://www.mircalcure.com/index.html?doctor")) {
            mDoctorUuid = split[1].trim();
            homePresenter.getDoctorQRcode();
            Toast.makeText(getActivity(), "医生随访二维码，等待医生审核", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "非医生随访二维码", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_tv_course_new:
                getActivity().startActivityForResult(new Intent(getActivity(), CourseActivity.class), 1111);
                break;
            case R.id.ll_tv_medical:
                getActivity().startActivityForResult(new Intent(getActivity(), MedicalActivity.class), 2222);
                break;
            case R.id.ll_tv_offline:
                getActivity().startActivityForResult(new Intent(getActivity(), OffLineActivity.class), 3333);
                break;
            case R.id.ll_tv_all_serve:
                getActivity().startActivityForResult(new Intent(getActivity(), AllServeActivity.class), 4444);
                break;
            case R.id.richscan:
                initPermission();
                break;
        }

    }

    HomePresenter homePresenter = new HomePresenter(new HomeNumView() {
        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
//            //通过这mErrorCode来判断是否绑定医生
//            mErrorCode = model.getErrorCode();
//
//            Toast.makeText(getActivity(), "ccccode"+ model.getErrorCode(), Toast.LENGTH_SHORT).show();
            //通过EventBus传值到VisitFragment中
            //现在需要将 model.getErrorCode() 传到VisitFragment
//            Toast.makeText(getActivity(), "ErrorCode==="+model.getErrorCode(), Toast.LENGTH_SHORT).show();
//            EventBus.getDefault().post(mErrorCode);
//            MainActivity activity = (MainActivity) getActivity();
//            activity.changFragment("我的");
        }

        @Override
        public void onServerFailure(String e) {

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
        public String patientUuid() {
            Log.i("patientuuid------", (String) PreUtils.getParam(getActivity(), "patientuuid", "0"));
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
//            Toast.makeText(getActivity(), "" + model.getErrorCode(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void LoadDoctorTeamInfor(ResultModel<DoctorTeamBean> model) {

//            model.getErrorCode();
            String DcotorName = model.getData().getDoctor_name();
            String TeamName = model.getData().getTeam_name();
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
                if (null == model.getData().getDoctorTeamList().get(i).getPhoto_path())
                    path = "";
                else path = ApiService.GET_IMAGE_ICON + model.getData().getDoctorTeamList().get(i).getPhoto_path();
                DisplayHelper.loadGlide(getActivity(), path, civ[i]);
            }
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
}
