package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.removeitemrecycleview.ItemRemoveRecyclerView;
import cn.qiyu.magicalcrue_patient.removeitemrecycleview.MyRecyclerAdapter;
import cn.qiyu.magicalcrue_patient.removeitemrecycleview.OnItemClickListener;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.utils.TimeUtils;
import cn.qiyu.magicalcrue_patient.visit.VisitDeleteRemindListView;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindListPresenter;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindListView;

/**
 * 提醒界面
 */

public class RemindActivity extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.rcl_remind)
    ItemRemoveRecyclerView mRclRemind;
    @Bind(R.id.tv_commit)
    TextView mTvCommit;
    List<RemindListBean> mList;
    private String mRemindUuid;


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
        mTvCommit.setOnClickListener(this);

        mVisitRemindListPresenter.getVisitRemindList();
    }

    VisitRemindListPresenter mVisitRemindListPresenter = new VisitRemindListPresenter(new VisitRemindListView() {
        @Override
        public String getPatientUuid() {
             return (String) PreUtils.getParam(RemindActivity.this, "patientuuid", "");
//             return "df430ac16590449cba026e34704190f3";
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
        public void LoadVisitRemindList(final ResultModel<List<RemindListBean>> model) {
            final MyRecyclerAdapter adapter = new MyRecyclerAdapter(RemindActivity.this, model.getData());

            if (null != model) {
                mRclRemind.setAdapter(adapter);
                mRclRemind.setLayoutManager(new LinearLayoutManager(RemindActivity.this));
                mRclRemind.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //TODO
                        Intent intent = new Intent(RemindActivity.this,RemindDetailsActivity.class);
                        intent.putExtra("remindUuid", model.getData().get(position).getUuid());
                        intent.putExtra("remindTimeWeek",TimeUtils.getWeekStr(model.getData().get(position).getCreate_time()));
                        startActivity(intent);

//                    Toast.makeText(RemindActivity.this, ""+model.getData().get(position).getUuid(), Toast.LENGTH_SHORT).show();
//                    Log.i("mRemindUuid====",model.getData().get(position).getUuid());
                    }

                    @Override
                    public void onDeleteClick(int position) {

                        mRemindUuid = model.getData().get(position).getUuid();
//                    Log.i("mRemindUuid====",mRemindUuid);
                        adapter.removeItem(position);
                        mVisitDeleteRemindListP.getVisitDeleteRemindList();
                    }
                });
            }


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
        mVisitRemindListPresenter.getVisitRemindList();
    }

    VisitRemindListPresenter mVisitDeleteRemindListP = new VisitRemindListPresenter(new VisitDeleteRemindListView() {
        @Override
        public String getRemindUuid() {
//            Log.i("mRemindUuid==",mRemindUuid);
            return mRemindUuid;
        }

        @Override
        public String getPatientUuid() {
            return (String)PreUtils.getParam(RemindActivity.this,"patientuuid","");
        }

        @Override
        public void LoadVisitDeleteRemindList(ResultModel model) {
//            Toast.makeText(RemindActivity.this, "删除成功吗", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
//            Toast.makeText(RemindActivity.this, "删"+model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
//            Toast.makeText(RemindActivity.this, "除"+e, Toast.LENGTH_SHORT).show();

        }
    });


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_commit:
//                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RemindActivity.this,AddRemindActivity.class));
                break;
        }
    }
}
