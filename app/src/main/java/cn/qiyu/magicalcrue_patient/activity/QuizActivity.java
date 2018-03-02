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
import com.google.gson.Gson;
import com.lidong.photopicker.ImageCaptureManager;
import com.lidong.photopicker.ImageConfig;
import com.lidong.photopicker.PhotoPickerActivity;
import com.lidong.photopicker.PhotoPreviewActivity;
import com.lidong.photopicker.SelectModel;
import com.lidong.photopicker.intent.PhotoPickerIntent;
import com.lidong.photopicker.intent.PhotoPreviewIntent;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.image.ImageUpLoadPresenter;
import cn.qiyu.magicalcrue_patient.image.ImageUpLoadView;
import cn.qiyu.magicalcrue_patient.model.ImageUpLoadBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.VisitDialogueQuizBean;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.visit.VisitDialogueQuizPresenter;
import cn.qiyu.magicalcrue_patient.visit.VisitDialogueQuizView;
import okhttp3.MediaType;
import okhttp3.RequestBody;


/**
 * Created by ShiLei on 2017/12/11.
 * 提问界面
 */

public class QuizActivity extends BaseActivity {
    @Bind(R.id.id_editor_detail)
    EditText mIdEditorDetail;
    @Bind(R.id.id_editor_detail_font_count)
    TextView mIdEditorDetailFontCount;
    @Bind(R.id.iv_quiz_pic)
    ImageView mIvQuizPic;
    @Bind(R.id.tv_quiz)
    TextView mTvQuiz;
    @Bind(R.id.tv_quiz_commit)
    TextView mTvQuizCommit;
    @Bind(R.id.rl_camera)
    RelativeLayout mRlCamera;
    @Bind(R.id.gridView)
    GridView mGridView;
    private boolean islMaxCount;
    private ImageConfig imgConfig;
    private static final int REQUEST_CAMERA_CODE = 10;
    private static final int REQUEST_PREVIEW_CODE = 20;
    private ArrayList<String> imagePaths = new ArrayList<>();
    private ImageCaptureManager captureManager; // 相机拍照处理类
    private String TAG = QuizActivity.class.getSimpleName();
    private GridAdapter mGridAdapter;
    private String mUserUuid;
    private File mFileName;
    private RequestBody mRequestFile;
    private String mFileId;
    private ArrayList<String> mList;
    private StringBuffer mStringBuffer = new StringBuffer();

    private int requestImageIndex=0;
    private Dialog mLoadingDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mLoadingDialog = new Dialog(QuizActivity.this, R.style.progress_dialog);
        mLoadingDialog.setContentView(R.layout.progress_dialog);
        mLoadingDialog.setCancelable(true);
        mLoadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        TextView msg = (TextView) mLoadingDialog.findViewById(R.id.id_tv_loadingmsg);
        msg.setText("上传中...");

        mUserUuid = (String) PreUtils.getParam(QuizActivity.this, "uuid", "0");
        Log.i("mUserUuid======", mUserUuid);


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
                    Toast.makeText(QuizActivity.this, "最多输入500字", Toast.LENGTH_SHORT).show();
                    islMaxCount = false;
                }
            }
        });
    }
    ImageUpLoadPresenter mImageUpLoadPresenter = new ImageUpLoadPresenter(new ImageUpLoadView() {
        @Override
        public RequestBody getImageUpLoadFileId() {

            mRequestFile = RequestBody.create(MediaType.parse("image/png"), mFileName);
            Log.i("mRequestFile===",mRequestFile+"");
            return mRequestFile;
        }



        @Override
        public void getImageUpLoad(ImageUpLoadBean imageUpLoadBean) {
            requestImageIndex=requestImageIndex+1;
//            Log.i("getImageUpLoad==", ""+requestImageIndex+"");
            String fileName = imageUpLoadBean.getData().getFileName();
//            Toast.makeText(QuizActivity.this, "成功", Toast.LENGTH_SHORT).show();
            mStringBuffer.append(fileName + ",");
//            Log.i("mStringBuffer=======", mStringBuffer.toString());
//            mFileId = imageUpLoadBean.getFileId();
            //上传
//            Log.i("mList==", mList.size()+"");

            if(requestImageIndex==mList.size()-1){
                mVisitDialogueQuizPresenter.getVisitDialogueQuiz();
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
            Toast.makeText(QuizActivity.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(QuizActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    });


    @OnClick({R.id.iv_quiz_pic, R.id.tv_quiz, R.id.tv_quiz_commit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_quiz_pic:
                // preview
                mRlCamera.setVisibility(View.GONE);
                mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String imgs = (String) parent.getItemAtPosition(position);
                        if ("000000".equals(imgs)) {
                            PhotoPickerIntent intent = new PhotoPickerIntent(QuizActivity.this);
                            intent.setSelectModel(SelectModel.MULTI);
                            intent.setShowCarema(true); // 是否显示拍照
                            intent.setMaxTotal(8); // 最多选择照片数量，默认为6
                            intent.setImageConfig(imgConfig);
                            intent.setSelectedPaths(imagePaths); // 已选中的照片地址， 用于回显选中状态
                            startActivityForResult(intent, REQUEST_CAMERA_CODE);
                        } else {
                            PhotoPreviewIntent intent = new PhotoPreviewIntent(QuizActivity.this);
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
            case R.id.tv_quiz:
                break;
            case R.id.tv_quiz_commit:

                if (TextUtils.isEmpty(mIdEditorDetail.getText().toString())) {
                    Toast.makeText(QuizActivity.this, "请输入需要发表的内容!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mList != null && mList.size() > 0) {
                    for (int i = 0; i < mList.size() - 1; i++) {
                        mFileName = new File(mList.get(i));
                        mImageUpLoadPresenter.getImage();


                    }
                } else {
                    mVisitDialogueQuizPresenter.getVisitDialogQuizText();
                }
        }
    }





    @Override
    protected void onResume() {
        super.onResume();
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
                    Log.d(TAG, "ListExtra: " + "ListExtra = [" + ListExtra.size());
                    loadAdpater(ListExtra);
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
            inflater = LayoutInflater.from(QuizActivity.this);
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
                Glide.with(QuizActivity.this)
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


    //随访对话提问上传
    VisitDialogueQuizPresenter mVisitDialogueQuizPresenter = new VisitDialogueQuizPresenter(new VisitDialogueQuizView() {
        @Override
        public String getDoctorUuid() {
//            return "95bbb5cb43ec43b58b464e89be63a585";
            return (String) PreUtils.getParam(QuizActivity.this, "doctorUuid", "0");
        }

        @Override
        public String getUserUuid() {
            return mUserUuid;
        }

        @Override
        public String getUserType() {
            return "1";
        }

        @Override
        public String getComplaint() {
            return mIdEditorDetail.getText().toString();
        }

        @Override
        public String getImageArray() {

            return null==mStringBuffer.toString()? null:mStringBuffer.toString();
        }

        @Override
        public void LoadVisitDialogueQuiz(ResultModel<VisitDialogueQuizBean> model) {
            Toast.makeText(QuizActivity.this, "提问成功", Toast.LENGTH_SHORT).show();
            finish();
//            Log.i("LoadVisitDialogueQuiz==", "requestImageIndex="+requestImageIndex+"");


        }

        @Override
        public void LoadVisitDialogueQuizText(ResultModel<VisitDialogueQuizBean> model) {
            Toast.makeText(QuizActivity.this, "提问成功", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(QuizActivity.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(QuizActivity.this, "" + e, Toast.LENGTH_SHORT).show();

        }
    });

}
