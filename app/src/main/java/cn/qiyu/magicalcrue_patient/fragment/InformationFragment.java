package cn.qiyu.magicalcrue_patient.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
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
import cn.qiyu.magicalcrue_patient.information.InformationPresenter;
import cn.qiyu.magicalcrue_patient.information.InformationView;
import cn.qiyu.magicalcrue_patient.model.InfoDoctorNoticeListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.view.RecycleViewDivider;


/**
 * Created by Administrator on 2017/11/13.
 * 消息界面
 */

public class InformationFragment extends Fragment {
    @Bind(R.id.rcl_doctor_notice)
    RecyclerView mRclDoctorNotice;
    @Bind(R.id.swipeLayout)
    SwipeRefreshLayout mSwipeLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_information, container, false);

        ButterKnife.bind(this, view);
        mRclDoctorNotice.addItemDecoration(new RecycleViewDivider(getActivity(), LinearLayoutManager.HORIZONTAL, R.drawable.recycleview_tieku));
        mInformationPresenter.InformationDoctorNoticeList();
        getLode();
        return view;
    }

    InformationPresenter mInformationPresenter = new InformationPresenter(new InformationView() {
        @Override
        public String getDoctorUuid() {
//            return (String) PreUtils.getParam(getActivity(), "doctorUuid", "");
            return "95bbb5cb43ec43b58b464e89be63a585";
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
        public void getDoctorNoticeList(ResultModel<List<InfoDoctorNoticeListBean>> model) {
            mSwipeLayout.setRefreshing(false);
            mRclDoctorNotice.setAdapter(new RecyclerAdpter(model.getData()));
            mRclDoctorNotice.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        @Override
        public void showProgress() {

        }

        @Override
        public void hideProgress() {

        }

        @Override
        public void onViewFailure(ResultModel model) {
            Toast.makeText(getActivity(), "" + model.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServerFailure(String e) {
            Toast.makeText(getActivity(), "" + e, Toast.LENGTH_SHORT).show();
        }
    });

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }




    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind({R.id.tv_doctor_notice_status, R.id.tv_doctor_notic_title, R.id.tv_doctor_notice_date})
        TextView[] mtextview;
        @Bind(R.id.msg_unread)
        ImageView mIvMsgUnread;
        InfoDoctorNoticeListBean mModel;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });

        }

        void setItem(InfoDoctorNoticeListBean item) {
            this.mModel = item;
        }

        //刷新
        void refreshView() {
            String create_time = mModel.getCreate_time();
            mtextview[2].setText(create_time);
            mtextview[1].setText(mModel.getTitle());
//            Toast.makeText(getActivity(), "shijina=="+mModel.getCreate_time(), Toast.LENGTH_SHORT).show();
            int status = mModel.getStatus();
            if (status == 0) {
                mIvMsgUnread.setImageResource(R.drawable.doctor_notice_msg_unread);
            } else {
                mIvMsgUnread.setImageResource(R.drawable.doctor_notice_read);
            }
        }
    }

    class RecyclerAdpter extends RecyclerView.Adapter<ViewHolder> {
        private List<InfoDoctorNoticeListBean> mlist;

        public RecyclerAdpter(List<InfoDoctorNoticeListBean> mlist) {
            this.mlist = mlist;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new ViewHolder(LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview_doctor_notice_item, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.setItem(mlist.get(position));
            holder.refreshView();
        }

        @Override
        public int getItemCount() {
            return mlist.size();
        }
    }

    public void getLode() {

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
