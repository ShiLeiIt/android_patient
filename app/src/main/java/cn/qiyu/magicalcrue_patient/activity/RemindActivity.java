package cn.qiyu.magicalcrue_patient.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.TimeUtils;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindListPresenter;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindListView;

/**
 * 提醒界面
 */

public class RemindActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.rcl_remind)
    RecyclerView mRclRemind;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mTvTitle.setText(R.string.remind);
        mTvCommit.setVisibility(View.VISIBLE);
        mTvCommit.setText(R.string.add);
        mTvCommit.setTextColor(getResources().getColor(R.color.add_remind));
        mVisitRemindListPresenter.getVisitRemindList();
    }

    VisitRemindListPresenter mVisitRemindListPresenter = new VisitRemindListPresenter(new VisitRemindListView() {
        @Override
        public String getPatientUuid() {
//             return (String) PreUtils.getParam(RemindActivity.this, "patientuuid", "");
             return "df430ac16590449cba026e34704190f3";
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
        public void LoadVisitRemindList(ResultModel<List<RemindListBean>> model) {
            mRclRemind.setAdapter(new RemindActivity.RecyclerAdpter(model.getData()));
            mRclRemind.setLayoutManager(new LinearLayoutManager(RemindActivity.this));
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
        @Bind({R.id.tv_group_name, R.id.tv_group_member,R.id.tv_week, R.id.tv_scale_satus})
        TextView[] mtextview;
        RemindListBean mModel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    mQuestionUUid = mModel.getPaperID();
//                    mPaperUserID = mModel.getPaperUserID();
//                    Log.i("paperUserID", mPaperUserID + "");
//                    mScalePresenter.VisitScaleDetailsData();

                }
            });

        }

        void setItem(RemindListBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            String creatTime = mModel.getCreate_time();
            String substring = creatTime.substring(0, 10);
            String weekStr = TimeUtils.getWeekStr(creatTime);
            int status = mModel.getStatus();
            mtextview[0].setText(mModel.getEvent_detail());
            mtextview[1].setText(substring);
            mtextview[2].setText(weekStr);
            mtextview[3].setVisibility(View.GONE);
//            if (status == 0) {
//                mtextview[2].setText("未填写");
//                mtextview[2].setTextColor(getResources().getColor(R.color.app_gray));
//            } else {
//                mtextview[2].setText("已填写");
//                mtextview[2].setTextColor(getResources().getColor(R.color.app_relation_tv));
//            }

        }
    }

    class RecyclerAdpter extends RecyclerView.Adapter<RemindActivity.ViewHolder> {
        private List<RemindListBean> mlist;

        public RecyclerAdpter(List<RemindListBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public RemindActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new RemindActivity.ViewHolder(LayoutInflater.from(RemindActivity.this).inflate(R.layout.recyclerview_remind_item, null));
        }

        @Override
        public void onBindViewHolder(RemindActivity.ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }




}
