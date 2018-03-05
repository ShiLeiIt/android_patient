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
import cn.qiyu.magicalcrue_patient.visit.PharmacyRecordAddView;
import cn.qiyu.magicalcrue_patient.visit.PharmacyRecordPresenter;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ShiLei on 2017/12/21.
 * 添加用药方案记录信息
 */

public class AddPharmacyRecordDataActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;
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
    @Bind(R.id.et_drug_name)
    EditText mEtDrugName;
    @Bind(R.id.rl_drug_name)
    RelativeLayout mRlDrugName;
    @Bind(R.id.lav_pharmacy_way)
    LayoutAddOutpatientView mLavPharmacyWay;
    @Bind(R.id.et_dosage_name)
    EditText mEtDosageName;

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
    private int requestImageIndex = 0;
    private String mWayName;
    private TextView mTvWayName;
    private Dialog mLoadingDialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pharmacy_recode_data);
        ButterKnife.bind(this);
        init();

    }


    private void init() {
        mTvCommit.setVisibility(View.VISIBLE);
        mTvCommit.setText(R.string.save);
        mTvCommit.setTextColor(getResources().getColor(R.color.app_userInfor));
        mTvTitle.setText(R.string.addPharmacyRecord);
        mTvWayName = (TextView) mLavPharmacyWay.findViewById(R.id.tv_first_visit_time);
        //添加Dialog
        mLoadingDialog = new Dialog(AddPharmacyRecordDataActivity.this, R.style.progress_dialog);
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
                    Toast.makeText(AddPharmacyRecordDataActivity.this, "最多输入500字", Toast.LENGTH_SHORT).show();
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
            requestImageIndex = requestImageIndex + 1;
            mStringBuffer.append(imageUpLoadBean.getData().getFileName() + ",");

            if (requestImageIndex == mList.size() - 1) {
                mPharmacyRecordPresenter.getPharmacyRecodeSave();
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

        }

        @Override
        public void onServerFailure(String e) {

        }
    });


    //上传用药方案记录
    PharmacyRecordPresenter mPharmacyRecordPresenter = new PharmacyRecordPresenter(new PharmacyRecordAddView() {
        @Override
        public String getParentUuid() {
            return (String)PreUtils.getParam(AddPharmacyRecordDataActivity.this, GlobalConstants.PATIENT_UUID,"0");
        }

        @Override
        public String getDrugName() {
            return mEtDrugName.getText().toString();
        }

        @Override
        public String getUsaged() {
            return mWayName;
        }

        @Override
        public String getAmount() {
            return mEtDosageName.getText().toString();
        }

        @Override
        public String getRemarks() {
            return mIdEditorDetail.getText().toString();
        }

        @Override
        public String getImageList() {
            return null==mStringBuffer.toString()? null:mStringBuffer.toString();
        }

        @Override
        public void LoadPharmacyRecordSave(ResultModel<AddOutPatientDataSaveBean> model) {
            Toast.makeText(AddPharmacyRecordDataActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
            finish();
        }

        @Override
        public void LoadPharmacyRecordSaveText(ResultModel<AddOutPatientDataSaveBean> model) {
            Toast.makeText(AddPharmacyRecordDataActivity.this, "添加成功", Toast.LENGTH_SHORT).show();
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

        }

        @Override
        public void onServerFailure(String e) {

        }
    });

    @OnClick(R.id.tv_commit)
    public void onViewClicked() {
        if (TextUtils.isEmpty(mEtDrugName.getText().toString())||TextUtils.isEmpty(mWayName)||TextUtils.isEmpty(mEtDosageName.getText().toString())) {
            Toast.makeText(AddPharmacyRecordDataActivity.this, "有选项没有填写完整", Toast.LENGTH_SHORT).show();
            return;
        }
        if (mList != null && mList.size() > 0) {
            for (int i = 0; i < mList.size() - 1; i++) {
                mFileName = new File(mList.get(i));
                mImageUpLoadPresenter.getImage();
            }
        } else {
            mPharmacyRecordPresenter.getPharmacyRecodeSaveText();
        }

    }

    @OnClick({R.id.lav_pharmacy_way,R.id.iv_quiz_pic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lav_pharmacy_way:
                //用药方式
                Intent intentHos = new Intent(AddPharmacyRecordDataActivity.this, PharmacyWayListActivity.class);
                intentHos.putExtra("isHospital", "0");
                startActivityForResult(intentHos, 0x000);
                break;
            case R.id.iv_quiz_pic:
                mRlCamera.setVisibility(View.GONE);
                mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String imgs = (String) parent.getItemAtPosition(position);
                        if ("000000".equals(imgs)) {

                            PhotoPickerIntent intent = new PhotoPickerIntent(AddPharmacyRecordDataActivity.this);
                            intent.setSelectModel(SelectModel.MULTI);
                            intent.setShowCarema(true); // 是否显示拍照
                            intent.setMaxTotal(8); // 最多选择照片数量，默认为6
                            intent.setImageConfig(imgConfig);
                            intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                            startActivityForResult(intent, REQUEST_CAMERA_CODE);
                        } else {
                            PhotoPreviewIntent intent = new PhotoPreviewIntent(AddPharmacyRecordDataActivity.this);
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
                    //用药方式列表
                    mWayName = data.getStringExtra("WayName");
                    mTvWayName.setText(mWayName);
                    break;
                case 0x001:
//                    //科室列表
//                    mOfficeName = data.getStringExtra("OfficeName");
//                    mOfficeId = data.getStringExtra("OfficeId");
//                    mTvDepartments.setText(mOfficeName);
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
            inflater = LayoutInflater.from(AddPharmacyRecordDataActivity.this);
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
                Glide.with(AddPharmacyRecordDataActivity.this)
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


}
