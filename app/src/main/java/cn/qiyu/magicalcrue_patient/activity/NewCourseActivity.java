package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.PatientCourseListBean;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.utils.TimeUtils;
import cn.qiyu.magicalcrue_patient.visit.PatientCourseListPresenter;
import cn.qiyu.magicalcrue_patient.visit.PatientCourseListView;

/**
 * 患教课堂
 */

public class NewCourseActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.rcl_new_course)
    RecyclerView mRclNewCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_course);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText(R.string.newCourse);
        mPatientCourseListPresenter.getPatientCourseList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPatientCourseListPresenter.getPatientCourseList();
    }

    PatientCourseListPresenter mPatientCourseListPresenter = new PatientCourseListPresenter(new PatientCourseListView() {
        @Override
        public String getPatientUuid() {
            Log.i("patientUuid-=-=-",(String) PreUtils.getParam(NewCourseActivity.this, "patientuuid", ""));
                         return (String) PreUtils.getParam(NewCourseActivity.this, "patientuuid", "");
//            return "df430ac16590449cba026e34704190f3";
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
        public void LoadPatientCourseList(ResultModel<List<PatientCourseListBean>> model) {
            mRclNewCourse.setAdapter(new NewCourseActivity.RecyclerAdpter(model.getData()));
            mRclNewCourse.setLayoutManager(new LinearLayoutManager(NewCourseActivity.this));

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
    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind({R.id.tv_group_name, R.id.tv_group_member})
        TextView[] mtextview;
        PatientCourseListBean mModel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(NewCourseActivity.this, BannerDetailActivity.class);
                    intent.putExtra("url", mModel.getUrl());
                   startActivity(intent);

                }
            });
        }
        void setItem(PatientCourseListBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            mtextview[0].setText(mModel.getTitle());
            mtextview[1].setText(mModel.getContent());
        }
    }

    class RecyclerAdpter extends RecyclerView.Adapter<NewCourseActivity.ViewHolder> {
        private List<PatientCourseListBean> mlist;

        public RecyclerAdpter(List<PatientCourseListBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public NewCourseActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new NewCourseActivity.ViewHolder(LayoutInflater.from(NewCourseActivity.this).inflate(R.layout.recyclerview_new_course_item, null));
        }

        @Override
        public void onBindViewHolder(NewCourseActivity.ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }

}
