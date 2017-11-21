package cn.qiyu.magicalcrue_patient.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import cn.addapp.pickers.picker.DatePicker;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.userinfor.UserInforEdtPresenter;
import cn.qiyu.magicalcrue_patient.userinfor.UserInforEdtView;
import cn.qiyu.magicalcrue_patient.utils.Utils;
import cn.qiyu.magicalcrue_patient.view.SelectPicPopupWindow;
import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 用户信息界面
 */
public class UserInforActivity extends FragmentActivity implements View.OnClickListener, EasyPermissions.PermissionCallbacks {

    @Bind(R.id.iv_userinfor_back)
    ImageView mIvUserinforBack;
    @Bind(R.id.tv_save_userinfor)
    TextView mTvSaveUserinfor;
    @Bind(R.id.iv_head_arrows)
    ImageView mIvHeadArrows;
    @Bind(R.id.tv_name)
    TextView mTvName;
    @Bind(R.id.tv_real_name)
    TextView mTvRealName;
    @Bind(R.id.iv_name_arrows)
    ImageView mIvNameArrows;
    @Bind(R.id.tv_citiy)
    TextView mTvCitiy;
    @Bind(R.id.tv_select_citiy)
    TextView mTvSelectCitiy;
    @Bind(R.id.tv_gender)
    TextView mTvGender;
    @Bind(R.id.iv_girl)
    ImageView mIvGirl;
    @Bind(R.id.tv_girl_s)
    TextView mTvGirlS;
    @Bind(R.id.iv_boy)
    ImageView mIvBoy;
    @Bind(R.id.tv_Date)
    TextView mTvDate;
    @Bind(R.id.tv_select_Date)
    TextView mTvSelectDate;
    @Bind(R.id.civ_head)
    CircleImageView mCivHead;
    private SelectPicPopupWindow mPicPopupWindow;
    /**
     * 扫描跳转Activity RequestCode
     */
    public static final int REQUEST_CODE = 111;
    /**
     * 请求CAMERA权限码
     */
    public static final int REQUEST_CAMERA_PERM = 101;
    private String mId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infor);
        ButterKnife.bind(this);

        init();
        mPicPopupWindow = new SelectPicPopupWindow(UserInforActivity.this, this);
    }

    private void init() {
        mTvSelectCitiy.setText(getIntent().getStringExtra("addressname"));
        mId = getIntent().getStringExtra("id");
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
    UserInforEdtPresenter mUserInforEdtPresenter = new UserInforEdtPresenter(new UserInforEdtView() {
        @Override
        public String getUuId() {
//            Toast.makeText(UserInforActivity.this, getIntent().getStringExtra("id"), Toast.LENGTH_SHORT).show();

            return  mId;
        }

        @Override
        public String getPhotoPath() {
            return "12345678";
        }

        @Override
        public String getUser_name() {
            return mTvRealName.getText().toString();
        }

        @Override
        public String getBirthday() {
            return mTvSelectDate.getText().toString();
        }

        @Override
        public String getSex() {
            if (((Integer) (mIvGirl.getTag())) == 1) {
                return "1";
            }
            return "0";
        }
        @Override
        public String getNative_place_cd() {
            return getIntent().getStringExtra("addresscode");
        }

        @Override
        public void getUserInforEdt(ResultModel rlBean) {
            Intent intent = new Intent(UserInforActivity.this, PatientDataActivity.class);
            startActivity(intent);
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(UserInforActivity.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(UserInforActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    });

    @OnClick({R.id.iv_userinfor_back, R.id.tv_save_userinfor, R.id.iv_head_arrows, R.id.iv_name_arrows,
            R.id.tv_select_citiy, R.id.iv_girl, R.id.iv_boy, R.id.tv_select_Date, R.id.civ_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_userinfor_back:
                break;
            case R.id.tv_save_userinfor:
                mUserInforEdtPresenter.getUserInforEdt();


                break;
            case R.id.iv_head_arrows:
                break;
            case R.id.iv_name_arrows:
                break;
            case R.id.tv_select_citiy:
                startActivityForResult(new Intent(UserInforActivity.this,SeclectCityActivity.class),0x001);
                break;
            case R.id.iv_girl:
                mIvGirl.setTag(1);
                mIvBoy.setTag(0);
                mIvGirl.setImageResource(R.drawable.check_box_select);
                mIvBoy.setImageResource(R.drawable.check_box_normal);
                Toast.makeText(this, "" + ((Integer) (mIvGirl.getTag())), Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_boy:
                mIvBoy.setTag(1);
                mIvGirl.setTag(0);
                mIvBoy.setImageResource(R.drawable.check_box_select);
                mIvGirl.setImageResource(R.drawable.check_box_normal);
                Toast.makeText(this, "" + ((Integer) (mIvBoy.getTag())), Toast.LENGTH_SHORT).show();

                break;
            case R.id.tv_select_Date:
                tvSelectDate();
                break;
            case R.id.civ_head:
                View inflate = getLayoutInflater().inflate(R.layout.activity_user_infor, null);
                mPicPopupWindow.showAtLocation(inflate, Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
        }
    }




    //日期的选择
    private void tvSelectDate() {
        final DatePicker picker = new DatePicker(this);
        picker.setCanLoop(false);
        picker.setWheelModeEnable(true);
        picker.setTopPadding(15);
        picker.setRangeStart(1950, 1, 1);
        picker.setRangeEnd(2050, 1, 11);
        picker.setSelectedItem(2017, 10, 14);
        picker.setWeightEnable(true);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
//                        showToast(year + "-" + month + "-" + day);
                mTvSelectDate.setText(year + "-" + month + "-" + day);
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.show();
    }

    /**
     * 初始化相机权限事件
     */
    private void initPermission() {
        //检查权限
        String[] permissions = Utils.checkPermission(this);
        if (permissions.length == 0) {
            //权限都申请了
            //是否登录
            //调用相机
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        } else {
            //申请权限
            ActivityCompat.requestPermissions(this, permissions, 100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /**
         * 处理二维码扫描结果
         */
        if (resultCode == RESULT_OK){
            if (requestCode == 0x001){
                if (data!=null) {
                    String addressname = data.getStringExtra("addressname");
//                    String addresscode = data.getStringExtra("addresscode");
                    mTvSelectCitiy.setText(addressname);
                    Toast.makeText(this, addressname, Toast.LENGTH_SHORT).show();
                }

            }
        }
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
//                Bundle bundle = data.getExtras();
//                if (bundle == null) {
//                    return;
//                }
//                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
//                    String result = bundle.getString(CodeUtils.RESULT_STRING);
//                    Toast.makeText(this, "解析结果:" + result, Toast.LENGTH_LONG).show();
//                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
//                    Toast.makeText(UserInforActivity.this, "解析二维码失败", Toast.LENGTH_LONG).show();
//                }
            }
        } else if (requestCode == REQUEST_CAMERA_PERM) {
            Toast.makeText(this, "从设置页面返回...", Toast.LENGTH_SHORT)
                    .show();
        }


        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * EasyPermissions接管权限处理逻辑
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_photo:
                //相机调用
                initPermission();
                break;
            case R.id.tv_local_photo:
                //手机相册调用
                Intent intent1 = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
//        Toast.makeText(this, "执行onPermissionsGranted()...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
//        Toast.makeText(this, "执行onPermissionsDenied()...", Toast.LENGTH_SHORT).show();
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this, "当前需要申请相机与读写权限,需要打开设置页面么?")
                    .setTitle("权限申请")
                    .setPositiveButton("确认")
                    .setNegativeButton("取消", null /* click listener */)
                    .setRequestCode(REQUEST_CAMERA_PERM)
                    .build()
                    .show();
        }
    }
}
