package cn.qiyu.magicalcrue_patient.removeitemrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

import cn.qiyu.magicalcrue_patient.R;
import cn.qiyu.magicalcrue_patient.model.RemindListBean;
import cn.qiyu.magicalcrue_patient.utils.TimeUtils;

public class MyRecyclerAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<RemindListBean> mList;
    private LinearLayout linearLayout;

    public MyRecyclerAdapter(Context context, List<RemindListBean> list) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mList = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyRecyclerViewHolder(mInflater.inflate(R.layout.recyclerview_remind_item,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyRecyclerViewHolder viewHolder = (MyRecyclerViewHolder) holder;
        linearLayout=viewHolder.mLlItemLay;
        viewHolder.mTvContent.setText(mList.get(position).getEvent_detail());
        viewHolder.mTvTime.setText(mList.get(position).getCreate_time().substring(0, 10));
        viewHolder.mTvWeek.setText(TimeUtils.getWeekStr(mList.get(position).getCreate_time()));
        viewHolder.mTvStatus.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public void removeItem(int position) {
        mList.remove(position);
        notifyDataSetChanged();
    }
}
