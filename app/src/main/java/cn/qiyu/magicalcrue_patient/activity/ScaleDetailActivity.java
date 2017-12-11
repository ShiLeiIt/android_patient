package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
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
 * 量表详情页面填写并保存
 */
public class ScaleDetailActivity extends BaseActivity {

    @Bind(R.id.lv_scale_detail)
    ListView lvScaleDetail;
    @Bind(R.id.iv_exit_mine)
    ImageView mIvExitMine;
    private ScaleDetailBean questionnaireDetail;
    private String mPaperUserID;
    private String mCommitJa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        questionnaireDetail = (ScaleDetailBean) intent.getSerializableExtra("scaleDetail");
        mPaperUserID = intent.getStringExtra("paperUserID");
//        Log.i("scalebean", "" + questionnaireDetail.getQuestionList().get(0).getOptionsList().size());
        lvScaleDetail.setAdapter(new ScaleDetailsAdapter(this, questionnaireDetail.getQuestionList()));
        //rvScaleDetail.setLayoutManager(new LinearLayoutManager(ScaleDetailActivity.this));
    }

    MyScalePresenter mScalePresenter = new MyScalePresenter(new MyScaleView() {
        @Override
        public String getPatientUuid() {
            Log.i("patientuuid===----==", (String) PreUtils.getParam(ScaleDetailActivity.this, "patientuuid", "0"));
            return (String) PreUtils.getParam(ScaleDetailActivity.this, "patientuuid", "0");
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
            Toast.makeText(ScaleDetailActivity.this, "提交成功", Toast.LENGTH_SHORT).show();
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
            Toast.makeText(ScaleDetailActivity.this, "" + model.getErrorCode(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(ScaleDetailActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    });


    @OnClick({R.id.iv_exit_mine, R.id.tv_send_patient})

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_exit_mine:
                finish();
                break;
            case R.id.tv_send_patient:

                //scalePresenter.getPatientByFollowDoctorList();
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
                mScalePresenter.VisitScaleDetailsCommit();
                break;
        }
    }


    @OnClick(R.id.iv_exit_mine)
    public void onViewClicked() {
        finish();
    }

}
