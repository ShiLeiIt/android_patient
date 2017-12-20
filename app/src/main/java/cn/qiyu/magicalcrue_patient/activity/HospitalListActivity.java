package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.DiseasesBean;
import cn.qiyu.magicalcrue_patient.model.HospitalListBean;
import cn.qiyu.magicalcrue_patient.model.HospitalOfficeListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.view.RecycleViewDivider;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryHospitalListView;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryHospitalOfficeListView;
import cn.qiyu.magicalcrue_patient.visit.CaseHistoryPresenter;

/**
 * Created by ShiLei on 2017/12/19.
 */

public class HospitalListActivity extends BaseActivity {
    @Bind(R.id.iv_hospital_list_back)
    ImageView mIvHospitalListBack;
    @Bind(R.id.rlv_hospital_list)
    RecyclerView mRlvHospitalList;
    private String mHospitalName;
    private RecyclerAdpter mRecyclerAdpter;

    private List<HospitalListBean> mList;
    private String mIsHospital;
    private String mOfficeName;
    private RecyclerOfficeAdpter mOfficeAdpter;
    private int mHospitalId;
    private String mOfficeUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_list);
        ButterKnife.bind(this);
        init();
        initData();
    }


    private void init() {

        mRlvHospitalList.addItemDecoration(new RecycleViewDivider(HospitalListActivity.this, LinearLayoutManager.HORIZONTAL, R.drawable.relation_bg));
        mIsHospital = getIntent().getStringExtra("isHospital");

    }
    //科室列表
    CaseHistoryPresenter caseHistoryPresenter = new CaseHistoryPresenter(new CaseHistoryHospitalOfficeListView() {
        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPageCount() {
            return "100";
        }

        @Override
        public void LoadHospitalOfficeList(ResultModel<List<HospitalOfficeListBean>> model) {
            mOfficeAdpter = new RecyclerOfficeAdpter(model.getData());
            mRlvHospitalList.setAdapter(mOfficeAdpter);
            mRlvHospitalList.setLayoutManager(new LinearLayoutManager(HospitalListActivity.this));
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
    //医院列表
    CaseHistoryPresenter mCaseHistoryPresenter = new CaseHistoryPresenter(new CaseHistoryHospitalListView() {
        @Override
        public String getKeyWords() {
            return "";
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
        public void LoadHospitalList(ResultModel<List<HospitalListBean>> model) {

            mRecyclerAdpter = new RecyclerAdpter(model.getData());
            mRlvHospitalList.setAdapter(mRecyclerAdpter);
            mRlvHospitalList.setLayoutManager(new LinearLayoutManager(HospitalListActivity.this));
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
        if (mIsHospital.equals("0")) {
            mCaseHistoryPresenter.getHospitalList();
        } else if (mIsHospital.equals("1")) {
            caseHistoryPresenter.getHospitalOfficeList();
        }
    }

    @OnClick({R.id.iv_hospital_list_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_hospital_list_back:
                Intent intent = new Intent(HospitalListActivity.this, OutpatientInformationListActivity.class);
                if (TextUtils.isEmpty(mHospitalName)) {
                    if (mIsHospital.equals("0")) {
                        Toast.makeText(this, "请选择医院", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    intent.putExtra("HospitalName", mHospitalName);
                    intent.putExtra("HospitalId",String.valueOf(mHospitalId));
                    setResult(RESULT_OK, intent);
                    finish();
                }

                if (TextUtils.isEmpty(mOfficeName)) {
                    if (mIsHospital.equals("1")) {
                        Toast.makeText(this, "请选择科室", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    intent.putExtra("OfficeName", mOfficeName);
                    intent.putExtra("OfficeId", mOfficeUuid);
                    setResult(RESULT_OK, intent);
                    finish();
                }


                break;

        }
    }



    class ViewHolder extends RecyclerView.ViewHolder {
        HospitalListBean mModel;
        private final TextView mTv_relation;
        private final ImageView mIv_seclect;

        public ViewHolder(final View itemView) {
            super(itemView);
            mTv_relation = (TextView) itemView.findViewById(R.id.tv_relation);
            mIv_seclect = (ImageView) itemView.findViewById(R.id.iv_select);
        }

        void setItem(HospitalListBean item) {
            this.mModel = item;

        }

        //刷新
        void refreshView() {
            mTv_relation.setText(mModel.getHospitalName());
            if (mModel.isSelect()) {
                mIv_seclect.setVisibility(View.VISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_relation_tv));
            } else {
                mIv_seclect.setVisibility(View.INVISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_userInfor));
            }
        }
    }

    public class RecyclerAdpter extends RecyclerView.Adapter<HospitalListActivity.ViewHolder> {


        public RecyclerAdpter(List<HospitalListBean> mlist) {
            mList = mlist;
        }

        @Override
        public HospitalListActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new HospitalListActivity.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_patient_relation_item, null));
        }


        @Override
        public void onBindViewHolder(final HospitalListActivity.ViewHolder holder, final int position) {
            holder.setItem(mList.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(PatientRelationListActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                    mHospitalName = mList.get(position).getHospitalName();
                    mHospitalId = mList.get(position).getHospitalId();

//                    mBianma = mlist.get(position).getBIANMA();
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

    //医院科室列表
    class ViewHolderOffice extends RecyclerView.ViewHolder {
        HospitalOfficeListBean mModel;
        private final TextView mTv_relation;
        private final ImageView mIv_seclect;

        public ViewHolderOffice(final View itemView) {
            super(itemView);
            mTv_relation = (TextView) itemView.findViewById(R.id.tv_relation);
            mIv_seclect = (ImageView) itemView.findViewById(R.id.iv_select);
        }

        void setItem(HospitalOfficeListBean item) {
            this.mModel = item;

        }

        //刷新
        void refreshView() {
            mTv_relation.setText(mModel.getOffice_name());
            if (mModel.isSelect()) {
                mIv_seclect.setVisibility(View.VISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_relation_tv));
            } else {
                mIv_seclect.setVisibility(View.INVISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_userInfor));
            }
        }
    }

    public class RecyclerOfficeAdpter extends RecyclerView.Adapter<HospitalListActivity.ViewHolderOffice> {
        private List<HospitalOfficeListBean> mlist;

        public RecyclerOfficeAdpter(List<HospitalOfficeListBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public HospitalListActivity.ViewHolderOffice onCreateViewHolder(ViewGroup parent, int viewType) {

            return new HospitalListActivity.ViewHolderOffice(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_patient_relation_item, null));

        }

        @Override
        public void onBindViewHolder(final HospitalListActivity.ViewHolderOffice holder, final int position) {
            holder.setItem(mlist.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(PatientRelationListActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                    mOfficeName = mlist.get(position).getOffice_name();
                    mOfficeUuid = mlist.get(position).getUuid();
                    for (int i = 0; i < mlist.size(); i++) {
                        if (i == position) {
                            mlist.get(i).setSelect(true);
                        } else {
                            mlist.get(i).setSelect(false);
                        }
                    }
                    mOfficeAdpter.notifyDataSetChanged();
                }
            });
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }

    }


}
