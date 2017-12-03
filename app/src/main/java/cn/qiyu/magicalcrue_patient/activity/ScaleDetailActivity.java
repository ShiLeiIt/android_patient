package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import com.alibaba.fastjson.JSONArray;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.ScaleDetailsAdapter;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.model.ScaleSelectBean;
import cn.qiyu.magicalcrue_patient.model.ScaleTitleBean;


public class ScaleDetailActivity extends BaseActivity {

    @Bind(R.id.lv_scale_detail)
    ListView lvScaleDetail;
    private ScaleDetailBean questionnaireDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        questionnaireDetail = (ScaleDetailBean) intent.getSerializableExtra("scaleDetail");
        Log.i("scalebean", "" + questionnaireDetail.getQuestionList().get(0).getOptionsList().size());
        lvScaleDetail.setAdapter(new ScaleDetailsAdapter(this, questionnaireDetail.getQuestionList()));
        //rvScaleDetail.setLayoutManager(new LinearLayoutManager(ScaleDetailActivity.this));
    }

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
                    String commitJa = JSONArray.toJSONString(commitOptionList);
                    if (null != commitJa) {
                        Log.e("1111", commitJa);
                    }
                }
                break;

        }
    }

}
