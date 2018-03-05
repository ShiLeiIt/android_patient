package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.adapter.ListDischargeItemAdapter;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.constant.GlobalConstants;
import cn.qiyu.magicalcrue_patient.model.AddOutPatientDataSaveBean;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryPresenter;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryView;

/**
 * Created by ShiLei on 2017/12/19.
 * 门诊信息
 */

public class OutpatientInformationListActivity extends BaseActivity {
    @Bind(R.id.lv_follow_up_Detail)
    ListView mLvFollowUpDetail;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;
    private String mOutPatient;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outpatient_information);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText(R.string.outpatientInfo);
        mTvCommit.setText(R.string.add);
        mTvCommit.setVisibility(View.VISIBLE);
        //通过此字段判断是不是门诊信息，在适配器修改
        mOutPatient = getIntent().getStringExtra("outPatient");


    }

    CaseHistoryPresenter mCaseHistoryPresenter = new CaseHistoryPresenter(new CaseHistoryView() {
        @Override
        public String getPatientUuid() {
            Log.i("patientUuid=-------=", (String) PreUtils.getParam(OutpatientInformationListActivity.this, "patientuuid", "0"));
            return (String) PreUtils.getParam(OutpatientInformationListActivity.this, GlobalConstants.PATIENT_UUID,"0");

        }

        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPageCount() {
            return "100";
        }

        //获取门诊信息
        @Override
        public void LoadOutPatientInfoList(ResultModel<List<DischargeBean>> model) {
            ListDischargeItemAdapter listDischargeItemAdapter = new ListDischargeItemAdapter(OutpatientInformationListActivity.this, OutpatientInformationListActivity.this, model.getData(),mOutPatient);
            mLvFollowUpDetail.setAdapter(listDischargeItemAdapter);
        }

        //获取出院小结
        @Override
        public void LoadLeaveHospitalInfoList(ResultModel<List<DischargeBean>> model) {

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

    @Override
    protected void onResume() {
        super.onResume();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mCaseHistoryPresenter.getOutPatientInfoList();
            }
        });
    }


    @OnClick(R.id.tv_commit)
    public void onViewClicked() {
        startActivity(new Intent(OutpatientInformationListActivity.this,AddOutpatientDataActivity.class));
    }
}
