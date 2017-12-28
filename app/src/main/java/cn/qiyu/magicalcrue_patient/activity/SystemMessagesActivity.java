package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
import cn.qiyu.magicalcrue_patient.information.InformationSysMsgView;
import cn.qiyu.magicalcrue_patient.model.InfoUserNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InfoUserSystemMsgListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.view.RecycleViewDivider;

/**
 * Created by ShiLei on 2017/12/25.
 * 系统消息
 */

public class SystemMessagesActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.rcl_system_message)
    RecyclerView mRclSystemMessage;
    @Bind(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeLayout;
    private String mMessageUuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_system_message_list);
        ButterKnife.bind(this);
        init();
    }

    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationSysMsgView() {
        @Override
        public String getPage() {
            return "1";
        }

        @Override
        public String getPagecount() {
            return "100";
        }

        @Override
        public void getSystemMessageList(ResultModel<List<InfoUserSystemMsgListBean>> model) {
            mSwipeLayout.setRefreshing(false);
            mRclSystemMessage.setAdapter(new SystemMessagesActivity.RecyclerAdpter(model.getData()));
            mRclSystemMessage.setLayoutManager(new LinearLayoutManager(SystemMessagesActivity.this));
        }

        @Override
        public String getUserUuid() {
            return (String) PreUtils.getParam(SystemMessagesActivity.this, "uuid", "0");
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
        mInformationPresenter.getSystemMessageList();
    }

    private void init() {
        mTvTitle.setText(R.string.systemMessages);
        mRclSystemMessage.addItemDecoration(new RecycleViewDivider(SystemMessagesActivity.this, LinearLayoutManager.HORIZONTAL, R.drawable.recycleview_tieku));
        getLoad();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind({R.id.tv_doctor_notice_num, R.id.tv_doctor_notic_title, R.id.tv_doctor_notice_date,R.id.tv_doctor_notice_content})
        TextView[] mtextview;
        InfoUserSystemMsgListBean mModel;
        @Bind(R.id.iv_doctor_notice)
        ImageView mIvSysMSg;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //条目点击
                    Intent intent = new Intent(SystemMessagesActivity.this, DoctorNoticeDetailActivity.class);
                    mMessageUuid = mModel.getUuid();
                    Log.i("msgUuid==", mMessageUuid);
                    intent.putExtra("isSystemMsg", "isSystemMsg");
                    intent.putExtra("title", mModel.getTitle());
                    intent.putExtra("context", mModel.getContent());
                    intent.putExtra("messageUuid", mMessageUuid);
                    startActivity(intent);

                }
            });

        }

        void setItem(InfoUserSystemMsgListBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            String create_time = mModel.getCreate_time();
            mtextview[2].setText(create_time);
            mtextview[3].setText(mModel.getContent());
            mtextview[1].setText(mModel.getTitle());
            mIvSysMSg.setImageResource(R.drawable.system_notice);
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
    class RecyclerAdpter extends RecyclerView.Adapter<SystemMessagesActivity.ViewHolder> {
        private List<InfoUserSystemMsgListBean> mlist;

        public RecyclerAdpter(List<InfoUserSystemMsgListBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public SystemMessagesActivity.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new SystemMessagesActivity.ViewHolder(LayoutInflater.from(SystemMessagesActivity.this).inflate(R.layout.recyclerview_doctor_notice_item, null));
        }

        @Override
        public void onBindViewHolder(SystemMessagesActivity.ViewHolder holder, int position) {
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
                mInformationPresenter.getSystemMessageList();
            }
        });
    }

}
