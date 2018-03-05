package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.ScaleDetailsAdapter;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.constant.GlobalConstants;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailsCommitBean;
import cn.qiyu.magicalcrue_patient.model.ScaleSelectBean;
import cn.qiyu.magicalcrue_patient.model.ScaleTitleBean;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.visit.MyScalePresenter;
import cn.qiyu.magicalcrue_patient.visit.MyScaleView;

/**
 * 量表详情已填写显示
 */
public class ScaleDetailShowActivity extends BaseActivity {

    @Bind(R.id.rv_scale_detail)
    RecyclerView rvScaleDetail;
    @Bind(R.id.tv_send_patient)
    TextView tvSendPatient;
    @Bind(R.id.iv_exit_mine)
    ImageView mIvExitMine;
    @Bind(R.id.lv_scale_detail)
    ListView mLvScaleDetail;
    private ScaleDetailBean questionnaireDetail;
    private String mStatus;
    private String mCommitJa;
    private String mPaperUserID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_detail_show);
        ButterKnife.bind(this);
        Intent intent = getIntent();


        mStatus = intent.getStringExtra("mStatus");
        questionnaireDetail = (ScaleDetailBean) intent.getSerializableExtra("scaleDetail");
        mPaperUserID = intent.getStringExtra("paperUserID");

        if (mStatus.equals("0")) {
            tvSendPatient.setVisibility(View.VISIBLE);
            mLvScaleDetail.setVisibility(View.VISIBLE);
            rvScaleDetail.setVisibility(View.GONE);
            mLvScaleDetail.setAdapter(new ScaleDetailsAdapter(this, questionnaireDetail.getQuestionList()));
        } else {
            rvScaleDetail.setVisibility(View.VISIBLE);
            mLvScaleDetail.setVisibility(View.GONE);
            rvScaleDetail.setAdapter(new RecyclerAdpter(questionnaireDetail.getQuestionList()));
            rvScaleDetail.setLayoutManager(new LinearLayoutManager(ScaleDetailShowActivity.this));
            tvSendPatient.setVisibility(View.GONE);
        }

    }

    MyScalePresenter mScalePresenter = new MyScalePresenter(new MyScaleView() {
        @Override
        public String getPatientUuid() {
//            Log.i("patientuuid===----==", (String) PreUtils.getParam(ScaleDetailActivity.this, "patientuuid", "0"));
            return (String) PreUtils.getParam(ScaleDetailShowActivity.this, GlobalConstants.PATIENT_UUID, "0");
        }

        @Override
        public String getStatus() {
            return null;
        }

        @Override
        public String getPage() {
            return null;
        }

        @Override
        public String getPagecount() {
            return null;
        }

        @Override
        public void LoadDate(ResultModel<List<MyScaleBean>> model) {

        }

        @Override
        public String paperId() {
            return null;
        }

        @Override
        public String paperUserId() {
            Log.i("mPaperUserID===", mPaperUserID);
            return mPaperUserID;
        }

        @Override
        public String userId() {
            return null;
        }

        @Override
        public void LoadScaleDetailsData(ResultModel<ScaleDetailBean> model) {

        }

        @Override
        public String getQuestionArr() {
            Log.i("mCommitJa===", mCommitJa);
            return mCommitJa;
        }

        @Override
        public void LoadScaleDetailsCommit(ResultModel model) {
            Toast.makeText(ScaleDetailShowActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(ScaleDetailShowActivity.this, "" + model.getErrorCode(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(ScaleDetailShowActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    });


    @OnClick(R.id.tv_send_patient)
    public void onViewClicked() {
        List<ScaleTitleBean> questionList = questionnaireDetail.getQuestionList();
        List<ScaleDetailsCommitBean> commitOptionList = new ArrayList<>();
        if (null != questionList) {
            for (int i = 0; i < questionList.size(); i++) {
                ScaleDetailsCommitBean commitBean = new ScaleDetailsCommitBean();
                ScaleTitleBean scaleTitleBean = questionList.get(i);
                StringBuffer optionIds = new StringBuffer();
                switch (scaleTitleBean.getQuestionType()) {
                    case "radio":
                    case "checkbox":
                        if (null != scaleTitleBean.getOptionsList() && scaleTitleBean.getOptionsList().size() > 0) {
                            List<ScaleSelectBean> optionList = scaleTitleBean.getOptionsList();
                            for (int j = 0; j < optionList.size(); j++) {
                                if (optionList.get(j).isChecked()) {
                                    if (j == optionList.size() - 1) {
                                        optionIds.append(optionList.get(j).getOptionID());
                                    } else {
                                        optionIds.append(optionList.get(j).getOptionID() + ",");
                                    }
                                }
                            }
                        }
                        commitBean.setResult("");
                        break;

                    default:
                        if (null != scaleTitleBean.getResult()) {
                            commitBean.setResult(scaleTitleBean.getResult());
                        }
                        break;
                }
                commitBean.setOptionID(optionIds.toString());
                commitBean.setPaperID(scaleTitleBean.getPaperID());
                commitBean.setQuestionID(scaleTitleBean.getQuestionID());
                commitOptionList.add(commitBean);
            }
            mCommitJa = JSONArray.toJSONString(commitOptionList);
            if (null != mCommitJa) {
                Log.e("1111", mCommitJa);
            }
        }
        //必须选中答案才能提交
        for (int i = 0; i < commitOptionList.size(); i++) {
            ScaleDetailsCommitBean scaleDetailsCommitBean = commitOptionList.get(i);
            if (TextUtils.isEmpty(scaleDetailsCommitBean.getOptionID()) && TextUtils.isEmpty(scaleDetailsCommitBean.getResult())) {
                Toast.makeText(this, "请填写选项", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        mScalePresenter.VisitScaleDetailsCommit();

    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind({R.id.tv_question_title})
        TextView mtextview;
        @Bind(R.id.ll_question_option_container)
        LinearLayout linearLayout;
        ScaleTitleBean mModel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void setItem(ScaleTitleBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView(int num) {
            linearLayout.removeAllViews();
            String type = "";
            switch (mModel.getQuestionType()) {
                case "radio":
                case "checkbox":
                    if (mModel.getQuestionType().equals("radio"))
                        type = "（单选）";
                    else
                        type = "（多选）";
                    for (int i = 0; i < mModel.getOptionsList().size(); i++) {
                        LinearLayout linearLayout1 = new LinearLayout(ScaleDetailShowActivity.this);
                        final CheckBox checkBox = new CheckBox(ScaleDetailShowActivity.this);
                        checkBox.setButtonDrawable(R.drawable.selector_choose);
                        checkBox.setTextColor(ScaleDetailShowActivity.this.getResources().getColor(R.color.app_gray));
                        checkBox.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            if (checkBox.isChecked())
                                                                checkBox.setChecked(false);

                                                            else
                                                                checkBox.setChecked(true);
                                                        }
                                                    }
                        );
                        for (int j = 0; j < mModel.getAnswerOptionIOS().size(); j++) {
                            if (mModel.getOptionsList().get(i).getOptionID().equals(mModel.getAnswerOptionIOS().get(j))) {
                                checkBox.setChecked(true);

                            }
                        }
                        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
                        linearLayout1.addView(checkBox);
                        TextView textView = new TextView(ScaleDetailShowActivity.this);
                        textView.setPadding(40, 0, 0, 0);
                        textView.setTextSize(16);
                        textView.setGravity(Gravity.CENTER_HORIZONTAL);
                        textView.setText(mModel.getOptionsList().get(i).getContent());
                        textView.setTextColor(ScaleDetailShowActivity.this.getResources().getColor(R.color.app_gray));
                        linearLayout1.addView(textView);
                        linearLayout1.setPadding(0, 20, 0, 0);
                        linearLayout.addView(linearLayout1);
                    }
                    break;
                default:
                    type = "(描述)";
                    EditText editText = new EditText(ScaleDetailShowActivity.this);
                    editText.setBackgroundResource(R.drawable.edit_scale_detail);
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.setKeyListener(null);
                    editText.setPadding(20, 20, 20, 20);
                    editText.setText(mModel.getAnswerResult());
                    editText.setTextColor(ScaleDetailShowActivity.this.getResources().getColor(R.color.app_gray));
                    linearLayout.addView(editText);
                    break;
            }
            mtextview.setText((num + 1) + "、" + mModel.getContent().toString() + type);
        }
    }

    class RecyclerAdpter extends RecyclerView.Adapter<ViewHolder> {
        private List<ScaleTitleBean> mlist;

        public RecyclerAdpter(List<ScaleTitleBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(ScaleDetailShowActivity.this).inflate(R.layout.recyclerview_item_option_show, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView(position);
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }


}
