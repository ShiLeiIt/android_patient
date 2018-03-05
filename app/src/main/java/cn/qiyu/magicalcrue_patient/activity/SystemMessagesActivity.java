package cn.qiyu.magicalcrue_patient.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.base.BaseActivity;
import cn.qiyu.magicalcrue_patient.constant.GlobalConstants;
import cn.qiyu.magicalcrue_patient.fragment.FiScaleFragment;
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
import cn.qiyu.magicalcrue_patient.information.InformationSysMsgRdView;
import cn.qiyu.magicalcrue_patient.information.InformationSysMsgView;
import cn.qiyu.magicalcrue_patient.model.InfoUserNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.InfoUserSystemMsgListBean;
import cn.qiyu.magicalcrue_patient.model.MyScaleBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.model.ScaleDetailBean;
import cn.qiyu.magicalcrue_patient.utils.PreUtils;
import cn.qiyu.magicalcrue_patient.view.RecycleViewDivider;
import cn.qiyu.magicalcrue_patient.visit.MyScalePresenter;
import cn.qiyu.magicalcrue_patient.visit.MyScaleView;

/**
 * Created by ShiLei on 2017/12/25.
 * 系统消息
 */

public class SystemMessagesActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView mTvTitle;
    @Bind(R.id.rcl_system_message)
    PullLoadMoreRecyclerView mRclSystemMessage;
//    @Bind(R.id.swipeLayout)
//    SwipeRefreshLayout mSwipeLayout;
    private String mMessageUuid;
    private String mPaperId;
    private String mPaperUserID;
    private boolean ispull = false;
    private int page = 1;
    private Handler mHandler = new Handler();
    private RecyclerAdpter mRecyclerAdpter;
    private String mQuestionUUid;
    private int mStatus;

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
            return page + "";
        }

        @Override
        public String getPagecount() {
            return "10";
        }

        @Override
        public void getSystemMessageList(ResultModel<List<InfoUserSystemMsgListBean>> model) {
//            mSwipeLayout.setRefreshing(false);
            mRecyclerAdpter = new RecyclerAdpter(model.getData());
//            mRclSystemMessage.setAdapter(new SystemMessagesActivity.RecyclerAdpter(model.getData()));
//            mRclSystemMessage.setLayoutManager(new LinearLayoutManager(SystemMessagesActivity.this));
            if (ispull) {
                mRecyclerAdpter.setPullAddList(model.getData());
            } else {
                mRclSystemMessage.setAdapter(mRecyclerAdpter);
                mRclSystemMessage.setLinearLayout();
            }
            //取消转圈
            mRclSystemMessage.setPullLoadMoreCompleted();


        }

        @Override
        public String getUserUuid() {
            return (String) PreUtils.getParam(SystemMessagesActivity.this, GlobalConstants.USER_UUID, "0");
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            mRclSystemMessage.setPullLoadMoreCompleted();
        }

        @Override
        public void onServerFailure(String e) {
            mRclSystemMessage.setPullLoadMoreCompleted();
        }
    });

    @Override
    protected void onResume() {
        super.onResume();
        mInformationPresenter.getSystemMessageList();
    }

    private void init() {
        mTvTitle.setText(R.string.systemMessages);
        mRclSystemMessage.setRefreshing(true);
        mRclSystemMessage.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                ispull = false;
                page = 1;
                mInformationPresenter.getSystemMessageList();
            }

            @Override
            public void onLoadMore() {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ispull = true;
                        page = page + 1;
                        mInformationPresenter.getSystemMessageList();
                    }
                }, 300);
            }
        });
//        mRclSystemMessage.addItemDecoration(new RecycleViewDivider(SystemMessagesActivity.this, LinearLayoutManager.HORIZONTAL, R.drawable.recycleview_tieku));
//        getLoad();
    }

    MyScalePresenter mScalePresenter = new MyScalePresenter(new MyScaleView() {
        @Override
        public String getPatientUuid() {
            return (String) PreUtils.getParam(SystemMessagesActivity.this, GlobalConstants.PATIENT_UUID, "");
        }

        @Override
        public String getStatus() {
            return null;
        }

        @Override
        public String getPage() {
            return null;
        }

        @Override
        public String getPagecount() {
            return null;
        }

        @Override
        public void LoadDate(ResultModel<List<MyScaleBean>> model) {
        }

        @Override
        public String paperId() {
            return mPaperId;
        }

        @Override
        public String paperUserId() {
            return mPaperUserID;
        }

        @Override
        public String userId() {
             return (String) PreUtils.getParam(SystemMessagesActivity.this, GlobalConstants.PATIENT_UUID, "");
        }

        @Override
        public void LoadScaleDetailsData(ResultModel<ScaleDetailBean> model) {
            //跳转到医生量表页面
            if (model.getData().getPaperData().getStatus() == 0) {
                Intent intentScale = new Intent(SystemMessagesActivity.this, ScaleDetailActivity.class);
                intentScale.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentScale.putExtra("scaleDetail", model.getData());
                intentScale.putExtra("paperUserID", mPaperUserID);
                startActivity(intentScale);
            } else {
                Intent intentScale = new Intent(SystemMessagesActivity.this, ScaleDetailShowActivity.class);
                intentScale.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intentScale.putExtra("scaleDetail", model.getData());
                intentScale.putExtra("paperUserID", mPaperUserID);
                intentScale.putExtra("mStatus", model.getData().getPaperData().getStatus()+"");
                startActivity(intentScale);
            }


        }

        @Override
        public String getQuestionArr() {
            return null;
        }

        @Override
        public void LoadScaleDetailsCommit(ResultModel model) {

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
    //系统消息已读
    InformationPresenter mPresenter = new InformationPresenter(new InformationSysMsgRdView() {
        @Override
        public String getMessageId() {
            return mMessageUuid;
        }

        @Override
        public void getSystemMessageRead(ResultModel<InfoUserSystemMsgListBean> model) {

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
        @Bind({R.id.tv_doctor_notice_num, R.id.tv_doctor_notic_title, R.id.tv_doctor_notice_date, R.id.tv_doctor_notice_content})
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
                    int service_type = mModel.getService_type();
                    String service_uuid = mModel.getService_uuid();

                    //设置系统消息为已读
                    mMessageUuid = mModel.getUuid();
                    mPresenter.getSystemMsgRead();
//                    Log.i("paperID===", mPaperId);
//                    Log.i("PaperUserID===", mPaperUserID);
                    switch (service_type) {
                        //量表详情
                        case 1018:
//                            Toast.makeText(SystemMessagesActivity.this, "请转至随访页面查看量表", Toast.LENGTH_SHORT).show();
                             mPaperId = service_uuid.substring(0, service_uuid.indexOf("&"));
                            mPaperUserID = service_uuid.substring(service_uuid.length()-3);
//                            Log.i("mPaperId===",service_uuid.substring(0, service_uuid.indexOf("&")));
//                            Log.i("mPaperUserID===",service_uuid.substring(service_uuid.length()-3));

                            mScalePresenter.VisitScaleDetailsData();

                            break;
                        case 1001:
                            //跳转病历门诊信息界面
                            Intent intentO = new Intent(SystemMessagesActivity.this, OutpatientInformationListActivity.class);
                            intentO.putExtra("outPatient", "outPatient");
                            startActivity(intentO);
                            break;
                        case 1002:
                            //跳转到出院小结信息界面
                            Intent intentL = new Intent(SystemMessagesActivity.this, LeaveHospitalInfoListActivity.class);
                            intentL.putExtra("leaveHospital", "leaveHospital");
                            startActivity(intentL);
                            break;
                        case 1022:
                            //跳转到检查报告单界面
                            Intent intentI = new Intent(SystemMessagesActivity.this, InspectionReportInfoListActivity.class);
                            startActivity(intentI);
                            break;
                        case 1006:
                            //跳转到用药记录方案信息界面
                            Intent intentP = new Intent(SystemMessagesActivity.this, PharmacyPlanRecordInfoListActivity.class);
                            startActivity(intentP);
                            break;
                        case 1007:
                            //跳转到身体症状记录信息界面
                            Intent intentS = new Intent(SystemMessagesActivity.this, SymgraphyInfoListActivity.class);
                            startActivity(intentS);
                            break;

                    }
//                    Intent intent = new Intent(SystemMessagesActivity.this, DoctorNoticeDetailActivity.class);
//                    mMessageUuid = mModel.getUuid();
//                    Log.i("msgUuid==", mMessageUuid);
//                    intent.putExtra("isSystemMsg", "isSystemMsg");
//                    intent.putExtra("title", mModel.getTitle());
//                    intent.putExtra("context", mModel.getContent());
//                    intent.putExtra("messageUuid", mMessageUuid);
//                    startActivity(intent);

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
            Log.i("status====", status + "");
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
        private LayoutInflater mLayoutInflater;

        public RecyclerAdpter(List<InfoUserSystemMsgListBean> mlist) {
            this.mlist = mlist;
            mLayoutInflater = LayoutInflater.from(SystemMessagesActivity.this);
        }

        public void setPullAddList(List<InfoUserSystemMsgListBean> model) {
            mlist.addAll(model);
            notifyDataSetChanged();
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
            return mlist.size() == 0 ? 0 : mlist.size();
        }
    }


    public void getLoad() {

/*加载的渐变动画*/
//        mSwipeLayout.setColorSchemeResources(R.color.colorAccent,
//                R.color.colorPrimary,
//                R.color.colorPrimaryDark);
//        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                mInformationPresenter.getSystemMessageList();
//            }
//        });
    }

}
