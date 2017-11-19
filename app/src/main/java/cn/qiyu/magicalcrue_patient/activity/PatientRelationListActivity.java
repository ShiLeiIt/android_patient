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

import butterknife.OnClick;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.home.PatientInfoPresenter;
import cn.qiyu.magicalcrue_patient.home.PatientInfoView;
import cn.qiyu.magicalcrue_patient.model.PatientRelationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;

/**
 * Created by ShiLei on 2017/11/19.
 */

public class PatientRelationListActivity extends Activity {

    private RecyclerView mRl_relation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_relation);
        mRl_relation = (RecyclerView) findViewById(R.id.rlv_patient_relation);
        mPatientInfoPresenter.LoadPatientRelation();
    }
    PatientInfoPresenter mPatientInfoPresenter=new PatientInfoPresenter(new PatientInfoView() {
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
            Toast.makeText(PatientRelationListActivity.this, ""+model.getData().size(), Toast.LENGTH_SHORT).show();
            mRl_relation.setAdapter(new RecyclerAdpter(model.getData()));
            mRl_relation .setLayoutManager(new LinearLayoutManager(PatientRelationListActivity.this));
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(PatientRelationListActivity.this, e, Toast.LENGTH_SHORT).show();
        }
    });


    class ViewHolder extends RecyclerView.ViewHolder {

        PatientRelationBean mModel;
        private final TextView mTv_relation;
        private final ImageView mIv_seclect;

        public ViewHolder(View itemView) {
            super(itemView);
            mTv_relation = (TextView) itemView.findViewById(R.id.tv_relation);
            mIv_seclect = (ImageView) itemView.findViewById(R.id.iv_select);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIv_seclect.setVisibility(View.VISIBLE);
                    Intent intent=new Intent(PatientRelationListActivity.this,PatientDataActivity.class);
                    intent.putExtra("name",mModel.getNAME());
                    startActivity(intent);
                    finish();
                }
            });

        }


        void setItem(PatientRelationBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            mTv_relation.setText(mModel.getNAME());
        }
    }

    public class RecyclerAdpter extends RecyclerView.Adapter<PatientRelationListActivity.ViewHolder> {
        private List<PatientRelationBean> mlist;

        public RecyclerAdpter(List<PatientRelationBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_patient_relation_item, null));

        }

        @Override
        public void onBindViewHolder(PatientRelationListActivity.ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }
}