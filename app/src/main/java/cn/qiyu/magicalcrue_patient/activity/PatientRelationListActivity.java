package cn.qiyu.magicalcrue_patient.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import cn.qiyu.magicalcrue_patient.home.PatientInfoRelationPresenter;
import cn.qiyu.magicalcrue_patient.home.PatientRelationInfoView;
import cn.qiyu.magicalcrue_patient.model.DiseasesBean;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.view.RecycleViewDivider;

/**
 * Created by ShiLei on 2017/11/19.
 * 患者关系列表页面
 */

public class PatientRelationListActivity extends Activity {

    @Bind(R.id.iv_patient_relation_back)
    ImageView mIvBack;
    private RecyclerView mRl_relation;
    private String mRelationName;
    private RecyclerAdpter mAdpter;
    private String mIsrelation;
    private RecyclerDiseaseAdpter mDiseaseAdpter;
    private String mCancerName;
    private String mBianma;
    private int mCancerId;
    private String mUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_relation);
        ButterKnife.bind(this);
        mRl_relation = (RecyclerView) findViewById(R.id.rlv_patient_relation);
        init();
        if (mIsrelation.equals("0")) {
            //进去患者关系列表
            mPatientInfoRelationPresenter.LoadPatientRelation();
        } else {
            //进入疾病种类列表
            mPatientInfoRelationPresenter.LoadDiseasesList();
        }
    }

    private void init() {
        mRl_relation.addItemDecoration(new RecycleViewDivider(PatientRelationListActivity.this, LinearLayoutManager.HORIZONTAL,R.drawable.relation_bg));
        mIsrelation = getIntent().getStringExtra("isreleation");
    }

    PatientInfoRelationPresenter mPatientInfoRelationPresenter = new PatientInfoRelationPresenter(new PatientRelationInfoView() {
        @Override
        public String getBianMa() {
            return "relationshipCode";
        }
        @Override
        public String getType() {
            return "1";
        }
        @Override
        public void LoadPatientRelation(ResultModel<List<PatientRelationBean>> model) {
            Toast.makeText(PatientRelationListActivity.this, "" + model.getData().size(), Toast.LENGTH_SHORT).show();
            mAdpter = new RecyclerAdpter(model.getData());
            mRl_relation.setAdapter(mAdpter);
            mRl_relation.setLayoutManager(new LinearLayoutManager(PatientRelationListActivity.this));
        }

        @Override
        public void LoadDiseases(ResultModel<List<DiseasesBean>> model) {
            mDiseaseAdpter = new RecyclerDiseaseAdpter(model.getData());
            mRl_relation.setAdapter(mDiseaseAdpter);
            mRl_relation.setLayoutManager(new LinearLayoutManager(PatientRelationListActivity.this));
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
            Toast.makeText(PatientRelationListActivity.this, e, Toast.LENGTH_SHORT).show();
        }
    });
    @OnClick(R.id.iv_patient_relation_back)
    public void onViewClicked() {
        Intent intent = new Intent(PatientRelationListActivity.this, PatientDataActivity.class);
        intent.putExtra("relationName", mRelationName);
        intent.putExtra("relationNameBianma", mBianma);
        intent.putExtra("DiseaseName", mCancerName);
        intent.putExtra("uuid", mUuid);
        setResult(RESULT_OK,intent);
        finish();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        PatientRelationBean mModel;
        private final TextView mTv_relation;
        private final ImageView mIv_seclect;

        public ViewHolder(final View itemView) {
            super(itemView);
            mTv_relation = (TextView) itemView.findViewById(R.id.tv_relation);
            mIv_seclect = (ImageView) itemView.findViewById(R.id.iv_select);
        }

        void setItem(PatientRelationBean item) {
            this.mModel = item;

        }
        //刷新
        void refreshView() {
            mTv_relation.setText(mModel.getNAME());
            if (mModel.isSelect()){
                mIv_seclect.setVisibility(View.VISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_relation_tv));
            }else {
                mIv_seclect.setVisibility(View.INVISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_userInfor));
            }
        }
    }

    public class RecyclerAdpter extends RecyclerView.Adapter<ViewHolder> {
        private List<PatientRelationBean> mlist;
        public RecyclerAdpter(List<PatientRelationBean> mlist) {
            this.mlist = mlist;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_patient_relation_item, null));
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.setItem(mlist.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(PatientRelationListActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                    mRelationName = mlist.get(position).getNAME();
                    mBianma = mlist.get(position).getBIANMA();
                    for (int i = 0; i < mlist.size(); i++) {
                        if (i == position){
                            mlist.get(i).setSelect(true);
                        }else {
                            mlist.get(i).setSelect(false);
                        }
                    }
                    mAdpter.notifyDataSetChanged();
                }
            });
            holder.refreshView();
        }
        @Override
        public int getItemCount() {
            return mlist.size();
        }

    }

    //疾病种类适配器

    class ViewHolderDis extends RecyclerView.ViewHolder {
        DiseasesBean mModel;
        private final TextView mTv_relation;
        private final ImageView mIv_seclect;

        public ViewHolderDis(final View itemView) {
            super(itemView);
            mTv_relation = (TextView) itemView.findViewById(R.id.tv_relation);
            mIv_seclect = (ImageView) itemView.findViewById(R.id.iv_select);
        }

        void setItem(DiseasesBean item) {
            this.mModel = item;

        }
        //刷新
        void refreshView() {
            mTv_relation.setText(mModel.getCancerName());
            if (mModel.isSelect()){
                mIv_seclect.setVisibility(View.VISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_relation_tv));
            }else {
                mIv_seclect.setVisibility(View.INVISIBLE);
                mTv_relation.setTextColor(getResources().getColor(R.color.app_userInfor));
            }
        }
    }

    public class RecyclerDiseaseAdpter extends RecyclerView.Adapter<ViewHolderDis> {
        private List<DiseasesBean> mlist;

        public RecyclerDiseaseAdpter(List<DiseasesBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public ViewHolderDis onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolderDis(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_patient_relation_item, null));

        }
        @Override
        public void onBindViewHolder(final ViewHolderDis holder, final int position) {
            holder.setItem(mlist.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Toast.makeText(PatientRelationListActivity.this, "position"+position, Toast.LENGTH_SHORT).show();
                    mCancerName = mlist.get(position).getCancerName();
                    mUuid = mlist.get(position).getUuid();
                    for (int i = 0; i < mlist.size(); i++) {
                        if (i == position){
                            mlist.get(i).setSelect(true);
                        }else {
                            mlist.get(i).setSelect(false);
                        }
                    }
                    mDiseaseAdpter.notifyDataSetChanged();
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