package cn.qiyu.magicalcrue_patient.removeitemrecycleview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.model.ResultModel;
import cn.qiyu.magicalcrue_patient.visit.VisitDeleteRemindListView;
import cn.qiyu.magicalcrue_patient.visit.VisitRemindListPresenter;

public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
    public  TextView mTvContent;
    public  TextView mTvTime;
    public  TextView mTvWeek;
    public  TextView mTvStatus;
    public  TextView mTvItemDel;
    public  LinearLayout mLlItemLay;
//    RemindListBean mModel;

    public MyRecyclerViewHolder(View itemView) {
        super(itemView);
        mTvContent = (TextView) itemView.findViewById(R.id.tv_remind_detail);
        mTvTime = (TextView) itemView.findViewById(R.id.tv_create_time);
        mTvWeek = (TextView) itemView.findViewById(R.id.tv_week);
        mTvStatus = (TextView) itemView.findViewById(R.id.tv_remind_satus);
        mTvItemDel = (TextView) itemView.findViewById(R.id.item_delete);
        mLlItemLay = (LinearLayout) itemView.findViewById(R.id.item_layout);

    }



}
