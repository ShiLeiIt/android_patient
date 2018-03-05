package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import cn.qiyu.magicalcrue_patient.constant.GlobalConstants;
import cn.qiyu.magicalcrue_patient.fragment.InformationFragment;
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
import cn.qiyu.magicalcrue_patient.information.InformationView;
import cn.qiyu.magicalcrue_patient.model.InfoUserNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InformationBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.view.RecycleViewDivider;

/**
 * Created by ShiLei on 2017/12/7.
 */

public class DoctorNoticeListActivity extends BaseActivity {
    @Bind(R.id.rcl_doctor_notice)
    RecyclerView mRclDoctorNotice;
    @Bind(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeLayout;
    private String mMessageUuid;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_notice_list);
        ButterKnife.bind(this);
        mRclDoctorNotice.addItemDecoration(new RecycleViewDivider(DoctorNoticeListActivity.this, LinearLayoutManager.HORIZONTAL, R.drawable.recycleview_tieku));
        getLoad();
    }

    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationView() {
        @Override
        public String getUserUuid() {
            return (String) PreUtils.getParam(DoctorNoticeListActivity.this, GlobalConstants.USER_UUID, "0");
        }

        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPagecount() {
            return "100";
        }

        @Override
        public void getDoctorNoticeList(ResultModel<List<InfoUserNoticeListBean>> model) {
            mSwipeLayout.setRefreshing(false);
//            Toast.makeText(DoctorNoticeListActivity.this, "成功==-==-"+model.getData().size(), Toast.LENGTH_SHORT).show();
            mRclDoctorNotice.setAdapter(new DoctorNoticeListActivity.RecyclerAdpter(model.getData()));
            mRclDoctorNotice.setLayoutManager(new LinearLayoutManager(DoctorNoticeListActivity.this));
        }



        @Override
        public void getInformationList(ResultModel<InformationBean> model) {

        }


        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(DoctorNoticeListActivity.this, "" + model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(DoctorNoticeListActivity.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    });

    @OnClick(R.id.iv_course_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mInformationPresenter.InformationDoctorNoticeList();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind({R.id.tv_doctor_notice_num, R.id.tv_doctor_notic_title, R.id.tv_doctor_notice_date,R.id.tv_doctor_notice_content})
        TextView[] mtextview;
        InfoUserNoticeListBean mModel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                //条目点击
                    Intent intent = new Intent(DoctorNoticeListActivity.this, DoctorNoticeDetailActivity.class);
                    mMessageUuid = mModel.getUuid();
                    Log.i("msgUuid==", mMessageUuid);
                    intent.putExtra("isSystemMsg", "isDoctorNotice");
                    intent.putExtra("title", mModel.getTitle());
                    intent.putExtra("context", mModel.getContent());
                    intent.putExtra("messageUuid", mMessageUuid);
                    startActivity(intent);

                }
            });

        }

        void setItem(InfoUserNoticeListBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            String create_time = mModel.getCreate_time();
            mtextview[2].setText(create_time);
            mtextview[3].setText(mModel.getContent());
            mtextview[1].setText(mModel.getTitle());
//            Toast.makeText(getActivity(), "shijina=="+mModel.getCreate_time(), Toast.LENGTH_SHORT).show();
           int status = mModel.getStatus();
            Log.i("status====", status +"");
            switch (status) {
                case 0:
                    mtextview[0].setVisibility(View.VISIBLE);
                    break;
                case 1:
                    mtextview[0].setVisibility(View.INVISIBLE);
                    break;

            }
        }
    }

    class RecyclerAdpter extends RecyclerView.Adapter<DoctorNoticeListActivity.ViewHolder> {
        private List<InfoUserNoticeListBean> mlist;

        public RecyclerAdpter(List<InfoUserNoticeListBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public DoctorNoticeListActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new DoctorNoticeListActivity.ViewHolder(LayoutInflater.from(DoctorNoticeListActivity.this).inflate(R.layout.recyclerview_doctor_notice_item, null));
        }

        @Override
        public void onBindViewHolder(DoctorNoticeListActivity.ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }


    public void getLoad() {

/*加载的渐变动画*/
        mSwipeLayout.setColorSchemeResources(R.color.colorAccent,
                R.color.colorPrimary,
                R.color.colorPrimaryDark);
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mInformationPresenter.InformationDoctorNoticeList();
            }
        });
    }
}
