package cn.qiyu.magicalcrue_patient.activity;

import android.Manifest;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.entity.City;
import cn.addapp.pickers.entity.County;
import cn.addapp.pickers.entity.Province;
import cn.addapp.pickers.picker.DatePicker;
import cn.qiyu.magicalcrue_patient.BuildConfig;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.image.ImageUpLoadPresenter;
import cn.qiyu.magicalcrue_patient.image.ImageUpLoadView;
import cn.qiyu.magicalcrue_patient.model.CityBean;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.userinfor.UserInforEdtPresenter;
import cn.qiyu.magicalcrue_patient.userinfor.UserInforEdtView;
import cn.qiyu.magicalcrue_patient.utils.Utils;
import cn.qiyu.magicalcrue_patient.view.SelectPicPopupWindow;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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
    public static final String PHOTO_PATH = "photo_path";
    private String mId;
    private FileOutputStream mFileOutputStream;
    private File mFileName;
    private String mAbsolutePath;
    private Uri uritempFile;
    private final int REQUEST_SELECT_PHOTO = 0;
    private final int CAMERA = 200;
    private RequestBody mRequestFile;
    private String mFilePath;
    private String mAddresscode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_infor);
        ButterKnife.bind(this);

        init();
        mPicPopupWindow = new SelectPicPopupWindow(UserInforActivity.this, this);
    }

    private void init() {
        uritempFile = Uri.parse("file://" + "/" + Environment.getExternalStorageDirectory().getPath() + "/" + "small.jpg");
        mTvSelectCitiy.setText(getIntent().getStringExtra("addressname"));
        mId = getIntent().getStringExtra("id");

        mIvGirl.setTag(0);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    //图片上传服务器
    ImageUpLoadPresenter mImageUpLoadPresenter = new ImageUpLoadPresenter(new ImageUpLoadView() {
        @Override
        public RequestBody getImageUpLoadFile() {
            if (mRequestFile!=null) {
                mRequestFile = RequestBody.create(MediaType.parse("multipart/form-data"), mFileName);
            }
            return mRequestFile;
        }


        @Override
        public void getImageUpLoad(ImageUpLoadBean imageUpLoadBean) {
           mFilePath = imageUpLoadBean.getFilePath();
            mUserInforEdtPresenter.getUserInforEdt();
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ImageUpLoadBean model) {

        }

        @Override
        public void onServerFailure(String e) {

        }
    });

    //数据保存
    UserInforEdtPresenter mUserInforEdtPresenter = new UserInforEdtPresenter(new UserInforEdtView() {
        @Override
        public String getUuId() {
            return mId;
        }

        @Override
        public String getPhotoPath() {
            return mFilePath;
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
            return mAddresscode;
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

                if ( TextUtils.isEmpty(mFilePath)||TextUtils.isEmpty(mTvRealName.getText().toString())
                        || TextUtils.isEmpty(mTvSelectDate.getText().toString())
                         ||TextUtils.isEmpty(mAddresscode)   ) {
                    Toast.makeText(this, "信息填写不完整", Toast.LENGTH_SHORT).show();


                } else {
                    mImageUpLoadPresenter.getImage();
                }



                break;
            case R.id.iv_head_arrows:
                break;
            case R.id.iv_name_arrows:
                break;
            case R.id.tv_select_citiy:
                startActivityForResult(new Intent(UserInforActivity.this, SeclectCityActivity.class), 0x001);
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

            File filePath = new File(Environment.getExternalStorageDirectory(), "myCamera");
            if (!filePath.exists()) {
                filePath.mkdirs();
                Log.e("isExists", "=" + filePath.mkdirs());
            }
            mFileName = new File(filePath, System.currentTimeMillis() + ".jpg");
            try {
                if (!mFileName.exists()) {
                    mFileName.createNewFile();
                    mAbsolutePath = mFileName.getAbsolutePath();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Uri uriForFile = FileProvider.getUriForFile(UserInforActivity.this, "cn.qiyu.magicalcrue_patient.fileprovider", mFileName);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uriForFile);
            } else {
                // 将系统Camera的拍摄结果写入到文件
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(mFileName));
            }
            // 启动intent对应的Activity，返回默认消息
            startActivityForResult(intent, CAMERA);
        } else {
            //申请权限
            ActivityCompat.requestPermissions(this, permissions, 100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == 0x001) {
                if (data != null) {
                    String addressname = data.getStringExtra("addressname");
                    mAddresscode = data.getStringExtra("addresscode");
                    mTvSelectCitiy.setText(addressname);
                    Toast.makeText(this, addressname, Toast.LENGTH_SHORT).show();
                }
            } else if (requestCode == CAMERA) { //拍照
                //照相返回的
                Bitmap bitmap = Utils.getLoacalBitmap(mAbsolutePath);
                mCivHead.setImageBitmap(bitmap);
            } else if (requestCode == REQUEST_SELECT_PHOTO) {
                //相册返回的
                // 外界的程序访问ContentProvider所提供数据 可以通过ContentResolver接口
                ContentResolver resolver = getContentResolver();
                Uri originalUri = data.getData(); // 获得图片的uri

                //以下是将相册uri转成file
                String[] proj = { MediaStore.Images.Media.DATA };
                Cursor actualimagecursor = managedQuery(originalUri,proj,null,null,null);
                int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                actualimagecursor.moveToFirst();
                String img_path = actualimagecursor.getString(actual_image_column_index);
                mFileName = new File(img_path);
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                    mCivHead.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (requestCode == REQUEST_CAMERA_PERM) {
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
                String[] permissions = Utils.checkPermission(this);
                if (permissions.length == 0) {
                    //手机相册调用
                    Intent intentFromGallery = new Intent();
                    // 设置文件类型
                    intentFromGallery.setType("image/*");
                    intentFromGallery.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(intentFromGallery, REQUEST_SELECT_PHOTO);
                }else {
                    //申请权限
                    ActivityCompat.requestPermissions(this, permissions, 100);
                }
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
