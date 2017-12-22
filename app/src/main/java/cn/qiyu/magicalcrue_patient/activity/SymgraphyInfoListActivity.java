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
import cn.qiyu.magicalcrue_patient.adapter.ListSymgraphyItemAdapter;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.DischargeBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.SymptomatographyBean;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryPresenter;
import cn.qiyu.magicalcrue_patient.visit.CaseHistorySymgyListView;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryView;

/**
 * Created by ShiLei on 2017/12/22.
 * 身体症状记录信息
 */

public class SymgraphyInfoListActivity extends BaseActivity {
    @Bind(R.id.lv_follow_up_Detail)
    ListView mLvFollowUpDetail;
    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outpatient_information);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText(R.string.symptomatography);
        mTvCommit.setText(R.string.add);
        mTvCommit.setVisibility(View.VISIBLE);


    }

    CaseHistoryPresenter mCaseHistoryPresenter = new CaseHistoryPresenter(new CaseHistorySymgyListView() {


        @Override
        public String getPatientUuid() {
            return (String) PreUtils.getParam(SymgraphyInfoListActivity.this,"patientuuid","0");
        }

        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPageCount() {
            return "100";
        }

        @Override
        public void LoadSymgyList(ResultModel<List<SymptomatographyBean>> model) {
            ListSymgraphyItemAdapter listSymgraphyItemAdapter = new ListSymgraphyItemAdapter(SymgraphyInfoListActivity.this, SymgraphyInfoListActivity.this, model.getData());
            mLvFollowUpDetail.setAdapter(listSymgraphyItemAdapter);

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
                mCaseHistoryPresenter.getSymgyList();
            }
        });
    }

    @OnClick(R.id.tv_commit)
    public void onViewClicked() {
        startActivity(new Intent(SymgraphyInfoListActivity.this,AddSymgraphyDataActivity.class));
    }
}
