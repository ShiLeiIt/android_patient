package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.HospitalOfficeListBean;
import cn.qiyu.magicalcrue_patient.model.PharmacyWaybean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.view.RecycleViewDivider;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryHospitalListView;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryHospitalOfficeListView;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryPresenter;
import cn.qiyu.magicalcrue_patient.visit.PharmacyRecordPresenter;
import cn.qiyu.magicalcrue_patient.visit.PharmacyRecordWayView;

/**
 * Created by ShiLei on 2017/12/21.
 * 用药方式
 */

public class PharmacyWayListActivity extends BaseActivity {
    @Bind(R.id.iv_hospital_list_back)
    ImageView mIvHospitalListBack;
    @Bind(R.id.rlv_hospital_list)
    RecyclerView mRlvHospitalList;
    private List<PharmacyWaybean> mList;
    private String mWayName;
    private RecyclerAdpter mRecyclerAdpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);
        ButterKnife.bind(this);
        init();
        initData();
    }

    private void init() {

        mRlvHospitalList.addItemDecoration(new RecycleViewDivider(PharmacyWayListActivity.this, LinearLayoutManager.HORIZONTAL, R.drawable.relation_bg));

    }

    //用药方式列表
    PharmacyRecordPresenter mPharmacyRecordPresenter = new PharmacyRecordPresenter(new PharmacyRecordWayView() {
        @Override
        public String getBianMa() {
            return "routeofmedication";
        }

        @Override
        public String getType() {
            return "1";
        }

        @Override
        public void LoadPharmacyRecordWay(ResultModel<List<PharmacyWaybean>> model) {
            mRecyclerAdpter = new RecyclerAdpter(model.getData());
            mRlvHospitalList.setAdapter(mRecyclerAdpter);
            mRlvHospitalList.setLayoutManager(new LinearLayoutManager(PharmacyWayListActivity.this));
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


    private void initData() {
        mPharmacyRecordPresenter.getPharmacyRecordWay();
    }

    @OnClick({R.id.iv_hospital_list_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_hospital_list_back:
                Intent intent = new Intent(PharmacyWayListActivity.this, AddPharmacyRecordDataActivity.class);
                if (TextUtils.isEmpty(mWayName)) {
                        Toast.makeText(this, "请选择用药方式", Toast.LENGTH_SHORT).show();
                } else {
                    intent.putExtra("WayName", mWayName);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                break;

        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        PharmacyWaybean mModel;
        private final TextView mTv_relation;
        private final ImageView mIv_seclect;

        public ViewHolder(final View itemView) {
            super(itemView);
            mTv_relation = (TextView) itemView.findViewById(R.id.tv_relation);
            mIv_seclect = (ImageView) itemView.findViewById(R.id.iv_select);
        }

        void setItem(PharmacyWaybean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            mTv_relation.setText(mModel.getNAME());
            if (mModel.isSelect()) {
                mIv_seclect.setVisibility(View.VISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_relation_tv));
            } else {
                mIv_seclect.setVisibility(View.INVISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_userInfor));
            }
        }
    }
    public class RecyclerAdpter extends RecyclerView.Adapter<PharmacyWayListActivity.ViewHolder> {


        public RecyclerAdpter(List<PharmacyWaybean> mlist) {
            mList = mlist;
        }

        @Override
        public PharmacyWayListActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PharmacyWayListActivity.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_patient_relation_item, null));
        }

        @Override
        public void onBindViewHolder(final PharmacyWayListActivity.ViewHolder holder, final int position) {
            holder.setItem(mList.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mWayName = mList.get(position).getNAME();
                    for (int i = 0; i < mList.size(); i++) {
                        if (i == position) {
                            mList.get(i).setSelect(true);
                        } else {
                            mList.get(i).setSelect(false);
                        }
                    }
                    mRecyclerAdpter.notifyDataSetChanged();
                }
            });
            holder.refreshView();
        }
        @Override
        public int getItemCount() {
            return mList.size();
        }

    }
}
