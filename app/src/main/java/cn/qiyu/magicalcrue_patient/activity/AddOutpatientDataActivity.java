package cn.qiyu.magicalcrue_patient.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lidong.photopicker.ImageConfig;
import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.PhotoPreviewActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.intent.PhotoPreviewIntent;

import org.json.JSONArray;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.addapp.pickers.picker.DatePicker;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.constant.GlobalConstants;
import cn.qiyu.magicalcrue_patient.image.ImageUpLoadPresenter;
import cn.qiyu.magicalcrue_patient.image.ImageUpLoadView;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.view.LayoutAddOutpatientView;
import cn.qiyu.magicalcrue_patient.visit.OutPatientAddPresenter;
import cn.qiyu.magicalcrue_patient.visit.OutPatientAddView;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryPresenter;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ShiLei on 2017/12/18.
 * 添加门诊资料信息
 */

public class AddOutpatientDataActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;
    @Bind(R.id.lav_time)
    LayoutAddOutpatientView mLavTime;
    @Bind(R.id.lav_hospital)
    LayoutAddOutpatientView mLavHospital;
    @Bind(R.id.lav_departments)
    LayoutAddOutpatientView mLavDepartments;
    @Bind(R.id.et_doctor_name)
    EditText mEtDoctorName;
    @Bind(R.id.rl_doctor_name)
    RelativeLayout mRlDoctorName;
    @Bind(R.id.iv_quiz_pic)
    ImageView mIvQuizPic;
    @Bind(R.id.rl_camera)
    RelativeLayout mRlCamera;
    @Bind(R.id.gridView)
    GridView mGridView;
    @Bind(R.id.id_editor_detail)
    EditText mIdEditorDetail;
    @Bind(R.id.id_editor_detail_font_count)
    TextView mIdEditorDetailFontCount;

    private TextView mTvFirstTime;
    private TextView mTvHospital;
    private TextView mTvDepartments;
    private ImageConfig imgConfig;
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private ArrayList<String> mList;
    private GridAdapter mGridAdapter;
    private String mHospitalName;
    private String mOfficeName;
    private boolean islMaxCount;
    private String mHospitalId;
    private String mOfficeId;
    private RequestBody mRequestFile;
    private File mFileName;
    private StringBuffer mStringBuffer = new StringBuffer();
    private int requestImageIndex=0;
    private String mDoctorName;
    private Dialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_outpatient_data);
        ButterKnife.bind(this);
        init();

    }


    private void init() {
        mTvCommit.setVisibility(View.VISIBLE);
        mTvCommit.setText(R.string.save);
        mTvCommit.setTextColor(getResources().getColor(R.color.app_userInfor));
        mTvTitle.setText(R.string.addOutpatientData);
        //门诊时间
        mTvFirstTime = (TextView) mLavTime.findViewById(R.id.tv_first_visit_time);
        //医院
        mTvHospital = (TextView) mLavHospital.findViewById(R.id.tv_first_visit_time);
        //科室
        mTvDepartments = (TextView) mLavDepartments.findViewById(R.id.tv_first_visit_time);
        //添加Dialog
        mLoadingDialog = new Dialog(AddOutpatientDataActivity.this, R.style.progress_dialog);
        mLoadingDialog.setContentView(R.layout.progress_dialog);
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg = (TextView) mLoadingDialog.findViewById(R.id.id_tv_loadingmsg);
        msg.setText("上传中...");

        //图片
        imgConfig = new ImageConfig();
        imgConfig.minHeight = 1080;
        imgConfig.minWidth = 1920;
        imgConfig.mimeType = new String[]{"image/jpeg", "image/png"}; // 图片类型 image/gif ...
        imgConfig.minSize = 480 * 1024; // 图片大小
        int cols = getResources().getDisplayMetrics().widthPixels / getResources().getDisplayMetrics().densityDpi;
        cols = cols < 4 ? 4 : cols;
        mGridView.setNumColumns(cols);



        mIdEditorDetail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int detailLength = s.length();
                mIdEditorDetailFontCount.setText(detailLength + "/500字");
                if (detailLength == 499) {
                    islMaxCount = true;
                }
                if (detailLength == 500 && islMaxCount) {
                    Toast.makeText(AddOutpatientDataActivity.this, "最多输入500字", Toast.LENGTH_SHORT).show();
                    islMaxCount = false;
                }
            }
        });

    }
    ImageUpLoadPresenter mImageUpLoadPresenter = new ImageUpLoadPresenter(new ImageUpLoadView() {
        @Override
        public RequestBody getImageUpLoadFileId() {
            mRequestFile = RequestBody.create(MediaType.parse("image/png"), mFileName);
            return mRequestFile;
        }



        @Override
        public void getImageUpLoad(ImageUpLoadBean imageUpLoadBean) {
            requestImageIndex=requestImageIndex+1;
            mStringBuffer.append(imageUpLoadBean.getData().getFileName() + ",");

            if(requestImageIndex==mList.size()-1){
                mOutPatientAddPresenter.getOutPatientSave();
            }
        }

        @Override
        public void showProgress() {
            mLoadingDialog.show();
        }

        @Override
        public void hideProgress() {
            mLoadingDialog.hide();

        }

        @Override
        public void onViewFailure(ImageUpLoadBean model) {
//            Toast.makeText(AddOutpatientDataActivity.this, "SHANG", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServerFailure(String e) {
//            Toast.makeText(AddOutpatientDataActivity.this, ""+e, Toast.LENGTH_SHORT).show();

        }
    });



     //上传门诊信息
    OutPatientAddPresenter mOutPatientAddPresenter = new OutPatientAddPresenter(new OutPatientAddView() {
        @Override
        public String getParentUuid() {
            return (String) PreUtils.getParam(AddOutpatientDataActivity.this, GlobalConstants.PATIENT_UUID,"0");
        }

        @Override
        public String getDiagnosisDate() {
            return mTvFirstTime.getText().toString();
        }

        @Override
        public String getHospitalId() {
            Log.i("hospitalId==", mHospitalId);
            return mHospitalId;
        }

        @Override
        public String getOfficeId() {
            Log.i("officeId==",mOfficeId);
            return mOfficeId;
        }

        @Override
        public String getDoctorName() {
            return mEtDoctorName.getText().toString();
        }

        @Override
        public String getSummary() {
            return mIdEditorDetail.getText().toString();
        }

        @Override
        public String getImageList() {
            Log.i("mStringBuffer===", mStringBuffer.toString());
            return  null==mStringBuffer.toString()? null:mStringBuffer.toString();
        }

        @Override
        public void LoadOutPatientSave(ResultModel<AddOutPatientDataSaveBean> model) {
            Log.i("222==========", "jinglai");
            Toast.makeText(AddOutpatientDataActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            finish();
        }

         @Override
         public void LoadOutPatientSaveText(ResultModel<AddOutPatientDataSaveBean> model) {
             Log.i("1111111111111111111==", "meijin");
             Toast.makeText(AddOutpatientDataActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
             finish();
         }

         @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(AddOutpatientDataActivity.this, "门诊错误", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(AddOutpatientDataActivity.this, "门诊获取失败", Toast.LENGTH_SHORT).show();
        }
    });

    @OnClick(R.id.tv_commit)
    public void onViewClicked() {
        if (TextUtils.isEmpty(mTvFirstTime.getText().toString())||TextUtils.isEmpty(mHospitalName)||TextUtils.isEmpty(mOfficeName)||TextUtils.isEmpty(mEtDoctorName.getText().toString())) {
            Toast.makeText(AddOutpatientDataActivity.this, "有选项没有填写完整", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mList != null && mList.size() > 0) {
            for (int i = 0; i < mList.size()-1; i++) {
                mFileName = new File(mList.get(i));
                mImageUpLoadPresenter.getImage();
            }
        } else {
            mOutPatientAddPresenter.getOutPatientSaveText();
        }

    }

    @OnClick({R.id.lav_time, R.id.lav_hospital, R.id.lav_departments, R.id.rl_doctor_name, R.id.iv_quiz_pic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lav_time:
                //门诊时间
                tvSelectDate(mTvFirstTime);
                break;
            case R.id.lav_hospital:
                Intent intentHos = new Intent(AddOutpatientDataActivity.this, HospitalListActivity.class);
                intentHos.putExtra("isHospital", "0");
                startActivityForResult(intentHos, 0x000);
                break;
            case R.id.lav_departments:
                Intent intentDep = new Intent(AddOutpatientDataActivity.this, HospitalListActivity.class);
                intentDep.putExtra("isHospital", "1");
                startActivityForResult(intentDep, 0x001);
                break;
            case R.id.rl_doctor_name:

                break;
            case R.id.iv_quiz_pic:
                mRlCamera.setVisibility(View.GONE);
                mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String imgs = (String) parent.getItemAtPosition(position);
                        if ("000000".equals(imgs)) {

                            PhotoPickerIntent intent = new PhotoPickerIntent(AddOutpatientDataActivity.this);
                            intent.setSelectModel(SelectModel.MULTI);
                            intent.setShowCarema(true); // 是否显示拍照
                            intent.setMaxTotal(8); // 最多选择照片数量，默认为6
                            intent.setImageConfig(imgConfig);
                            intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                            startActivityForResult(intent, REQUEST_CAMERA_CODE);
                        } else {
                            PhotoPreviewIntent intent = new PhotoPreviewIntent(AddOutpatientDataActivity.this);
                            intent.setCurrentItem(position);
                            intent.setPhotoPaths(imagePaths);
                            startActivityForResult(intent, REQUEST_PREVIEW_CODE);
                        }
                    }
                });
                imagePaths.add("000000");
                mGridAdapter = new GridAdapter(imagePaths);
                mGridView.setAdapter(mGridAdapter);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                // 选择照片
                case REQUEST_CAMERA_CODE:
                    mList = data.getStringArrayListExtra(PhotoPickerActivity.EXTRA_RESULT);
                    loadAdpater(mList);
                    break;
                // 预览
                case REQUEST_PREVIEW_CODE:
                    ArrayList<String> ListExtra = data.getStringArrayListExtra(PhotoPreviewActivity.EXTRA_RESULT);
//                    Log.d(TAG, "ListExtra: " + "ListExtra = [" + ListExtra.size());
                    loadAdpater(ListExtra);
                    break;
                case 0x000:
                    //医院列表
                    mHospitalName = data.getStringExtra("HospitalName");
                    mHospitalId = data.getStringExtra("HospitalId");

                    mTvHospital.setText(mHospitalName);
                    break;
                case 0x001:
                    //科室列表
                    mOfficeName = data.getStringExtra("OfficeName");
                    mOfficeId = data.getStringExtra("OfficeId");
                    mTvDepartments.setText(mOfficeName);
                    break;
            }
        }
    }


    private void loadAdpater(ArrayList<String> paths) {
        if (imagePaths != null && imagePaths.size() > 0) {
            imagePaths.clear();
        }
        if (paths.contains("000000")) {
            paths.remove("000000");
        }
        paths.add("000000");
        imagePaths.addAll(paths);
        mGridAdapter = new GridAdapter(imagePaths);
        mGridView.setAdapter(mGridAdapter);
        try {
            JSONArray obj = new JSONArray(imagePaths);
            Log.e("--", obj.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class GridAdapter extends BaseAdapter {
        private ArrayList<String> listUrls;
        private LayoutInflater inflater;

        public GridAdapter(ArrayList<String> listUrls) {
            this.listUrls = listUrls;
            if (listUrls.size() == 9) {
                listUrls.remove(listUrls.size() - 1);
            }
            inflater = LayoutInflater.from(AddOutpatientDataActivity.this);
        }

        public int getCount() {
            return listUrls.size();
        }

        @Override
        public String getItem(int position) {
            return listUrls.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = inflater.inflate(R.layout.item_image, parent, false);
                holder.image = (ImageView) convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            final String path = listUrls.get(position);
            if (path.equals("000000")) {
                holder.image.setImageResource(R.drawable.add);
            } else {
                Glide.with(AddOutpatientDataActivity.this)
                        .load(path)
                        .placeholder(R.mipmap.default_error)
                        .error(R.mipmap.default_error)
                        .centerCrop()
                        .crossFade()
                        .into(holder.image);
            }
            return convertView;
        }

        class ViewHolder {
            ImageView image;
        }
    }


    //日期的选择
    private void tvSelectDate(final TextView tv) {
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

                tv.setText(year + "-" + month + "-" + day);
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

}
